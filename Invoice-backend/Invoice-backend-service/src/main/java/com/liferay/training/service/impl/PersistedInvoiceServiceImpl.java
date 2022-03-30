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

package com.liferay.training.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionHelper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.model.PersistedInvoice;
import com.liferay.training.model.PersistedInvoiceLine;
import com.liferay.training.service.base.PersistedInvoiceServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=custominvoice",
		"json.web.service.context.path=PersistedInvoice" }, service = AopService.class)
public class PersistedInvoiceServiceImpl extends PersistedInvoiceServiceBaseImpl {
	public List<PersistedInvoice> getInvoices(int start, int end) {
		return persistedInvoiceLocalService.getPersistedInvoices(start, end);
	}

	public int countAll() {
		return persistedInvoicePersistence.countAll();
	}

	public PersistedInvoice getPersistedInvoice(Long persistedInvoiceId) throws PrincipalException, PortalException {

		PersistedInvoice customInvoice = persistedInvoicePersistence.fetchByPrimaryKey(persistedInvoiceId);
		_persistedInvoiceModelResourcePermission.check(getPermissionChecker(), customInvoice, ActionKeys.VIEW);
		return customInvoice;

	}

	public PersistedInvoice deletePersistedInvoice(Long persistedInvoiceId) throws PrincipalException, PortalException {
		_persistedInvoiceModelResourcePermission.check(getPermissionChecker(),
				persistedInvoiceLocalService.getPersistedInvoice(persistedInvoiceId), ActionKeys.DELETE);
		
		return persistedInvoiceLocalService.deletePersistedInvoice(persistedInvoiceId);
	}

	public PersistedInvoice updatePersistedInvoice(final long persistedInvoiceId, final Double gst,
			final String cardCode, final String cardName, final String carrier, final Date documentDate,
			final String documentNumber, final String documentStatus, final Date dueDate, final Double freightAmount,
			final Double invoiceTotal,
			final List<PersistedInvoiceLine> invoiceLines,
			final ServiceContext serviceContext) throws PortalException {
		_persistedInvoiceModelResourcePermission.check(getPermissionChecker(),
				persistedInvoiceLocalService.getPersistedInvoice(persistedInvoiceId), ActionKeys.UPDATE);
		return persistedInvoiceLocalService.updatePersistedInvoice(persistedInvoiceId, gst, cardCode, cardName, carrier, documentDate,
				documentNumber, documentStatus, dueDate, freightAmount, invoiceTotal, invoiceLines, serviceContext);
	}

	public PersistedInvoice patchPersistedInvoice(final long persistedInvoiceId, final Double gst, final String cardCode, final String cardName,
			final String carrier, final Date documentDate, final String documentNumber, final String documentStatus,
			final Date dueDate, final Double freightAmount, final Double invoiceTotal,
			final List<PersistedInvoiceLine> invoiceLines,
			final ServiceContext serviceContext) throws PortalException {
		_persistedInvoiceModelResourcePermission.check(getPermissionChecker(),persistedInvoiceLocalService.getPersistedInvoice(persistedInvoiceId),
				ActionKeys.UPDATE);
		return persistedInvoiceLocalService.patchPersistedInvoice(persistedInvoiceId, gst, cardCode, cardName, carrier, documentDate,
				documentNumber, documentStatus, dueDate, freightAmount, invoiceTotal, invoiceLines, serviceContext);
	}

	public PersistedInvoice addPersistedInvoice(final Double gst, final String cardCode, final String cardName,
			final String carrier, final Date documentDate, final String documentNumber, final String documentStatus,
			final Date dueDate, final Double freightAmount, final Double invoiceTotal,
			final List<PersistedInvoiceLine> invoiceLines,
			final ServiceContext serviceContext) throws PortalException {
		ModelResourcePermissionHelper.check(_persistedInvoiceModelResourcePermission, getPermissionChecker(),
				serviceContext.getScopeGroupId(), 0, ActionKeys.ADD_ENTRY);
		return persistedInvoiceLocalService.addPersistedInvoice(gst, cardCode, cardName, carrier, documentDate,
				documentNumber, documentStatus, dueDate, freightAmount, invoiceTotal,invoiceLines, serviceContext);
	}

	public List<PersistedInvoice> getInvoicesByKeywords(String keywords, int start, int end,
			OrderByComparator<PersistedInvoice> orderByComparator) {
		return persistedInvoiceLocalService.getInvoicesByKeywords(keywords, start, end, orderByComparator);
	}

	public long getInvoicesCountByKeywords(String keywords) {

		return persistedInvoiceLocalService.getInvoicesCountByKeywords(keywords);
	}
	
	
	@Reference(policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY, target = "(model.class.name=com.liferay.training.model.PersistedInvoice)")
	private volatile ModelResourcePermission<PersistedInvoice> _persistedInvoiceModelResourcePermission;
}