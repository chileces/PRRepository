package com.liferay.training.headless.client.dto.v1_0;

import com.liferay.training.headless.client.function.UnsafeSupplier;
import com.liferay.training.headless.client.serdes.v1_0.InvoiceSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author ces-user
 * @generated
 */
@Generated("")
public class Invoice implements Cloneable, Serializable {

	public static Invoice toDTO(String json) {
		return InvoiceSerDes.toDTO(json);
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public void setCardCode(
		UnsafeSupplier<String, Exception> cardCodeUnsafeSupplier) {

		try {
			cardCode = cardCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String cardCode;

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public void setCardName(
		UnsafeSupplier<String, Exception> cardNameUnsafeSupplier) {

		try {
			cardName = cardNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String cardName;

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public void setCarrier(
		UnsafeSupplier<String, Exception> carrierUnsafeSupplier) {

		try {
			carrier = carrierUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String carrier;

	public Long getCommerceAccountId() {
		return commerceAccountId;
	}

	public void setCommerceAccountId(Long commerceAccountId) {
		this.commerceAccountId = commerceAccountId;
	}

	public void setCommerceAccountId(
		UnsafeSupplier<Long, Exception> commerceAccountIdUnsafeSupplier) {

		try {
			commerceAccountId = commerceAccountIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long commerceAccountId;

	public Date getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	public void setDocumentDate(
		UnsafeSupplier<Date, Exception> documentDateUnsafeSupplier) {

		try {
			documentDate = documentDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date documentDate;

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public void setDocumentNumber(
		UnsafeSupplier<String, Exception> documentNumberUnsafeSupplier) {

		try {
			documentNumber = documentNumberUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String documentNumber;

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	public void setDocumentStatus(
		UnsafeSupplier<String, Exception> documentStatusUnsafeSupplier) {

		try {
			documentStatus = documentStatusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String documentStatus;

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setDueDate(
		UnsafeSupplier<Date, Exception> dueDateUnsafeSupplier) {

		try {
			dueDate = dueDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dueDate;

	public Double getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(Double freightAmount) {
		this.freightAmount = freightAmount;
	}

	public void setFreightAmount(
		UnsafeSupplier<Double, Exception> freightAmountUnsafeSupplier) {

		try {
			freightAmount = freightAmountUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double freightAmount;

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public void setGst(UnsafeSupplier<Double, Exception> gstUnsafeSupplier) {
		try {
			gst = gstUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double gst;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

	public InvoiceLine[] getInvoiceLines() {
		return invoiceLines;
	}

	public void setInvoiceLines(InvoiceLine[] invoiceLines) {
		this.invoiceLines = invoiceLines;
	}

	public void setInvoiceLines(
		UnsafeSupplier<InvoiceLine[], Exception> invoiceLinesUnsafeSupplier) {

		try {
			invoiceLines = invoiceLinesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected InvoiceLine[] invoiceLines;

	public Double getInvoiceTotal() {
		return invoiceTotal;
	}

	public void setInvoiceTotal(Double invoiceTotal) {
		this.invoiceTotal = invoiceTotal;
	}

	public void setInvoiceTotal(
		UnsafeSupplier<Double, Exception> invoiceTotalUnsafeSupplier) {

		try {
			invoiceTotal = invoiceTotalUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double invoiceTotal;

	@Override
	public Invoice clone() throws CloneNotSupportedException {
		return (Invoice)super.clone();
	}

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
		return InvoiceSerDes.toJSON(this);
	}

}