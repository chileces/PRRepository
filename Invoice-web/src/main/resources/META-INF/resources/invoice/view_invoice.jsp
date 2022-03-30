<%@ include file="../init.jsp"%>
<div class="container-fluid-1280">
	<h2>Invoice details</h2>
	<div class="assignment-metadata">
		<dl>
			<dt>
				<liferay-ui:message key="cardCode" />
			</dt>
			<dd>${persistedInvoice.cardCode}</dd>
			<dt>
				<liferay-ui:message key="cardName" />
			</dt>
			<dd>${persistedInvoice.cardName}</dd>
			<dt>
				<liferay-ui:message key="created-by" />
			</dt>
			<dd>${persistedInvoice.userName}</dd>
			<dt>
				<liferay-ui:message key="duedate" />
			</dt>
			<dd>${persistedInvoice.dueDate}</dd>
			<dt>
				<liferay-ui:message key="carrier" />
			</dt>
			<dd>${persistedInvoice.carrier}</dd>
		</dl>
	</div>
	<h2>Invoice Lines</h2>

	<liferay-ui:search-container deltaConfigurable="true"
		emptyResultsMessage="no-results-found"
		iteratorURL="${iteratorInvoiceLineURL}" id="searchResults2"
		total="${searchCount}">
		<liferay-ui:search-container-results results="${invoiceLines}" />
		<liferay-ui:search-container-row
			className="com.liferay.training.model.PersistedInvoiceLine"
			keyProperty="persistedInvoiceLineId" modelVar="entry">
			<liferay-ui:search-container-column-text property="lineNum"
				orderable="<%= true %>" orderableProperty="lineNum"
				name="lineNum" />
			<liferay-ui:search-container-column-text property="salesOrderlineNum"
				name="salesOrderlineNum" />
			<liferay-ui:search-container-column-text property="salesOrder"
				name="salesOrder" />
			<liferay-ui:search-container-column-text property="itemCode"
				name="itemCode" />


			<liferay-ui:search-container-column-text
				value="<%= NumberFormat.getCurrencyInstance(locale).format(entry.getPrice()) %>"
				name="price" />
			<liferay-ui:search-container-column-text property="quantity"
				name="quantity" />
			<liferay-ui:search-container-column-text property="discountPercent"
				name="discountPercent" />
			<liferay-ui:search-container-column-text name="lineTotal"
				value="<%= NumberFormat.getCurrencyInstance(locale).format(entry.getLineTotal()) %>" />
		</liferay-ui:search-container-row>
		<%-- Iterator / Paging --%>
		<liferay-ui:search-iterator markupView="lexicon" />

	</liferay-ui:search-container>
	<aui:button-row>
		<aui:button cssClass="btn btn-primary" type="submit" value="Payment"/>
		<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}"
			type="cancel" />
	</aui:button-row>
</div>