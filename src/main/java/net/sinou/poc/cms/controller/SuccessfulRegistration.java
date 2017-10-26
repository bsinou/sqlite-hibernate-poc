package net.sinou.poc.cms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessfulRegistration extends HttpServlet {
	private static final long serialVersionUID = -205965605310472125L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html><body><center> User successfully registered, perfect</center></body></html>");
	}
}
