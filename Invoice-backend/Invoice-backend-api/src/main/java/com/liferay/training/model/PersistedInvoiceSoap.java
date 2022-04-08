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
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.service.http.PersistedInvoiceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PersistedInvoiceSoap implements Serializable {

	public static PersistedInvoiceSoap toSoapModel(PersistedInvoice model) {
		PersistedInvoiceSoap soapModel = new PersistedInvoiceSoap();

		soapModel.setPersistedInvoiceId(model.getPersistedInvoiceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGst(model.getGst());
		soapModel.setCardCode(model.getCardCode());
		soapModel.setCardName(model.getCardName());
		soapModel.setCarrier(model.getCarrier());
		soapModel.setDocumentDate(model.getDocumentDate());
		soapModel.setDocumentNumber(model.getDocumentNumber());
		soapModel.setDocumentStatus(model.getDocumentStatus());
		soapModel.setDueDate(model.getDueDate());
		soapModel.setFreightAmount(model.getFreightAmount());
		soapModel.setInvoiceTotal(model.getInvoiceTotal());
		soapModel.setCommerceAccountId(model.getCommerceAccountId());

		return soapModel;
	}

	public static PersistedInvoiceSoap[] toSoapModels(
		PersistedInvoice[] models) {

		PersistedInvoiceSoap[] soapModels =
			new PersistedInvoiceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersistedInvoiceSoap[][] toSoapModels(
		PersistedInvoice[][] models) {

		PersistedInvoiceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PersistedInvoiceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersistedInvoiceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersistedInvoiceSoap[] toSoapModels(
		List<PersistedInvoice> models) {

		List<PersistedInvoiceSoap> soapModels =
			new ArrayList<PersistedInvoiceSoap>(models.size());

		for (PersistedInvoice model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersistedInvoiceSoap[soapModels.size()]);
	}

	public PersistedInvoiceSoap() {
	}

	public long getPrimaryKey() {
		return _persistedInvoiceId;
	}

	public void setPrimaryKey(long pk) {
		setPersistedInvoiceId(pk);
	}

	public long getPersistedInvoiceId() {
		return _persistedInvoiceId;
	}

	public void setPersistedInvoiceId(long persistedInvoiceId) {
		_persistedInvoiceId = persistedInvoiceId;
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

	public double getGst() {
		return _gst;
	}

	public void setGst(double gst) {
		_gst = gst;
	}

	public String getCardCode() {
		return _cardCode;
	}

	public void setCardCode(String cardCode) {
		_cardCode = cardCode;
	}

	public String getCardName() {
		return _cardName;
	}

	public void setCardName(String cardName) {
		_cardName = cardName;
	}

	public String getCarrier() {
		return _carrier;
	}

	public void setCarrier(String carrier) {
		_carrier = carrier;
	}

	public Date getDocumentDate() {
		return _documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		_documentDate = documentDate;
	}

	public String getDocumentNumber() {
		return _documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		_documentNumber = documentNumber;
	}

	public String getDocumentStatus() {
		return _documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		_documentStatus = documentStatus;
	}

	public Date getDueDate() {
		return _dueDate;
	}

	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	public double getFreightAmount() {
		return _freightAmount;
	}

	public void setFreightAmount(double freightAmount) {
		_freightAmount = freightAmount;
	}

	public double getInvoiceTotal() {
		return _invoiceTotal;
	}

	public void setInvoiceTotal(double invoiceTotal) {
		_invoiceTotal = invoiceTotal;
	}

	public long getCommerceAccountId() {
		return _commerceAccountId;
	}

	public void setCommerceAccountId(long commerceAccountId) {
		_commerceAccountId = commerceAccountId;
	}

	private long _persistedInvoiceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private double _gst;
	private String _cardCode;
	private String _cardName;
	private String _carrier;
	private Date _documentDate;
	private String _documentNumber;
	private String _documentStatus;
	private Date _dueDate;
	private double _freightAmount;
	private double _invoiceTotal;
	private long _commerceAccountId;

}