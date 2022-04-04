package com.liferay.training.web.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.model.PersistedInvoice;
import com.liferay.training.model.PersistedInvoiceLine;
import com.liferay.training.service.PersistedInvoiceLineService;
import com.liferay.training.service.PersistedInvoiceService;
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
 * MVC Command for showing the assignment submissions list view.
 *
 * @author liferay
 */
@Component(immediate = true, property = { "javax.portlet.name=" + InvoicePortletKeys.INVOICE,
		"mvc.command.name=" + MVCCommandNames.VIEW_INVOICE }, service = MVCRenderCommand.class)
public class ViewSingleInvoiceMVCRenderCommand implements MVCRenderCommand {
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long persistedInvoiceId = ParamUtil.getLong(renderRequest, "persistedInvoiceId", 0);
		// Resolve start and end for the search.
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;

		try {
			// Call the service to get the assignment.
			PersistedInvoice persistedInvoice = _persistedInvoiceService.getPersistedInvoice(persistedInvoiceId);
			List<PersistedInvoiceLine> invoiceLines = _persistedInvoiceLineService
					.findByInvoiceId(persistedInvoiceId, start, end);
			int searchCount = _persistedInvoiceLineService.countByCustomInvoiceId(persistedInvoiceId);

			// Set attributes to the request.
			PortletURL iteratorURL = renderResponse.createRenderURL();
			iteratorURL.setParameter("mvcRenderCommandName", MVCCommandNames.VIEW_INVOICE);
			iteratorURL.setParameter("persistedInvoiceId", String.valueOf(persistedInvoiceId));

			renderRequest.setAttribute("iteratorInvoiceLineURL", iteratorURL);
			renderRequest.setAttribute("persistedInvoice", persistedInvoice);
			renderRequest.setAttribute("invoiceLines", invoiceLines);
			renderRequest.setAttribute("searchCount", searchCount);
			renderRequest.setAttribute("persistedInvoiceClass", PersistedInvoice.class);

//			// Set back icon visible.
			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
			String redirect = renderRequest.getParameter("redirect");
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(redirect);
			return "/invoice/view_invoice.jsp";
		} catch (PortalException pe) {
			throw new PortletException(pe);
		}
	}

	@Reference
	private PersistedInvoiceService _persistedInvoiceService;
	@Reference
	private PersistedInvoiceLineService _persistedInvoiceLineService;

	@Reference
	private Portal _portal;
	@Reference
	private UserLocalService _userLocalService;
}