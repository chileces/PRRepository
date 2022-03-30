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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PersistedInvoice}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoice
 * @generated
 */
public class PersistedInvoiceWrapper
	extends BaseModelWrapper<PersistedInvoice>
	implements ModelWrapper<PersistedInvoice>, PersistedInvoice {

	public PersistedInvoiceWrapper(PersistedInvoice persistedInvoice) {
		super(persistedInvoice);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("persistedInvoiceId", getPersistedInvoiceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("gst", getGst());
		attributes.put("cardCode", getCardCode());
		attributes.put("cardName", getCardName());
		attributes.put("carrier", getCarrier());
		attributes.put("documentDate", getDocumentDate());
		attributes.put("documentNumber", getDocumentNumber());
		attributes.put("documentStatus", getDocumentStatus());
		attributes.put("dueDate", getDueDate());
		attributes.put("freightAmount", getFreightAmount());
		attributes.put("invoiceTotal", getInvoiceTotal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long persistedInvoiceId = (Long)attributes.get("persistedInvoiceId");

		if (persistedInvoiceId != null) {
			setPersistedInvoiceId(persistedInvoiceId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Double gst = (Double)attributes.get("gst");

		if (gst != null) {
			setGst(gst);
		}

		String cardCode = (String)attributes.get("cardCode");

		if (cardCode != null) {
			setCardCode(cardCode);
		}

		String cardName = (String)attributes.get("cardName");

		if (cardName != null) {
			setCardName(cardName);
		}

		String carrier = (String)attributes.get("carrier");

		if (carrier != null) {
			setCarrier(carrier);
		}

		Date documentDate = (Date)attributes.get("documentDate");

		if (documentDate != null) {
			setDocumentDate(documentDate);
		}

		String documentNumber = (String)attributes.get("documentNumber");

		if (documentNumber != null) {
			setDocumentNumber(documentNumber);
		}

		String documentStatus = (String)attributes.get("documentStatus");

		if (documentStatus != null) {
			setDocumentStatus(documentStatus);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Double freightAmount = (Double)attributes.get("freightAmount");

		if (freightAmount != null) {
			setFreightAmount(freightAmount);
		}

		Double invoiceTotal = (Double)attributes.get("invoiceTotal");

		if (invoiceTotal != null) {
			setInvoiceTotal(invoiceTotal);
		}
	}

	/**
	 * Returns the card code of this persisted invoice.
	 *
	 * @return the card code of this persisted invoice
	 */
	@Override
	public String getCardCode() {
		return model.getCardCode();
	}

	/**
	 * Returns the card name of this persisted invoice.
	 *
	 * @return the card name of this persisted invoice
	 */
	@Override
	public String getCardName() {
		return model.getCardName();
	}

	/**
	 * Returns the carrier of this persisted invoice.
	 *
	 * @return the carrier of this persisted invoice
	 */
	@Override
	public String getCarrier() {
		return model.getCarrier();
	}

	/**
	 * Returns the company ID of this persisted invoice.
	 *
	 * @return the company ID of this persisted invoice
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this persisted invoice.
	 *
	 * @return the create date of this persisted invoice
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the document date of this persisted invoice.
	 *
	 * @return the document date of this persisted invoice
	 */
	@Override
	public Date getDocumentDate() {
		return model.getDocumentDate();
	}

	/**
	 * Returns the document number of this persisted invoice.
	 *
	 * @return the document number of this persisted invoice
	 */
	@Override
	public String getDocumentNumber() {
		return model.getDocumentNumber();
	}

	/**
	 * Returns the document status of this persisted invoice.
	 *
	 * @return the document status of this persisted invoice
	 */
	@Override
	public String getDocumentStatus() {
		return model.getDocumentStatus();
	}

	/**
	 * Returns the due date of this persisted invoice.
	 *
	 * @return the due date of this persisted invoice
	 */
	@Override
	public Date getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the freight amount of this persisted invoice.
	 *
	 * @return the freight amount of this persisted invoice
	 */
	@Override
	public double getFreightAmount() {
		return model.getFreightAmount();
	}

	/**
	 * Returns the group ID of this persisted invoice.
	 *
	 * @return the group ID of this persisted invoice
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the gst of this persisted invoice.
	 *
	 * @return the gst of this persisted invoice
	 */
	@Override
	public double getGst() {
		return model.getGst();
	}

	/**
	 * Returns the invoice total of this persisted invoice.
	 *
	 * @return the invoice total of this persisted invoice
	 */
	@Override
	public double getInvoiceTotal() {
		return model.getInvoiceTotal();
	}

	/**
	 * Returns the modified date of this persisted invoice.
	 *
	 * @return the modified date of this persisted invoice
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the persisted invoice ID of this persisted invoice.
	 *
	 * @return the persisted invoice ID of this persisted invoice
	 */
	@Override
	public long getPersistedInvoiceId() {
		return model.getPersistedInvoiceId();
	}

	/**
	 * Returns the primary key of this persisted invoice.
	 *
	 * @return the primary key of this persisted invoice
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this persisted invoice.
	 *
	 * @return the user ID of this persisted invoice
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this persisted invoice.
	 *
	 * @return the user name of this persisted invoice
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this persisted invoice.
	 *
	 * @return the user uuid of this persisted invoice
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the card code of this persisted invoice.
	 *
	 * @param cardCode the card code of this persisted invoice
	 */
	@Override
	public void setCardCode(String cardCode) {
		model.setCardCode(cardCode);
	}

	/**
	 * Sets the card name of this persisted invoice.
	 *
	 * @param cardName the card name of this persisted invoice
	 */
	@Override
	public void setCardName(String cardName) {
		model.setCardName(cardName);
	}

	/**
	 * Sets the carrier of this persisted invoice.
	 *
	 * @param carrier the carrier of this persisted invoice
	 */
	@Override
	public void setCarrier(String carrier) {
		model.setCarrier(carrier);
	}

	/**
	 * Sets the company ID of this persisted invoice.
	 *
	 * @param companyId the company ID of this persisted invoice
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this persisted invoice.
	 *
	 * @param createDate the create date of this persisted invoice
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the document date of this persisted invoice.
	 *
	 * @param documentDate the document date of this persisted invoice
	 */
	@Override
	public void setDocumentDate(Date documentDate) {
		model.setDocumentDate(documentDate);
	}

	/**
	 * Sets the document number of this persisted invoice.
	 *
	 * @param documentNumber the document number of this persisted invoice
	 */
	@Override
	public void setDocumentNumber(String documentNumber) {
		model.setDocumentNumber(documentNumber);
	}

	/**
	 * Sets the document status of this persisted invoice.
	 *
	 * @param documentStatus the document status of this persisted invoice
	 */
	@Override
	public void setDocumentStatus(String documentStatus) {
		model.setDocumentStatus(documentStatus);
	}

	/**
	 * Sets the due date of this persisted invoice.
	 *
	 * @param dueDate the due date of this persisted invoice
	 */
	@Override
	public void setDueDate(Date dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the freight amount of this persisted invoice.
	 *
	 * @param freightAmount the freight amount of this persisted invoice
	 */
	@Override
	public void setFreightAmount(double freightAmount) {
		model.setFreightAmount(freightAmount);
	}

	/**
	 * Sets the group ID of this persisted invoice.
	 *
	 * @param groupId the group ID of this persisted invoice
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the gst of this persisted invoice.
	 *
	 * @param gst the gst of this persisted invoice
	 */
	@Override
	public void setGst(double gst) {
		model.setGst(gst);
	}

	/**
	 * Sets the invoice total of this persisted invoice.
	 *
	 * @param invoiceTotal the invoice total of this persisted invoice
	 */
	@Override
	public void setInvoiceTotal(double invoiceTotal) {
		model.setInvoiceTotal(invoiceTotal);
	}

	/**
	 * Sets the modified date of this persisted invoice.
	 *
	 * @param modifiedDate the modified date of this persisted invoice
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the persisted invoice ID of this persisted invoice.
	 *
	 * @param persistedInvoiceId the persisted invoice ID of this persisted invoice
	 */
	@Override
	public void setPersistedInvoiceId(long persistedInvoiceId) {
		model.setPersistedInvoiceId(persistedInvoiceId);
	}

	/**
	 * Sets the primary key of this persisted invoice.
	 *
	 * @param primaryKey the primary key of this persisted invoice
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this persisted invoice.
	 *
	 * @param userId the user ID of this persisted invoice
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this persisted invoice.
	 *
	 * @param userName the user name of this persisted invoice
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this persisted invoice.
	 *
	 * @param userUuid the user uuid of this persisted invoice
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PersistedInvoiceWrapper wrap(PersistedInvoice persistedInvoice) {
		return new PersistedInvoiceWrapper(persistedInvoice);
	}

}