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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PersistedInvoiceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceLocalService
 * @generated
 */
public class PersistedInvoiceLocalServiceWrapper
	implements PersistedInvoiceLocalService,
			   ServiceWrapper<PersistedInvoiceLocalService> {

	public PersistedInvoiceLocalServiceWrapper(
		PersistedInvoiceLocalService persistedInvoiceLocalService) {

		_persistedInvoiceLocalService = persistedInvoiceLocalService;
	}

	@Override
	public com.liferay.training.model.PersistedInvoice addPersistedInvoice(
			Double gst, String cardCode, String cardName, String carrier,
			java.util.Date documentDate, String documentNumber,
			String documentStatus, java.util.Date dueDate, Double freightAmount,
			Double invoiceTotal,
			java.util.List<com.liferay.training.model.PersistedInvoiceLine>
				invoiceLines,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedInvoiceLocalService.addPersistedInvoice(
			gst, cardCode, cardName, carrier, documentDate, documentNumber,
			documentStatus, dueDate, freightAmount, invoiceTotal, invoiceLines,
			serviceContext);
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
	@Override
	public com.liferay.training.model.PersistedInvoice addPersistedInvoice(
		com.liferay.training.model.PersistedInvoice persistedInvoice) {

		return _persistedInvoiceLocalService.addPersistedInvoice(
			persistedInvoice);
	}

	@Override
	public int countAll() {
		return _persistedInvoiceLocalService.countAll();
	}

	/**
	 * Creates a new persisted invoice with the primary key. Does not add the persisted invoice to the database.
	 *
	 * @param persistedInvoiceId the primary key for the new persisted invoice
	 * @return the new persisted invoice
	 */
	@Override
	public com.liferay.training.model.PersistedInvoice createPersistedInvoice(
		long persistedInvoiceId) {

		return _persistedInvoiceLocalService.createPersistedInvoice(
			persistedInvoiceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedInvoiceLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.liferay.training.model.PersistedInvoice deletePersistedInvoice(
			long persistedInvoiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedInvoiceLocalService.deletePersistedInvoice(
			persistedInvoiceId);
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
	@Override
	public com.liferay.training.model.PersistedInvoice deletePersistedInvoice(
		com.liferay.training.model.PersistedInvoice persistedInvoice) {

		return _persistedInvoiceLocalService.deletePersistedInvoice(
			persistedInvoice);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedInvoiceLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _persistedInvoiceLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _persistedInvoiceLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _persistedInvoiceLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _persistedInvoiceLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _persistedInvoiceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _persistedInvoiceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.training.model.PersistedInvoice fetchPersistedInvoice(
		long persistedInvoiceId) {

		return _persistedInvoiceLocalService.fetchPersistedInvoice(
			persistedInvoiceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _persistedInvoiceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _persistedInvoiceLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.training.model.PersistedInvoice>
		getInvoices(int start, int end) {

		return _persistedInvoiceLocalService.getInvoices(start, end);
	}

	@Override
	public java.util.List<com.liferay.training.model.PersistedInvoice>
		getInvoicesByKeywords(
			String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.training.model.PersistedInvoice>
					orderByComparator) {

		return _persistedInvoiceLocalService.getInvoicesByKeywords(
			keywords, start, end, orderByComparator);
	}

	@Override
	public long getInvoicesCountByKeywords(String keywords) {
		return _persistedInvoiceLocalService.getInvoicesCountByKeywords(
			keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedInvoiceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the persisted invoice with the primary key.
	 *
	 * @param persistedInvoiceId the primary key of the persisted invoice
	 * @return the persisted invoice
	 * @throws PortalException if a persisted invoice with the primary key could not be found
	 */
	@Override
	public com.liferay.training.model.PersistedInvoice getPersistedInvoice(
			long persistedInvoiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedInvoiceLocalService.getPersistedInvoice(
			persistedInvoiceId);
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
	@Override
	public java.util.List<com.liferay.training.model.PersistedInvoice>
		getPersistedInvoices(int start, int end) {

		return _persistedInvoiceLocalService.getPersistedInvoices(start, end);
	}

	/**
	 * Returns the number of persisted invoices.
	 *
	 * @return the number of persisted invoices
	 */
	@Override
	public int getPersistedInvoicesCount() {
		return _persistedInvoiceLocalService.getPersistedInvoicesCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedInvoiceLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.training.model.PersistedInvoice patchPersistedInvoice(
			long persistedInvoiceId, Double gst, String cardCode,
			String cardName, String carrier, java.util.Date documentDate,
			String documentNumber, String documentStatus,
			java.util.Date dueDate, Double freightAmount, Double invoiceTotal,
			java.util.List<com.liferay.training.model.PersistedInvoiceLine>
				invoiceLines,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedInvoiceLocalService.patchPersistedInvoice(
			persistedInvoiceId, gst, cardCode, cardName, carrier, documentDate,
			documentNumber, documentStatus, dueDate, freightAmount,
			invoiceTotal, invoiceLines, serviceContext);
	}

	@Override
	public com.liferay.training.model.PersistedInvoice updatePersistedInvoice(
			long persistedInvoiceId, Double gst, String cardCode,
			String cardName, String carrier, java.util.Date documentDate,
			String documentNumber, String documentStatus,
			java.util.Date dueDate, Double freightAmount, Double invoiceTotal,
			java.util.List<com.liferay.training.model.PersistedInvoiceLine>
				invoiceLines,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedInvoiceLocalService.updatePersistedInvoice(
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
	@Override
	public com.liferay.training.model.PersistedInvoice updatePersistedInvoice(
		com.liferay.training.model.PersistedInvoice persistedInvoice) {

		return _persistedInvoiceLocalService.updatePersistedInvoice(
			persistedInvoice);
	}

	@Override
	public PersistedInvoiceLocalService getWrappedService() {
		return _persistedInvoiceLocalService;
	}

	@Override
	public void setWrappedService(
		PersistedInvoiceLocalService persistedInvoiceLocalService) {

		_persistedInvoiceLocalService = persistedInvoiceLocalService;
	}

	private PersistedInvoiceLocalService _persistedInvoiceLocalService;

}