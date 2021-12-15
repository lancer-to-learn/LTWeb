package vn.group.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import vn.group.model.ProductModel;
import vn.group.model.ReceiptDetailModel;
import vn.group.service.ProductService;
import vn.group.service.impl.ProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/cart-update" })
public class CartUpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		if (url.contains("cart-update")) {
			String pId = req.getParameter("id");
			String quan = req.getParameter("quantity");
			int id = Integer.parseInt(pId);
			int quantity = Integer.parseInt(quan);
			if (quantity < 1)
				quantity = 1;
			ProductService productService = new ProductServiceImpl();
			ProductModel product = productService.getProductById(id);
			// cartItem.setQuantity(Integer.parseInt(quantity));
			HttpSession httpSession = req.getSession();
			Object obj = httpSession.getAttribute("cart");
			@SuppressWarnings("unchecked")
			Map<Integer, ReceiptDetailModel> map = (Map<Integer, ReceiptDetailModel>) obj;
			
			if (product.getpAmount()>= quantity) {	
				ReceiptDetailModel item = map.get(id);
				Object ob = httpSession.getAttribute("cart_quantity");
				int cart_quantity = (int) ob;
				cart_quantity -= item.getQuantity();
				item.setQuantity(quantity);
				
				cart_quantity += item.getQuantity();
				httpSession.setAttribute("cart_quantity", cart_quantity);
				httpSession.setAttribute("cart", map);
				PrintWriter out = resp.getWriter();
		        out.print(cart_quantity);
			}
			PrintWriter out = resp.getWriter();
	        out.print("404");
			
		}
	}
}
