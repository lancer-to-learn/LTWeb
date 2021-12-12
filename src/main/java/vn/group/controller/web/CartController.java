package vn.group.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.io.Serializable;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.group.model.BrandModel;
//import vn.group.model.ProductModel;
import vn.group.model.ReceiptDetailModel;
import vn.group.service.BrandService;
//import vn.group.service.ProductService;
import vn.group.service.impl.BrandServiceImpl;
//import vn.group.service.impl.ProductServiceImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/cart-item", "/cart-remove" })

public class CartController extends HttpServlet implements Serializable {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		BrandService brandService = new BrandServiceImpl(); // làm việc với Brand
		List<BrandModel> allBrand = brandService.getAllBrand();

		// Truyền dữ liệu lên views
		req.setAttribute("allBrand", allBrand);
		if (url.contains("cart-item")) {
			// Khởi tạo DAO
			RequestDispatcher rq = req.getRequestDispatcher("/views/web/cart.jsp");
			rq.forward(req, resp);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("cart-remove")) {
			HttpSession httpSession = req.getSession();
			Object obj = httpSession.getAttribute("cart");// Doc tu Session ra
			
			String pId = req.getParameter("pid");
			
			if (obj != null) {
				Map<Integer, ReceiptDetailModel> map = (Map<Integer, ReceiptDetailModel>) obj; // ep ve kieu cua no
				// Xoa san pham trong map
				map.remove(Integer.parseInt(pId));
				int cart_quantity = 0;
				// Cap nhat lai Session
				httpSession.setAttribute("cart", map);
				for(ReceiptDetailModel item: (List<ReceiptDetailModel>) map) {
					cart_quantity += item.getQuantity();
				}
				PrintWriter out = resp.getWriter();
		        out.print(cart_quantity);
			}	
		}
	}
		
		
}
