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
import com.liferay.training.exception.NoSuchPersistedInvoiceException;
import com.liferay.training.model.PersistedInvoice;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the persisted invoice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceUtil
 * @generated
 */
@ProviderType
public interface PersistedInvoicePersistence
	extends BasePersistence<PersistedInvoice> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedInvoiceUtil} to access the persisted invoice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the persisted invoice in the entity cache if it is enabled.
	 *
	 * @param persistedInvoice the persisted invoice
	 */
	public void cacheResult(PersistedInvoice persistedInvoice);

	/**
	 * Caches the persisted invoices in the entity cache if it is enabled.
	 *
	 * @param persistedInvoices the persisted invoices
	 */
	public void cacheResult(java.util.List<PersistedInvoice> persistedInvoices);

	/**
	 * Creates a new persisted invoice with the primary key. Does not add the persisted invoice to the database.
	 *
	 * @param persistedInvoiceId the primary key for the new persisted invoice
	 * @return the new persisted invoice
	 */
	public PersistedInvoice create(long persistedInvoiceId);

	/**
	 * Removes the persisted invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedInvoiceId the primary key of the persisted invoice
	 * @return the persisted invoice that was removed
	 * @throws NoSuchPersistedInvoiceException if a persisted invoice with the primary key could not be found
	 */
	public PersistedInvoice remove(long persistedInvoiceId)
		throws NoSuchPersistedInvoiceException;

	public PersistedInvoice updateImpl(PersistedInvoice persistedInvoice);

	/**
	 * Returns the persisted invoice with the primary key or throws a <code>NoSuchPersistedInvoiceException</code> if it could not be found.
	 *
	 * @param persistedInvoiceId the primary key of the persisted invoice
	 * @return the persisted invoice
	 * @throws NoSuchPersistedInvoiceException if a persisted invoice with the primary key could not be found
	 */
	public PersistedInvoice findByPrimaryKey(long persistedInvoiceId)
		throws NoSuchPersistedInvoiceException;

	/**
	 * Returns the persisted invoice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param persistedInvoiceId the primary key of the persisted invoice
	 * @return the persisted invoice, or <code>null</code> if a persisted invoice with the primary key could not be found
	 */
	public PersistedInvoice fetchByPrimaryKey(long persistedInvoiceId);

	/**
	 * Returns all the persisted invoices.
	 *
	 * @return the persisted invoices
	 */
	public java.util.List<PersistedInvoice> findAll();

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
	public java.util.List<PersistedInvoice> findAll(int start, int end);

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
	public java.util.List<PersistedInvoice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedInvoice>
			orderByComparator);

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
	public java.util.List<PersistedInvoice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedInvoice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the persisted invoices from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of persisted invoices.
	 *
	 * @return the number of persisted invoices
	 */
	public int countAll();

}