package vn.group.controller.web;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.group.model.AccountModel;
import vn.group.service.UserService;
import vn.group.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/login", "/myaccount" })
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String url = req.getRequestURL().toString();
		if (url.contains("login")) {
			RequestDispatcher rq = req.getRequestDispatcher("/views/login/login.jsp");
			rq.forward(req, resp);
		}
		else
		{
			HttpSession session = req.getSession();
			Object obj = session.getAttribute("acc");
			if (obj != null) {
				AccountModel acc = (AccountModel) obj;
				String role = "Admin";
				if (acc.getRole()==2)
					role = "Seller";
				else
					role = "Customer";
				
				req.setAttribute("mess", req.getParameter("mess"));
				req.setAttribute("role", role);
				RequestDispatcher rq = req.getRequestDispatcher("/views/login/myaccount.jsp");
				rq.forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserService user = new UserServiceImpl();
		AccountModel account = user.getUser(username, password);
		if (account == null) {
			req.setAttribute("message", "Sai tài khoản hoặc mật khẩu");
			req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);
		} else {
			account.setUser(username);
			account.setPass(password);
			HttpSession session = req.getSession();
			session.setAttribute("acc", account);
			if (account.getRole() == 1) {
				resp.sendRedirect("admin");
			} else {
				// session.setMaxInactiveInterval(1000);
				resp.sendRedirect("home");
			}
		}
	}
}
