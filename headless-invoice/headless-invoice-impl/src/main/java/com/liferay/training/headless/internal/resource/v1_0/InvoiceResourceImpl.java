package com.liferay.training.headless.internal.resource.v1_0;

import com.liferay.headless.common.spi.service.context.ServiceContextUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.SearchUtil;
import com.liferay.training.headless.dto.v1_0.Invoice;
import com.liferay.training.headless.dto.v1_0.InvoiceLine;
import com.liferay.training.headless.internal.odata.entity.v1_0.InvoiceEntityModel;
import com.liferay.training.headless.resource.v1_0.InvoiceResource;
import com.liferay.training.model.PersistedInvoice;
import com.liferay.training.model.PersistedInvoiceLine;
import com.liferay.training.service.PersistedInvoiceLineService;
import com.liferay.training.service.PersistedInvoiceService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ces-user
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/invoice.properties", 
scope = ServiceScope.PROTOTYPE, service = InvoiceResource.class)
public class InvoiceResourceImpl extends BaseInvoiceResourceImpl implements EntityModelResource {

	private InvoiceEntityModel _invoiceEntityModel = new InvoiceEntityModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) throws Exception {
		return _invoiceEntityModel;
	}

	@Override
	public Page<Invoice> getInvoicesPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		try {
			return SearchUtil.search(
					booleanQuery -> {
						// does nothing, we just need the UnsafeConsumer<BooleanQuery, Exception> method
					},
					filter, PersistedInvoice.class, search, pagination,
					queryConfig -> queryConfig.setSelectedFieldNames(
							Field.ENTRY_CLASS_PK),
					searchContext -> searchContext.setCompanyId(
							contextCompany.getCompanyId()),
					document -> _convertToDto(
							customInvoiceService.getPersistedInvoice(
									GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
					sorts);
		} catch (Exception e) {
			_log.error("Error listing Invoices: " + e.getMessage(), e);

			throw e;
		}
	}

	@Override
	public Invoice postInvoice(Invoice invoice) throws Exception {
		List<PersistedInvoiceLine> invoiceLines = new ArrayList<PersistedInvoiceLine>();
		// invoice line
		for (InvoiceLine line : invoice.getInvoiceLines()) {
			invoiceLines.add(_convertFromDto(line));
		}
		// call to SB to post 1 invoice
		PersistedInvoice persistedInvoice = customInvoiceService.addPersistedInvoice(invoice.getGst(),
				invoice.getCardCode(), invoice.getCardName(), invoice.getCarrier(), invoice.getDocumentDate(),
				invoice.getDocumentNumber(), invoice.getDocumentStatus(), invoice.getDueDate(),
				invoice.getFreightAmount(), invoice.getInvoiceTotal(), invoiceLines, _getServiceContext());
		return _convertToDto(persistedInvoice);
	}

	@Override
	public Invoice getInvoice(Long invoiceId) throws Exception {
		// call to SB to get 1 invoice
		Invoice invoice = _convertToDto(customInvoiceService.getPersistedInvoice(invoiceId));
		List<PersistedInvoiceLine> invoiceLines = customInvoiceLineService.findByInvoiceId(invoiceId);
		InvoiceLine[] list = new InvoiceLine[invoiceLines.size()];
		int i = 0;
		for (PersistedInvoiceLine line : invoiceLines) {
			list[i] = _convertToDto(line);
			i ++;
		}
		invoice.setInvoiceLines(list);
		return invoice;
	}

	@Override
	public Invoice putInvoice(Long invoiceId, Invoice invoice) throws Exception {

		List<PersistedInvoiceLine> invoiceLines = new ArrayList<PersistedInvoiceLine>();
		// invoice line
		for (InvoiceLine line : invoice.getInvoiceLines()) {
			invoiceLines.add(_convertFromDto(line));
		}

		PersistedInvoice persistedInvoice = customInvoiceService.updatePersistedInvoice(invoiceId, invoice.getGst(),
				invoice.getCardCode(), invoice.getCardName(), invoice.getCarrier(), invoice.getDocumentDate(),
				invoice.getDocumentNumber(), invoice.getDocumentStatus(), invoice.getDueDate(),
				invoice.getFreightAmount(), invoice.getInvoiceTotal(), invoiceLines, _getServiceContext());
		return _convertToDto(persistedInvoice);
	}

	@Override
	public Invoice patchInvoice(Long invoiceId, Invoice invoice) throws Exception {
		List<PersistedInvoiceLine> invoiceLines = null;
		if (invoice.getInvoiceLines() != null) {
			invoiceLines = new ArrayList<PersistedInvoiceLine>();
			for (InvoiceLine line : invoice.getInvoiceLines()) {
				invoiceLines.add(_convertFromDto(line));
			}
		}
		PersistedInvoice persistedInvoice = customInvoiceService.patchPersistedInvoice(invoiceId, invoice.getGst(),
				invoice.getCardCode(), invoice.getCardName(), invoice.getCarrier(), invoice.getDocumentDate(),
				invoice.getDocumentNumber(), invoice.getDocumentStatus(), invoice.getDueDate(),
				invoice.getFreightAmount(), invoice.getInvoiceTotal(), invoiceLines, _getServiceContext());
		return _convertToDto(persistedInvoice);
	}

	@Override
	public void deleteInvoice(Long invoiceId) throws Exception {
		customInvoiceService.deletePersistedInvoice(invoiceId);
	}

	private InvoiceLine _convertToDto(PersistedInvoiceLine persistedCustomInvoiceLine) {
		InvoiceLine invoiceLine = new InvoiceLine();
		invoiceLine.setDiscountPercent(persistedCustomInvoiceLine.getDiscountPercent());
		invoiceLine.setItemCode(persistedCustomInvoiceLine.getItemCode());
		invoiceLine.setLineNum(persistedCustomInvoiceLine.getLineNum());
		invoiceLine.setLineTotal(persistedCustomInvoiceLine.getLineTotal());
		invoiceLine.setPrice(persistedCustomInvoiceLine.getPrice());
		invoiceLine.setQuantity(persistedCustomInvoiceLine.getQuantity());
		invoiceLine.setSalesOrder(persistedCustomInvoiceLine.getSalesOrder());
		invoiceLine.setSalesOrderlineNum(persistedCustomInvoiceLine.getSalesOrderlineNum());

		return invoiceLine;
	}

	private PersistedInvoiceLine _convertFromDto(InvoiceLine invoiceLine) {
		PersistedInvoiceLine pInvoiceLine = customInvoiceLineService.createNewPersistedInvoiceLine();
		pInvoiceLine.setDiscountPercent(invoiceLine.getDiscountPercent());
		pInvoiceLine.setItemCode(invoiceLine.getItemCode());
		pInvoiceLine.setLineNum(invoiceLine.getLineNum());
		pInvoiceLine.setLineTotal(invoiceLine.getLineTotal());
		pInvoiceLine.setPrice(invoiceLine.getPrice());
		pInvoiceLine.setQuantity(invoiceLine.getQuantity());
		pInvoiceLine.setSalesOrder(invoiceLine.getSalesOrder());
		pInvoiceLine.setSalesOrderlineNum(invoiceLine.getSalesOrderlineNum());

		return pInvoiceLine;
	}

	private Invoice _convertToDto(PersistedInvoice persistedInvoice) {
		Invoice invoice = new Invoice();
		invoice.setCardCode(persistedInvoice.getCardCode());
		invoice.setCardName(persistedInvoice.getCardName());
		invoice.setCarrier(persistedInvoice.getCarrier());
		invoice.setDocumentDate(persistedInvoice.getDocumentDate());
		invoice.setDocumentNumber(persistedInvoice.getDocumentNumber());
		invoice.setDocumentStatus(persistedInvoice.getDocumentStatus());
		invoice.setInvoiceTotal(persistedInvoice.getInvoiceTotal());
		invoice.setFreightAmount(persistedInvoice.getFreightAmount());
		invoice.setGst(persistedInvoice.getGst());
		invoice.setId(persistedInvoice.getPersistedInvoiceId());
		return invoice;
	}

	private List<Invoice> _convertToDtoList(List<PersistedInvoice> customInvoices) {
		List<Invoice> invoices = new ArrayList<Invoice>();
		for (PersistedInvoice persistedInvoice : customInvoices) {
			invoices.add(_convertToDto(persistedInvoice));
		}
		return invoices;
	}

	

	

	@Reference
	private PersistedInvoiceLineService customInvoiceLineService;
	
	@Reference
	private PersistedInvoiceService customInvoiceService;
	protected ServiceContext _getServiceContext() throws PortalException {
		ServiceContext serviceContext = ServiceContextUtil.createServiceContext(0, "anyone");
		serviceContext.setCompanyId(contextCompany.getCompanyId());

		// need the current user in the service context.
		// will get easier in newer version of the REST Builder plugin...
		// but for now, this is the only game in town.
		long userId = PrincipalThreadLocal.getUserId();
		serviceContext.setScopeGroupId(contextCompany.getGroupId());
		serviceContext.setUserId(userId);

		return serviceContext;
	}
	
	private static final Logger _log = LoggerFactory.getLogger(InvoiceResourceImpl.class);

}