package vn.group.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/stats-month", "/admin/stats-year"})
public class StatsController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		if (url.contains("stats-month"))
		{
			RequestDispatcher rq = req.getRequestDispatcher("/views/admin/statsmonth.jsp");
			rq.forward(req, resp);
		}
		else {
			if (url.contains("stats-year"))
			{
				RequestDispatcher rq = req.getRequestDispatcher("/views/admin/statsyear.jsp");
				rq.forward(req, resp);
			}
		}
	}
}
