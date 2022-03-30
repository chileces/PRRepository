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
import com.liferay.training.service.PersistedInvoiceLineServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>PersistedInvoiceLineServiceUtil</code> service
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
 * @see PersistedInvoiceLineServiceSoap
 * @generated
 */
public class PersistedInvoiceLineServiceHttp {

	public static java.util.List
		<com.liferay.training.model.PersistedInvoiceLine> findByInvoiceId(
			HttpPrincipal httpPrincipal, Long customInvoiceId, int start,
			int end) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceLineServiceUtil.class, "findByInvoiceId",
				_findByInvoiceIdParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, customInvoiceId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.training.model.PersistedInvoiceLine>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int countByCustomInvoiceId(
		HttpPrincipal httpPrincipal, Long persistedInvoiceId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceLineServiceUtil.class, "countByCustomInvoiceId",
				_countByCustomInvoiceIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, persistedInvoiceId);

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

	public static java.util.List
		<com.liferay.training.model.PersistedInvoiceLine> findByInvoiceId(
			HttpPrincipal httpPrincipal, Long customInvoiceId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceLineServiceUtil.class, "findByInvoiceId",
				_findByInvoiceIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, customInvoiceId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.training.model.PersistedInvoiceLine>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.model.PersistedInvoiceLine
		createNewPersistedInvoiceLine(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceLineServiceUtil.class,
				"createNewPersistedInvoiceLine",
				_createNewPersistedInvoiceLineParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.model.PersistedInvoiceLine)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.model.PersistedInvoiceLine
			addPersistedInvoiceLine(
				HttpPrincipal httpPrincipal, long persistedInvoiceId,
				double price, Integer quantity, String itemCode,
				Integer lineNum, double lineTotal, long salesOrder,
				Integer saleOrderLineNum,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedInvoiceLineServiceUtil.class,
				"addPersistedInvoiceLine",
				_addPersistedInvoiceLineParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, persistedInvoiceId, price, quantity, itemCode,
				lineNum, lineTotal, salesOrder, saleOrderLineNum,
				serviceContext);

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

			return (com.liferay.training.model.PersistedInvoiceLine)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PersistedInvoiceLineServiceHttp.class);

	private static final Class<?>[] _findByInvoiceIdParameterTypes0 =
		new Class[] {Long.class, int.class, int.class};
	private static final Class<?>[] _countByCustomInvoiceIdParameterTypes1 =
		new Class[] {Long.class};
	private static final Class<?>[] _findByInvoiceIdParameterTypes2 =
		new Class[] {Long.class};
	private static final Class<?>[]
		_createNewPersistedInvoiceLineParameterTypes3 = new Class[] {};
	private static final Class<?>[] _addPersistedInvoiceLineParameterTypes4 =
		new Class[] {
			long.class, double.class, Integer.class, String.class,
			Integer.class, double.class, long.class, Integer.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};

}