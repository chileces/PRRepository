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

package com.liferay.training.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.training.service.PersistedInvoiceServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>PersistedInvoiceServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.training.model.PersistedInvoiceSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.training.model.PersistedInvoice</code>, that is translated to a
 * <code>com.liferay.training.model.PersistedInvoiceSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PersistedInvoiceServiceSoap {

	public static com.liferay.training.model.PersistedInvoiceSoap[] getInvoices(
			int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.training.model.PersistedInvoice>
				returnValue = PersistedInvoiceServiceUtil.getInvoices(
					start, end);

			return com.liferay.training.model.PersistedInvoiceSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int countAll() throws RemoteException {
		try {
			int returnValue = PersistedInvoiceServiceUtil.countAll();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.training.model.PersistedInvoiceSoap
			getPersistedInvoice(Long persistedInvoiceId)
		throws RemoteException {

		try {
			com.liferay.training.model.PersistedInvoice returnValue =
				PersistedInvoiceServiceUtil.getPersistedInvoice(
					persistedInvoiceId);

			return com.liferay.training.model.PersistedInvoiceSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.training.model.PersistedInvoiceSoap
			updatePersistedInvoice(
				com.liferay.training.model.PersistedInvoiceSoap
					persistedInvoice)
		throws RemoteException {

		try {
			com.liferay.training.model.PersistedInvoice returnValue =
				PersistedInvoiceServiceUtil.updatePersistedInvoice(
					com.liferay.training.model.impl.PersistedInvoiceModelImpl.
						toModel(persistedInvoice));

			return com.liferay.training.model.PersistedInvoiceSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.training.model.PersistedInvoiceSoap
			deletePersistedInvoice(Long persistedInvoiceId)
		throws RemoteException {

		try {
			com.liferay.training.model.PersistedInvoice returnValue =
				PersistedInvoiceServiceUtil.deletePersistedInvoice(
					persistedInvoiceId);

			return com.liferay.training.model.PersistedInvoiceSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.training.model.PersistedInvoiceSoap
			updatePersistedInvoice(
				long persistedInvoiceId, Double gst, String cardCode,
				String cardName, String carrier, java.util.Date documentDate,
				String documentNumber, String documentStatus,
				java.util.Date dueDate, Double freightAmount,
				Double invoiceTotal,
				com.liferay.training.model.PersistedInvoiceLineSoap[]
					invoiceLines,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.training.model.PersistedInvoice returnValue =
				PersistedInvoiceServiceUtil.updatePersistedInvoice(
					persistedInvoiceId, gst, cardCode, cardName, carrier,
					documentDate, documentNumber, documentStatus, dueDate,
					freightAmount, invoiceTotal,
					com.liferay.training.model.impl.
						PersistedInvoiceLineModelImpl.toModels(invoiceLines),
					serviceContext);

			return com.liferay.training.model.PersistedInvoiceSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.training.model.PersistedInvoiceSoap
			patchPersistedInvoice(
				long persistedInvoiceId, Double gst, String cardCode,
				String cardName, String carrier, java.util.Date documentDate,
				String documentNumber, String documentStatus,
				java.util.Date dueDate, Double freightAmount,
				Double invoiceTotal,
				com.liferay.training.model.PersistedInvoiceLineSoap[]
					invoiceLines,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.training.model.PersistedInvoice returnValue =
				PersistedInvoiceServiceUtil.patchPersistedInvoice(
					persistedInvoiceId, gst, cardCode, cardName, carrier,
					documentDate, documentNumber, documentStatus, dueDate,
					freightAmount, invoiceTotal,
					com.liferay.training.model.impl.
						PersistedInvoiceLineModelImpl.toModels(invoiceLines),
					serviceContext);

			return com.liferay.training.model.PersistedInvoiceSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.training.model.PersistedInvoiceSoap
			addPersistedInvoice(
				Double gst, String cardCode, String cardName, String carrier,
				java.util.Date documentDate, String documentNumber,
				String documentStatus, java.util.Date dueDate,
				Double freightAmount, Double invoiceTotal,
				com.liferay.training.model.PersistedInvoiceLineSoap[]
					invoiceLines,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.training.model.PersistedInvoice returnValue =
				PersistedInvoiceServiceUtil.addPersistedInvoice(
					gst, cardCode, cardName, carrier, documentDate,
					documentNumber, documentStatus, dueDate, freightAmount,
					invoiceTotal,
					com.liferay.training.model.impl.
						PersistedInvoiceLineModelImpl.toModels(invoiceLines),
					serviceContext);

			return com.liferay.training.model.PersistedInvoiceSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.training.model.PersistedInvoiceSoap[]
			getInvoicesByKeywords(
				String keywords, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.training.model.PersistedInvoice>
						orderByComparator)
		throws RemoteException {

		try {
			java.util.List<com.liferay.training.model.PersistedInvoice>
				returnValue = PersistedInvoiceServiceUtil.getInvoicesByKeywords(
					keywords, start, end, orderByComparator);

			return com.liferay.training.model.PersistedInvoiceSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static long getInvoicesCountByKeywords(String keywords)
		throws RemoteException {

		try {
			long returnValue =
				PersistedInvoiceServiceUtil.getInvoicesCountByKeywords(
					keywords);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PersistedInvoiceServiceSoap.class);

}