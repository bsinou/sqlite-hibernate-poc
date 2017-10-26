package net.sinou.poc.cms.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sinou.poc.cms.domain.Page;
import net.sinou.poc.cms.service.PageFacade;

@WebServlet(name = "RouterServlet", urlPatterns = { "/router" })
public class RouterController extends HttpServlet {
	private static final long serialVersionUID = -3141464108396009238L;

	private final static String PAGE_PARAM_KEY = "page";

	private String userPath;
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
		userPath = request.getParameter(PAGE_PARAM_KEY);

		Optional<Page> page = pageFacade.findByUrl(userPath);

		if (!page.isPresent()) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		} else {
			try {
				request.setAttribute("pageRecord", page.get());
				// use RequestDispatcher to forward request internally
				userPath = "/cms/view/DynamicPage.jsp";
				request.getRequestDispatcher(userPath).forward(request, response);
			} catch (Exception ex) {
				// TODO use a logger
				ex.printStackTrace();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
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
