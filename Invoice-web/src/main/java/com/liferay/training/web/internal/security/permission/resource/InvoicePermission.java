package com.liferay.training.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.training.constants.InvoiceConstants;
import com.liferay.training.model.PersistedInvoice;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = InvoicePermission.class) // entity permission checking
public class InvoicePermission {
	
	public static boolean contains(PermissionChecker permissionChecker, long invoiceId, String actionId)
			throws PortalException {
		return _invoiceModelResourcePermission.contains(permissionChecker, invoiceId, actionId);
	}

	@Reference(target = "(model.class.name=" + InvoiceConstants.RESOURCE_INVOICE_NAME + ")", unbind = "-")
	protected void setEntryModelPermission(ModelResourcePermission<PersistedInvoice> modelResourcePermission) {
		_invoiceModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<PersistedInvoice> _invoiceModelResourcePermission;
}
