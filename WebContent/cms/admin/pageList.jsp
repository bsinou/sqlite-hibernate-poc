<%@page import="net.sinou.poc.cms.util.JspUtils"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%
	System.out.println("\n======= Request URI: " + request.getRequestURI() + "\n");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%JspUtils.getFullUriBase(request, "/cms/css/cms.css");%>">
<link rel="shortcut icon"
	href="<%JspUtils.getFullUriBase(request, "/cms/img/favicon.ico");%>">

<script
	src="<%JspUtils.getFullUriBase(request, "/cms/js/jquery-1.4.2.js");%>"
	type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('tr.tableRow').hover(function() {
			$(this).addClass('selectedRow');
		}, function() {
			$(this).removeClass('selectedRow');
		});
	});
</script>

<title>Page List</title>
</head>

<body>
	<div id="main">
		<h2>admin console</h2>
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

		<%-- pageList is requested --%>	
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
</body>
</html>
