package com.liferay.training.headless.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.training.headless.dto.v1_0.Invoice;
import com.liferay.training.headless.resource.v1_0.InvoiceResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author ces-user
 * @generated
 */
@Generated("")
public class Query {

	public static void setInvoiceResourceComponentServiceObjects(
		ComponentServiceObjects<InvoiceResource>
			invoiceResourceComponentServiceObjects) {

		_invoiceResourceComponentServiceObjects =
			invoiceResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {invoices(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the list of Invoices Results can be paginated, filtered, searched, and sorted."
	)
	public InvoicePage invoices(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_invoiceResourceComponentServiceObjects,
			this::_populateResourceContext,
			invoiceResource -> new InvoicePage(
				invoiceResource.getInvoicesPage(
					search,
					_filterBiFunction.apply(invoiceResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(invoiceResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {invoice(invoiceId: ___){gst, id, cardCode, cardName, carrier, documentDate, documentNumber, documentStatus, dueDate, freightAmount, invoiceTotal, invoiceLines}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the Invoice via its ID.")
	public Invoice invoice(@GraphQLName("invoiceId") Long invoiceId)
		throws Exception {

		return _applyComponentServiceObjects(
			_invoiceResourceComponentServiceObjects,
			this::_populateResourceContext,
			invoiceResource -> invoiceResource.getInvoice(invoiceId));
	}

	@GraphQLName("InvoicePage")
	public class InvoicePage {

		public InvoicePage(Page invoicePage) {
			actions = invoicePage.getActions();

			items = invoicePage.getItems();
			lastPage = invoicePage.getLastPage();
			page = invoicePage.getPage();
			pageSize = invoicePage.getPageSize();
			totalCount = invoicePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Invoice> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}