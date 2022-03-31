package com.liferay.training.web.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.training.model.PersistedInvoice;
import com.liferay.training.service.PersistedInvoiceService;
import com.liferay.training.web.constants.InvoicePortletKeys;
import com.liferay.training.web.constants.MVCCommandNames;
import com.liferay.training.web.display.context.InvoicesManagementToolbarDisplayContext;
import com.liferay.training.web.internal.security.permission.resource.InvoicePermission;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + InvoicePortletKeys.INVOICE,
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.VIEW_INVOICES }, service = MVCRenderCommand.class)
public class InvoicePortletMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		extractedData(renderRequest, renderResponse);		
		addManagementToolbarAttributes(renderRequest, renderResponse);
		renderRequest.setAttribute("invoicePermission", _invoicePermission);
		return "/view.jsp";
	}
	
	private void extractedData(RenderRequest renderRequest, RenderResponse renderResponse) {
		// Resolve start and end for the search.
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;
		
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "cardName");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");

		// Create comparator
		OrderByComparator<PersistedInvoice> comparator = OrderByComparatorFactoryUtil.create("PersistedInvoice",
				orderByCol,
				!("asc").equals(orderByType));
		
		// Get keywords.
		
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		List<PersistedInvoice> results = null;
		long count = 0;
		if (!"".equals(keywords)) {
			results = _persistedInvoiceService.getInvoicesByKeywords( keywords, start, end, comparator);
			count = _persistedInvoiceService.getInvoicesCountByKeywords(keywords);
		}else {
			count = _persistedInvoiceService.getInvoicesCountByKeywords(null);
			results = _persistedInvoiceService.getInvoicesByKeywords(null, start, end, comparator);
		}
		PortletURL iteratorURL = renderResponse.createRenderURL();
		renderRequest.setAttribute("iteratorURL", iteratorURL);
		renderRequest.setAttribute("searchResults", results);
		renderRequest.setAttribute("searchCount", count);
	}
	/**
	 * Adds Clay management toolbar context object to the request.
	 *
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void addManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		InvoicesManagementToolbarDisplayContext invoicesManagementToolbarDisplayContext = new InvoicesManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("invoicesManagementToolbarDisplayContext",
				invoicesManagementToolbarDisplayContext);
	}
	@Reference
	private PersistedInvoiceService _persistedInvoiceService;
	@Reference
	private Portal _portal;
	@Reference
	protected InvoicePermission _invoicePermission;
}
