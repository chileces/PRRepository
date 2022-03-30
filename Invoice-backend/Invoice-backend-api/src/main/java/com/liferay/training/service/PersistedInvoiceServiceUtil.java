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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.model.PersistedInvoice;

import java.util.List;

/**
 * Provides the remote service utility for PersistedInvoice. This utility wraps
 * <code>com.liferay.training.service.impl.PersistedInvoiceServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceService
 * @generated
 */
public class PersistedInvoiceServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.service.impl.PersistedInvoiceServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static PersistedInvoice addPersistedInvoice(
			Double gst, String cardCode, String cardName, String carrier,
			java.util.Date documentDate, String documentNumber,
			String documentStatus, java.util.Date dueDate, Double freightAmount,
			Double invoiceTotal,
			List<com.liferay.training.model.PersistedInvoiceLine> invoiceLines,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addPersistedInvoice(
			gst, cardCode, cardName, carrier, documentDate, documentNumber,
			documentStatus, dueDate, freightAmount, invoiceTotal, invoiceLines,
			serviceContext);
	}

	public static int countAll() {
		return getService().countAll();
	}

	public static PersistedInvoice deletePersistedInvoice(
			Long persistedInvoiceId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException,
			   PortalException {

		return getService().deletePersistedInvoice(persistedInvoiceId);
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

	public static PersistedInvoice getPersistedInvoice(Long persistedInvoiceId)
		throws com.liferay.portal.kernel.security.auth.PrincipalException,
			   PortalException {

		return getService().getPersistedInvoice(persistedInvoiceId);
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

	public static PersistedInvoiceService getService() {
		return _service;
	}

	private static volatile PersistedInvoiceService _service;

}