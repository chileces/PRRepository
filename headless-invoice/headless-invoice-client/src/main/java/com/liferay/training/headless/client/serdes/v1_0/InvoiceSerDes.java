package com.liferay.training.headless.client.serdes.v1_0;

import com.liferay.training.headless.client.dto.v1_0.Invoice;
import com.liferay.training.headless.client.dto.v1_0.InvoiceLine;
import com.liferay.training.headless.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author ces-user
 * @generated
 */
@Generated("")
public class InvoiceSerDes {

	public static Invoice toDTO(String json) {
		InvoiceJSONParser invoiceJSONParser = new InvoiceJSONParser();

		return invoiceJSONParser.parseToDTO(json);
	}

	public static Invoice[] toDTOs(String json) {
		InvoiceJSONParser invoiceJSONParser = new InvoiceJSONParser();

		return invoiceJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Invoice invoice) {
		if (invoice == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (invoice.getCardCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"cardCode\": ");

			sb.append("\"");

			sb.append(_escape(invoice.getCardCode()));

			sb.append("\"");
		}

		if (invoice.getCardName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"cardName\": ");

			sb.append("\"");

			sb.append(_escape(invoice.getCardName()));

			sb.append("\"");
		}

		if (invoice.getCarrier() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"carrier\": ");

			sb.append("\"");

			sb.append(_escape(invoice.getCarrier()));

			sb.append("\"");
		}

		if (invoice.getCommerceAccountId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commerceAccountId\": ");

			sb.append(invoice.getCommerceAccountId());
		}

		if (invoice.getDocumentDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"documentDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(invoice.getDocumentDate()));

			sb.append("\"");
		}

		if (invoice.getDocumentNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"documentNumber\": ");

			sb.append("\"");

			sb.append(_escape(invoice.getDocumentNumber()));

			sb.append("\"");
		}

		if (invoice.getDocumentStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"documentStatus\": ");

			sb.append("\"");

			sb.append(_escape(invoice.getDocumentStatus()));

			sb.append("\"");
		}

		if (invoice.getDueDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dueDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(invoice.getDueDate()));

			sb.append("\"");
		}

		if (invoice.getFreightAmount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"freightAmount\": ");

			sb.append(invoice.getFreightAmount());
		}

		if (invoice.getGst() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"gst\": ");

			sb.append(invoice.getGst());
		}

		if (invoice.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(invoice.getId());
		}

		if (invoice.getInvoiceLines() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"invoiceLines\": ");

			sb.append("[");

			for (int i = 0; i < invoice.getInvoiceLines().length; i++) {
				sb.append(String.valueOf(invoice.getInvoiceLines()[i]));

				if ((i + 1) < invoice.getInvoiceLines().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (invoice.getInvoiceTotal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"invoiceTotal\": ");

			sb.append(invoice.getInvoiceTotal());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		InvoiceJSONParser invoiceJSONParser = new InvoiceJSONParser();

		return invoiceJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Invoice invoice) {
		if (invoice == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (invoice.getCardCode() == null) {
			map.put("cardCode", null);
		}
		else {
			map.put("cardCode", String.valueOf(invoice.getCardCode()));
		}

		if (invoice.getCardName() == null) {
			map.put("cardName", null);
		}
		else {
			map.put("cardName", String.valueOf(invoice.getCardName()));
		}

		if (invoice.getCarrier() == null) {
			map.put("carrier", null);
		}
		else {
			map.put("carrier", String.valueOf(invoice.getCarrier()));
		}

		if (invoice.getCommerceAccountId() == null) {
			map.put("commerceAccountId", null);
		}
		else {
			map.put(
				"commerceAccountId",
				String.valueOf(invoice.getCommerceAccountId()));
		}

		if (invoice.getDocumentDate() == null) {
			map.put("documentDate", null);
		}
		else {
			map.put(
				"documentDate",
				liferayToJSONDateFormat.format(invoice.getDocumentDate()));
		}

		if (invoice.getDocumentNumber() == null) {
			map.put("documentNumber", null);
		}
		else {
			map.put(
				"documentNumber", String.valueOf(invoice.getDocumentNumber()));
		}

		if (invoice.getDocumentStatus() == null) {
			map.put("documentStatus", null);
		}
		else {
			map.put(
				"documentStatus", String.valueOf(invoice.getDocumentStatus()));
		}

		if (invoice.getDueDate() == null) {
			map.put("dueDate", null);
		}
		else {
			map.put(
				"dueDate",
				liferayToJSONDateFormat.format(invoice.getDueDate()));
		}

		if (invoice.getFreightAmount() == null) {
			map.put("freightAmount", null);
		}
		else {
			map.put(
				"freightAmount", String.valueOf(invoice.getFreightAmount()));
		}

		if (invoice.getGst() == null) {
			map.put("gst", null);
		}
		else {
			map.put("gst", String.valueOf(invoice.getGst()));
		}

		if (invoice.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(invoice.getId()));
		}

		if (invoice.getInvoiceLines() == null) {
			map.put("invoiceLines", null);
		}
		else {
			map.put("invoiceLines", String.valueOf(invoice.getInvoiceLines()));
		}

		if (invoice.getInvoiceTotal() == null) {
			map.put("invoiceTotal", null);
		}
		else {
			map.put("invoiceTotal", String.valueOf(invoice.getInvoiceTotal()));
		}

		return map;
	}

	public static class InvoiceJSONParser extends BaseJSONParser<Invoice> {

		@Override
		protected Invoice createDTO() {
			return new Invoice();
		}

		@Override
		protected Invoice[] createDTOArray(int size) {
			return new Invoice[size];
		}

		@Override
		protected void setField(
			Invoice invoice, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "cardCode")) {
				if (jsonParserFieldValue != null) {
					invoice.setCardCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "cardName")) {
				if (jsonParserFieldValue != null) {
					invoice.setCardName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "carrier")) {
				if (jsonParserFieldValue != null) {
					invoice.setCarrier((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "commerceAccountId")) {
				if (jsonParserFieldValue != null) {
					invoice.setCommerceAccountId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "documentDate")) {
				if (jsonParserFieldValue != null) {
					invoice.setDocumentDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "documentNumber")) {
				if (jsonParserFieldValue != null) {
					invoice.setDocumentNumber((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "documentStatus")) {
				if (jsonParserFieldValue != null) {
					invoice.setDocumentStatus((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dueDate")) {
				if (jsonParserFieldValue != null) {
					invoice.setDueDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "freightAmount")) {
				if (jsonParserFieldValue != null) {
					invoice.setFreightAmount(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "gst")) {
				if (jsonParserFieldValue != null) {
					invoice.setGst(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					invoice.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "invoiceLines")) {
				if (jsonParserFieldValue != null) {
					invoice.setInvoiceLines(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> InvoiceLineSerDes.toDTO((String)object)
						).toArray(
							size -> new InvoiceLine[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "invoiceTotal")) {
				if (jsonParserFieldValue != null) {
					invoice.setInvoiceTotal(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}