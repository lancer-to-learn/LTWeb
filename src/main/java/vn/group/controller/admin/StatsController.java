package vn.group.controller.admin;

import java.awt.image.ColorModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.MTOM;

import vn.group.model.AccountModel;
import vn.group.model.StatModel;
import vn.group.model.MyColorModel;
import vn.group.service.StatService;
import vn.group.service.impl.StatServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/stats-month", "/admin/stats-year"})
public class StatsController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		if (url.contains("stats-month"))
		{
			StatService statservice = new StatServiceImpl();
			HttpSession session = req.getSession();
			Object user = session.getAttribute("acc");
			AccountModel account = new AccountModel();
			if (user != null)
				account = (AccountModel)user;
			
			List<StatModel> stat = statservice.getBrandStatById(account.getId());
			stat = statservice.modifyBrandStat(stat);
			
			List<MyColorModel> mycolor = new ArrayList<MyColorModel>();
			for (int i=0; i<stat.size();i++)
			{
				int r = (int) Math.round(Math.random()*255);
				int g = (int) Math.round(Math.random()*255);
				int b = (int) Math.round(Math.random()*255);
				mycolor.add(new MyColorModel(r, g, b));
			}
			
			req.setAttribute("color", mycolor);
			req.setAttribute("stat", stat);
			RequestDispatcher rq = req.getRequestDispatcher("/views/admin/statsmonth.jsp");
			rq.forward(req, resp);
		}
		else {
			if (url.contains("stats-year"))
			{
				StatService statservice = new StatServiceImpl();
				HttpSession session = req.getSession();
				Object user = session.getAttribute("acc");
				AccountModel account = new AccountModel();
				if (user != null)
					account = (AccountModel)user;
				
				List<StatModel> stat = statservice.getMonthYearStat(account.getId());
				stat = statservice.modifYearStat(stat);
				try {
				int year = 0; 
				year = Integer.parseInt(req.getParameter("year"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				
				List<MyColorModel> mycolor = new ArrayList<MyColorModel>();
				for (int i=0; i<stat.size();i++)
				{
					int r = (int) Math.round(Math.random()*255);
					int g = (int) Math.round(Math.random()*255);
					int b = (int) Math.round(Math.random()*255);
					mycolor.add(new MyColorModel(r, g, b));
				}
				req.setAttribute("color", mycolor);
				req.setAttribute("stat", stat);
				
				RequestDispatcher rq = req.getRequestDispatcher("/views/admin/statsyear.jsp");
				rq.forward(req, resp);
			}
		}
	}
}
