package vn.group.controller.web;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.Serializable;
//import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.group.model.BrandModel;
import vn.group.service.BrandService;
//import vn.group.service.ProductService;
import vn.group.service.impl.BrandServiceImpl;
//import vn.group.service.impl.ProductServiceImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/cart-item"})

public class CartController extends HttpServlet implements Serializable {
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
		/*else {
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
					
					PrintWriter out = resp.getWriter();
			        out.print(cart_quantity);
				}	
			}
		}*/
	}

	
}
		
		
