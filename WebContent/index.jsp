<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">

	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
	<jsp:output omit-xml-declaration="true" />
	<jsp:output doctype-root-element="HTML"
		doctype-system="about:legacy-compat" />
	<html lang="en">
<head>
<title>Proof of Concept</title>
<c:url var="faviconUrl" value="/resources/img/favicon.ico" />
<link rel="icon" type="image/x-icon" href="${faviconUrl}" />
<c:url var="bootstrapUrl" value="/cms/css/bootstrap.css" />
<link href="${bootstrapUrl}" rel="stylesheet"></link>
<c:url var="bootstrapResponsiveUrl"
	value="/cms/css/bootstrap-responsive.css" />
<link href="${bootstrapResponsiveUrl}" rel="stylesheet"></link>
</head>

<body>
	<div class="container">
		<p>This page should never be seen</p>
	</div>
</body>
	</html>
</jsp:root>
