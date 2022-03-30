package com.liferay.training.internal.security.permission.resource;

import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.training.constants.InvoiceConstants;
import com.liferay.training.model.PersistedInvoiceLine;
import com.liferay.training.service.PersistedInvoiceLineLocalService;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class PersistedInvoiceLineModelResourcePermissionRegistrar {
	@Activate
	public void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();

		properties.put("model.class.name", PersistedInvoiceLine.class.getName());

		_serviceRegistration = bundleContext.registerService(
				ModelResourcePermission.class,
				ModelResourcePermissionFactory.create(
						PersistedInvoiceLine.class, PersistedInvoiceLine::getPersistedInvoiceId,
						_persistedInvoiceLineLocalService::getPersistedInvoiceLine, _portletResourcePermission,
						(modelResourcePermission, consumer) -> {
							// nothing to accept
						}),
				properties);
	}

	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference
	private PersistedInvoiceLineLocalService _persistedInvoiceLineLocalService;

	@Reference(target = "(resource.name=" + InvoiceConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;

	private ServiceRegistration<ModelResourcePermission> _serviceRegistration;
}
