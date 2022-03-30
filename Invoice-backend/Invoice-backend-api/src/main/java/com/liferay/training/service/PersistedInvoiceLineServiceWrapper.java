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
 * Provides a wrapper for {@link PersistedInvoiceLineService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceLineService
 * @generated
 */
public class PersistedInvoiceLineServiceWrapper
	implements PersistedInvoiceLineService,
			   ServiceWrapper<PersistedInvoiceLineService> {

	public PersistedInvoiceLineServiceWrapper(
		PersistedInvoiceLineService persistedInvoiceLineService) {

		_persistedInvoiceLineService = persistedInvoiceLineService;
	}

	@Override
	public com.liferay.training.model.PersistedInvoiceLine
			addPersistedInvoiceLine(
				long persistedInvoiceId, double price, Integer quantity,
				String itemCode, Integer lineNum, double lineTotal,
				long salesOrder, Integer saleOrderLineNum,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedInvoiceLineService.addPersistedInvoiceLine(
			persistedInvoiceId, price, quantity, itemCode, lineNum, lineTotal,
			salesOrder, saleOrderLineNum, serviceContext);
	}

	@Override
	public int countByCustomInvoiceId(Long persistedInvoiceId) {
		return _persistedInvoiceLineService.countByCustomInvoiceId(
			persistedInvoiceId);
	}

	@Override
	public com.liferay.training.model.PersistedInvoiceLine
		createNewPersistedInvoiceLine() {

		return _persistedInvoiceLineService.createNewPersistedInvoiceLine();
	}

	@Override
	public java.util.List<com.liferay.training.model.PersistedInvoiceLine>
		findByInvoiceId(Long customInvoiceId) {

		return _persistedInvoiceLineService.findByInvoiceId(customInvoiceId);
	}

	@Override
	public java.util.List<com.liferay.training.model.PersistedInvoiceLine>
		findByInvoiceId(Long customInvoiceId, int start, int end) {

		return _persistedInvoiceLineService.findByInvoiceId(
			customInvoiceId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedInvoiceLineService.getOSGiServiceIdentifier();
	}

	@Override
	public PersistedInvoiceLineService getWrappedService() {
		return _persistedInvoiceLineService;
	}

	@Override
	public void setWrappedService(
		PersistedInvoiceLineService persistedInvoiceLineService) {

		_persistedInvoiceLineService = persistedInvoiceLineService;
	}

	private PersistedInvoiceLineService _persistedInvoiceLineService;

}