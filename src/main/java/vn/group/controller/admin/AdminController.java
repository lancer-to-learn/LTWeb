package vn.group.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin", "/seller" })
public class AdminController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		if (url.contains("admin")) {
			RequestDispatcher rq = req.getRequestDispatcher("/views/admin/admin.jsp");
			rq.forward(req, resp);
		}
		else
		{
			RequestDispatcher rq = req.getRequestDispatcher("/views/seller/seller.jsp");
			rq.forward(req, resp);
		}
	}
	// sdfsfsfsf
}
