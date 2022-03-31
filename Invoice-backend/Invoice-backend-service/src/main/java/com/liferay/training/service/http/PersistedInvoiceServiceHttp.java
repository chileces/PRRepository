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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.training.service.PersistedInvoiceServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>PersistedInvoiceServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedInvoiceServiceSoap
 * @generated
 */
public class PersistedInvoiceServiceHttp {

	public static java.util.List<com.liferay.training.model.PersistedInvoice>
		getInvoices(HttpPrincipal httpPrincipal, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceServiceUtil.class, "getInvoices",
				_getInvoicesParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.training.model.PersistedInvoice>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int countAll(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceServiceUtil.class, "countAll",
				_countAllParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.model.PersistedInvoice
			getPersistedInvoice(
				HttpPrincipal httpPrincipal, Long persistedInvoiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.security.auth.PrincipalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceServiceUtil.class, "getPersistedInvoice",
				_getPersistedInvoiceParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, persistedInvoiceId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.security.auth.
							PrincipalException) {

					throw (com.liferay.portal.kernel.security.auth.
						PrincipalException)exception;
				}

				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.model.PersistedInvoice)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.model.PersistedInvoice
			updatePersistedInvoice(
				HttpPrincipal httpPrincipal,
				com.liferay.training.model.PersistedInvoice persistedInvoice)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceServiceUtil.class, "updatePersistedInvoice",
				_updatePersistedInvoiceParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, persistedInvoice);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.model.PersistedInvoice)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.model.PersistedInvoice
			deletePersistedInvoice(
				HttpPrincipal httpPrincipal, Long persistedInvoiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.security.auth.PrincipalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceServiceUtil.class, "deletePersistedInvoice",
				_deletePersistedInvoiceParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, persistedInvoiceId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.security.auth.
							PrincipalException) {

					throw (com.liferay.portal.kernel.security.auth.
						PrincipalException)exception;
				}

				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.model.PersistedInvoice)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.model.PersistedInvoice
			updatePersistedInvoice(
				HttpPrincipal httpPrincipal, long persistedInvoiceId,
				Double gst, String cardCode, String cardName, String carrier,
				java.util.Date documentDate, String documentNumber,
				String documentStatus, java.util.Date dueDate,
				Double freightAmount, Double invoiceTotal,
				java.util.List<com.liferay.training.model.PersistedInvoiceLine>
					invoiceLines,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceServiceUtil.class, "updatePersistedInvoice",
				_updatePersistedInvoiceParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, persistedInvoiceId, gst, cardCode, cardName, carrier,
				documentDate, documentNumber, documentStatus, dueDate,
				freightAmount, invoiceTotal, invoiceLines, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.model.PersistedInvoice)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.model.PersistedInvoice
			patchPersistedInvoice(
				HttpPrincipal httpPrincipal, long persistedInvoiceId,
				Double gst, String cardCode, String cardName, String carrier,
				java.util.Date documentDate, String documentNumber,
				String documentStatus, java.util.Date dueDate,
				Double freightAmount, Double invoiceTotal,
				java.util.List<com.liferay.training.model.PersistedInvoiceLine>
					invoiceLines,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceServiceUtil.class, "patchPersistedInvoice",
				_patchPersistedInvoiceParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, persistedInvoiceId, gst, cardCode, cardName, carrier,
				documentDate, documentNumber, documentStatus, dueDate,
				freightAmount, invoiceTotal, invoiceLines, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.model.PersistedInvoice)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.model.PersistedInvoice
			addPersistedInvoice(
				HttpPrincipal httpPrincipal, Double gst, String cardCode,
				String cardName, String carrier, java.util.Date documentDate,
				String documentNumber, String documentStatus,
				java.util.Date dueDate, Double freightAmount,
				Double invoiceTotal,
				java.util.List<com.liferay.training.model.PersistedInvoiceLine>
					invoiceLines,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceServiceUtil.class, "addPersistedInvoice",
				_addPersistedInvoiceParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, gst, cardCode, cardName, carrier, documentDate,
				documentNumber, documentStatus, dueDate, freightAmount,
				invoiceTotal, invoiceLines, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.model.PersistedInvoice)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.training.model.PersistedInvoice>
		getInvoicesByKeywords(
			HttpPrincipal httpPrincipal, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.training.model.PersistedInvoice>
					orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceServiceUtil.class, "getInvoicesByKeywords",
				_getInvoicesByKeywordsParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, keywords, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.training.model.PersistedInvoice>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getInvoicesCountByKeywords(
		HttpPrincipal httpPrincipal, String keywords) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceServiceUtil.class, "getInvoicesCountByKeywords",
				_getInvoicesCountByKeywordsParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PersistedInvoiceServiceHttp.class);

	private static final Class<?>[] _getInvoicesParameterTypes0 = new Class[] {
		int.class, int.class
	};
	private static final Class<?>[] _countAllParameterTypes1 = new Class[] {};
	private static final Class<?>[] _getPersistedInvoiceParameterTypes2 =
		new Class[] {Long.class};
	private static final Class<?>[] _updatePersistedInvoiceParameterTypes3 =
		new Class[] {com.liferay.training.model.PersistedInvoice.class};
	private static final Class<?>[] _deletePersistedInvoiceParameterTypes4 =
		new Class[] {Long.class};
	private static final Class<?>[] _updatePersistedInvoiceParameterTypes5 =
		new Class[] {
			long.class, Double.class, String.class, String.class, String.class,
			java.util.Date.class, String.class, String.class,
			java.util.Date.class, Double.class, Double.class,
			java.util.List.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _patchPersistedInvoiceParameterTypes6 =
		new Class[] {
			long.class, Double.class, String.class, String.class, String.class,
			java.util.Date.class, String.class, String.class,
			java.util.Date.class, Double.class, Double.class,
			java.util.List.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _addPersistedInvoiceParameterTypes7 =
		new Class[] {
			Double.class, String.class, String.class, String.class,
			java.util.Date.class, String.class, String.class,
			java.util.Date.class, Double.class, Double.class,
			java.util.List.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getInvoicesByKeywordsParameterTypes8 =
		new Class[] {
			String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getInvoicesCountByKeywordsParameterTypes9 =
		new Class[] {String.class};

}