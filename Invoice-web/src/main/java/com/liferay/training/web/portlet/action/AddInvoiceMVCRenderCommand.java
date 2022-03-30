package com.liferay.training.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.web.constants.InvoicePortletKeys;
import com.liferay.training.web.constants.MVCCommandNames;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

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
		// Set back icon visible.

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		String redirect = renderRequest.getParameter("redirect");
		//renderRequest.setAttribute("previewRender", false);

		portletDisplay.setURLBack(redirect);
		// Set assignment to the request attributes.
		return "/invoice/add_invoice.jsp";
	}

}