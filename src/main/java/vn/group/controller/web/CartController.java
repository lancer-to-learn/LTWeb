/*package vn.group.controller.web;

import java.io.IOException;
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
import vn.group.service.BrandService;
import vn.group.service.ProductService;
import vn.group.service.impl.BrandServiceImpl;
import vn.group.service.impl.ProductServiceImpl;
import vn.iotstar.model.CartItemModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/cart-item", "/cart-add", "/cart-remove" })
public class CartController extends HttpServlet implements Serializable {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		if (url.contains("cart-item")) {
			BrandService brandService = new BrandServiceImpl(); // làm việc với Brand
			List<BrandModel> allBrand = brandService.getAllBrand();

			// Truyền dữ liệu lên views
			req.setAttribute("allBrand", allBrand);

			// Khởi tạo DAO
			RequestDispatcher rq = req.getRequestDispatcher("/views/web/cart.jsp");
			rq.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("cart-add")) {
			String pId = req.getParameter("pId");
			String quantity = req.getParameter("quantity");
			ProductModel product = productService.getProductbyID(pId);
			CartItemModel cartItem = new CartItemModel();
			cartItem.setQuantity(Integer.parseInt(quantity));
			cartItem.setUnitPrice(product.getPrice());
			cartItem.setProduct(product);
			HttpSession httpSession = req.getSession();
			Object obj = httpSession.getAttribute("cart");
			if (obj == null) {
				Map<Integer, CartItemModel> map = new HashMap<Integer, CartItemModel>();
				map.put(cartItem.getProduct().getpID(), cartItem);
				httpSession.setAttribute("cart", map);
			} else {
				Map<Integer, CartItemModel> map = extracted(obj);
				CartItemModel existedCartItem = map.get(Integer.valueOf(pId));
				if (existedCartItem == null) {
					map.put(product.getpID(), cartItem);
				} else {
					existedCartItem.setQuantity(existedCartItem.getQuantity() + Integer.parseInt(quantity));
				}
				httpSession.setAttribute("cart", map);
			}
			resp.sendRedirect(req.getContextPath() + "/member/cart");
		}
		
		@SuppressWarnings("unchecked")
		private Map<Integer, CartItemModel> extracted(Object obj) {
			return (Map<Integer, CartItemModel>) obj;
	}

}
*/