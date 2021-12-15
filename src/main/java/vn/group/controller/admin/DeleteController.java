package vn.group.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.group.model.AccountModel;
import vn.group.service.BrandService;
import vn.group.service.ProductService;
import vn.group.service.ShipService;
import vn.group.service.impl.BrandServiceImpl;
import vn.group.service.impl.ProductServiceImpl;
import vn.group.service.impl.ShipServiceImpl;

@WebServlet(urlPatterns = { "/admin/delete/list-brand", "/admin/delete/list-product", "/admin/delete/list-city" })
public class DeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8553291888043305743L;

	// title, publisher, price, cover_image, quantity
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("list-brand")) {
			BrandService brandservice = new BrandServiceImpl();
			String id = req.getParameter("id");
			int bid = Integer.parseInt(id);

			brandservice.delete(bid);
			resp.sendRedirect(req.getContextPath() + "/admin/list-brand");
		} else if (url.contains("list-product")) {
			ProductService productservice = new ProductServiceImpl();
			String id = req.getParameter("id");
			int pid = Integer.parseInt(id);

			HttpSession session = req.getSession();
			Object user = session.getAttribute("acc");
			AccountModel account = new AccountModel();
			if (user != null) {
				account = (AccountModel) user;
				
				productservice.deleteDetail(pid);
				productservice.delete(pid);
				if (account.getRole()==1)
					resp.sendRedirect(req.getContextPath() + "/admin/list-product");
				else
					resp.sendRedirect(req.getContextPath() + "/seller/list-product");
			}
		} else if (url.contains("list-city")) {
			ShipService shipservice = new ShipServiceImpl();
			String id = req.getParameter("id");
			int sid = Integer.parseInt(id);

			shipservice.delete(sid);
			resp.sendRedirect(req.getContextPath() + "/admin/list-city");
		}
	}
}
