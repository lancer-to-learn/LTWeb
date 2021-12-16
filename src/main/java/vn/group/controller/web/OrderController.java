package vn.group.controller.web;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.group.model.AccountModel;
import vn.group.model.ProductModel;
import vn.group.model.QuantityModel;
import vn.group.model.ReceiptDetailModel;
import vn.group.model.ReceiptModel;
import vn.group.model.TotalMoneyModel;
import vn.group.service.ProductService;
import vn.group.service.ReceiptService;
import vn.group.service.impl.ProductServiceImpl;
import vn.group.service.impl.ReceiptServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/order", "/admin/order" })
public class OrderController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		String url = req.getRequestURL().toString();

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("acc");
		if (obj != null) {
			AccountModel acc = (AccountModel) obj;
			ReceiptService re = new ReceiptServiceImpl();

			QuantityModel quantity = new QuantityModel();
			TotalMoneyModel total = new TotalMoneyModel();
			if (url.contains("admin")) {
				List<ReceiptDetailModel> listReceiptDetail = new ArrayList<ReceiptDetailModel>();
				if (acc.getRole()==1) {
					listReceiptDetail = re.getReceiptByAdmin();
				}
				else {
					listReceiptDetail = re.getReceiptBySeller(acc.getId());
				}
				quantity.setAllQuantity(re.getQuantityReceipt(listReceiptDetail, "All"));
				quantity.setSoldQuantity(re.getQuantityReceipt(listReceiptDetail, "Sold"));
				quantity.setWaitingQuantity(re.getQuantityReceipt(listReceiptDetail, "Waiting"));
				quantity.setShippingQuantity(re.getQuantityReceipt(listReceiptDetail, "Shipping"));
				quantity.setCanceledQuantity(re.getQuantityReceipt(listReceiptDetail, "Canceled"));

				total.setAllTotal(re.getTotalMoney(listReceiptDetail, "All"));
				total.setSoldTotal(re.getTotalMoney(listReceiptDetail, "Sold"));
				total.setWaitingTotal(re.getTotalMoney(listReceiptDetail, "Waiting"));
				total.setShippingTotal(re.getTotalMoney(listReceiptDetail, "Shipping"));
				total.setCanceledTotal(re.getTotalMoney(listReceiptDetail, "Canceled"));
				for (ReceiptDetailModel item: listReceiptDetail) {
					long millis=System.currentTimeMillis();  
					java.sql.Date date=new java.sql.Date(millis);  
					Duration diff = Duration.between(item.getReceipt().getDate().toLocalDate().atStartOfDay(), 
							date.toLocalDate().atStartOfDay());
					if (item.getStatus().equals("Shipping") && diff.toDays() >= item.getCity().getTime()) {
						item.setStatus("Confirm");
					}
				}
				
				req.setAttribute("listDetail", listReceiptDetail);
				req.setAttribute("quantity", quantity);
				req.setAttribute("total", total);

				RequestDispatcher rq = req.getRequestDispatcher("/views/admin/order.jsp");
				rq.forward(req, resp);
			} else {
				
					List<ReceiptDetailModel> listReceiptDetail = re.getReceiptByUser(acc.getId());
					List<ReceiptModel> listReceipt = re.getReceipt(acc.getId());

					quantity.setAllQuantity(re.getQuantityReceipt(listReceiptDetail, "All"));
					quantity.setSoldQuantity(re.getQuantityReceipt(listReceiptDetail, "Sold"));
					quantity.setWaitingQuantity(re.getQuantityReceipt(listReceiptDetail, "Waiting"));
					quantity.setShippingQuantity(re.getQuantityReceipt(listReceiptDetail, "Shipping"));
					quantity.setCanceledQuantity(re.getQuantityReceipt(listReceiptDetail, "Canceled"));

					total.setAllTotal(re.getTotalMoney(listReceiptDetail, "All"));
					total.setSoldTotal(re.getTotalMoney(listReceiptDetail, "Sold"));
					total.setWaitingTotal(re.getTotalMoney(listReceiptDetail, "Waiting"));
					total.setShippingTotal(re.getTotalMoney(listReceiptDetail, "Shipping"));
					total.setCanceledTotal(re.getTotalMoney(listReceiptDetail, "Canceled"));
					
					for (ReceiptDetailModel item: listReceiptDetail) {
						long millis=System.currentTimeMillis();  
						java.sql.Date date=new java.sql.Date(millis);  
						Duration diff = Duration.between(item.getReceipt().getDate().toLocalDate().atStartOfDay(), 
								date.toLocalDate().atStartOfDay());
						if (item.getStatus().equals("Shipping") && diff.toDays() >= item.getCity().getTime()) {
							item.setStatus("Confirm");
						}
					}
					
					ProductService productService =  new ProductServiceImpl(); 
					
					List<ProductModel> list = productService.getSellestProduct();

					req.setAttribute("listDetail", listReceiptDetail);
					req.setAttribute("listAllReceipt", listReceipt);
					req.setAttribute("quantity", quantity);
					req.setAttribute("total", total);
					req.setAttribute("list", list );

					RequestDispatcher rq = req.getRequestDispatcher("/views/web/order.jsp");
					rq.forward(req, resp);
				}
			}
		}
	}


