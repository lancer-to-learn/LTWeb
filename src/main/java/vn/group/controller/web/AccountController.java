package vn.group.controller.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import vn.group.model.AccountModel;
import vn.group.service.UserService;
import vn.group.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user-edit", "/user-edit-image", "/user-to-seller", "/user-change-password" })
public class AccountController extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("acc");
		AccountModel acc = (AccountModel) obj;
		UserService userService = new UserServiceImpl();
		if (url.contains("user-edit")) {

			try {
				AccountModel user = new AccountModel();
				BeanUtils.populate(user, req.getParameterMap());
				acc.setEmail(user.getEmail());
				acc.setPhone(user.getPhone());
				userService.editUser(acc);
				resp.sendRedirect("myaccount?mess=Your information is changed!!!");
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp.sendRedirect("myaccount?mess1=Your information is unchanged!!! Some error is occured!");
			}
		} else {
			if (url.contains("user-change-password")) {
				try {
					String old = req.getParameter("current");
					String new_pass = req.getParameter("new");
					String renew = req.getParameter("renew");
					if (old.equals(acc.getPass())) {
						if (new_pass.equals(renew)) {
							acc.setPass(old);
							userService.changPassword(acc);
							resp.sendRedirect("myaccount?mess4=Your password is changed!!!");
						} else {
							resp.sendRedirect(
									"myaccount?mess5=Your password is unchanged!!! Your re-type password is not correct#tab_1_3");
						}
					}
					else {
						resp.sendRedirect(
								"myaccount?mess6=Your password is unchanged!!! Your old password is not correct");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				if (url.contains("user-to-seller")) {
					try {
						userService.changToSeller(acc);
						resp.sendRedirect("myaccount");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {

				}

			}
		}
	}

}
