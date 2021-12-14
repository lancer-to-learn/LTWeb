package vn.group.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;

import vn.group.model.BrandModel;
import vn.group.service.BrandService;
import vn.group.service.impl.BrandServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/list-brand", "/admin/custom-brand"})
public class BrandController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		if (url.contains("list-brand"))
		{
			BrandService brandservice = new BrandServiceImpl(); 
			List<BrandModel> brands = brandservice.getAllBrand();
			
			req.setAttribute("brands", brands);
			RequestDispatcher rq = req.getRequestDispatcher("/views/admin/listbrand.jsp");
			rq.forward(req, resp);
		}
		else {
			if (url.contains("custom-brand"))
			{
				RequestDispatcher rq = req.getRequestDispatcher("/views/admin/custombrand.jsp");
				rq.forward(req, resp);
			}
		}
		
	}
}
