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
		</div>

		<%
			System.out.println("\n======= Request URI: " + request.getRequestURI() + "\n");
		%>
		<form method="post"
			action="<%JspUtils.getFullUriBase(request, "/admin/addPage");%>"
			class="inlineLink">
			<button type="submit" class="link-button">Create page</button>
		</form>

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
</body>
</html>
