/*package vn.group.controller.web;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.Serializable;
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
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");// Doc tu Session ra
		Object ab = httpSession.getAttribute("cart_quantity");
		int quan = (int) ab;
		
		String pId = req.getParameter("id");
		
		if (obj != null) {
			Map<Integer, ReceiptDetailModel> map = (Map<Integer, ReceiptDetailModel>) obj; // ep ve kieu cua no
			// Xoa san pham trong map
			map.remove(Integer.parseInt(pId));
			//int cart_quantity = 0;
			// Cap nhat lai Session
			httpSession.setAttribute("cart", map);
			quan -= map.get(Integer.parseInt(pId)).getQuantity();
			httpSession.setAttribute("cart_quantity", quan);
			//PrintWriter out = resp.getWriter();
	        //out.print(cart_quantity);
		}
	}
}
*/