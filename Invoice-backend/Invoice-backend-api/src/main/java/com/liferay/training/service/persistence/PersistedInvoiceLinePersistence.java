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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.training.exception.NoSuchPersistedInvoiceLineException;
import com.liferay.training.model.PersistedInvoiceLine;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the persisted invoice line service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceLineUtil
 * @generated
 */
@ProviderType
public interface PersistedInvoiceLinePersistence
	extends BasePersistence<PersistedInvoiceLine> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedInvoiceLineUtil} to access the persisted invoice line persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the persisted invoice lines where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @return the matching persisted invoice lines
	 */
	public java.util.List<PersistedInvoiceLine> findByCustomInvoiceId(
		long persistedInvoiceId);

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
	public java.util.List<PersistedInvoiceLine> findByCustomInvoiceId(
		long persistedInvoiceId, int start, int end);

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
	public java.util.List<PersistedInvoiceLine> findByCustomInvoiceId(
		long persistedInvoiceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedInvoiceLine>
			orderByComparator);

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
	public java.util.List<PersistedInvoiceLine> findByCustomInvoiceId(
		long persistedInvoiceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedInvoiceLine>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a matching persisted invoice line could not be found
	 */
	public PersistedInvoiceLine findByCustomInvoiceId_First(
			long persistedInvoiceId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PersistedInvoiceLine> orderByComparator)
		throws NoSuchPersistedInvoiceLineException;

	/**
	 * Returns the first persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted invoice line, or <code>null</code> if a matching persisted invoice line could not be found
	 */
	public PersistedInvoiceLine fetchByCustomInvoiceId_First(
		long persistedInvoiceId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedInvoiceLine>
			orderByComparator);

	/**
	 * Returns the last persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a matching persisted invoice line could not be found
	 */
	public PersistedInvoiceLine findByCustomInvoiceId_Last(
			long persistedInvoiceId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PersistedInvoiceLine> orderByComparator)
		throws NoSuchPersistedInvoiceLineException;

	/**
	 * Returns the last persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted invoice line, or <code>null</code> if a matching persisted invoice line could not be found
	 */
	public PersistedInvoiceLine fetchByCustomInvoiceId_Last(
		long persistedInvoiceId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedInvoiceLine>
			orderByComparator);

	/**
	 * Returns the persisted invoice lines before and after the current persisted invoice line in the ordered set where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceLineId the primary key of the current persisted invoice line
	 * @param persistedInvoiceId the persisted invoice ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a persisted invoice line with the primary key could not be found
	 */
	public PersistedInvoiceLine[] findByCustomInvoiceId_PrevAndNext(
			long persistedInvoiceLineId, long persistedInvoiceId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PersistedInvoiceLine> orderByComparator)
		throws NoSuchPersistedInvoiceLineException;

	/**
	 * Removes all the persisted invoice lines where persistedInvoiceId = &#63; from the database.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 */
	public void removeByCustomInvoiceId(long persistedInvoiceId);

	/**
	 * Returns the number of persisted invoice lines where persistedInvoiceId = &#63;.
	 *
	 * @param persistedInvoiceId the persisted invoice ID
	 * @return the number of matching persisted invoice lines
	 */
	public int countByCustomInvoiceId(long persistedInvoiceId);

	/**
	 * Caches the persisted invoice line in the entity cache if it is enabled.
	 *
	 * @param persistedInvoiceLine the persisted invoice line
	 */
	public void cacheResult(PersistedInvoiceLine persistedInvoiceLine);

	/**
	 * Caches the persisted invoice lines in the entity cache if it is enabled.
	 *
	 * @param persistedInvoiceLines the persisted invoice lines
	 */
	public void cacheResult(
		java.util.List<PersistedInvoiceLine> persistedInvoiceLines);

	/**
	 * Creates a new persisted invoice line with the primary key. Does not add the persisted invoice line to the database.
	 *
	 * @param persistedInvoiceLineId the primary key for the new persisted invoice line
	 * @return the new persisted invoice line
	 */
	public PersistedInvoiceLine create(long persistedInvoiceLineId);

	/**
	 * Removes the persisted invoice line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedInvoiceLineId the primary key of the persisted invoice line
	 * @return the persisted invoice line that was removed
	 * @throws NoSuchPersistedInvoiceLineException if a persisted invoice line with the primary key could not be found
	 */
	public PersistedInvoiceLine remove(long persistedInvoiceLineId)
		throws NoSuchPersistedInvoiceLineException;

	public PersistedInvoiceLine updateImpl(
		PersistedInvoiceLine persistedInvoiceLine);

	/**
	 * Returns the persisted invoice line with the primary key or throws a <code>NoSuchPersistedInvoiceLineException</code> if it could not be found.
	 *
	 * @param persistedInvoiceLineId the primary key of the persisted invoice line
	 * @return the persisted invoice line
	 * @throws NoSuchPersistedInvoiceLineException if a persisted invoice line with the primary key could not be found
	 */
	public PersistedInvoiceLine findByPrimaryKey(long persistedInvoiceLineId)
		throws NoSuchPersistedInvoiceLineException;

	/**
	 * Returns the persisted invoice line with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param persistedInvoiceLineId the primary key of the persisted invoice line
	 * @return the persisted invoice line, or <code>null</code> if a persisted invoice line with the primary key could not be found
	 */
	public PersistedInvoiceLine fetchByPrimaryKey(long persistedInvoiceLineId);

	/**
	 * Returns all the persisted invoice lines.
	 *
	 * @return the persisted invoice lines
	 */
	public java.util.List<PersistedInvoiceLine> findAll();

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
	public java.util.List<PersistedInvoiceLine> findAll(int start, int end);

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
	public java.util.List<PersistedInvoiceLine> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedInvoiceLine>
			orderByComparator);

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
	public java.util.List<PersistedInvoiceLine> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedInvoiceLine>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the persisted invoice lines from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of persisted invoice lines.
	 *
	 * @return the number of persisted invoice lines
	 */
	public int countAll();

}