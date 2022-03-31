<%@ include file="../init.jsp"%>
<div class="container-fluid-1280">
	<h2>Invoice details</h2>
	<liferay-ui:error
		exception="<%=CommerceOrderValidatorException.class%>"
		message="freight-amount-invalid" />
	<portlet:actionURL var="editInvoiceURL"
		name="<%=MVCCommandNames.EDIT_INVOICE%>">

	</portlet:actionURL>
	<aui:model-context bean="${persistedInvoice}"
		model="${persistedInvoiceClass}" />

	<aui:form action="${editInvoiceURL}" name="fm" method="post"
		validateOnBlur="<%=true %>">

		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset label="invoice-information">
				<aui:input name="persistedInvoiceId" type="hidden" />
				<div class="form-group-autofit">
					<div class="form-group-item">
						<aui:input name="carrier" type="text">
						</aui:input>
					</div>
					<div class="form-group-item">
						<aui:input name="cardName" label="cardName" type="text"
							readonly="true">
							<aui:validator name="required" />
						</aui:input>
					</div>
				</div>
				<div class="form-group-autofit">
					<div class="form-group-item">
						<aui:input name="userName" type="text" label="created-by"
							readonly="true">
							<aui:validator name="required" />
						</aui:input>
					</div>
					<div class="form-group-item">
						<aui:input name="documentNumber" type="text"
							label="documentNumber" readonly="true">
							<aui:validator name="required" />
						</aui:input>
					</div>
				</div>
				<div class="form-group-autofit">
					<div class="form-group-item">
						<aui:input name="documentDate" type="text" label="documentDate"
							readonly="true">
							<aui:validator name="required" />
						</aui:input>
					</div>
					<div class="form-group-item">
						<aui:input name="documentStatus" type="text"
							label="documentStatus" readonly="true">
							<aui:validator name="required" />
						</aui:input>
					</div>
				</div>
				<div class="form-group-autofit">
					<div class="form-group-item">
						<aui:input name="freightAmount" label="freightAmount">
							<aui:validator name="required" />
						</aui:input>
					</div>
				</div>
			</aui:fieldset>
		</aui:fieldset-group>
		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" value="Update" />
			<aui:button cssClass="btn btn-primary" value="Payment" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}"
				type="cancel" />
		</aui:button-row>
	</aui:form>
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
				orderable="<%=true%>" orderableProperty="lineNum" name="lineNum" />
			<liferay-ui:search-container-column-text property="salesOrderlineNum"
				name="salesOrderlineNum" />
			<liferay-ui:search-container-column-text property="salesOrder"
				name="salesOrder" />
			<liferay-ui:search-container-column-text property="itemCode"
				name="itemCode" />


			<liferay-ui:search-container-column-text
				value="<%=NumberFormat.getCurrencyInstance(locale).format(entry.getPrice())%>"
				name="price" />
			<liferay-ui:search-container-column-text property="quantity"
				name="quantity" />
			<liferay-ui:search-container-column-text property="discountPercent"
				name="discountPercent" />
			<liferay-ui:search-container-column-text name="lineTotal"
				value="<%=NumberFormat.getCurrencyInstance(locale).format(entry.getLineTotal())%>" />
		</liferay-ui:search-container-row>
		<%-- Iterator / Paging --%>
		<liferay-ui:search-iterator markupView="lexicon" />

	</liferay-ui:search-container>

</div>