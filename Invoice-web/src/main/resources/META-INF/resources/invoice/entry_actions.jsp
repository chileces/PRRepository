<%@ include file="../init.jsp"%>
<c:set var="invoice" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />
<liferay-ui:icon-menu markupView="lexicon">
	<%-- View action. --%>
	<c:if
		test="${invoicePermission.contains(permissionChecker, invoice.persistedInvoiceId,'VIEW') }">
		<portlet:renderURL var="viewInvoiceURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.VIEW_INVOICE%>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="persistedInvoiceId"
				value="${invoice.persistedInvoiceId}" />
		</portlet:renderURL>
		<liferay-ui:icon message="view" url="${viewInvoiceURL}" />
	</c:if>
	<c:if
		test="${invoicePermission.contains(permissionChecker, invoice.persistedInvoiceId,'DELETE') }">
		<%-- Delete action. --%>
		<portlet:actionURL name="<%=MVCCommandNames.DELETE_INVOICE%>"
			var="deleteInvoiceURL">
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="persistedInvoiceId"
				value="${invoice.persistedInvoiceId}" />
		</portlet:actionURL>
		<liferay-ui:icon-delete url="${deleteInvoiceURL}" />
	</c:if>

</liferay-ui:icon-menu>