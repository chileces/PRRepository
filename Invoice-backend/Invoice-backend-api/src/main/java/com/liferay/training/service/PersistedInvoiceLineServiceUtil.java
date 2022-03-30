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
import com.liferay.training.model.PersistedInvoiceLine;

import java.util.List;

/**
 * Provides the remote service utility for PersistedInvoiceLine. This utility wraps
 * <code>com.liferay.training.service.impl.PersistedInvoiceLineServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceLineService
 * @generated
 */
public class PersistedInvoiceLineServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.service.impl.PersistedInvoiceLineServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static PersistedInvoiceLine addPersistedInvoiceLine(
			long persistedInvoiceId, double price, Integer quantity,
			String itemCode, Integer lineNum, double lineTotal, long salesOrder,
			Integer saleOrderLineNum,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addPersistedInvoiceLine(
			persistedInvoiceId, price, quantity, itemCode, lineNum, lineTotal,
			salesOrder, saleOrderLineNum, serviceContext);
	}

	public static int countByCustomInvoiceId(Long persistedInvoiceId) {
		return getService().countByCustomInvoiceId(persistedInvoiceId);
	}

	public static PersistedInvoiceLine createNewPersistedInvoiceLine() {
		return getService().createNewPersistedInvoiceLine();
	}

	public static List<PersistedInvoiceLine> findByInvoiceId(
		Long customInvoiceId) {

		return getService().findByInvoiceId(customInvoiceId);
	}

	public static List<PersistedInvoiceLine> findByInvoiceId(
		Long customInvoiceId, int start, int end) {

		return getService().findByInvoiceId(customInvoiceId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static PersistedInvoiceLineService getService() {
		return _service;
	}

	private static volatile PersistedInvoiceLineService _service;

}