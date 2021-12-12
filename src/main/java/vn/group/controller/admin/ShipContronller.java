package vn.group.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/list-city", "/admin/custom-city"})
public class ShipContronller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		if (url.contains("list-city"))
		{
			RequestDispatcher rq = req.getRequestDispatcher("/views/admin/listcity.jsp");
			rq.forward(req, resp);
		}
		else {
			if (url.contains("custom-city"))
			{
				RequestDispatcher rq = req.getRequestDispatcher("/views/admin/customcity.jsp");
				rq.forward(req, resp);
			}
		}
		
	}
}
