package com.liferay.training.web.portlet.action;

import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.product.constants.CPField;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.training.model.PersistedInvoice;
import com.liferay.training.service.PersistedInvoiceService;
import com.liferay.training.web.constants.InvoicePortletKeys;
import com.liferay.training.web.constants.MVCCommandNames;
import com.liferay.training.web.display.context.InvoicesManagementToolbarDisplayContext;
import com.liferay.training.web.internal.security.permission.resource.InvoicePermission;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

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
//		OrderByComparator<PersistedInvoice> comparator = OrderByComparatorFactoryUtil.create("PersistedInvoice",
//				orderByCol,
//				!("asc").equals(orderByType));
		
		// Get keywords.
		
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		List<PersistedInvoice> results = null;
		long count = 0;
		Pagination pagination = Pagination.of(currentPage, delta);
		//commerceAccountId eq commerceAccountId
		long commerceAccountId = 0;
		HttpServletRequest httpServletRequest =
				_portal.getHttpServletRequest(renderRequest);
		CommerceContext _commerceContext = (CommerceContext)httpServletRequest.getAttribute(
				CommerceWebKeys.COMMERCE_CONTEXT);
		if (_commerceContext != null) {
			try {
				commerceAccountId = _commerceContext.getCommerceAccount().getCommerceAccountId();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		BooleanFilter filter= new BooleanFilter();
		filter.add(
				new TermFilter(
					"commerceAccountId", String.valueOf(commerceAccountId)),
				BooleanClauseOccur.MUST);
		
		Sort[] sort = _getCommerceOrderSorts(orderByCol, orderByType);
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Page<PersistedInvoice> searchResults = _persistedInvoiceService.getInvoicesByKeywords(themeDisplay.getCompanyId(),
					keywords, filter,pagination, sort);
			count = searchResults.getTotalCount();
			results = new ArrayList<PersistedInvoice>(searchResults.getItems());
			//results.sort(comparator);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PortletURL iteratorURL = renderResponse.createRenderURL();
		renderRequest.setAttribute("iteratorURL", iteratorURL);
		renderRequest.setAttribute("searchResults", results);
		renderRequest.setAttribute("searchCount", count);
		
	}
	
	
	private Sort[] _getCommerceOrderSorts(
			String orderByCol, String orderByType) {

			if (Validator.isNull(orderByCol) || Validator.isNull(orderByType)) {
				return SortFactoryUtil.getDefaultSorts();
			}

			boolean reverse = true;

			if (orderByType.equals("asc")) {
				reverse = false;
			}

			if (orderByCol.equals("cardName")) {
				return new Sort[] {
					SortFactoryUtil.create("cardName_sortable", reverse),//Field.getSortableFieldName("cardName")
					SortFactoryUtil.create(null, Sort.SCORE_TYPE, false)
				};
			}

			if (orderByCol.equals("documentNumber")) {
				return new Sort[] {
					SortFactoryUtil.create(Field.getSortableFieldName("documentNumber"), reverse),
					SortFactoryUtil.create(null, Sort.SCORE_TYPE, reverse)
				};
			}			
			else if (orderByCol.equals("invoiceTotal")) {
				return new Sort[] {
					SortFactoryUtil.create("invoiceTotal_sortable", reverse),//Field.getSortableFieldName("invoiceTotal")
					SortFactoryUtil.create(null, Sort.SCORE_TYPE, false)
				};
			}

			return SortFactoryUtil.getDefaultSorts();
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
