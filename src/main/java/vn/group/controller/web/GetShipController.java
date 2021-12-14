package vn.group.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.group.model.CityModel;
import vn.group.service.CityService;
import vn.group.service.impl.CityServiceImpl;


@WebServlet(urlPatterns = { "/ship" })
public class GetShipController  extends HttpServlet{

	private static final long serialVersionUID = -3962248753696527783L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String cityname = req.getParameter("cityName");
		float total = Float.parseFloat(req.getParameter("total"));
		CityService city = new CityServiceImpl();
		List<CityModel> listCity = city.getAllCity();
		for (CityModel ci: listCity)
		{
			if (ci.getName().contains(cityname)) {
				total = total + ci.getPrice();			
			}
		}
		PrintWriter out = resp.getWriter();
        out.print(total);
	}
}
