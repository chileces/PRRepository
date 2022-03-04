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

package com.amf.registration.service.http;

import com.amf.registration.service.RegistrationLogServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>RegistrationLogServiceUtil</code> service
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
 * @see RegistrationLogServiceSoap
 * @generated
 */
public class RegistrationLogServiceHttp {

	public static com.amf.registration.model.RegistrationLog addRegistrationLog(
			HttpPrincipal httpPrincipal, long groupId, long companyId,
			String userName, java.util.Date createDate,
			java.util.Date modifiedDate, String eventType, String ipAddress)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationLogServiceUtil.class, "addRegistrationLog",
				_addRegistrationLogParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, companyId, userName, createDate,
				modifiedDate, eventType, ipAddress);

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

			return (com.amf.registration.model.RegistrationLog)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.amf.registration.model.RegistrationLog>
		findAll(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationLogServiceUtil.class, "findAll",
				_findAllParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.amf.registration.model.RegistrationLog>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.amf.registration.model.RegistrationLog>
		findByEventType(
			HttpPrincipal httpPrincipal, String eventType, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationLogServiceUtil.class, "findByEventType",
				_findByEventTypeParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, eventType, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.amf.registration.model.RegistrationLog>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getRegistrationLogCountByKeywords(
		HttpPrincipal httpPrincipal, String fieldName, String value) {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationLogServiceUtil.class,
				"getRegistrationLogCountByKeywords",
				_getRegistrationLogCountByKeywordsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fieldName, value);

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
		RegistrationLogServiceHttp.class);

	private static final Class<?>[] _addRegistrationLogParameterTypes0 =
		new Class[] {
			long.class, long.class, String.class, java.util.Date.class,
			java.util.Date.class, String.class, String.class
		};
	private static final Class<?>[] _findAllParameterTypes1 = new Class[] {};
	private static final Class<?>[] _findByEventTypeParameterTypes2 =
		new Class[] {String.class, int.class, int.class};
	private static final Class<?>[]
		_getRegistrationLogCountByKeywordsParameterTypes3 = new Class[] {
			String.class, String.class
		};

}