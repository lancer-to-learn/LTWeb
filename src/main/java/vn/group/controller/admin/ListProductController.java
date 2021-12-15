package vn.group.controller.admin;

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

import vn.group.model.AccountModel;
import vn.group.model.BrandModel;
import vn.group.model.ProductModel;
import vn.group.service.BrandService;
import vn.group.service.ProductService;
import vn.group.service.impl.BrandServiceImpl;
import vn.group.service.impl.ProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/list-product", "/admin/custom-product", "/seller/list-product",
		"/seller/custom-product" })
public class ListProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("acc");
		if (obj != null) {
			AccountModel acc = (AccountModel) obj;
			if (url.contains("admin/list-product")) {
				resp.setContentType("text/html");
				ProductService productservice = new ProductServiceImpl();
				List<ProductModel> products = productservice.getAllProduct();
				List<ProductModel> pros = new ArrayList<ProductModel>();

				for (int i = 0; i < products.size(); i++) {
					ProductModel pro1 = products.get(i);
					if (pro1.getSeller().getRole() == 1) {
						pros.add(pro1);
					}
				}

				req.setAttribute("products", pros);
				RequestDispatcher rq = req.getRequestDispatcher("/views/admin/listproduct.jsp");
				rq.forward(req, resp);
			} else if (url.contains("admin/custom-product")) {
				BrandService brandservice = new BrandServiceImpl();
				List<BrandModel> brands = brandservice.getAllBrand();

				req.setAttribute("brands", brands);

				RequestDispatcher rq = req.getRequestDispatcher("/views/admin/customproduct.jsp");
				rq.forward(req, resp);
			} else if (url.contains("seller/list-product")) {
				resp.setContentType("text/html");
				ProductService productservice = new ProductServiceImpl();
				List<ProductModel> products = productservice.getAllProduct();
				List<ProductModel> pros = new ArrayList<ProductModel>();

				for (int i = 0; i < products.size(); i++) {
					ProductModel pro1 = products.get(i);
					if (pro1.getSeller().getId() == acc.getId()) {
						pros.add(pro1);
					}
				}

				req.setAttribute("products", pros);
				RequestDispatcher rq = req.getRequestDispatcher("/views/admin/listproduct.jsp");
				rq.forward(req, resp);
			} else if (url.contains("seller/custom-product")) {
				BrandService brandservice = new BrandServiceImpl();
				List<BrandModel> brands = brandservice.getAllBrand();

				req.setAttribute("brands", brands);

				RequestDispatcher rq = req.getRequestDispatcher("/views/admin/customproduct.jsp");
				rq.forward(req, resp);
			}
		}
	}
}
