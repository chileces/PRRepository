/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.service.http.PersistedInvoiceLineServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PersistedInvoiceLineSoap implements Serializable {

	public static PersistedInvoiceLineSoap toSoapModel(
		PersistedInvoiceLine model) {

		PersistedInvoiceLineSoap soapModel = new PersistedInvoiceLineSoap();

		soapModel.setPersistedInvoiceLineId(model.getPersistedInvoiceLineId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPersistedInvoiceId(model.getPersistedInvoiceId());
		soapModel.setPrice(model.getPrice());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setDiscountPercent(model.getDiscountPercent());
		soapModel.setItemCode(model.getItemCode());
		soapModel.setLineNum(model.getLineNum());
		soapModel.setLineTotal(model.getLineTotal());
		soapModel.setSalesOrder(model.getSalesOrder());
		soapModel.setSalesOrderlineNum(model.getSalesOrderlineNum());

		return soapModel;
	}

	public static PersistedInvoiceLineSoap[] toSoapModels(
		PersistedInvoiceLine[] models) {

		PersistedInvoiceLineSoap[] soapModels =
			new PersistedInvoiceLineSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersistedInvoiceLineSoap[][] toSoapModels(
		PersistedInvoiceLine[][] models) {

		PersistedInvoiceLineSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PersistedInvoiceLineSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersistedInvoiceLineSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersistedInvoiceLineSoap[] toSoapModels(
		List<PersistedInvoiceLine> models) {

		List<PersistedInvoiceLineSoap> soapModels =
			new ArrayList<PersistedInvoiceLineSoap>(models.size());

		for (PersistedInvoiceLine model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new PersistedInvoiceLineSoap[soapModels.size()]);
	}

	public PersistedInvoiceLineSoap() {
	}

	public long getPrimaryKey() {
		return _persistedInvoiceLineId;
	}

	public void setPrimaryKey(long pk) {
		setPersistedInvoiceLineId(pk);
	}

	public long getPersistedInvoiceLineId() {
		return _persistedInvoiceLineId;
	}

	public void setPersistedInvoiceLineId(long persistedInvoiceLineId) {
		_persistedInvoiceLineId = persistedInvoiceLineId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getPersistedInvoiceId() {
		return _persistedInvoiceId;
	}

	public void setPersistedInvoiceId(long persistedInvoiceId) {
		_persistedInvoiceId = persistedInvoiceId;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public Integer getQuantity() {
		return _quantity;
	}

	public void setQuantity(Integer quantity) {
		_quantity = quantity;
	}

	public double getDiscountPercent() {
		return _discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		_discountPercent = discountPercent;
	}

	public String getItemCode() {
		return _itemCode;
	}

	public void setItemCode(String itemCode) {
		_itemCode = itemCode;
	}

	public Integer getLineNum() {
		return _lineNum;
	}

	public void setLineNum(Integer lineNum) {
		_lineNum = lineNum;
	}

	public double getLineTotal() {
		return _lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		_lineTotal = lineTotal;
	}

	public long getSalesOrder() {
		return _salesOrder;
	}

	public void setSalesOrder(long salesOrder) {
		_salesOrder = salesOrder;
	}

	public Integer getSalesOrderlineNum() {
		return _salesOrderlineNum;
	}

	public void setSalesOrderlineNum(Integer salesOrderlineNum) {
		_salesOrderlineNum = salesOrderlineNum;
	}

	private long _persistedInvoiceLineId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _persistedInvoiceId;
	private double _price;
	private Integer _quantity;
	private double _discountPercent;
	private String _itemCode;
	private Integer _lineNum;
	private double _lineTotal;
	private long _salesOrder;
	private Integer _salesOrderlineNum;

}