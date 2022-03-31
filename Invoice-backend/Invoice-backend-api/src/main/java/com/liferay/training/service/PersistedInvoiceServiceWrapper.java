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
 * Provides a wrapper for {@link PersistedInvoiceService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceService
 * @generated
 */
public class PersistedInvoiceServiceWrapper
	implements PersistedInvoiceService,
			   ServiceWrapper<PersistedInvoiceService> {

	public PersistedInvoiceServiceWrapper(
		PersistedInvoiceService persistedInvoiceService) {

		_persistedInvoiceService = persistedInvoiceService;
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

		return _persistedInvoiceService.addPersistedInvoice(
			gst, cardCode, cardName, carrier, documentDate, documentNumber,
			documentStatus, dueDate, freightAmount, invoiceTotal, invoiceLines,
			serviceContext);
	}

	@Override
	public int countAll() {
		return _persistedInvoiceService.countAll();
	}

	@Override
	public com.liferay.training.model.PersistedInvoice deletePersistedInvoice(
			Long persistedInvoiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.security.auth.PrincipalException {

		return _persistedInvoiceService.deletePersistedInvoice(
			persistedInvoiceId);
	}

	@Override
	public java.util.List<com.liferay.training.model.PersistedInvoice>
		getInvoices(int start, int end) {

		return _persistedInvoiceService.getInvoices(start, end);
	}

	@Override
	public java.util.List<com.liferay.training.model.PersistedInvoice>
		getInvoicesByKeywords(
			String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.training.model.PersistedInvoice>
					orderByComparator) {

		return _persistedInvoiceService.getInvoicesByKeywords(
			keywords, start, end, orderByComparator);
	}

	@Override
	public long getInvoicesCountByKeywords(String keywords) {
		return _persistedInvoiceService.getInvoicesCountByKeywords(keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedInvoiceService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.training.model.PersistedInvoice getPersistedInvoice(
			Long persistedInvoiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.security.auth.PrincipalException {

		return _persistedInvoiceService.getPersistedInvoice(persistedInvoiceId);
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

		return _persistedInvoiceService.patchPersistedInvoice(
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

		return _persistedInvoiceService.updatePersistedInvoice(
			persistedInvoiceId, gst, cardCode, cardName, carrier, documentDate,
			documentNumber, documentStatus, dueDate, freightAmount,
			invoiceTotal, invoiceLines, serviceContext);
	}

	@Override
	public com.liferay.training.model.PersistedInvoice updatePersistedInvoice(
			com.liferay.training.model.PersistedInvoice persistedInvoice)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedInvoiceService.updatePersistedInvoice(
			persistedInvoice);
	}

	@Override
	public PersistedInvoiceService getWrappedService() {
		return _persistedInvoiceService;
	}

	@Override
	public void setWrappedService(
		PersistedInvoiceService persistedInvoiceService) {

		_persistedInvoiceService = persistedInvoiceService;
	}

	private PersistedInvoiceService _persistedInvoiceService;

}