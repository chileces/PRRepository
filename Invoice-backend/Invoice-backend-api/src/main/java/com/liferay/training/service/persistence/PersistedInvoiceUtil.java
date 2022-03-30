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

package com.liferay.training.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.model.PersistedInvoice;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the persisted invoice service. This utility wraps <code>com.liferay.training.service.persistence.impl.PersistedInvoicePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoicePersistence
 * @generated
 */
public class PersistedInvoiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(PersistedInvoice persistedInvoice) {
		getPersistence().clearCache(persistedInvoice);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, PersistedInvoice> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersistedInvoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersistedInvoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersistedInvoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersistedInvoice> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersistedInvoice update(PersistedInvoice persistedInvoice) {
		return getPersistence().update(persistedInvoice);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersistedInvoice update(
		PersistedInvoice persistedInvoice, ServiceContext serviceContext) {

		return getPersistence().update(persistedInvoice, serviceContext);
	}

	/**
	 * Caches the persisted invoice in the entity cache if it is enabled.
	 *
	 * @param persistedInvoice the persisted invoice
	 */
	public static void cacheResult(PersistedInvoice persistedInvoice) {
		getPersistence().cacheResult(persistedInvoice);
	}

	/**
	 * Caches the persisted invoices in the entity cache if it is enabled.
	 *
	 * @param persistedInvoices the persisted invoices
	 */
	public static void cacheResult(List<PersistedInvoice> persistedInvoices) {
		getPersistence().cacheResult(persistedInvoices);
	}

	/**
	 * Creates a new persisted invoice with the primary key. Does not add the persisted invoice to the database.
	 *
	 * @param persistedInvoiceId the primary key for the new persisted invoice
	 * @return the new persisted invoice
	 */
	public static PersistedInvoice create(long persistedInvoiceId) {
		return getPersistence().create(persistedInvoiceId);
	}

	/**
	 * Removes the persisted invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedInvoiceId the primary key of the persisted invoice
	 * @return the persisted invoice that was removed
	 * @throws NoSuchPersistedInvoiceException if a persisted invoice with the primary key could not be found
	 */
	public static PersistedInvoice remove(long persistedInvoiceId)
		throws com.liferay.training.exception.NoSuchPersistedInvoiceException {

		return getPersistence().remove(persistedInvoiceId);
	}

	public static PersistedInvoice updateImpl(
		PersistedInvoice persistedInvoice) {

		return getPersistence().updateImpl(persistedInvoice);
	}

	/**
	 * Returns the persisted invoice with the primary key or throws a <code>NoSuchPersistedInvoiceException</code> if it could not be found.
	 *
	 * @param persistedInvoiceId the primary key of the persisted invoice
	 * @return the persisted invoice
	 * @throws NoSuchPersistedInvoiceException if a persisted invoice with the primary key could not be found
	 */
	public static PersistedInvoice findByPrimaryKey(long persistedInvoiceId)
		throws com.liferay.training.exception.NoSuchPersistedInvoiceException {

		return getPersistence().findByPrimaryKey(persistedInvoiceId);
	}

	/**
	 * Returns the persisted invoice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param persistedInvoiceId the primary key of the persisted invoice
	 * @return the persisted invoice, or <code>null</code> if a persisted invoice with the primary key could not be found
	 */
	public static PersistedInvoice fetchByPrimaryKey(long persistedInvoiceId) {
		return getPersistence().fetchByPrimaryKey(persistedInvoiceId);
	}

	/**
	 * Returns all the persisted invoices.
	 *
	 * @return the persisted invoices
	 */
	public static List<PersistedInvoice> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the persisted invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoices
	 * @param end the upper bound of the range of persisted invoices (not inclusive)
	 * @return the range of persisted invoices
	 */
	public static List<PersistedInvoice> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the persisted invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoices
	 * @param end the upper bound of the range of persisted invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted invoices
	 */
	public static List<PersistedInvoice> findAll(
		int start, int end,
		OrderByComparator<PersistedInvoice> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoices
	 * @param end the upper bound of the range of persisted invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted invoices
	 */
	public static List<PersistedInvoice> findAll(
		int start, int end,
		OrderByComparator<PersistedInvoice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the persisted invoices from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of persisted invoices.
	 *
	 * @return the number of persisted invoices
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PersistedInvoicePersistence getPersistence() {
		return _persistence;
	}

	private static volatile PersistedInvoicePersistence _persistence;

}