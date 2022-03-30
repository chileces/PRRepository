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

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ces-user
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "Contains all of the information for a Sapphire invoice",
	value = "Invoice"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Invoice")
public class Invoice implements Serializable {

	public static Invoice toDTO(String json) {
		return ObjectMapperUtil.readValue(Invoice.class, json);
	}

	public static Invoice unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Invoice.class, json);
	}

	@Schema(
		description = "Business partner identify, this field is mapped with Account external reference code"
	)
	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	@JsonIgnore
	public void setCardCode(
		UnsafeSupplier<String, Exception> cardCodeUnsafeSupplier) {

		try {
			cardCode = cardCodeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "Business partner identify, this field is mapped with Account external reference code"
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String cardCode;

	@Schema(
		description = "Business partner full name, this field is mapped with Commerce Account name"
	)
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	@JsonIgnore
	public void setCardName(
		UnsafeSupplier<String, Exception> cardNameUnsafeSupplier) {

		try {
			cardName = cardNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "Business partner full name, this field is mapped with Commerce Account name"
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String cardName;

	@Schema(description = "A carrier is a transportation service provider")
	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	@JsonIgnore
	public void setCarrier(
		UnsafeSupplier<String, Exception> carrierUnsafeSupplier) {

		try {
			carrier = carrierUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "A carrier is a transportation service provider"
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String carrier;

	@Schema(description = "Document date")
	public Date getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	@JsonIgnore
	public void setDocumentDate(
		UnsafeSupplier<Date, Exception> documentDateUnsafeSupplier) {

		try {
			documentDate = documentDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Document date")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date documentDate;

	@Schema(description = "Document number")
	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	@JsonIgnore
	public void setDocumentNumber(
		UnsafeSupplier<String, Exception> documentNumberUnsafeSupplier) {

		try {
			documentNumber = documentNumberUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Document number")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String documentNumber;

	@Schema(description = "your current balance")
	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	@JsonIgnore
	public void setDocumentStatus(
		UnsafeSupplier<String, Exception> documentStatusUnsafeSupplier) {

		try {
			documentStatus = documentStatusUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "your current balance")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String documentStatus;

	@Schema(description = "due date")
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@JsonIgnore
	public void setDueDate(
		UnsafeSupplier<Date, Exception> dueDateUnsafeSupplier) {

		try {
			dueDate = dueDateUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "due date")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date dueDate;

	@Schema(description = "Shippment's payment")
	public Double getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(Double freightAmount) {
		this.freightAmount = freightAmount;
	}

	@JsonIgnore
	public void setFreightAmount(
		UnsafeSupplier<Double, Exception> freightAmountUnsafeSupplier) {

		try {
			freightAmount = freightAmountUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Shippment's payment")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double freightAmount;

	@Schema(
		description = "A business instrument issued by a supplier or a seller to recipient or the buyer of goods and services"
	)
	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	@JsonIgnore
	public void setGst(UnsafeSupplier<Double, Exception> gstUnsafeSupplier) {
		try {
			gst = gstUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "A business instrument issued by a supplier or a seller to recipient or the buyer of goods and services"
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double gst;

	@Schema(description = "The invoice identify")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The invoice identify")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long id;

	@Schema(description = "Invoice lines")
	@Valid
	public InvoiceLine[] getInvoiceLines() {
		return invoiceLines;
	}

	public void setInvoiceLines(InvoiceLine[] invoiceLines) {
		this.invoiceLines = invoiceLines;
	}

	@JsonIgnore
	public void setInvoiceLines(
		UnsafeSupplier<InvoiceLine[], Exception> invoiceLinesUnsafeSupplier) {

		try {
			invoiceLines = invoiceLinesUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Invoice lines")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected InvoiceLine[] invoiceLines;

	@Schema(description = "Invoice total number")
	public Double getInvoiceTotal() {
		return invoiceTotal;
	}

	public void setInvoiceTotal(Double invoiceTotal) {
		this.invoiceTotal = invoiceTotal;
	}

	@JsonIgnore
	public void setInvoiceTotal(
		UnsafeSupplier<Double, Exception> invoiceTotalUnsafeSupplier) {

		try {
			invoiceTotal = invoiceTotalUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Invoice total number")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double invoiceTotal;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Invoice)) {
			return false;
		}

		Invoice invoice = (Invoice)object;

		return Objects.equals(toString(), invoice.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (cardCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"cardCode\": ");

			sb.append("\"");

			sb.append(_escape(cardCode));

			sb.append("\"");
		}

		if (cardName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"cardName\": ");

			sb.append("\"");

			sb.append(_escape(cardName));

			sb.append("\"");
		}

		if (carrier != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"carrier\": ");

			sb.append("\"");

			sb.append(_escape(carrier));

			sb.append("\"");
		}

		if (documentDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"documentDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(documentDate));

			sb.append("\"");
		}

		if (documentNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"documentNumber\": ");

			sb.append("\"");

			sb.append(_escape(documentNumber));

			sb.append("\"");
		}

		if (documentStatus != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"documentStatus\": ");

			sb.append("\"");

			sb.append(_escape(documentStatus));

			sb.append("\"");
		}

		if (dueDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dueDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dueDate));

			sb.append("\"");
		}

		if (freightAmount != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"freightAmount\": ");

			sb.append(freightAmount);
		}

		if (gst != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"gst\": ");

			sb.append(gst);
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (invoiceLines != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"invoiceLines\": ");

			sb.append("[");

			for (int i = 0; i < invoiceLines.length; i++) {
				sb.append(String.valueOf(invoiceLines[i]));

				if ((i + 1) < invoiceLines.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (invoiceTotal != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"invoiceTotal\": ");

			sb.append(invoiceTotal);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.liferay.training.headless.dto.v1_0.Invoice",
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