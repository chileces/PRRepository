package com.liferay.training.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.service.PersistedInvoiceService;
import com.liferay.training.web.constants.InvoicePortletKeys;
import com.liferay.training.web.constants.MVCCommandNames;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(immediate = true, property = { "javax.portlet.name=" + InvoicePortletKeys.INVOICE,
		"mvc.command.name=" + MVCCommandNames.DELETE_INVOICE }, service = MVCActionCommand.class)
public class DeleteInvoiceMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		//get assignment Id
		long persistedInvoiceId = ParamUtil.getLong(actionRequest, "persistedInvoiceId");
		try {
			_persistedInvoiceService.deletePersistedInvoice(persistedInvoiceId);
			//set delete success message
			SessionMessages.add(actionRequest, "Invoice deleted");
			sendRedirect(actionRequest, actionResponse);		
		} catch (PortalException portalException) {
			SessionErrors.add(actionRequest, "serviceErrorDetails", portalException);
		}
			
	}
	
	@Reference
	private PersistedInvoiceService _persistedInvoiceService; 
}
