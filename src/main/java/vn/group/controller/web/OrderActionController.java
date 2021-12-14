package vn.group.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.group.model.AccountModel;
import vn.group.model.ReceiptDetailModel;
import vn.group.service.ReceiptService;
import vn.group.service.impl.ReceiptServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/order-canceled", "/order-again" })
public class OrderActionController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		if (url.contains("order-canceled")) {
			HttpSession session = req.getSession();
			Object obj = session.getAttribute("acc");
			if (obj != null) {
				AccountModel acc = (AccountModel) obj;
				String id = req.getParameter("rid");
				ReceiptService re = new ReceiptServiceImpl();
				List<ReceiptDetailModel> listReceiptDetail = re.getReceiptByUser(acc.getId());
				for (ReceiptDetailModel item : listReceiptDetail) {
					if (item.getRdId() == Integer.parseInt(id)) {
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
	}

}
