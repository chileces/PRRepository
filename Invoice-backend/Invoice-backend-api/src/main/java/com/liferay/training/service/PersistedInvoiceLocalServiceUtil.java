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

package com.liferay.training.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.model.PersistedInvoice;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PersistedInvoice. This utility wraps
 * <code>com.liferay.training.service.impl.PersistedInvoiceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceLocalService
 * @generated
 */
public class PersistedInvoiceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.service.impl.PersistedInvoiceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static PersistedInvoice addPersistedInvoice(
			Double gst, String cardCode, String cardName, String carrier,
			java.util.Date documentDate, String documentNumber,
			String documentStatus, java.util.Date dueDate, Double freightAmount,
			Double invoiceTotal, long commerceAccountId,
			List<com.liferay.training.model.PersistedInvoiceLine> invoiceLines,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addPersistedInvoice(
			gst, cardCode, cardName, carrier, documentDate, documentNumber,
			documentStatus, dueDate, freightAmount, invoiceTotal,
			commerceAccountId, invoiceLines, serviceContext);
	}

	/**
	 * Adds the persisted invoice to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedInvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedInvoice the persisted invoice
	 * @return the persisted invoice that was added
	 */
	public static PersistedInvoice addPersistedInvoice(
		PersistedInvoice persistedInvoice) {

		return getService().addPersistedInvoice(persistedInvoice);
	}

	public static int countAll() {
		return getService().countAll();
	}

	/**
	 * Creates a new persisted invoice with the primary key. Does not add the persisted invoice to the database.
	 *
	 * @param persistedInvoiceId the primary key for the new persisted invoice
	 * @return the new persisted invoice
	 */
	public static PersistedInvoice createPersistedInvoice(
		long persistedInvoiceId) {

		return getService().createPersistedInvoice(persistedInvoiceId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the persisted invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedInvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedInvoiceId the primary key of the persisted invoice
	 * @return the persisted invoice that was removed
	 * @throws PortalException if a persisted invoice with the primary key could not be found
	 */
	public static PersistedInvoice deletePersistedInvoice(
			long persistedInvoiceId)
		throws PortalException {

		return getService().deletePersistedInvoice(persistedInvoiceId);
	}

	/**
	 * Deletes the persisted invoice from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedInvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedInvoice the persisted invoice
	 * @return the persisted invoice that was removed
	 */
	public static PersistedInvoice deletePersistedInvoice(
		PersistedInvoice persistedInvoice) {

		return getService().deletePersistedInvoice(persistedInvoice);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.model.impl.PersistedInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.model.impl.PersistedInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static PersistedInvoice fetchPersistedInvoice(
		long persistedInvoiceId) {

		return getService().fetchPersistedInvoice(persistedInvoiceId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<PersistedInvoice> getInvoices(int start, int end) {
		return getService().getInvoices(start, end);
	}

	public static List<PersistedInvoice> getInvoicesByKeywords(
		String keywords, int start, int end,
		OrderByComparator<PersistedInvoice> orderByComparator) {

		return getService().getInvoicesByKeywords(
			keywords, start, end, orderByComparator);
	}

	public static long getInvoicesCountByKeywords(String keywords) {
		return getService().getInvoicesCountByKeywords(keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Returns the persisted invoice with the primary key.
	 *
	 * @param persistedInvoiceId the primary key of the persisted invoice
	 * @return the persisted invoice
	 * @throws PortalException if a persisted invoice with the primary key could not be found
	 */
	public static PersistedInvoice getPersistedInvoice(long persistedInvoiceId)
		throws PortalException {

		return getService().getPersistedInvoice(persistedInvoiceId);
	}

	/**
	 * Returns a range of all the persisted invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.model.impl.PersistedInvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted invoices
	 * @param end the upper bound of the range of persisted invoices (not inclusive)
	 * @return the range of persisted invoices
	 */
	public static List<PersistedInvoice> getPersistedInvoices(
		int start, int end) {

		return getService().getPersistedInvoices(start, end);
	}

	/**
	 * Returns the number of persisted invoices.
	 *
	 * @return the number of persisted invoices
	 */
	public static int getPersistedInvoicesCount() {
		return getService().getPersistedInvoicesCount();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static PersistedInvoice patchPersistedInvoice(
			long persistedInvoiceId, Double gst, String cardCode,
			String cardName, String carrier, java.util.Date documentDate,
			String documentNumber, String documentStatus,
			java.util.Date dueDate, Double freightAmount, Double invoiceTotal,
			List<com.liferay.training.model.PersistedInvoiceLine> invoiceLines,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().patchPersistedInvoice(
			persistedInvoiceId, gst, cardCode, cardName, carrier, documentDate,
			documentNumber, documentStatus, dueDate, freightAmount,
			invoiceTotal, invoiceLines, serviceContext);
	}

	public static PersistedInvoice updatePersistedInvoice(
			long persistedInvoiceId, Double gst, String cardCode,
			String cardName, String carrier, java.util.Date documentDate,
			String documentNumber, String documentStatus,
			java.util.Date dueDate, Double freightAmount, Double invoiceTotal,
			List<com.liferay.training.model.PersistedInvoiceLine> invoiceLines,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updatePersistedInvoice(
			persistedInvoiceId, gst, cardCode, cardName, carrier, documentDate,
			documentNumber, documentStatus, dueDate, freightAmount,
			invoiceTotal, invoiceLines, serviceContext);
	}

	/**
	 * Updates the persisted invoice in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedInvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedInvoice the persisted invoice
	 * @return the persisted invoice that was updated
	 */
	public static PersistedInvoice updatePersistedInvoice(
		PersistedInvoice persistedInvoice) {

		return getService().updatePersistedInvoice(persistedInvoice);
	}

	public static PersistedInvoiceLocalService getService() {
		return _service;
	}

	private static volatile PersistedInvoiceLocalService _service;

}