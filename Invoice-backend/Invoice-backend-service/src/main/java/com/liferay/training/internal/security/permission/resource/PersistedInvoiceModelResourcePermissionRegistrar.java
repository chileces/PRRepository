package com.liferay.training.internal.security.permission.resource;

import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.training.constants.InvoiceConstants;
import com.liferay.training.model.PersistedInvoice;
import com.liferay.training.service.PersistedInvoiceLocalService;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class PersistedInvoiceModelResourcePermissionRegistrar {

	@Activate
	public void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();

		properties.put("model.class.name", PersistedInvoice.class.getName());

		_serviceRegistration = bundleContext.registerService(
				ModelResourcePermission.class,
				ModelResourcePermissionFactory.create(
						PersistedInvoice.class, PersistedInvoice::getPersistedInvoiceId,
						persistedInvoiceLocalService::getPersistedInvoice, _portletResourcePermission,
						(modelResourcePermission, consumer) -> {
							// nothing really to consume
						}),
				properties);
	}

	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference
	private PersistedInvoiceLocalService persistedInvoiceLocalService;

	@Reference(target = "(resource.name=" + InvoiceConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;

	private ServiceRegistration<ModelResourcePermission> _serviceRegistration;
}
