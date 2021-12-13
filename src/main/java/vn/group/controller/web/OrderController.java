package vn.group.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.group.model.AccountModel;
import vn.group.model.ReceiptDetailModel;
import vn.group.model.ReceiptModel;
import vn.group.service.ReceiptService;
import vn.group.service.impl.ReceiptServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/order" })
public class OrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("acc");
		if (obj != null) {
			AccountModel acc = (AccountModel) obj;
			ReceiptService re = new ReceiptServiceImpl();
			List<ReceiptDetailModel> listReceiptDetail = re.getReceiptByUser(acc.getId());
			List<ReceiptModel> listReceipt = re.getReceipt(acc.getId());
			req.setAttribute("listDetail", listReceiptDetail);
			req.setAttribute("listAllReceipt", listReceipt);
			RequestDispatcher rq = req.getRequestDispatcher("/views/web/order.jsp");
			rq.forward(req, resp);
		}
	}

}
