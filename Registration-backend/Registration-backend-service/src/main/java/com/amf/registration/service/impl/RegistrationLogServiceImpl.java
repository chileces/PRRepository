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

package com.amf.registration.service.impl;

import com.amf.registration.model.RegistrationLog;
import com.amf.registration.service.base.RegistrationLogServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=registration",
		"json.web.service.context.path=RegistrationLog"
	},
	service = AopService.class
)
public class RegistrationLogServiceImpl extends RegistrationLogServiceBaseImpl {
	
	public RegistrationLog addRegistrationLog(long groupId, long companyId, String userName,
			Date createDate, Date modifiedDate, String eventType, String ipAddress) throws PortalException{
		
		return registrationLogLocalService.addRegistrationLog(groupId, companyId, userName, createDate, modifiedDate, eventType, ipAddress);
	}
	
	public List<RegistrationLog> findAll(){
		return registrationLogLocalService.findAll();
	}
	
	public List<RegistrationLog> findByEventType(String eventType, int start, int end){		
		return registrationLogPersistence.findByEventType(eventType, start, end);
	}
	
	public long getRegistrationLogCountByKeywords(String fieldName, String value) {
		return registrationLogLocalService.getRegistrationLogCountByKeywords(fieldName, value);
	}
	
}