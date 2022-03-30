package com.liferay.training.web.internal.security.permission.resource;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.training.constants.InvoiceConstants;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class InvoiceToplevelPermission {
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {
		return _portletResourcePermission.contains(permissionChecker, groupId, actionId);
	}
	
	@Reference(target="(resource.name=" + InvoiceConstants.RESOURCE_NAME + ")", unbind = "-")
	protected void setPortletResourcePermission(PortletResourcePermission portletResourcePermission) {
		_portletResourcePermission = portletResourcePermission;
	}
	
	private static PortletResourcePermission _portletResourcePermission;
}
