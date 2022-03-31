package com.liferay.training.web.portlet.action;

import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.web.constants.InvoicePortletKeys;
import com.liferay.training.web.constants.MVCCommandNames;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Command for showing edit assignment view.
 *
 * @author liferay
 */
@Component(immediate = true, property = { "javax.portlet.name=" + InvoicePortletKeys.INVOICE,
		"mvc.command.name=" + MVCCommandNames.ADD_INVOICE }, service = MVCRenderCommand.class)
public class AddInvoiceMVCRenderCommand implements MVCRenderCommand {
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// Resolve start and end for the search.
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;
		// Set back icon visible.
		
		List<CommerceOrder> orders = _commerceOrderLocalService.getCommerceOrders(start, end);
		long searchCount = _commerceOrderLocalService.getCommerceOrdersCount();
		PortletURL iteratorURL = renderResponse.createRenderURL();
		iteratorURL.setParameter("mvcRenderCommandName", MVCCommandNames.ADD_INVOICE);
		renderRequest.setAttribute("iteratorURL", iteratorURL);
		renderRequest.setAttribute("searchCount", searchCount);
		renderRequest.setAttribute("orders", orders);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		String redirect = renderRequest.getParameter("redirect");
		// renderRequest.setAttribute("previewRender", false);

		 portletDisplay.setURLBack(redirect);
		//Set assignment to the request attributes.
		return "/invoice/add_invoice.jsp";
	}

	@Reference
	private CommerceOrderLocalService _commerceOrderLocalService;

}