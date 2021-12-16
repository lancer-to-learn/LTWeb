package vn.group.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.group.model.AccountModel;
import vn.group.model.ReceiptDetailModel;
import vn.group.service.ProductService;
import vn.group.service.ReceiptService;
import vn.group.service.impl.ProductServiceImpl;
import vn.group.service.impl.ReceiptServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/order-canceled", "/order-confirm", "/order-accept" })
public class OrderActionController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("acc");
		if (url.contains("order-canceled")) {
			
			if (obj != null) {
				AccountModel acc = (AccountModel) obj;
				String id = req.getParameter("rid");
				ReceiptService re = new ReceiptServiceImpl();
				List<ReceiptDetailModel> listReceiptDetail =  new ArrayList<ReceiptDetailModel>();
				if (acc.getRole()==1)
					listReceiptDetail = re.getReceiptByAdmin();
				else
					if (acc.getRole()==2)
						listReceiptDetail = re.getReceiptBySeller(acc.getId());
					else
						listReceiptDetail = re.getReceiptByUser(acc.getId());
				for (ReceiptDetailModel item : listReceiptDetail) {
					if (item.getRdId() == Integer.parseInt(id)) {
						System.out.println(item.getProduct().getpName());
						if (re.editReceipt(item, "Canceled")) {
							PrintWriter out = resp.getWriter();
							out.print("200");
						} else {
							PrintWriter out = resp.getWriter();
							out.print("404");
						}
					}
				}

			} else {
				PrintWriter out = resp.getWriter();
				out.print("404");
			}

		}
		else {
			if (url.contains("order-confirm")) {
				if (obj != null) {
					AccountModel acc = (AccountModel) obj;
					ProductService pro = new ProductServiceImpl();
					String id = req.getParameter("rid");
					ReceiptService re = new ReceiptServiceImpl();
					List<ReceiptDetailModel> listReceiptDetail = re.getReceiptByUser(acc.getId());
					for (ReceiptDetailModel item : listReceiptDetail) {
						if (item.getRdId() == Integer.parseInt(id)) {
							System.out.println(item.getProduct().getpName());
							if (re.editReceipt(item, "Sold")) {
								pro.sellProduct(item.getQuantity(), item.getProduct());
								PrintWriter out = resp.getWriter();
								out.print("200");
							} else {
								PrintWriter out = resp.getWriter();
								out.print("404");
							}
						}
					}

				} else {
					PrintWriter out = resp.getWriter();
					out.print("404");
				}
			}
			else {
				if (obj != null) {
					AccountModel acc = (AccountModel) obj;
					String id = req.getParameter("rid");
					ReceiptService re = new ReceiptServiceImpl();
					List<ReceiptDetailModel> listReceiptDetail =  new ArrayList<ReceiptDetailModel>();
					if (acc.getRole()==1)
						listReceiptDetail = re.getReceiptByAdmin();
					else
						if (acc.getRole()==2)
							listReceiptDetail = re.getReceiptBySeller(acc.getId());
						else
							listReceiptDetail = re.getReceiptByUser(acc.getId());
					for (ReceiptDetailModel item : listReceiptDetail) {
						if (item.getRdId() == Integer.parseInt(id)) {
							System.out.println(item.getProduct().getpName());
							if (re.editReceipt(item, "Shipping")) {
								PrintWriter out = resp.getWriter();
								out.print("200");
							} else {
								PrintWriter out = resp.getWriter();
								out.print("404");
							}
						}
					}

				} else {
					PrintWriter out = resp.getWriter();
					out.print("404");
				}
			}
		}
	}

}
