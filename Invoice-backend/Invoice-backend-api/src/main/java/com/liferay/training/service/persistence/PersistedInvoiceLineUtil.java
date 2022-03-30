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
import com.liferay.training.model.PersistedInvoiceLine;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the persisted invoice line service. This utility wraps <code>com.liferay.training.service.persistence.impl.PersistedInvoiceLinePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceLinePersistence
 * @generated
 */
public class PersistedInvoiceLineUtil {

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
	public static void clearCache(PersistedInvoiceLine persistedInvoiceLine) {
		getPersistence().clearCache(persistedInvoiceLine);
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
	public static Map<Serializable, PersistedInvoiceLine> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersistedInvoiceLine> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersistedInvoiceLine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersistedInvoiceLine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersistedInvoiceLine> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersistedInvoiceLine update(
		PersistedInvoiceLine persistedInvoiceLine) {

		return getPersistence().update(persistedInvoiceLine);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersistedInvoiceLine update(
		PersistedInvoiceLine persistedInvoiceLine,
		ServiceContext serviceContext) {

		return getPersistence().update(persistedInvoiceLine, serviceContext);
	}

	/**
	 * Returns all the persisted invoice lines where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @return the matching persisted invoice lines
	 */
	public static List<PersistedInvoiceLine> findByCustomInvoiceId(
		long persistedInvoiceId) {

		return getPersistence().findByCustomInvoiceId(persistedInvoiceId);
	}

	/**
	 * Returns a range of all the persisted invoice lines where persistedInvoiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param start the lower bound of the range of persisted invoice lines
	 * @param end the upper bound of the range of persisted invoice lines (not inclusive)
	 * @return the range of matching persisted invoice lines
	 */
	public static List<PersistedInvoiceLine> findByCustomInvoiceId(
		long persistedInvoiceId, int start, int end) {

		return getPersistence().findByCustomInvoiceId(
			persistedInvoiceId, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted invoice lines where persistedInvoiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param start the lower bound of the range of persisted invoice lines
	 * @param end the upper bound of the range of persisted invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted invoice lines
	 */
	public static List<PersistedInvoiceLine> findByCustomInvoiceId(
		long persistedInvoiceId, int start, int end,
		OrderByComparator<PersistedInvoiceLine> orderByComparator) {

		return getPersistence().findByCustomInvoiceId(
			persistedInvoiceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted invoice lines where persistedInvoiceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param start the lower bound of the range of persisted invoice lines
	 * @param end the upper bound of the range of persisted invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted invoice lines
	 */
	public static List<PersistedInvoiceLine> findByCustomInvoiceId(
		long persistedInvoiceId, int start, int end,
		OrderByComparator<PersistedInvoiceLine> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCustomInvoiceId(
			persistedInvoiceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a matching persisted invoice line could not be found
	 */
	public static PersistedInvoiceLine findByCustomInvoiceId_First(
			long persistedInvoiceId,
			OrderByComparator<PersistedInvoiceLine> orderByComparator)
		throws com.liferay.training.exception.
			NoSuchPersistedInvoiceLineException {

		return getPersistence().findByCustomInvoiceId_First(
			persistedInvoiceId, orderByComparator);
	}

	/**
	 * Returns the first persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted invoice line, or <code>null</code> if a matching persisted invoice line could not be found
	 */
	public static PersistedInvoiceLine fetchByCustomInvoiceId_First(
		long persistedInvoiceId,
		OrderByComparator<PersistedInvoiceLine> orderByComparator) {

		return getPersistence().fetchByCustomInvoiceId_First(
			persistedInvoiceId, orderByComparator);
	}

	/**
	 * Returns the last persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a matching persisted invoice line could not be found
	 */
	public static PersistedInvoiceLine findByCustomInvoiceId_Last(
			long persistedInvoiceId,
			OrderByComparator<PersistedInvoiceLine> orderByComparator)
		throws com.liferay.training.exception.
			NoSuchPersistedInvoiceLineException {

		return getPersistence().findByCustomInvoiceId_Last(
			persistedInvoiceId, orderByComparator);
	}

	/**
	 * Returns the last persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted invoice line, or <code>null</code> if a matching persisted invoice line could not be found
	 */
	public static PersistedInvoiceLine fetchByCustomInvoiceId_Last(
		long persistedInvoiceId,
		OrderByComparator<PersistedInvoiceLine> orderByComparator) {

		return getPersistence().fetchByCustomInvoiceId_Last(
			persistedInvoiceId, orderByComparator);
	}

	/**
	 * Returns the persisted invoice lines before and after the current persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceLineId the primary key of the current persisted invoice line
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a persisted invoice line with the primary key could not be found
	 */
	public static PersistedInvoiceLine[] findByCustomInvoiceId_PrevAndNext(
			long persistedInvoiceLineId, long persistedInvoiceId,
			OrderByComparator<PersistedInvoiceLine> orderByComparator)
		throws com.liferay.training.exception.
			NoSuchPersistedInvoiceLineException {

		return getPersistence().findByCustomInvoiceId_PrevAndNext(
			persistedInvoiceLineId, persistedInvoiceId, orderByComparator);
	}

	/**
	 * Removes all the persisted invoice lines where persistedInvoiceId = &#63; from the database.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 */
	public static void removeByCustomInvoiceId(long persistedInvoiceId) {
		getPersistence().removeByCustomInvoiceId(persistedInvoiceId);
	}

	/**
	 * Returns the number of persisted invoice lines where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @return the number of matching persisted invoice lines
	 */
	public static int countByCustomInvoiceId(long persistedInvoiceId) {
		return getPersistence().countByCustomInvoiceId(persistedInvoiceId);
	}

	/**
	 * Caches the persisted invoice line in the entity cache if it is enabled.
	 *
	 * @param persistedInvoiceLine the persisted invoice line
	 */
	public static void cacheResult(PersistedInvoiceLine persistedInvoiceLine) {
		getPersistence().cacheResult(persistedInvoiceLine);
	}

	/**
	 * Caches the persisted invoice lines in the entity cache if it is enabled.
	 *
	 * @param persistedInvoiceLines the persisted invoice lines
	 */
	public static void cacheResult(
		List<PersistedInvoiceLine> persistedInvoiceLines) {

		getPersistence().cacheResult(persistedInvoiceLines);
	}

	/**
	 * Creates a new persisted invoice line with the primary key. Does not add the persisted invoice line to the database.
	 *
	 * @param persistedInvoiceLineId the primary key for the new persisted invoice line
	 * @return the new persisted invoice line
	 */
	public static PersistedInvoiceLine create(long persistedInvoiceLineId) {
		return getPersistence().create(persistedInvoiceLineId);
	}

	/**
	 * Removes the persisted invoice line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedInvoiceLineId the primary key of the persisted invoice line
	 * @return the persisted invoice line that was removed
	 * @throws NoSuchPersistedInvoiceLineException if a persisted invoice line with the primary key could not be found
	 */
	public static PersistedInvoiceLine remove(long persistedInvoiceLineId)
		throws com.liferay.training.exception.
			NoSuchPersistedInvoiceLineException {

		return getPersistence().remove(persistedInvoiceLineId);
	}

	public static PersistedInvoiceLine updateImpl(
		PersistedInvoiceLine persistedInvoiceLine) {

		return getPersistence().updateImpl(persistedInvoiceLine);
	}

	/**
	 * Returns the persisted invoice line with the primary key or throws a <code>NoSuchPersistedInvoiceLineException</code> if it could not be found.
	 *
	 * @param persistedInvoiceLineId the primary key of the persisted invoice line
	 * @return the persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a persisted invoice line with the primary key could not be found
	 */
	public static PersistedInvoiceLine findByPrimaryKey(
			long persistedInvoiceLineId)
		throws com.liferay.training.exception.
			NoSuchPersistedInvoiceLineException {

		return getPersistence().findByPrimaryKey(persistedInvoiceLineId);
	}

	/**
	 * Returns the persisted invoice line with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param persistedInvoiceLineId the primary key of the persisted invoice line
	 * @return the persisted invoice line, or <code>null</code> if a persisted invoice line with the primary key could not be found
	 */
	public static PersistedInvoiceLine fetchByPrimaryKey(
		long persistedInvoiceLineId) {

		return getPersistence().fetchByPrimaryKey(persistedInvoiceLineId);
	}

	/**
	 * Returns all the persisted invoice lines.
	 *
	 * @return the persisted invoice lines
	 */
	public static List<PersistedInvoiceLine> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the persisted invoice lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoice lines
	 * @param end the upper bound of the range of persisted invoice lines (not inclusive)
	 * @return the range of persisted invoice lines
	 */
	public static List<PersistedInvoiceLine> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the persisted invoice lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoice lines
	 * @param end the upper bound of the range of persisted invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted invoice lines
	 */
	public static List<PersistedInvoiceLine> findAll(
		int start, int end,
		OrderByComparator<PersistedInvoiceLine> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted invoice lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedInvoiceLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoice lines
	 * @param end the upper bound of the range of persisted invoice lines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted invoice lines
	 */
	public static List<PersistedInvoiceLine> findAll(
		int start, int end,
		OrderByComparator<PersistedInvoiceLine> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the persisted invoice lines from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of persisted invoice lines.
	 *
	 * @return the number of persisted invoice lines
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PersistedInvoiceLinePersistence getPersistence() {
		return _persistence;
	}

	private static volatile PersistedInvoiceLinePersistence _persistence;

}