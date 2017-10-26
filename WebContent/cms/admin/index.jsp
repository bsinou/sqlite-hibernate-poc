<%@page import="net.sinou.poc.cms.util.JspUtils"%>
<div id="adminMenu" class="alignLeft">
	<p>
		<a href="<%JspUtils.getFullUriBase(request, "/admin/viewPages");%>">View
			all pages</a>
	</p>
	<p>
	<form method="post"
		action="<%JspUtils.getFullUriBase(request, "/logout");%>"
		class="inlineLink">
		<button type="submit" class="link-button">Logout</button>
	</form>
	</p>
</div>

<%-- pageList is requested --%>
<%
	System.out.println("\n======= Request URI: " + request.getRequestURI() + "\n");
%>
<form method="post"
		action="<%JspUtils.getFullUriBase(request, "/admin/addPage");%>"
		class="inlineLink">
		<button type="submit" class="link-button">Create page</button>
</form>
	
<c:if test="${!empty pageList}">

	<table id="adminTable" class="detailsTable">

		<tr class="header">
			<th colspan="4">Pages</th>
		</tr>

		<tr class="tableHeading">
			<td>Page ID</td>
			<td>Title</td>
			<td>Description</td>
		</tr>

		<c:forEach var="page" items="${pageList}" varStatus="iter">
			<tr
				class="${((iter.index % 2) == 1) ? 'lightBlue' : 'white'} tableRow"
				onclick="document.location.href='customerRecord?${customer.id}'">

				<%-- Below anchor tags are provided in case JavaScript is disabled --%>
				<td><a href="customerRecord?${page.id}" class="noDecoration">${page.id}</a></td>
				<td><a href="customerRecord?${page.id}" class="noDecoration">${page.title}</a></td>
				<td><a href="customerRecord?${page.id}" class="noDecoration">${page.description}</a></td>
			</tr>
		</c:forEach>

	</table>
</c:if>

<%-- pageRecord is requested --%>
<c:if test="${!empty pageRecord}">

	<table id="adminTable" class="detailsTable">

		<tr class="header">
			<th colspan="2">page details</th>
		</tr>
		<tr>
			<td style="width: 290px"><strong>Page id:</strong></td>
			<td>${pageRecord.id}</td>
		</tr>
		<tr>
			<td><strong>Title:</strong></td>
			<td>${pageRecord.title}</td>
		</tr>
		<tr>
			<td><strong>Description:</strong></td>
			<td>${pageRecord.email}</td>
		</tr>
		<tr>
			<td><strong>body:</strong></td>
			<td>${pageRecord.body}</td>
		</tr>
		</table>
</c:if>