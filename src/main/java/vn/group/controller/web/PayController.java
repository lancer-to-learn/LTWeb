package vn.group.controller.web;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.group.model.AccountModel;
import vn.group.model.BrandModel;
import vn.group.model.CityModel;
import vn.group.model.ReceiptDetailModel;
import vn.group.model.ReceiptModel;
import vn.group.service.BrandService;
import vn.group.service.CityService;
import vn.group.service.ReceiptService;
import vn.group.service.impl.BrandServiceImpl;
import vn.group.service.impl.CityServiceImpl;
import vn.group.service.impl.ReceiptServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/pay" })
public class PayController extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		BrandService brandService = new BrandServiceImpl();
		ReceiptService re = new ReceiptServiceImpl();
		CityService cityService = new CityServiceImpl();
		List<BrandModel> allBrand = brandService.getAllBrand();
		String city = req.getParameter("city");
		CityModel ship = cityService.getCity(city);

		req.setAttribute("allBrand", allBrand);
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		Object ob = httpSession.getAttribute("acc");
		if (ob != null) {
			AccountModel acc = (AccountModel) ob;
			ReceiptModel receipt = new ReceiptModel();
			receipt.setUser(acc);
			receipt = re.insertReceipt(receipt);
			Map<Integer, ReceiptDetailModel> map = (Map<Integer, ReceiptDetailModel>) obj;
			Collection<ReceiptDetailModel> items = map.values();
			for (ReceiptDetailModel item : items) {
				if (re != null) {
					item.setStatus("Waiting");
					item.setReceipt(receipt);
					item.setCity(ship);
					if (re.insert(item)) {
						httpSession.removeAttribute("cart_quantity");
						httpSession.removeAttribute("cart");
						resp.sendRedirect("order");
					}
				}

			}

		}
	}

}
