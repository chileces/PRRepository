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
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.model.PersistedInvoiceLine;
import com.liferay.training.service.base.PersistedInvoiceLineLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.training.model.PersistedInvoiceLine",
	service = AopService.class
)
public class PersistedInvoiceLineLocalServiceImpl
	extends PersistedInvoiceLineLocalServiceBaseImpl {
	
	public PersistedInvoiceLine addPersistedInvoiceLine(final long persistedInvoiceId, final double price, final Integer quantity,  final 
			String itemCode, final Integer lineNum, final double lineTotal, final long salesOrder, final Integer saleOrderLineNum, final ServiceContext serviceContext) throws PortalException {
		PersistedInvoiceLine invoiceLine = createPersistedInvoiceLine(
				counterLocalService.increment(PersistedInvoiceLine.class.getName()));
		
		Date current = new Date();
		invoiceLine.setPersistedInvoiceId(persistedInvoiceId);
		invoiceLine.setPrice(price);
		invoiceLine.setItemCode(itemCode);
		invoiceLine.setLineNum(lineNum);
		invoiceLine.setLineTotal(lineTotal);
		invoiceLine.setSalesOrder(salesOrder);
		invoiceLine.setSalesOrderlineNum(saleOrderLineNum);;
		invoiceLine.setCompanyId(serviceContext.getCompanyId());
		invoiceLine.setCreateDate(serviceContext.getCreateDate(current));
		invoiceLine.setGroupId(serviceContext.getScopeGroupId());
		invoiceLine.setModifiedDate(serviceContext.getModifiedDate(current));
		invoiceLine.setQuantity(quantity);
		invoiceLine.setUserId(serviceContext.getUserId());

		User user = userLocalService.fetchUser(serviceContext.getUserId());
		if (user != null) {
			invoiceLine.setUserName(user.getFullName());
			invoiceLine.setUserUuid(user.getUserUuid());
		}
		invoiceLine = addPersistedInvoiceLine(invoiceLine);
		resourceLocalService.addResources(
				serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), serviceContext.getUserId(),
				PersistedInvoiceLine.class.getName(), invoiceLine.getPersistedInvoiceLineId(), false,
				serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		return invoiceLine;
	}
	/**
	 * delete all invoice line: Deletes all of the invoice line
	 * @param persistedInvoiceId
	 */
	public void deleteAllInvoiceLineDetails(final long persistedInvoiceId) {
		List<PersistedInvoiceLine> details = persistedInvoiceLinePersistence.findByCustomInvoiceId(persistedInvoiceId);

		if ((details != null) && (! details.isEmpty())) {
			for (PersistedInvoiceLine detail : details) {
				deletePersistedInvoiceLine(detail);
			}
		}
	}
	
	@Override
	public PersistedInvoiceLine deletePersistedInvoiceLine(long persistedInvoiceLineId) throws PortalException {
		PersistedInvoiceLine detail = fetchPersistedInvoiceLine(persistedInvoiceLineId);

		if (detail != null) {
			resourceLocalService.deleteResource(
					detail.getCompanyId(), PersistedInvoiceLine.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, detail.getPersistedInvoiceLineId());
		}

		return super.deletePersistedInvoiceLine(persistedInvoiceLineId);
	}

	@Override
	public PersistedInvoiceLine deletePersistedInvoiceLine(PersistedInvoiceLine persistedInvoiceLine) {
		try {
		resourceLocalService.deleteResource(
				persistedInvoiceLine.getCompanyId(), PersistedInvoiceLine.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, persistedInvoiceLine.getPersistedInvoiceLineId());
		} catch (PortalException e) {
			_log.warn("Error deleting vitamin detail permissions: " + e.getMessage(), e);
		}

		return super.deletePersistedInvoiceLine(persistedInvoiceLine);
	}

	/**
	 * getAllPersistedInvoiceLine: Returns the full list of details for the given persisted invoice id.
	 * @param persistedInvoiceId
	 * @return List The list of PersistedInvoiceLine details.
	 */
	public List<PersistedInvoiceLine> getAllPersistedInvoiceLine(final long persistedInvoiceId, int start, int end) {
		return persistedInvoiceLinePersistence.findByCustomInvoiceId(persistedInvoiceId, start, end);		
	}


	private static final Logger _log = LoggerFactory.getLogger(PersistedInvoiceLineLocalServiceImpl.class);
}