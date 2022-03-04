package com.amf.web.registration.portlet.action;

import com.amf.registration.model.RegistrationLog;
import com.amf.registration.service.RegistrationLogService;
import com.amf.web.registration.constants.MVCCommandNames;
import com.amf.web.registration.constants.RegistrationPortletKeys;
import com.amf.web.registration.display.context.RegistrationLogsManagementToolbarDisplayContext;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC command for showing the Registration logs list.
 *
 * @author liferay
 */
@Component(immediate = true, property = { "javax.portlet.name=" + RegistrationPortletKeys.ADMIN_MONITOR, "mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.VIEW_USER_ACTIVITIES }, service = MVCRenderCommand.class)
public class ViewRegistrationLogsMVCRenderCommand implements MVCRenderCommand {
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// Add registration logs list related attributes.
		String eventFilter = ParamUtil.getString(renderRequest, "eventFilter", StringPool.BLANK);
		System.out.println(eventFilter);
		findAllUserActivities(renderRequest, eventFilter);

		return "/monitor/view.jsp";
	}

	/**
	 * Adds assigment list related attributes to the request.
	 *
	 * @param renderRequest
	 */
	private void findAllUserActivities(RenderRequest renderRequest, String eventType) {
		// Resolve start and end for the search.
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;

		// Call the service to get the list of assignments.
		List<RegistrationLog> registrationLogs;
		long count = 0;
		if (eventType == null || eventType.isEmpty() || eventType.equals("All")) {
			registrationLogs = _registrationLogService.findAll();
			count = registrationLogs.size();
		}else {
			registrationLogs = _registrationLogService.findByEventType(eventType, start, end);
			
			count = _registrationLogService.getRegistrationLogCountByKeywords("eventType", eventType);
		}
		// Set request attributes.
		renderRequest.setAttribute("registrationLogs", registrationLogs);
		renderRequest.setAttribute("registrationLogCount", count);
	}
	
	@Reference
	protected RegistrationLogService _registrationLogService;

}