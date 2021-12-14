package vn.group.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Collection;
//import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.group.model.ReceiptDetailModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/cart-remove" })
public class CartRemoveController extends HttpServlet implements Serializable{
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		
		String pId = req.getParameter("pid");
		
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
			
			PrintWriter out = resp.getWriter();
	        out.print(cart_quantity);
		}
	}
}
