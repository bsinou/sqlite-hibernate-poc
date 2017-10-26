package net.sinou.poc.cms.util;

import javax.servlet.http.HttpServletRequest;

public class JspUtils {

	public static String getUriBase(HttpServletRequest request) {
		return "/" + request.getRequestURI().split("/")[0];
	}

	public static String getFullUriBase(HttpServletRequest request, String relUri) {
		return getUriBase(request) + relUri;
	}

	private JspUtils() {
	}
}
