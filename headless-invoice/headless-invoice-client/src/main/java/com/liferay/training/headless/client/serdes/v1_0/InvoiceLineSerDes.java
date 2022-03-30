package com.liferay.training.headless.client.serdes.v1_0;

import com.liferay.training.headless.client.dto.v1_0.InvoiceLine;
import com.liferay.training.headless.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author ces-user
 * @generated
 */
@Generated("")
public class InvoiceLineSerDes {

	public static InvoiceLine toDTO(String json) {
		InvoiceLineJSONParser invoiceLineJSONParser =
			new InvoiceLineJSONParser();

		return invoiceLineJSONParser.parseToDTO(json);
	}

	public static InvoiceLine[] toDTOs(String json) {
		InvoiceLineJSONParser invoiceLineJSONParser =
			new InvoiceLineJSONParser();

		return invoiceLineJSONParser.parseToDTOs(json);
	}

	public static String toJSON(InvoiceLine invoiceLine) {
		if (invoiceLine == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (invoiceLine.getDiscountPercent() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"discountPercent\": ");

			sb.append(invoiceLine.getDiscountPercent());
		}

		if (invoiceLine.getItemCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"itemCode\": ");

			sb.append("\"");

			sb.append(_escape(invoiceLine.getItemCode()));

			sb.append("\"");
		}

		if (invoiceLine.getLineNum() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lineNum\": ");

			sb.append(invoiceLine.getLineNum());
		}

		if (invoiceLine.getLineTotal() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lineTotal\": ");

			sb.append(invoiceLine.getLineTotal());
		}

		if (invoiceLine.getPrice() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"price\": ");

			sb.append(invoiceLine.getPrice());
		}

		if (invoiceLine.getQuantity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"quantity\": ");

			sb.append(invoiceLine.getQuantity());
		}

		if (invoiceLine.getSalesOrder() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"salesOrder\": ");

			sb.append(invoiceLine.getSalesOrder());
		}

		if (invoiceLine.getSalesOrderlineNum() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"salesOrderlineNum\": ");

			sb.append(invoiceLine.getSalesOrderlineNum());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		InvoiceLineJSONParser invoiceLineJSONParser =
			new InvoiceLineJSONParser();

		return invoiceLineJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(InvoiceLine invoiceLine) {
		if (invoiceLine == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (invoiceLine.getDiscountPercent() == null) {
			map.put("discountPercent", null);
		}
		else {
			map.put(
				"discountPercent",
				String.valueOf(invoiceLine.getDiscountPercent()));
		}

		if (invoiceLine.getItemCode() == null) {
			map.put("itemCode", null);
		}
		else {
			map.put("itemCode", String.valueOf(invoiceLine.getItemCode()));
		}

		if (invoiceLine.getLineNum() == null) {
			map.put("lineNum", null);
		}
		else {
			map.put("lineNum", String.valueOf(invoiceLine.getLineNum()));
		}

		if (invoiceLine.getLineTotal() == null) {
			map.put("lineTotal", null);
		}
		else {
			map.put("lineTotal", String.valueOf(invoiceLine.getLineTotal()));
		}

		if (invoiceLine.getPrice() == null) {
			map.put("price", null);
		}
		else {
			map.put("price", String.valueOf(invoiceLine.getPrice()));
		}

		if (invoiceLine.getQuantity() == null) {
			map.put("quantity", null);
		}
		else {
			map.put("quantity", String.valueOf(invoiceLine.getQuantity()));
		}

		if (invoiceLine.getSalesOrder() == null) {
			map.put("salesOrder", null);
		}
		else {
			map.put("salesOrder", String.valueOf(invoiceLine.getSalesOrder()));
		}

		if (invoiceLine.getSalesOrderlineNum() == null) {
			map.put("salesOrderlineNum", null);
		}
		else {
			map.put(
				"salesOrderlineNum",
				String.valueOf(invoiceLine.getSalesOrderlineNum()));
		}

		return map;
	}

	public static class InvoiceLineJSONParser
		extends BaseJSONParser<InvoiceLine> {

		@Override
		protected InvoiceLine createDTO() {
			return new InvoiceLine();
		}

		@Override
		protected InvoiceLine[] createDTOArray(int size) {
			return new InvoiceLine[size];
		}

		@Override
		protected void setField(
			InvoiceLine invoiceLine, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "discountPercent")) {
				if (jsonParserFieldValue != null) {
					invoiceLine.setDiscountPercent(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "itemCode")) {
				if (jsonParserFieldValue != null) {
					invoiceLine.setItemCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lineNum")) {
				if (jsonParserFieldValue != null) {
					invoiceLine.setLineNum(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lineTotal")) {
				if (jsonParserFieldValue != null) {
					invoiceLine.setLineTotal(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "price")) {
				if (jsonParserFieldValue != null) {
					invoiceLine.setPrice(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "quantity")) {
				if (jsonParserFieldValue != null) {
					invoiceLine.setQuantity(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "salesOrder")) {
				if (jsonParserFieldValue != null) {
					invoiceLine.setSalesOrder(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "salesOrderlineNum")) {
				if (jsonParserFieldValue != null) {
					invoiceLine.setSalesOrderlineNum(
						Integer.valueOf((String)jsonParserFieldValue));
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