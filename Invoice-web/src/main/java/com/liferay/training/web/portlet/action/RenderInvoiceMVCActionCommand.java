package com.liferay.training.web.portlet.action;

import com.liferay.commerce.constants.CommerceOrderConstants;
import com.liferay.commerce.currency.model.CommerceMoneyFactory;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.model.PersistedInvoice;
import com.liferay.training.model.PersistedInvoiceLine;
import com.liferay.training.service.PersistedInvoiceLineService;
import com.liferay.training.service.PersistedInvoiceService;
import com.liferay.training.web.constants.InvoicePortletKeys;
import com.liferay.training.web.constants.MVCCommandNames;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Command for showing edit assignment view.
 *
 * @author liferay
 */
@Component(immediate = true, property = { "javax.portlet.name=" + InvoicePortletKeys.INVOICE,
		"mvc.command.name=" + MVCCommandNames.RENDER_INVOICE }, service = MVCActionCommand.class)
public class RenderInvoiceMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(PersistedInvoice.class.getName(), actionRequest);

		long orderNumber = ParamUtil.getLong(actionRequest, "orderNumber", 0);

		try {
			CommerceOrder order = _commerceOrderLocalService.getCommerceOrder(orderNumber);
			List<PersistedInvoiceLine> invoiceLines = new ArrayList<PersistedInvoiceLine>();
			List<CommerceOrderItem> items = order.getCommerceOrderItems();
			int lineNum = 1;
			for(CommerceOrderItem item : items) {
				
				PersistedInvoiceLine invoiceLine = _persistedInvoiceLineService.createNewPersistedInvoiceLine();
				invoiceLine.setDiscountPercent(item.getDiscountWithTaxAmount().doubleValue());
				
				invoiceLine.setItemCode(item.getSku());
				invoiceLine.setLineNum(lineNum);
				invoiceLine.setLineTotal(item.getFinalPriceWithTaxAmount().doubleValue());
				invoiceLine.setPrice(item.getUnitPriceWithTaxAmount().doubleValue());
				invoiceLine.setQuantity(item.getQuantity());				
				invoiceLine.setSalesOrder(item.getCommerceOrderId());
				invoiceLine.setSalesOrderlineNum(lineNum);
				invoiceLines.add(invoiceLine);
				lineNum++;
			}	
			Double gst = 1.0;
			
			String documentNumber = String.valueOf(order.getCommerceOrderId());
			String documentStatus = CommerceOrderConstants.getOrderStatusLabel(order.getStatus());
			String carrier = order.getShippingOptionName();
			Double freightAmount = order.getShippingAmount().doubleValue();
			_persistedInvoiceService.addPersistedInvoice(gst, 
					order.getCommerceAccount().getExternalReferenceCode(),
					order.getCommerceAccount().getName(),
					carrier,
					order.getCreateDate(), documentNumber,documentStatus, order.getModifiedDate(),
					freightAmount,
					order.getTotalWithTaxAmount().doubleValue(), 
					order.getCommerceAccountId(), invoiceLines, serviceContext );
			order.setOrderStatus(CommerceOrderConstants.ORDER_STATUS_PROCESSING);
			
			_commerceOrderLocalService.updateCommerceOrder(order);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	@Reference
	private CommerceMoneyFactory _commerceMoneyFactory;
	@Reference
	private CommerceOrderLocalService _commerceOrderLocalService;
	@Reference
	private PersistedInvoiceService _persistedInvoiceService;
	@Reference
	private PersistedInvoiceLineService _persistedInvoiceLineService;
}