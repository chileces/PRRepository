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
 * This class is a wrapper for {@link PersistedInvoiceLine}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceLine
 * @generated
 */
public class PersistedInvoiceLineWrapper
	extends BaseModelWrapper<PersistedInvoiceLine>
	implements ModelWrapper<PersistedInvoiceLine>, PersistedInvoiceLine {

	public PersistedInvoiceLineWrapper(
		PersistedInvoiceLine persistedInvoiceLine) {

		super(persistedInvoiceLine);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("persistedInvoiceLineId", getPersistedInvoiceLineId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("persistedInvoiceId", getPersistedInvoiceId());
		attributes.put("price", getPrice());
		attributes.put("quantity", getQuantity());
		attributes.put("discountPercent", getDiscountPercent());
		attributes.put("itemCode", getItemCode());
		attributes.put("lineNum", getLineNum());
		attributes.put("lineTotal", getLineTotal());
		attributes.put("salesOrder", getSalesOrder());
		attributes.put("salesOrderlineNum", getSalesOrderlineNum());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long persistedInvoiceLineId = (Long)attributes.get(
			"persistedInvoiceLineId");

		if (persistedInvoiceLineId != null) {
			setPersistedInvoiceLineId(persistedInvoiceLineId);
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

		Long persistedInvoiceId = (Long)attributes.get("persistedInvoiceId");

		if (persistedInvoiceId != null) {
			setPersistedInvoiceId(persistedInvoiceId);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Double discountPercent = (Double)attributes.get("discountPercent");

		if (discountPercent != null) {
			setDiscountPercent(discountPercent);
		}

		String itemCode = (String)attributes.get("itemCode");

		if (itemCode != null) {
			setItemCode(itemCode);
		}

		Integer lineNum = (Integer)attributes.get("lineNum");

		if (lineNum != null) {
			setLineNum(lineNum);
		}

		Double lineTotal = (Double)attributes.get("lineTotal");

		if (lineTotal != null) {
			setLineTotal(lineTotal);
		}

		Long salesOrder = (Long)attributes.get("salesOrder");

		if (salesOrder != null) {
			setSalesOrder(salesOrder);
		}

		Integer salesOrderlineNum = (Integer)attributes.get(
			"salesOrderlineNum");

		if (salesOrderlineNum != null) {
			setSalesOrderlineNum(salesOrderlineNum);
		}
	}

	/**
	 * Returns the company ID of this persisted invoice line.
	 *
	 * @return the company ID of this persisted invoice line
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this persisted invoice line.
	 *
	 * @return the create date of this persisted invoice line
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the discount percent of this persisted invoice line.
	 *
	 * @return the discount percent of this persisted invoice line
	 */
	@Override
	public double getDiscountPercent() {
		return model.getDiscountPercent();
	}

	/**
	 * Returns the group ID of this persisted invoice line.
	 *
	 * @return the group ID of this persisted invoice line
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the item code of this persisted invoice line.
	 *
	 * @return the item code of this persisted invoice line
	 */
	@Override
	public String getItemCode() {
		return model.getItemCode();
	}

	/**
	 * Returns the line num of this persisted invoice line.
	 *
	 * @return the line num of this persisted invoice line
	 */
	@Override
	public Integer getLineNum() {
		return model.getLineNum();
	}

	/**
	 * Returns the line total of this persisted invoice line.
	 *
	 * @return the line total of this persisted invoice line
	 */
	@Override
	public double getLineTotal() {
		return model.getLineTotal();
	}

	/**
	 * Returns the modified date of this persisted invoice line.
	 *
	 * @return the modified date of this persisted invoice line
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the persisted invoice ID of this persisted invoice line.
	 *
	 * @return the persisted invoice ID of this persisted invoice line
	 */
	@Override
	public long getPersistedInvoiceId() {
		return model.getPersistedInvoiceId();
	}

	/**
	 * Returns the persisted invoice line ID of this persisted invoice line.
	 *
	 * @return the persisted invoice line ID of this persisted invoice line
	 */
	@Override
	public long getPersistedInvoiceLineId() {
		return model.getPersistedInvoiceLineId();
	}

	/**
	 * Returns the price of this persisted invoice line.
	 *
	 * @return the price of this persisted invoice line
	 */
	@Override
	public double getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this persisted invoice line.
	 *
	 * @return the primary key of this persisted invoice line
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quantity of this persisted invoice line.
	 *
	 * @return the quantity of this persisted invoice line
	 */
	@Override
	public Integer getQuantity() {
		return model.getQuantity();
	}

	/**
	 * Returns the sales order of this persisted invoice line.
	 *
	 * @return the sales order of this persisted invoice line
	 */
	@Override
	public long getSalesOrder() {
		return model.getSalesOrder();
	}

	/**
	 * Returns the sales orderline num of this persisted invoice line.
	 *
	 * @return the sales orderline num of this persisted invoice line
	 */
	@Override
	public Integer getSalesOrderlineNum() {
		return model.getSalesOrderlineNum();
	}

	/**
	 * Returns the user ID of this persisted invoice line.
	 *
	 * @return the user ID of this persisted invoice line
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this persisted invoice line.
	 *
	 * @return the user name of this persisted invoice line
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this persisted invoice line.
	 *
	 * @return the user uuid of this persisted invoice line
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
	 * Sets the company ID of this persisted invoice line.
	 *
	 * @param companyId the company ID of this persisted invoice line
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this persisted invoice line.
	 *
	 * @param createDate the create date of this persisted invoice line
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the discount percent of this persisted invoice line.
	 *
	 * @param discountPercent the discount percent of this persisted invoice line
	 */
	@Override
	public void setDiscountPercent(double discountPercent) {
		model.setDiscountPercent(discountPercent);
	}

	/**
	 * Sets the group ID of this persisted invoice line.
	 *
	 * @param groupId the group ID of this persisted invoice line
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the item code of this persisted invoice line.
	 *
	 * @param itemCode the item code of this persisted invoice line
	 */
	@Override
	public void setItemCode(String itemCode) {
		model.setItemCode(itemCode);
	}

	/**
	 * Sets the line num of this persisted invoice line.
	 *
	 * @param lineNum the line num of this persisted invoice line
	 */
	@Override
	public void setLineNum(Integer lineNum) {
		model.setLineNum(lineNum);
	}

	/**
	 * Sets the line total of this persisted invoice line.
	 *
	 * @param lineTotal the line total of this persisted invoice line
	 */
	@Override
	public void setLineTotal(double lineTotal) {
		model.setLineTotal(lineTotal);
	}

	/**
	 * Sets the modified date of this persisted invoice line.
	 *
	 * @param modifiedDate the modified date of this persisted invoice line
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the persisted invoice ID of this persisted invoice line.
	 *
	 * @param persistedInvoiceId the persisted invoice ID of this persisted invoice line
	 */
	@Override
	public void setPersistedInvoiceId(long persistedInvoiceId) {
		model.setPersistedInvoiceId(persistedInvoiceId);
	}

	/**
	 * Sets the persisted invoice line ID of this persisted invoice line.
	 *
	 * @param persistedInvoiceLineId the persisted invoice line ID of this persisted invoice line
	 */
	@Override
	public void setPersistedInvoiceLineId(long persistedInvoiceLineId) {
		model.setPersistedInvoiceLineId(persistedInvoiceLineId);
	}

	/**
	 * Sets the price of this persisted invoice line.
	 *
	 * @param price the price of this persisted invoice line
	 */
	@Override
	public void setPrice(double price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this persisted invoice line.
	 *
	 * @param primaryKey the primary key of this persisted invoice line
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quantity of this persisted invoice line.
	 *
	 * @param quantity the quantity of this persisted invoice line
	 */
	@Override
	public void setQuantity(Integer quantity) {
		model.setQuantity(quantity);
	}

	/**
	 * Sets the sales order of this persisted invoice line.
	 *
	 * @param salesOrder the sales order of this persisted invoice line
	 */
	@Override
	public void setSalesOrder(long salesOrder) {
		model.setSalesOrder(salesOrder);
	}

	/**
	 * Sets the sales orderline num of this persisted invoice line.
	 *
	 * @param salesOrderlineNum the sales orderline num of this persisted invoice line
	 */
	@Override
	public void setSalesOrderlineNum(Integer salesOrderlineNum) {
		model.setSalesOrderlineNum(salesOrderlineNum);
	}

	/**
	 * Sets the user ID of this persisted invoice line.
	 *
	 * @param userId the user ID of this persisted invoice line
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this persisted invoice line.
	 *
	 * @param userName the user name of this persisted invoice line
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this persisted invoice line.
	 *
	 * @param userUuid the user uuid of this persisted invoice line
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PersistedInvoiceLineWrapper wrap(
		PersistedInvoiceLine persistedInvoiceLine) {

		return new PersistedInvoiceLineWrapper(persistedInvoiceLine);
	}

}