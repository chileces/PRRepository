<%@ include file="../init.jsp"%>
<c:set var="invoice" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<portlet:actionURL var="renderInvoiceURL"
	name="<%=MVCCommandNames.RENDER_INVOICE%>">
	<portlet:param name="orderNumber"
		value="${invoice.getCommerceOrderId()}" />
</portlet:actionURL>

<aui:form action="${renderInvoiceURL}" name="fm">
	<aui:button cssClass="btn btn-primary" type="submit"
		value="Create invoice" />
</aui:form>