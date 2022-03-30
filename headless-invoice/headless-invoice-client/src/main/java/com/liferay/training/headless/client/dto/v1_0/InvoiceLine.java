package com.liferay.training.headless.client.dto.v1_0;

import com.liferay.training.headless.client.function.UnsafeSupplier;
import com.liferay.training.headless.client.serdes.v1_0.InvoiceLineSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author ces-user
 * @generated
 */
@Generated("")
public class InvoiceLine implements Cloneable, Serializable {

	public static InvoiceLine toDTO(String json) {
		return InvoiceLineSerDes.toDTO(json);
	}

	public Double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public void setDiscountPercent(
		UnsafeSupplier<Double, Exception> discountPercentUnsafeSupplier) {

		try {
			discountPercent = discountPercentUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double discountPercent;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public void setItemCode(
		UnsafeSupplier<String, Exception> itemCodeUnsafeSupplier) {

		try {
			itemCode = itemCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String itemCode;

	public Integer getLineNum() {
		return lineNum;
	}

	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}

	public void setLineNum(
		UnsafeSupplier<Integer, Exception> lineNumUnsafeSupplier) {

		try {
			lineNum = lineNumUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer lineNum;

	public Double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public void setLineTotal(
		UnsafeSupplier<Double, Exception> lineTotalUnsafeSupplier) {

		try {
			lineTotal = lineTotalUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double lineTotal;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setPrice(
		UnsafeSupplier<Double, Exception> priceUnsafeSupplier) {

		try {
			price = priceUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double price;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setQuantity(
		UnsafeSupplier<Integer, Exception> quantityUnsafeSupplier) {

		try {
			quantity = quantityUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer quantity;

	public Long getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(Long salesOrder) {
		this.salesOrder = salesOrder;
	}

	public void setSalesOrder(
		UnsafeSupplier<Long, Exception> salesOrderUnsafeSupplier) {

		try {
			salesOrder = salesOrderUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long salesOrder;

	public Integer getSalesOrderlineNum() {
		return salesOrderlineNum;
	}

	public void setSalesOrderlineNum(Integer salesOrderlineNum) {
		this.salesOrderlineNum = salesOrderlineNum;
	}

	public void setSalesOrderlineNum(
		UnsafeSupplier<Integer, Exception> salesOrderlineNumUnsafeSupplier) {

		try {
			salesOrderlineNum = salesOrderlineNumUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer salesOrderlineNum;

	@Override
	public InvoiceLine clone() throws CloneNotSupportedException {
		return (InvoiceLine)super.clone();
	}

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
		return InvoiceLineSerDes.toJSON(this);
	}

}