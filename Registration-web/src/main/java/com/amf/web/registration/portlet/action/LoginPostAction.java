package com.amf.web.registration.portlet.action;

import com.amf.registration.model.RegistrationLog;
import com.amf.registration.service.RegistrationLogLocalServiceUtil;
import com.amf.web.registration.enums.UserEventType;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "key=login.events.post" }, service = LifecycleAction.class)
public class LoginPostAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		long userId = 0;
		HttpServletRequest request = lifecycleEvent.getRequest();
		try {
			userId = PortalUtil.getUser(request).getUserId();

			long groupId = PortalUtil.getUser(request).getGroupId();
			String userName = PortalUtil.getUser(request).getScreenName() + "(" + userId + ")";
			String clientIpAddress =request.getRemoteAddr();
			long companyId = PortalUtil.getCompanyId(request);

			RegistrationLogLocalServiceUtil.addRegistrationLog(groupId, companyId, userName, 
					new Date(), new Date(),UserEventType.LOGIN.getDescription(),clientIpAddress);
			
			List<RegistrationLog> logs = RegistrationLogLocalServiceUtil.findAll();
			for (RegistrationLog log : logs) {
				System.out.println(log.getUserName() + log.getIpAddress());
			}
			System.out.println("login.event.post, userId : " + userId);

		} catch (PortalException e) {
			e.printStackTrace();			
		}
	}
	
}
