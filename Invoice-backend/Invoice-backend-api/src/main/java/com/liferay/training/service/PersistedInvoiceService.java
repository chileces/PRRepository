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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.model.PersistedInvoice;
import com.liferay.training.model.PersistedInvoiceLine;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for PersistedInvoice. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PersistedInvoiceService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.training.service.impl.PersistedInvoiceServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the persisted invoice remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PersistedInvoiceServiceUtil} if injection and service tracking are not available.
	 */
	public PersistedInvoice addPersistedInvoice(
			Double gst, String cardCode, String cardName, String carrier,
			Date documentDate, String documentNumber, String documentStatus,
			Date dueDate, Double freightAmount, Double invoiceTotal,
			List<PersistedInvoiceLine> invoiceLines,
			ServiceContext serviceContext)
		throws PortalException;

	public int countAll();

	public PersistedInvoice deletePersistedInvoice(Long persistedInvoiceId)
		throws PortalException, PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedInvoice> getInvoices(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedInvoice> getInvoicesByKeywords(
		String keywords, int start, int end,
		OrderByComparator<PersistedInvoice> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getInvoicesCountByKeywords(String keywords);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedInvoice getPersistedInvoice(Long persistedInvoiceId)
		throws PortalException, PrincipalException;

	public PersistedInvoice patchPersistedInvoice(
			long persistedInvoiceId, Double gst, String cardCode,
			String cardName, String carrier, Date documentDate,
			String documentNumber, String documentStatus, Date dueDate,
			Double freightAmount, Double invoiceTotal,
			List<PersistedInvoiceLine> invoiceLines,
			ServiceContext serviceContext)
		throws PortalException;

	public PersistedInvoice updatePersistedInvoice(
			long persistedInvoiceId, Double gst, String cardCode,
			String cardName, String carrier, Date documentDate,
			String documentNumber, String documentStatus, Date dueDate,
			Double freightAmount, Double invoiceTotal,
			List<PersistedInvoiceLine> invoiceLines,
			ServiceContext serviceContext)
		throws PortalException;

	public PersistedInvoice updatePersistedInvoice(
			PersistedInvoice persistedInvoice)
		throws PortalException;

}