<%@ include file="../init.jsp"%>
<div class="container-fluid-1280 edit-assignment">
	<h1>
		<liferay-ui:message key="Add Invoice from order" />
	</h1>
	<portlet:actionURL var="renderInvoiceURL"
		name="<%=MVCCommandNames.RENDER_INVOICE%>">
	</portlet:actionURL>
	<aui:form action="${renderInvoiceURL}" name="fm">
		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>
				<aui:input name="orderNumber">
				</aui:input>
			</aui:fieldset>
		</aui:fieldset-group>
		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}"
					type="cancel" />
		</aui:button-row>
	</aui:form>
</div>
