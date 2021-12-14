package vn.group.controller.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.group.model.CityModel;
import vn.group.model.ReceiptDetailModel;
import vn.group.service.CityService;
import vn.group.service.impl.CityServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/checkout" })

public class CheckoutController extends HttpServlet implements Serializable{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		CityService city = new CityServiceImpl();
		List<CityModel> listCity = city.getAllCity();
		HttpSession httpSession = req.getSession();
		float cart_total = 0;
		Object obj = httpSession.getAttribute("cart");
		if (obj != null) {
			Map<Integer, ReceiptDetailModel> map = (Map<Integer, ReceiptDetailModel>) obj; // ep ve kieu cua no		
			// Cap nhat lai Session
			
			Collection<ReceiptDetailModel> items = map.values();
			for(ReceiptDetailModel item: items) {
				cart_total += item.getPrice()*item.getQuantity();
			}
			
		}	
		
		req.setAttribute("listCity", listCity);
		req.setAttribute("total", cart_total);
		
		RequestDispatcher rq = req.getRequestDispatcher("/views/web/checkout.jsp");
		rq.forward(req, resp);
	}

}
