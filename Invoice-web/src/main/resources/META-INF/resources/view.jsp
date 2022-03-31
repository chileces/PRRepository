<%@ include file="/init.jsp"%>

<div class="container-fluid-1280">
	<h1>Invoices List</h1>

	<%
SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:MM:SS");
%>
	<clay:management-toolbar disabled="${searchCount eq 0}"
		displayContext="${invoicesManagementToolbarDisplayContext}"
		itemsTotal="${searchCount}" searchContainerId="assignmentEntries"
		selectable="false" />
	<liferay-ui:search-container emptyResultsMessage="no-results-found"
		iteratorURL="${iteratorURL}" id="searchResults" total="${searchCount}">
		<liferay-ui:search-container-results results="${searchResults}" />
		<liferay-ui:search-container-row
			className="com.liferay.training.model.PersistedInvoice"
			keyProperty="persistedInvoiceId" modelVar="entry">
			<liferay-ui:search-container-column-text property="documentNumber"
				name="documentNumber" />

			<liferay-ui:search-container-column-text property="cardName"
				orderable="<%= true %>" orderableProperty="cardName" name="cardName" />
			<liferay-ui:search-container-column-text property="cardCode"
				name="cardCode" />
			<liferay-ui:search-container-column-text property="carrier"
				name="carrier" />
			<liferay-ui:search-container-column-text property="gst"
				orderable="true" orderableProperty="gst" name="gst" />
			<liferay-ui:search-container-column-text orderable="<%= true %>"
				orderableProperty="documentDate"
				value="<%= sdf.format(entry.getDocumentDate()) %>"
				name="documentDate" />
			<liferay-ui:search-container-column-text property="documentStatus"
				name="documentStatus" />
			<liferay-ui:search-container-column-text property="freightAmount"
				name="freightAmount" />
			<liferay-ui:search-container-column-text
				value="<%= NumberFormat.getCurrencyInstance(locale).format(entry.getInvoiceTotal()) %>"
				name="invoiceTotal" />
			<liferay-ui:search-container-column-jsp name="actions"
				path="/invoice/entry_actions.jsp" />

		</liferay-ui:search-container-row>
		<%-- Iterator / Paging --%>
		<liferay-ui:search-iterator markupView="lexicon" />

	</liferay-ui:search-container>
</div>