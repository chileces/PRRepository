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

package com.liferay.training.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.training.model.PersistedInvoice;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PersistedInvoice in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersistedInvoiceCacheModel
	implements CacheModel<PersistedInvoice>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersistedInvoiceCacheModel)) {
			return false;
		}

		PersistedInvoiceCacheModel persistedInvoiceCacheModel =
			(PersistedInvoiceCacheModel)object;

		if (persistedInvoiceId ==
				persistedInvoiceCacheModel.persistedInvoiceId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, persistedInvoiceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{persistedInvoiceId=");
		sb.append(persistedInvoiceId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", gst=");
		sb.append(gst);
		sb.append(", cardCode=");
		sb.append(cardCode);
		sb.append(", cardName=");
		sb.append(cardName);
		sb.append(", carrier=");
		sb.append(carrier);
		sb.append(", documentDate=");
		sb.append(documentDate);
		sb.append(", documentNumber=");
		sb.append(documentNumber);
		sb.append(", documentStatus=");
		sb.append(documentStatus);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", freightAmount=");
		sb.append(freightAmount);
		sb.append(", invoiceTotal=");
		sb.append(invoiceTotal);
		sb.append(", commerceAccountId=");
		sb.append(commerceAccountId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersistedInvoice toEntityModel() {
		PersistedInvoiceImpl persistedInvoiceImpl = new PersistedInvoiceImpl();

		persistedInvoiceImpl.setPersistedInvoiceId(persistedInvoiceId);
		persistedInvoiceImpl.setGroupId(groupId);
		persistedInvoiceImpl.setCompanyId(companyId);
		persistedInvoiceImpl.setUserId(userId);

		if (userName == null) {
			persistedInvoiceImpl.setUserName("");
		}
		else {
			persistedInvoiceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			persistedInvoiceImpl.setCreateDate(null);
		}
		else {
			persistedInvoiceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			persistedInvoiceImpl.setModifiedDate(null);
		}
		else {
			persistedInvoiceImpl.setModifiedDate(new Date(modifiedDate));
		}

		persistedInvoiceImpl.setGst(gst);

		if (cardCode == null) {
			persistedInvoiceImpl.setCardCode("");
		}
		else {
			persistedInvoiceImpl.setCardCode(cardCode);
		}

		if (cardName == null) {
			persistedInvoiceImpl.setCardName("");
		}
		else {
			persistedInvoiceImpl.setCardName(cardName);
		}

		if (carrier == null) {
			persistedInvoiceImpl.setCarrier("");
		}
		else {
			persistedInvoiceImpl.setCarrier(carrier);
		}

		if (documentDate == Long.MIN_VALUE) {
			persistedInvoiceImpl.setDocumentDate(null);
		}
		else {
			persistedInvoiceImpl.setDocumentDate(new Date(documentDate));
		}

		if (documentNumber == null) {
			persistedInvoiceImpl.setDocumentNumber("");
		}
		else {
			persistedInvoiceImpl.setDocumentNumber(documentNumber);
		}

		if (documentStatus == null) {
			persistedInvoiceImpl.setDocumentStatus("");
		}
		else {
			persistedInvoiceImpl.setDocumentStatus(documentStatus);
		}

		if (dueDate == Long.MIN_VALUE) {
			persistedInvoiceImpl.setDueDate(null);
		}
		else {
			persistedInvoiceImpl.setDueDate(new Date(dueDate));
		}

		persistedInvoiceImpl.setFreightAmount(freightAmount);
		persistedInvoiceImpl.setInvoiceTotal(invoiceTotal);
		persistedInvoiceImpl.setCommerceAccountId(commerceAccountId);

		persistedInvoiceImpl.resetOriginalValues();

		return persistedInvoiceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		persistedInvoiceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		gst = objectInput.readDouble();
		cardCode = objectInput.readUTF();
		cardName = objectInput.readUTF();
		carrier = objectInput.readUTF();
		documentDate = objectInput.readLong();
		documentNumber = objectInput.readUTF();
		documentStatus = objectInput.readUTF();
		dueDate = objectInput.readLong();

		freightAmount = objectInput.readDouble();

		invoiceTotal = objectInput.readDouble();

		commerceAccountId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(persistedInvoiceId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeDouble(gst);

		if (cardCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cardCode);
		}

		if (cardName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cardName);
		}

		if (carrier == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(carrier);
		}

		objectOutput.writeLong(documentDate);

		if (documentNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentNumber);
		}

		if (documentStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentStatus);
		}

		objectOutput.writeLong(dueDate);

		objectOutput.writeDouble(freightAmount);

		objectOutput.writeDouble(invoiceTotal);

		objectOutput.writeLong(commerceAccountId);
	}

	public long persistedInvoiceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public double gst;
	public String cardCode;
	public String cardName;
	public String carrier;
	public long documentDate;
	public String documentNumber;
	public String documentStatus;
	public long dueDate;
	public double freightAmount;
	public double invoiceTotal;
	public long commerceAccountId;

}