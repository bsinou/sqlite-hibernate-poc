package net.sinou.poc.cms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sinou.poc.cms.domain.Page;
import net.sinou.poc.cms.services.PageService;
import net.sinou.poc.cms.services.SimplePageServiceImpl;

@WebServlet(name = "AdminServlet", urlPatterns = { "/admin", "/admin/viewPages", "/admin/addPage", "/admin/editPage" })
// @ServletSecurity(@HttpConstraint(transportGuarantee =
// TransportGuarantee.CONFIDENTIAL, rolesAllowed = { "CMS_EDITOR" }))
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 7029430336618441255L;

	private String userPath;
	private List<Page> pageList = new ArrayList<>();

	private PageService pageService = new SimplePageServiceImpl();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		userPath = request.getServletPath();
		System.out.println("\n\n======= Processing admin request with URL: " + userPath);
		System.out.println("======= Request URI: " + request.getRequestURI() + "\n");

		if (userPath.equals("/admin/viewPages")) {
			pageList = pageService.getAllPages();
			request.setAttribute("pageList", pageList);
			userPath = "/cms/admin/pageList.jsp";
		} else if (userPath.equals("/admin/addPage")) {
			Page page = new Page();
			request.setAttribute("pageRecord", page);
			userPath = "/cms/admin/pageDetail.jsp";
		} else if (userPath.equals("/admin/editPage")) {
			String pageId = request.getParameter("id");
			Page page = pageService.getPageById(Integer.parseInt(pageId));
			request.setAttribute("pageRecord", page);
			userPath = "/cms/admin/pageDetail.jsp";
		} else 
			userPath = "/cms/admin/index.jsp";

		try {
			request.getRequestDispatcher(userPath).forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
