package com.liferay.training.headless.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.training.headless.client.dto.v1_0.Invoice;
import com.liferay.training.headless.client.http.HttpInvoker;
import com.liferay.training.headless.client.pagination.Page;
import com.liferay.training.headless.client.pagination.Pagination;
import com.liferay.training.headless.client.resource.v1_0.InvoiceResource;
import com.liferay.training.headless.client.serdes.v1_0.InvoiceSerDes;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author ces-user
 * @generated
 */
@Generated("")
public abstract class BaseInvoiceResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_invoiceResource.setContextCompany(testCompany);

		InvoiceResource.Builder builder = InvoiceResource.builder();

		invoiceResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Invoice invoice1 = randomInvoice();

		String json = objectMapper.writeValueAsString(invoice1);

		Invoice invoice2 = InvoiceSerDes.toDTO(json);

		Assert.assertTrue(equals(invoice1, invoice2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Invoice invoice = randomInvoice();

		String json1 = objectMapper.writeValueAsString(invoice);
		String json2 = InvoiceSerDes.toJSON(invoice);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Invoice invoice = randomInvoice();

		invoice.setCardCode(regex);
		invoice.setCardName(regex);
		invoice.setCarrier(regex);
		invoice.setDocumentNumber(regex);
		invoice.setDocumentStatus(regex);

		String json = InvoiceSerDes.toJSON(invoice);

		Assert.assertFalse(json.contains(regex));

		invoice = InvoiceSerDes.toDTO(json);

		Assert.assertEquals(regex, invoice.getCardCode());
		Assert.assertEquals(regex, invoice.getCardName());
		Assert.assertEquals(regex, invoice.getCarrier());
		Assert.assertEquals(regex, invoice.getDocumentNumber());
		Assert.assertEquals(regex, invoice.getDocumentStatus());
	}

	@Test
	public void testGetInvoicesPage() throws Exception {
		Page<Invoice> page = invoiceResource.getInvoicesPage(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Invoice invoice1 = testGetInvoicesPage_addInvoice(randomInvoice());

		Invoice invoice2 = testGetInvoicesPage_addInvoice(randomInvoice());

		page = invoiceResource.getInvoicesPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(invoice1, (List<Invoice>)page.getItems());
		assertContains(invoice2, (List<Invoice>)page.getItems());
		assertValid(page);

		invoiceResource.deleteInvoice(invoice1.getId());

		invoiceResource.deleteInvoice(invoice2.getId());
	}

	@Test
	public void testGetInvoicesPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Invoice invoice1 = randomInvoice();

		invoice1 = testGetInvoicesPage_addInvoice(invoice1);

		for (EntityField entityField : entityFields) {
			Page<Invoice> page = invoiceResource.getInvoicesPage(
				null, getFilterString(entityField, "between", invoice1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(invoice1),
				(List<Invoice>)page.getItems());
		}
	}

	@Test
	public void testGetInvoicesPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Invoice invoice1 = testGetInvoicesPage_addInvoice(randomInvoice());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Invoice invoice2 = testGetInvoicesPage_addInvoice(randomInvoice());

		for (EntityField entityField : entityFields) {
			Page<Invoice> page = invoiceResource.getInvoicesPage(
				null, getFilterString(entityField, "eq", invoice1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(invoice1),
				(List<Invoice>)page.getItems());
		}
	}

	@Test
	public void testGetInvoicesPageWithPagination() throws Exception {
		Page<Invoice> totalPage = invoiceResource.getInvoicesPage(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Invoice invoice1 = testGetInvoicesPage_addInvoice(randomInvoice());

		Invoice invoice2 = testGetInvoicesPage_addInvoice(randomInvoice());

		Invoice invoice3 = testGetInvoicesPage_addInvoice(randomInvoice());

		Page<Invoice> page1 = invoiceResource.getInvoicesPage(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Invoice> invoices1 = (List<Invoice>)page1.getItems();

		Assert.assertEquals(
			invoices1.toString(), totalCount + 2, invoices1.size());

		Page<Invoice> page2 = invoiceResource.getInvoicesPage(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Invoice> invoices2 = (List<Invoice>)page2.getItems();

		Assert.assertEquals(invoices2.toString(), 1, invoices2.size());

		Page<Invoice> page3 = invoiceResource.getInvoicesPage(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(invoice1, (List<Invoice>)page3.getItems());
		assertContains(invoice2, (List<Invoice>)page3.getItems());
		assertContains(invoice3, (List<Invoice>)page3.getItems());
	}

	@Test
	public void testGetInvoicesPageWithSortDateTime() throws Exception {
		testGetInvoicesPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, invoice1, invoice2) -> {
				BeanUtils.setProperty(
					invoice1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetInvoicesPageWithSortInteger() throws Exception {
		testGetInvoicesPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, invoice1, invoice2) -> {
				BeanUtils.setProperty(invoice1, entityField.getName(), 0);
				BeanUtils.setProperty(invoice2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetInvoicesPageWithSortString() throws Exception {
		testGetInvoicesPageWithSort(
			EntityField.Type.STRING,
			(entityField, invoice1, invoice2) -> {
				Class<?> clazz = invoice1.getClass();

				String entityFieldName = entityField.getName();

				java.lang.reflect.Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						invoice1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						invoice2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						invoice1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						invoice2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						invoice1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						invoice2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetInvoicesPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Invoice, Invoice, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Invoice invoice1 = randomInvoice();
		Invoice invoice2 = randomInvoice();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, invoice1, invoice2);
		}

		invoice1 = testGetInvoicesPage_addInvoice(invoice1);

		invoice2 = testGetInvoicesPage_addInvoice(invoice2);

		for (EntityField entityField : entityFields) {
			Page<Invoice> ascPage = invoiceResource.getInvoicesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(invoice1, invoice2),
				(List<Invoice>)ascPage.getItems());

			Page<Invoice> descPage = invoiceResource.getInvoicesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(invoice2, invoice1),
				(List<Invoice>)descPage.getItems());
		}
	}

	protected Invoice testGetInvoicesPage_addInvoice(Invoice invoice)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetInvoicesPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"invoices",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 10);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject invoicesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/invoices");

		long totalCount = invoicesJSONObject.getLong("totalCount");

		Invoice invoice1 = testGraphQLInvoice_addInvoice();
		Invoice invoice2 = testGraphQLInvoice_addInvoice();

		invoicesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/invoices");

		Assert.assertEquals(
			totalCount + 2, invoicesJSONObject.getLong("totalCount"));

		assertContains(
			invoice1,
			Arrays.asList(
				InvoiceSerDes.toDTOs(invoicesJSONObject.getString("items"))));
		assertContains(
			invoice2,
			Arrays.asList(
				InvoiceSerDes.toDTOs(invoicesJSONObject.getString("items"))));
	}

	@Test
	public void testPostInvoice() throws Exception {
		Invoice randomInvoice = randomInvoice();

		Invoice postInvoice = testPostInvoice_addInvoice(randomInvoice);

		assertEquals(randomInvoice, postInvoice);
		assertValid(postInvoice);
	}

	protected Invoice testPostInvoice_addInvoice(Invoice invoice)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteInvoice() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Invoice invoice = testDeleteInvoice_addInvoice();

		assertHttpResponseStatusCode(
			204, invoiceResource.deleteInvoiceHttpResponse(invoice.getId()));

		assertHttpResponseStatusCode(
			404, invoiceResource.getInvoiceHttpResponse(invoice.getId()));

		assertHttpResponseStatusCode(
			404, invoiceResource.getInvoiceHttpResponse(0L));
	}

	protected Invoice testDeleteInvoice_addInvoice() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteInvoice() throws Exception {
		Invoice invoice = testGraphQLInvoice_addInvoice();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteInvoice",
						new HashMap<String, Object>() {
							{
								put("invoiceId", invoice.getId());
							}
						})),
				"JSONObject/data", "Object/deleteInvoice"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"invoice",
					new HashMap<String, Object>() {
						{
							put("invoiceId", invoice.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetInvoice() throws Exception {
		Invoice postInvoice = testGetInvoice_addInvoice();

		Invoice getInvoice = invoiceResource.getInvoice(postInvoice.getId());

		assertEquals(postInvoice, getInvoice);
		assertValid(getInvoice);
	}

	protected Invoice testGetInvoice_addInvoice() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetInvoice() throws Exception {
		Invoice invoice = testGraphQLInvoice_addInvoice();

		Assert.assertTrue(
			equals(
				invoice,
				InvoiceSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"invoice",
								new HashMap<String, Object>() {
									{
										put("invoiceId", invoice.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/invoice"))));
	}

	@Test
	public void testGraphQLGetInvoiceNotFound() throws Exception {
		Long irrelevantInvoiceId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"invoice",
						new HashMap<String, Object>() {
							{
								put("invoiceId", irrelevantInvoiceId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPatchInvoice() throws Exception {
		Invoice postInvoice = testPatchInvoice_addInvoice();

		Invoice randomPatchInvoice = randomPatchInvoice();

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Invoice patchInvoice = invoiceResource.patchInvoice(
			postInvoice.getId(), randomPatchInvoice);

		Invoice expectedPatchInvoice = postInvoice.clone();

		_beanUtilsBean.copyProperties(expectedPatchInvoice, randomPatchInvoice);

		Invoice getInvoice = invoiceResource.getInvoice(patchInvoice.getId());

		assertEquals(expectedPatchInvoice, getInvoice);
		assertValid(getInvoice);
	}

	protected Invoice testPatchInvoice_addInvoice() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutInvoice() throws Exception {
		Invoice postInvoice = testPutInvoice_addInvoice();

		Invoice randomInvoice = randomInvoice();

		Invoice putInvoice = invoiceResource.putInvoice(
			postInvoice.getId(), randomInvoice);

		assertEquals(randomInvoice, putInvoice);
		assertValid(putInvoice);

		Invoice getInvoice = invoiceResource.getInvoice(putInvoice.getId());

		assertEquals(randomInvoice, getInvoice);
		assertValid(getInvoice);
	}

	protected Invoice testPutInvoice_addInvoice() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Invoice testGraphQLInvoice_addInvoice() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Invoice invoice, List<Invoice> invoices) {
		boolean contains = false;

		for (Invoice item : invoices) {
			if (equals(invoice, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(invoices + " does not contain " + invoice, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Invoice invoice1, Invoice invoice2) {
		Assert.assertTrue(
			invoice1 + " does not equal " + invoice2,
			equals(invoice1, invoice2));
	}

	protected void assertEquals(
		List<Invoice> invoices1, List<Invoice> invoices2) {

		Assert.assertEquals(invoices1.size(), invoices2.size());

		for (int i = 0; i < invoices1.size(); i++) {
			Invoice invoice1 = invoices1.get(i);
			Invoice invoice2 = invoices2.get(i);

			assertEquals(invoice1, invoice2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Invoice> invoices1, List<Invoice> invoices2) {

		Assert.assertEquals(invoices1.size(), invoices2.size());

		for (Invoice invoice1 : invoices1) {
			boolean contains = false;

			for (Invoice invoice2 : invoices2) {
				if (equals(invoice1, invoice2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				invoices2 + " does not contain " + invoice1, contains);
		}
	}

	protected void assertValid(Invoice invoice) throws Exception {
		boolean valid = true;

		if (invoice.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("cardCode", additionalAssertFieldName)) {
				if (invoice.getCardCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("cardName", additionalAssertFieldName)) {
				if (invoice.getCardName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("carrier", additionalAssertFieldName)) {
				if (invoice.getCarrier() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"commerceAccountId", additionalAssertFieldName)) {

				if (invoice.getCommerceAccountId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("documentDate", additionalAssertFieldName)) {
				if (invoice.getDocumentDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("documentNumber", additionalAssertFieldName)) {
				if (invoice.getDocumentNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("documentStatus", additionalAssertFieldName)) {
				if (invoice.getDocumentStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dueDate", additionalAssertFieldName)) {
				if (invoice.getDueDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("freightAmount", additionalAssertFieldName)) {
				if (invoice.getFreightAmount() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("gst", additionalAssertFieldName)) {
				if (invoice.getGst() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("invoiceLines", additionalAssertFieldName)) {
				if (invoice.getInvoiceLines() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("invoiceTotal", additionalAssertFieldName)) {
				if (invoice.getInvoiceTotal() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Invoice> page) {
		boolean valid = false;

		java.util.Collection<Invoice> invoices = page.getItems();

		int size = invoices.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.liferay.training.headless.dto.v1_0.Invoice.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Invoice invoice1, Invoice invoice2) {
		if (invoice1 == invoice2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("cardCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						invoice1.getCardCode(), invoice2.getCardCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("cardName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						invoice1.getCardName(), invoice2.getCardName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("carrier", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						invoice1.getCarrier(), invoice2.getCarrier())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"commerceAccountId", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						invoice1.getCommerceAccountId(),
						invoice2.getCommerceAccountId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("documentDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						invoice1.getDocumentDate(),
						invoice2.getDocumentDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("documentNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						invoice1.getDocumentNumber(),
						invoice2.getDocumentNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("documentStatus", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						invoice1.getDocumentStatus(),
						invoice2.getDocumentStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dueDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						invoice1.getDueDate(), invoice2.getDueDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("freightAmount", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						invoice1.getFreightAmount(),
						invoice2.getFreightAmount())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("gst", additionalAssertFieldName)) {
				if (!Objects.deepEquals(invoice1.getGst(), invoice2.getGst())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(invoice1.getId(), invoice2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("invoiceLines", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						invoice1.getInvoiceLines(),
						invoice2.getInvoiceLines())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("invoiceTotal", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						invoice1.getInvoiceTotal(),
						invoice2.getInvoiceTotal())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_invoiceResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_invoiceResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Invoice invoice) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("cardCode")) {
			sb.append("'");
			sb.append(String.valueOf(invoice.getCardCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("cardName")) {
			sb.append("'");
			sb.append(String.valueOf(invoice.getCardName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("carrier")) {
			sb.append("'");
			sb.append(String.valueOf(invoice.getCarrier()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("commerceAccountId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("documentDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(invoice.getDocumentDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(invoice.getDocumentDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(invoice.getDocumentDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("documentNumber")) {
			sb.append("'");
			sb.append(String.valueOf(invoice.getDocumentNumber()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("documentStatus")) {
			sb.append("'");
			sb.append(String.valueOf(invoice.getDocumentStatus()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("dueDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(invoice.getDueDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(invoice.getDueDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(invoice.getDueDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("freightAmount")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("gst")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("invoiceLines")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("invoiceTotal")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Invoice randomInvoice() throws Exception {
		return new Invoice() {
			{
				cardCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				cardName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				carrier = StringUtil.toLowerCase(RandomTestUtil.randomString());
				commerceAccountId = RandomTestUtil.randomLong();
				documentDate = RandomTestUtil.nextDate();
				documentNumber = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				documentStatus = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				dueDate = RandomTestUtil.nextDate();
				freightAmount = RandomTestUtil.randomDouble();
				gst = RandomTestUtil.randomDouble();
				id = RandomTestUtil.randomLong();
				invoiceTotal = RandomTestUtil.randomDouble();
			}
		};
	}

	protected Invoice randomIrrelevantInvoice() throws Exception {
		Invoice randomIrrelevantInvoice = randomInvoice();

		return randomIrrelevantInvoice;
	}

	protected Invoice randomPatchInvoice() throws Exception {
		return randomInvoice();
	}

	protected InvoiceResource invoiceResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseInvoiceResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.training.headless.resource.v1_0.InvoiceResource
		_invoiceResource;

}