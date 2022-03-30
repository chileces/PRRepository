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
import com.liferay.training.model.PersistedInvoiceLine;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PersistedInvoiceLine in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersistedInvoiceLineCacheModel
	implements CacheModel<PersistedInvoiceLine>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersistedInvoiceLineCacheModel)) {
			return false;
		}

		PersistedInvoiceLineCacheModel persistedInvoiceLineCacheModel =
			(PersistedInvoiceLineCacheModel)object;

		if (persistedInvoiceLineId ==
				persistedInvoiceLineCacheModel.persistedInvoiceLineId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, persistedInvoiceLineId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{persistedInvoiceLineId=");
		sb.append(persistedInvoiceLineId);
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
		sb.append(", persistedInvoiceId=");
		sb.append(persistedInvoiceId);
		sb.append(", price=");
		sb.append(price);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", discountPercent=");
		sb.append(discountPercent);
		sb.append(", itemCode=");
		sb.append(itemCode);
		sb.append(", lineNum=");
		sb.append(lineNum);
		sb.append(", lineTotal=");
		sb.append(lineTotal);
		sb.append(", salesOrder=");
		sb.append(salesOrder);
		sb.append(", salesOrderlineNum=");
		sb.append(salesOrderlineNum);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersistedInvoiceLine toEntityModel() {
		PersistedInvoiceLineImpl persistedInvoiceLineImpl =
			new PersistedInvoiceLineImpl();

		persistedInvoiceLineImpl.setPersistedInvoiceLineId(
			persistedInvoiceLineId);
		persistedInvoiceLineImpl.setGroupId(groupId);
		persistedInvoiceLineImpl.setCompanyId(companyId);
		persistedInvoiceLineImpl.setUserId(userId);

		if (userName == null) {
			persistedInvoiceLineImpl.setUserName("");
		}
		else {
			persistedInvoiceLineImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			persistedInvoiceLineImpl.setCreateDate(null);
		}
		else {
			persistedInvoiceLineImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			persistedInvoiceLineImpl.setModifiedDate(null);
		}
		else {
			persistedInvoiceLineImpl.setModifiedDate(new Date(modifiedDate));
		}

		persistedInvoiceLineImpl.setPersistedInvoiceId(persistedInvoiceId);
		persistedInvoiceLineImpl.setPrice(price);
		persistedInvoiceLineImpl.setQuantity(quantity);
		persistedInvoiceLineImpl.setDiscountPercent(discountPercent);

		if (itemCode == null) {
			persistedInvoiceLineImpl.setItemCode("");
		}
		else {
			persistedInvoiceLineImpl.setItemCode(itemCode);
		}

		persistedInvoiceLineImpl.setLineNum(lineNum);
		persistedInvoiceLineImpl.setLineTotal(lineTotal);
		persistedInvoiceLineImpl.setSalesOrder(salesOrder);
		persistedInvoiceLineImpl.setSalesOrderlineNum(salesOrderlineNum);

		persistedInvoiceLineImpl.resetOriginalValues();

		return persistedInvoiceLineImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		persistedInvoiceLineId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		persistedInvoiceId = objectInput.readLong();

		price = objectInput.readDouble();

		quantity = objectInput.readInt();

		discountPercent = objectInput.readDouble();
		itemCode = objectInput.readUTF();

		lineNum = objectInput.readInt();

		lineTotal = objectInput.readDouble();

		salesOrder = objectInput.readLong();

		salesOrderlineNum = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(persistedInvoiceLineId);

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

		objectOutput.writeLong(persistedInvoiceId);

		objectOutput.writeDouble(price);

		objectOutput.writeInt(quantity);

		objectOutput.writeDouble(discountPercent);

		if (itemCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(itemCode);
		}

		objectOutput.writeInt(lineNum);

		objectOutput.writeDouble(lineTotal);

		objectOutput.writeLong(salesOrder);

		objectOutput.writeInt(salesOrderlineNum);
	}

	public long persistedInvoiceLineId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long persistedInvoiceId;
	public double price;
	public int quantity;
	public double discountPercent;
	public String itemCode;
	public int lineNum;
	public double lineTotal;
	public long salesOrder;
	public int salesOrderlineNum;

}