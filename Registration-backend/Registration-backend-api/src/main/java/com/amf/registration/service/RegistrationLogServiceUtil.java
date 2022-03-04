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

package com.amf.registration.service;

import com.amf.registration.model.RegistrationLog;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for RegistrationLog. This utility wraps
 * <code>com.amf.registration.service.impl.RegistrationLogServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationLogService
 * @generated
 */
public class RegistrationLogServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.amf.registration.service.impl.RegistrationLogServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static RegistrationLog addRegistrationLog(
			long groupId, long companyId, String userName,
			java.util.Date createDate, java.util.Date modifiedDate,
			String eventType, String ipAddress)
		throws PortalException {

		return getService().addRegistrationLog(
			groupId, companyId, userName, createDate, modifiedDate, eventType,
			ipAddress);
	}

	public static List<RegistrationLog> findAll() {
		return getService().findAll();
	}

	public static List<RegistrationLog> findByEventType(
		String eventType, int start, int end) {

		return getService().findByEventType(eventType, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static long getRegistrationLogCountByKeywords(
		String fieldName, String value) {

		return getService().getRegistrationLogCountByKeywords(fieldName, value);
	}

	public static RegistrationLogService getService() {
		return _service;
	}

	private static volatile RegistrationLogService _service;

}