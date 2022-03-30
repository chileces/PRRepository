package com.liferay.training.headless.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ces-user
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "This object is mapped with commerceorderitem",
	value = "InvoiceLine"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "InvoiceLine")
public class InvoiceLine implements Serializable {

	public static InvoiceLine toDTO(String json) {
		return ObjectMapperUtil.readValue(InvoiceLine.class, json);
	}

	public static InvoiceLine unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(InvoiceLine.class, json);
	}

	@Schema(description = "Discount percent")
	public Double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}

	@JsonIgnore
	public void setDiscountPercent(
		UnsafeSupplier<Double, Exception> discountPercentUnsafeSupplier) {

		try {
			discountPercent = discountPercentUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Discount percent")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double discountPercent;

	@Schema(description = "A commerce product SKU")
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@JsonIgnore
	public void setItemCode(
		UnsafeSupplier<String, Exception> itemCodeUnsafeSupplier) {

		try {
			itemCode = itemCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "A commerce product SKU")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String itemCode;

	@Schema(description = "Line number")
	public Integer getLineNum() {
		return lineNum;
	}

	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}

	@JsonIgnore
	public void setLineNum(
		UnsafeSupplier<Integer, Exception> lineNumUnsafeSupplier) {

		try {
			lineNum = lineNumUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Line number")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer lineNum;

	@Schema(description = "Line total")
	public Double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}

	@JsonIgnore
	public void setLineTotal(
		UnsafeSupplier<Double, Exception> lineTotalUnsafeSupplier) {

		try {
			lineTotal = lineTotalUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Line total")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double lineTotal;

	@Schema(description = "Price of good")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@JsonIgnore
	public void setPrice(
		UnsafeSupplier<Double, Exception> priceUnsafeSupplier) {

		try {
			price = priceUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Price of good")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double price;

	@Schema(description = "Number of quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@JsonIgnore
	public void setQuantity(
		UnsafeSupplier<Integer, Exception> quantityUnsafeSupplier) {

		try {
			quantity = quantityUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Number of quantity")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer quantity;

	@Schema(description = "The sales order")
	public Long getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(Long salesOrder) {
		this.salesOrder = salesOrder;
	}

	@JsonIgnore
	public void setSalesOrder(
		UnsafeSupplier<Long, Exception> salesOrderUnsafeSupplier) {

		try {
			salesOrder = salesOrderUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The sales order")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long salesOrder;

	@Schema(description = "Sale order line number")
	public Integer getSalesOrderlineNum() {
		return salesOrderlineNum;
	}

	public void setSalesOrderlineNum(Integer salesOrderlineNum) {
		this.salesOrderlineNum = salesOrderlineNum;
	}

	@JsonIgnore
	public void setSalesOrderlineNum(
		UnsafeSupplier<Integer, Exception> salesOrderlineNumUnsafeSupplier) {

		try {
			salesOrderlineNum = salesOrderlineNumUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Sale order line number")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer salesOrderlineNum;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InvoiceLine)) {
			return false;
		}

		InvoiceLine invoiceLine = (InvoiceLine)object;

		return Objects.equals(toString(), invoiceLine.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (discountPercent != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"discountPercent\": ");

			sb.append(discountPercent);
		}

		if (itemCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"itemCode\": ");

			sb.append("\"");

			sb.append(_escape(itemCode));

			sb.append("\"");
		}

		if (lineNum != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lineNum\": ");

			sb.append(lineNum);
		}

		if (lineTotal != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lineTotal\": ");

			sb.append(lineTotal);
		}

		if (price != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"price\": ");

			sb.append(price);
		}

		if (quantity != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"quantity\": ");

			sb.append(quantity);
		}

		if (salesOrder != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"salesOrder\": ");

			sb.append(salesOrder);
		}

		if (salesOrderlineNum != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"salesOrderlineNum\": ");

			sb.append(salesOrderlineNum);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.liferay.training.headless.dto.v1_0.InvoiceLine",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
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

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(value);
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}