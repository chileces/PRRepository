<%@ include file="../init.jsp"%>
<div class="container-fluid-1280 edit-assignment">
	<h2>
		<liferay-ui:message key="View all orders in system" />
	</h2>
	<liferay-ui:search-container deltaConfigurable="true"
		emptyResultsMessage="no-results-found" iteratorURL="${iteratorURL}"
		id="searchResults3" total="${searchCount}">
		<liferay-ui:search-container-results results="${orders}" />
		<liferay-ui:search-container-row
			className="com.liferay.commerce.model.CommerceOrder"
			keyProperty="commerceOrderId" modelVar="entry">
			<liferay-ui:search-container-column-text property="commerceOrderId"
				name="order-id" />
			<liferay-ui:search-container-column-text property="commerceAccountId"
				name="commerce-account-id" />
			<liferay-ui:search-container-column-text
				value="<%=entry.getCommerceAccount().getName() %>" name="account" />
			<liferay-ui:search-container-column-text property="createDate"
				name="createDate" />
			<liferay-ui:search-container-column-text name="orderStatus"
				value="<%=CommerceOrderConstants.getOrderStatusLabel(entry.getOrderStatus()) %>" />
			<!-- 6 is orderStatus in-progress  -->
			<c:if test="${entry.orderStatus ne 10}">
				<liferay-ui:search-container-column-jsp name="actions"
					path="/invoice/order_actions.jsp" />
			</c:if>
			<c:if test="${entry.orderStatus eq 10}">
				<liferay-ui:search-container-column-text name="actions"
					value="Already invoiced" />
			</c:if> -
		</liferay-ui:search-container-row>
		<%-- Iterator / Paging --%>

		<liferay-ui:search-iterator markupView="lexicon" />

	</liferay-ui:search-container>
</div>
