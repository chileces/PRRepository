package com.liferay.training.web.portlet.action;

import com.liferay.commerce.exception.CommerceOrderValidatorException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.model.PersistedInvoice;
import com.liferay.training.service.PersistedInvoiceService;
import com.liferay.training.service.validator.CustomInvoiceValidator;
import com.liferay.training.web.constants.InvoicePortletKeys;
import com.liferay.training.web.constants.MVCCommandNames;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + InvoicePortletKeys.INVOICE,
		"mvc.command.name=" + MVCCommandNames.EDIT_INVOICE }, service = MVCActionCommand.class)
public class EditInvoiceMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// get assignment Id
		// currently only update carrier & freightAmount without any validation!
		long persistedInvoiceId = ParamUtil.getLong(actionRequest, "persistedInvoiceId");
		String carrier = ParamUtil.getString(actionRequest, "carrier");
		Double freightAmount = ParamUtil.getDouble(actionRequest, "freightAmount");
		try {
			customInvoiceValidator.validateFreightAmount(freightAmount);

			PersistedInvoice invoice = _persistedInvoiceService.getPersistedInvoice(persistedInvoiceId);
			invoice.setCarrier(carrier);
			invoice.setFreightAmount(freightAmount);
			_persistedInvoiceService.updatePersistedInvoice(invoice);
			// set delete success message
			SessionMessages.add(actionRequest, "Invoice updated");
			sendRedirect(actionRequest, actionResponse);

		} catch (PortalException portalException) {
            SessionErrors.add(actionRequest, "error");

			if (portalException instanceof CommerceOrderValidatorException) {
				SessionErrors.add(actionRequest, portalException.getClass(), portalException);
			}else {
				SessionErrors.add(actionRequest, "serviceErrorDetails", portalException);
			}
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.VIEW_INVOICE);
		}
	}

	@Reference
	private CustomInvoiceValidator customInvoiceValidator;

	@Reference
	private PersistedInvoiceService _persistedInvoiceService;
}
