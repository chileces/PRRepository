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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegistrationLogService}.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationLogService
 * @generated
 */
public class RegistrationLogServiceWrapper
	implements RegistrationLogService, ServiceWrapper<RegistrationLogService> {

	public RegistrationLogServiceWrapper(
		RegistrationLogService registrationLogService) {

		_registrationLogService = registrationLogService;
	}

	@Override
	public com.amf.registration.model.RegistrationLog addRegistrationLog(
			long groupId, long companyId, String userName,
			java.util.Date createDate, java.util.Date modifiedDate,
			String eventType, String ipAddress)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationLogService.addRegistrationLog(
			groupId, companyId, userName, createDate, modifiedDate, eventType,
			ipAddress);
	}

	@Override
	public java.util.List<com.amf.registration.model.RegistrationLog>
		findAll() {

		return _registrationLogService.findAll();
	}

	@Override
	public java.util.List<com.amf.registration.model.RegistrationLog>
		findByEventType(String eventType, int start, int end) {

		return _registrationLogService.findByEventType(eventType, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _registrationLogService.getOSGiServiceIdentifier();
	}

	@Override
	public long getRegistrationLogCountByKeywords(
		String fieldName, String value) {

		return _registrationLogService.getRegistrationLogCountByKeywords(
			fieldName, value);
	}

	@Override
	public RegistrationLogService getWrappedService() {
		return _registrationLogService;
	}

	@Override
	public void setWrappedService(
		RegistrationLogService registrationLogService) {

		_registrationLogService = registrationLogService;
	}

	private RegistrationLogService _registrationLogService;

}