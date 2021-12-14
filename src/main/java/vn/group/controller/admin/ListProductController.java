package vn.group.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.group.dao.impl.BrandDaoImpl;
import vn.group.model.BrandModel;
import vn.group.model.ProductModel;
import vn.group.service.BrandService;
import vn.group.service.ProductService;
import vn.group.service.impl.BrandServiceImpl;
import vn.group.service.impl.ProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/list-product", "/admin/custom-product"})
public class ListProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		if (url.contains("list-product"))
		{
			resp.setContentType("text/html");
			ProductService productservice = new ProductServiceImpl();
			List<ProductModel> products = productservice.getAllProduct();
			
			req.setAttribute("products", products);
			RequestDispatcher rq = req.getRequestDispatcher("/views/admin/listproduct.jsp");
			rq.forward(req, resp);
		}		
		else if (url.contains("custom-product"))
		{
			BrandService brandservice = new BrandServiceImpl();
			List<BrandModel> brands = brandservice.getAllBrand();
			
			req.setAttribute("brands", brands);
			
			RequestDispatcher rq = req.getRequestDispatcher("/views/admin/customproduct.jsp");
			rq.forward(req, resp);
		}
	}
}
