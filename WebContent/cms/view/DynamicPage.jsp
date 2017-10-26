<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/cms.css">
<link rel="shortcut icon" href="../img/favicon.ico">

<script src="js/jquery-1.4.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.8.4.custom.min.js" type="text/javascript"></script>

<title>${page.title}</title>
</head>
<body>
	<div id="main">
		<div id="header">
			A header. We put the page description for the time being. <br /> <b>${page.title}:</b>
			${page.description}
		</div>

		<div id="dynPageBody">${page.body}</div>

		<div id="footer">
			<br>
			<hr id="footerDivider">
			<p id="footerText" class="reallySmallText">
				<a href="#">Privacy Policy</a> &nbsp;&nbsp;::&nbsp;&nbsp; <a
					href="#">Contact</a> &nbsp;&nbsp;&copy;&nbsp;&nbsp; 2017 the poc
			</p>
		</div>
	</div>
</body>
</html>