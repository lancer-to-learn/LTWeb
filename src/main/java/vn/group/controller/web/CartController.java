package vn.group.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Collection;
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

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import vn.group.model.BrandModel;
import vn.group.model.ProductModel;
//import vn.group.model.ProductModel;
import vn.group.model.ReceiptDetailModel;
import vn.group.service.BrandService;
import vn.group.service.ProductService;
//import vn.group.service.ProductService;
import vn.group.service.impl.BrandServiceImpl;
//import vn.group.service.impl.ProductServiceImpl;
import vn.group.service.impl.ProductServiceImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/cart-item", "/cart-update", "/cart-remove"})

public class CartController extends HttpServlet implements Serializable {
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		BrandService brandService = new BrandServiceImpl(); 
		List<BrandModel> allBrand = brandService.getAllBrand();

		req.setAttribute("allBrand", allBrand);
		if (url.contains("cart-item")) {

			RequestDispatcher rq = req.getRequestDispatcher("/views/web/cart.jsp");
			rq.forward(req, resp);
		}
		else {
			if (url.contains("cart-remove")) {
				HttpSession httpSession = req.getSession();
				Object obj = httpSession.getAttribute("cart");
				
				String pId = req.getParameter("id");
				
				if (obj != null) {
					Map<Integer, ReceiptDetailModel> map = (Map<Integer, ReceiptDetailModel>) obj; // ep ve kieu cua no
					// Xoa san pham trong map
					map.remove(Integer.parseInt(pId));
					
					// Cap nhat lai Session
					httpSession.setAttribute("cart", map);
					int cart_quantity = 0;
					Collection<ReceiptDetailModel> items = map.values();
					for(ReceiptDetailModel item: items) {
						cart_quantity += item.getQuantity();
					}
					
					httpSession.setAttribute("cart_quantity", cart_quantity);
					resp.sendRedirect("cart-item");
					
					/*PrintWriter out = resp.getWriter();
			        out.print(cart_quantity);*/
				}	
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		if (url.contains("cart-update")) {
			JsonObject data = new Gson().fromJson(req.getReader(), JsonObject.class);
			String pId = data.get("id").getAsString();
			String quan = data.get("quantity").getAsString();
			int id = Integer.parseInt(pId);
			int quantity = Integer.parseInt(quan);
			/*if (Integer.parseInt(quantity)<=1)
				quantity = "1";*/
			ProductService productService = new ProductServiceImpl();
			ProductModel product = productService.getProductById(id);
			// cartItem.setQuantity(Integer.parseInt(quantity));
			HttpSession httpSession = req.getSession();
			Object obj = httpSession.getAttribute("cart");
			Map<Integer, ReceiptDetailModel> map = (Map<Integer, ReceiptDetailModel>) obj;
			if (product.getpAmount()>= quantity) {
				ReceiptDetailModel item = map.get(id);
				Object ob = httpSession.getAttribute("cart_quantity");
				int cart_quantity = (int) ob;
				cart_quantity -= item.getQuantity();
				item.setQuantity(quantity);
				cart_quantity += item.getQuantity();
				httpSession.setAttribute("cart_quantity", cart_quantity);
				PrintWriter out = resp.getWriter();
		        out.print(cart_quantity);
			}
			
		}
	}
	


	
}
		
		
