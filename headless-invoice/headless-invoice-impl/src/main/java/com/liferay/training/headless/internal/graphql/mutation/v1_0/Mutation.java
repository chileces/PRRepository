package com.liferay.training.headless.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.training.headless.dto.v1_0.Invoice;
import com.liferay.training.headless.resource.v1_0.InvoiceResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author ces-user
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setInvoiceResourceComponentServiceObjects(
		ComponentServiceObjects<InvoiceResource>
			invoiceResourceComponentServiceObjects) {

		_invoiceResourceComponentServiceObjects =
			invoiceResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Create a new Invoice record")
	public Invoice createInvoice(@GraphQLName("invoice") Invoice invoice)
		throws Exception {

		return _applyComponentServiceObjects(
			_invoiceResourceComponentServiceObjects,
			this::_populateResourceContext,
			invoiceResource -> invoiceResource.postInvoice(invoice));
	}

	@GraphQLField
	public Response createInvoiceBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_invoiceResourceComponentServiceObjects,
			this::_populateResourceContext,
			invoiceResource -> invoiceResource.postInvoiceBatch(
				callbackURL, object));
	}

	@GraphQLField(
		description = "Deletes the Invoice and returns a 204 if the operation succeeds."
	)
	public boolean deleteInvoice(@GraphQLName("invoiceId") Long invoiceId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_invoiceResourceComponentServiceObjects,
			this::_populateResourceContext,
			invoiceResource -> invoiceResource.deleteInvoice(invoiceId));

		return true;
	}

	@GraphQLField
	public Response deleteInvoiceBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_invoiceResourceComponentServiceObjects,
			this::_populateResourceContext,
			invoiceResource -> invoiceResource.deleteInvoiceBatch(
				callbackURL, object));
	}

	@GraphQLField(
		description = "Replaces the Invoice with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public Invoice patchInvoice(
			@GraphQLName("invoiceId") Long invoiceId,
			@GraphQLName("invoice") Invoice invoice)
		throws Exception {

		return _applyComponentServiceObjects(
			_invoiceResourceComponentServiceObjects,
			this::_populateResourceContext,
			invoiceResource -> invoiceResource.patchInvoice(
				invoiceId, invoice));
	}

	@GraphQLField(
		description = "Replaces the Invoice, the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	public Invoice updateInvoice(
			@GraphQLName("invoiceId") Long invoiceId,
			@GraphQLName("invoice") Invoice invoice)
		throws Exception {

		return _applyComponentServiceObjects(
			_invoiceResourceComponentServiceObjects,
			this::_populateResourceContext,
			invoiceResource -> invoiceResource.putInvoice(invoiceId, invoice));
	}

	@GraphQLField
	public Response updateInvoiceBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_invoiceResourceComponentServiceObjects,
			this::_populateResourceContext,
			invoiceResource -> invoiceResource.putInvoiceBatch(
				callbackURL, object));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(InvoiceResource invoiceResource)
		throws Exception {

		invoiceResource.setContextAcceptLanguage(_acceptLanguage);
		invoiceResource.setContextCompany(_company);
		invoiceResource.setContextHttpServletRequest(_httpServletRequest);
		invoiceResource.setContextHttpServletResponse(_httpServletResponse);
		invoiceResource.setContextUriInfo(_uriInfo);
		invoiceResource.setContextUser(_user);
		invoiceResource.setGroupLocalService(_groupLocalService);
		invoiceResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<InvoiceResource>
		_invoiceResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}