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
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.model.PersistedInvoice;
import com.liferay.training.model.PersistedInvoiceLine;
import com.liferay.training.service.PersistedInvoiceLineLocalService;
import com.liferay.training.service.base.PersistedInvoiceLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.liferay.training.model.PersistedInvoice", service = AopService.class)
public class PersistedInvoiceLocalServiceImpl extends PersistedInvoiceLocalServiceBaseImpl {
	public List<PersistedInvoice> getInvoices(int start, int end) {
		return persistedInvoicePersistence.findAll(start, end);
	}

	public int countAll() {
		return persistedInvoicePersistence.countAll();
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedInvoice addPersistedInvoice(final Double gst, final String cardCode, final String cardName,
			final String carrier, final Date documentDate, final String documentNumber, final String documentStatus,
			final Date dueDate, final Double freightAmount, final Double invoiceTotal,
			final List<PersistedInvoiceLine> invoiceLines,
			final ServiceContext serviceContext) throws PortalException {
		PersistedInvoice pInvoice = createPersistedInvoice(
				counterLocalService.increment(PersistedInvoice.class.getName()));

		Date current = new Date();

		pInvoice.setCompanyId(serviceContext.getCompanyId());
		pInvoice.setCreateDate(current);
		pInvoice.setModifiedDate(current);

		User user = userLocalService.fetchUser(serviceContext.getUserId());
		if (user != null) {
			pInvoice.setUserName(user.getFullName());
			pInvoice.setUserUuid(user.getUserUuid());
		}
		
		pInvoice.setGroupId(serviceContext.getScopeGroupId());
		pInvoice.setGst(gst);
		pInvoice.setCardCode(cardCode);
		pInvoice.setCardName(cardName);
		pInvoice.setCarrier(carrier);
		pInvoice.setDocumentDate(documentDate);
		pInvoice.setDocumentNumber(documentNumber);
		pInvoice.setDocumentStatus(documentStatus);
		pInvoice.setDueDate(dueDate);
		pInvoice.setFreightAmount(freightAmount);
		pInvoice.setInvoiceTotal(invoiceTotal);

		pInvoice = addPersistedInvoice(pInvoice);

		resourceLocalService.addResources(pInvoice.getCompanyId(), pInvoice.getGroupId(), pInvoice.getUserId(),
				PersistedInvoice.class.getName(), pInvoice.getPersistedInvoiceId(), false,
				serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		
		for (PersistedInvoiceLine line : invoiceLines) {
			persistedInvoiceLineLocalService.addPersistedInvoiceLine(pInvoice.getPersistedInvoiceId(), line.getPrice(),
					line.getQuantity(), line.getItemCode(), line.getLineNum(), line.getLineTotal(),
					line.getSalesOrder(), line.getSalesOrderlineNum(), serviceContext);
		}
		
		return pInvoice;
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedInvoice updatePersistedInvoice(final long persistedInvoiceId, final Double gst,
			final String cardCode, final String cardName, final String carrier, final Date documentDate,
			final String documentNumber, final String documentStatus, final Date dueDate, final Double freightAmount,
			final Double invoiceTotal, final List<PersistedInvoiceLine> invoiceLines,
			final ServiceContext serviceContext) throws PortalException {
		// find our instance using the old id
		PersistedInvoice pInvoice = getPersistedInvoice(persistedInvoiceId);
		if (pInvoice == null) {
			_log.warn("Failed to find Invoice using id [" + persistedInvoiceId + "].");
			throw new PortalException("Could not find Invoice [" + persistedInvoiceId + "].");

		}
		Date current = new Date();

		pInvoice.setCompanyId(serviceContext.getCompanyId());
		pInvoice.setModifiedDate(current);

		User user = userLocalService.fetchUser(serviceContext.getUserId());
		if (user != null) {
			pInvoice.setUserName(user.getFullName());
			pInvoice.setUserUuid(user.getUserUuid());
		}
		
		pInvoice.setGroupId(serviceContext.getScopeGroupId());
		pInvoice.setGst(gst);
		pInvoice.setCardCode(cardCode);
		pInvoice.setCardName(cardName);
		pInvoice.setCarrier(carrier);
		pInvoice.setDocumentDate(documentDate);
		pInvoice.setDocumentNumber(documentNumber);
		pInvoice.setDocumentStatus(documentStatus);
		pInvoice.setDueDate(dueDate);
		pInvoice.setFreightAmount(freightAmount);
		pInvoice.setInvoiceTotal(invoiceTotal);

		pInvoice = updatePersistedInvoice(pInvoice);

		// purge all existing invoice lines
		persistedInvoiceLineLocalService.deleteAllInvoiceLineDetails(persistedInvoiceId);
		for (PersistedInvoiceLine line : invoiceLines) {
			persistedInvoiceLineLocalService.addPersistedInvoiceLine(persistedInvoiceId, line.getPrice(),
					line.getQuantity(), line.getItemCode(), line.getLineNum(), line.getLineTotal(),
					line.getSalesOrder(), line.getSalesOrderlineNum(), serviceContext);
		}

		return pInvoice;

	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedInvoice patchPersistedInvoice(final long persistedInvoiceId, final Double gst,
			final String cardCode, final String cardName, final String carrier, final Date documentDate,
			final String documentNumber, final String documentStatus, final Date dueDate, final Double freightAmount,
			final Double invoiceTotal, final List<PersistedInvoiceLine> invoiceLines,
			final ServiceContext serviceContext) throws PortalException {
		// find our instance using the old id
		PersistedInvoice pInvoice = getPersistedInvoice(persistedInvoiceId);
		boolean changed = false;
		if (pInvoice == null) {
			_log.warn("Failed to find Invoice using id [" + persistedInvoiceId + "].");
			throw new PortalException("Could not find Invoice [" + persistedInvoiceId + "].");

		}
		if (gst != null) {
			pInvoice.setGst(gst);
			changed = true;
		}
		if (cardCode != null) {
			pInvoice.setCardCode(cardCode);
			changed = true;
		}
		if (cardName != null) {
			pInvoice.setCardName(cardName);
			changed = true;
		}
		if (carrier != null) {
			pInvoice.setCarrier(carrier);
			changed = true;
		}
		if (documentDate != null) {
			pInvoice.setDocumentDate(documentDate);
			changed = true;
		}
		if (documentNumber != null) {
			pInvoice.setDocumentNumber(documentNumber);
			changed = true;
		}
		if (documentStatus != null) {
			pInvoice.setDocumentStatus(documentStatus);
			changed = true;
		}
		if (dueDate != null) {
			pInvoice.setDueDate(dueDate);
			changed = true;
		}
		if (freightAmount != null) {
			pInvoice.setFreightAmount(freightAmount);
			changed = true;
		}		
		if (invoiceTotal != null) {
			pInvoice.setInvoiceTotal(invoiceTotal);
			changed = true;
		}
		if (invoiceLines != null) {
			changed = true;
		}
		if (changed) {
			Date current = new Date();
	
			pInvoice.setCompanyId(serviceContext.getCompanyId());
			pInvoice.setModifiedDate(current);
	
			User user = userLocalService.fetchUser(serviceContext.getUserId());
			if (user != null) {
				pInvoice.setUserName(user.getFullName());
				pInvoice.setUserUuid(user.getUserUuid());
			}
	
			pInvoice.setGroupId(serviceContext.getScopeGroupId());
			pInvoice = updatePersistedInvoice(pInvoice);
	
			// purge all existing invoice lines
			if (invoiceLines != null && invoiceLines.size() > 0) {
				persistedInvoiceLineLocalService.deleteAllInvoiceLineDetails(persistedInvoiceId);
				for (PersistedInvoiceLine line : invoiceLines) {
					persistedInvoiceLineLocalService.addPersistedInvoiceLine(persistedInvoiceId, line.getPrice(),
							line.getQuantity(), line.getItemCode(), line.getLineNum(), line.getLineTotal(),
							line.getSalesOrder(), line.getSalesOrderlineNum(), serviceContext);
				}
			}
		}

		return pInvoice;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public PersistedInvoice deletePersistedInvoice(long persistedInvoiceId) throws PortalException {
		PersistedInvoice invoice = fetchPersistedInvoice(persistedInvoiceId);

		if (invoice != null) {
			//persistedInvoiceLineLocalService.deleteAllInvoiceLineDetails(persistedInvoiceId);

			return deletePersistedInvoice(invoice);
		}

		return null;
	}

	@Indexable(type = IndexableType.DELETE)
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	@Override
	public PersistedInvoice deletePersistedInvoice(PersistedInvoice persistedInvoice) {
		try {
			resourceLocalService.deleteResource(persistedInvoice.getCompanyId(), PersistedInvoice.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, persistedInvoice.getPersistedInvoiceId());
		} catch (PortalException e) {
			_log.warn("Error deleting persisted Invoice permissions: " + e.getMessage(), e);
		}

		persistedInvoiceLineLocalService.deleteAllInvoiceLineDetails(persistedInvoice.getPersistedInvoiceId());

		// call the super action method to try the delete.
		return super.deletePersistedInvoice(persistedInvoice);
	}

	public List<PersistedInvoice> getInvoicesByKeywords(String keywords, int start, int end,
			OrderByComparator<PersistedInvoice> orderByComparator) {
		return persistedInvoiceLocalService.dynamicQuery(getKeywordSearchDynamicQuery(keywords), start, end,
				orderByComparator);
	}

	public long getInvoicesCountByKeywords(String keywords) {
		return persistedInvoiceLocalService.dynamicQueryCount(getKeywordSearchDynamicQuery(keywords));
	}



	private DynamicQuery getKeywordSearchDynamicQuery(String keywords) {
		DynamicQuery dynamicQuery = dynamicQuery();
		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
			disjunctionQuery.add(RestrictionsFactoryUtil.like("cardName", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("cardCode", "%" + keywords + "%"));
			dynamicQuery.add(disjunctionQuery);
		}
		return dynamicQuery;
	}
	
	
	@Reference(unbind = "~")
	protected void setPersistedInvoiceLineLocalService(
			final PersistedInvoiceLineLocalService persistedInvoiceLineLocalService) {
		this.persistedInvoiceLineLocalService = persistedInvoiceLineLocalService;
	}

	private PersistedInvoiceLineLocalService persistedInvoiceLineLocalService;
	private static final Logger _log = LoggerFactory.getLogger(PersistedInvoiceLocalServiceImpl.class);
}