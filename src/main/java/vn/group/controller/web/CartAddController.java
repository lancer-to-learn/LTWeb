package vn.group.controller.web;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
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
import vn.group.model.ProductModel;
import vn.group.model.ReceiptDetailModel;
import vn.group.service.BrandService;
import vn.group.service.ProductService;
import vn.group.service.impl.BrandServiceImpl;
import vn.group.service.impl.ProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/cart-add" })
public class CartAddController extends HttpServlet implements Serializable {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// String url = req.getRequestURL().toString();
		BrandService brandService = new BrandServiceImpl(); // làm việc với Brand
		List<BrandModel> allBrand = brandService.getAllBrand();

		// Truyền dữ liệu lên views
		req.setAttribute("allBrand", allBrand);
		String pId = req.getParameter("pid");
		/*
		 * String quantity = req.getParameter("quantity"); if (quantity==null) quantity
		 * = "1";
		 */
		ProductService productService = new ProductServiceImpl();
		ProductModel product = productService.getProductById(Integer.parseInt(pId));
		ReceiptDetailModel cartItem = new ReceiptDetailModel();
		// cartItem.setQuantity(Integer.parseInt(quantity));
		cartItem.setQuantity(1);
		cartItem.setPrice(product.getpPrice());
		cartItem.setProduct(product);
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		if (obj == null) {
			Map<Integer, ReceiptDetailModel> map = new HashMap<Integer, ReceiptDetailModel>();
			map.put(product.getpId(), cartItem);
			httpSession.setAttribute("cart", map);
		} else {
			Map<Integer, ReceiptDetailModel> map = extracted(obj);
			ReceiptDetailModel existedCartItem = map.get(Integer.valueOf(pId));
			if (existedCartItem == null) {
				map.put(product.getpId(), cartItem);
			} else {
				existedCartItem.setQuantity(existedCartItem.getQuantity() + 1);
			}
			httpSession.setAttribute("cart", map);
		}
		RequestDispatcher rq = req.getRequestDispatcher("/views/web/cart.jsp");
		rq.forward(req, resp);
//				PrintWriter out = resp.getWriter();
//		        out.print(cartItem.getQuantity());

	}

	@SuppressWarnings("unchecked")
	private Map<Integer, ReceiptDetailModel> extracted(Object obj) {
		return (Map<Integer, ReceiptDetailModel>) obj;
	}
}
