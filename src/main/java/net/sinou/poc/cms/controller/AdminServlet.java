package net.sinou.poc.cms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sinou.poc.cms.domain.Page;
import net.sinou.poc.cms.service.PageFacade;

@WebServlet(name = "AdminServlet", urlPatterns = { "/admin/", "/admin/viewPages", "/admin/editPage", "/admin/logout" })
@ServletSecurity(@HttpConstraint(transportGuarantee = TransportGuarantee.CONFIDENTIAL, rolesAllowed = { "cmsEditor" }))
public class AdminServlet extends HttpServlet {

	private String userPath;
	private List<Page> pageList = new ArrayList<>();
	private PageFacade pageFacade;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		userPath = request.getServletPath();

		if (userPath.equals("/admin/viewPages")) {
			pageList = pageFacade.findAll();
			request.setAttribute("pageList", pageList);
		} else if (userPath.equals("/admin/editPage")) {
			// get page id from request
			String pageId = request.getQueryString();
			// get page details
			Page page = pageFacade.find(Integer.parseInt(pageId));
			request.setAttribute("pageRecord", page);
		} else if (userPath.equals("/admin/logout")) {
			session = request.getSession();
			session.invalidate(); // terminate session
			response.sendRedirect("/admin/");
			return;
		}

		// use RequestDispatcher to forward request internally
		userPath = "/admin/index.jsp";
		try {
			request.getRequestDispatcher(userPath).forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
