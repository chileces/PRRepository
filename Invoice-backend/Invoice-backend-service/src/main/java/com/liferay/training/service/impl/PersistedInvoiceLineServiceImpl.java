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
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionHelper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.model.PersistedInvoiceLine;
import com.liferay.training.service.base.PersistedInvoiceLineServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=custominvoice",
		"json.web.service.context.path=PersistedInvoiceLine" }, service = AopService.class)
public class PersistedInvoiceLineServiceImpl extends PersistedInvoiceLineServiceBaseImpl {
	public List<PersistedInvoiceLine> findByInvoiceId(Long customInvoiceId, int start, int end) {
		return persistedInvoiceLinePersistence.findByCustomInvoiceId(customInvoiceId, start, end);
	}

	public int countByCustomInvoiceId(Long persistedInvoiceId) {
		return persistedInvoiceLinePersistence.countByCustomInvoiceId(persistedInvoiceId);
	}

	public List<PersistedInvoiceLine> findByInvoiceId(Long customInvoiceId) {
		return persistedInvoiceLinePersistence.findByCustomInvoiceId(customInvoiceId);
	}

	public PersistedInvoiceLine createNewPersistedInvoiceLine() {
		return persistedInvoiceLinePersistence.create(0l);
	}

	///

	public PersistedInvoiceLine addPersistedInvoiceLine(final long persistedInvoiceId, final double price,
			final Integer quantity, final String itemCode, final Integer lineNum, final double lineTotal,
			final long salesOrder, final Integer saleOrderLineNum, final ServiceContext serviceContext)
			throws PortalException {

		ModelResourcePermissionHelper.check(_persistedInvoiceLineModelResourcePermission, getPermissionChecker(),
				serviceContext.getScopeGroupId(), 0, ActionKeys.ADD_ENTRY);
		return persistedInvoiceLineLocalService.addPersistedInvoiceLine(persistedInvoiceId, price, quantity, itemCode,
				lineNum, lineTotal, salesOrder, saleOrderLineNum, serviceContext);

	}

	@Reference(policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY, target = "(model.class.name=com.liferay.training.model.PersistedInvoiceLine)")
	private volatile ModelResourcePermission<PersistedInvoiceLine> _persistedInvoiceLineModelResourcePermission;

}