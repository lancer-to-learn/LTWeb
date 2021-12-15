package vn.group.controller.web;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.group.model.AccountModel;
import vn.group.service.UserService;
import vn.group.service.impl.UserServiceImpl;
import vn.group.utils.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/user-edit", "/user-image", "/user-to-seller", "/user-change-password" })
public class AccountController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("acc");
		AccountModel acc = (AccountModel) obj;
		UserService userService = new UserServiceImpl();
		if (url.contains("user-to-seller")) {
			try {
				userService.changToSeller(acc);
				acc.setRole(2);
				resp.sendRedirect("myaccount?mess=You are seller now!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}
	
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
				resp.sendRedirect("myaccount?mess=Your information is unchanged!!! Some error is occured!");
			}
		} else {
			if (url.contains("user-change-password")) {
				try {
					String old = req.getParameter("current");
					String new_pass = req.getParameter("new");
					String renew = req.getParameter("renew");
					if (old.equals(acc.getPass())) {
						if (new_pass.equals(renew)) {
							acc.setPass(renew);
							userService.changPassword(acc);
							resp.sendRedirect("myaccount?mess=Your password is changed!!!");
						} else {
							resp.sendRedirect(
									"myaccount?mess=Your password is unchanged!!! Your re-type password is not correct#tab_1_3");
						}
					}
					else {
						resp.sendRedirect(
								"myaccount?mess=Your password is unchanged!!! Your old password is not correct");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				
					DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
					ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
					servletFileUpload.setHeaderEncoding("UTF-8");	
					try {
						List<FileItem> items = servletFileUpload.parseRequest(req);
						for (FileItem item : items) {
							if (item.getFieldName().equals("image")) {
								String originalFileName = item.getName();
								int index = originalFileName.lastIndexOf(".");
								String ext = originalFileName.substring(index + 1);
								String fileName = System.currentTimeMillis() + "." + ext;
								File file = new File(Constant.DIR + "/avatar/" + fileName);
								item.write(file);
								acc.setImage("avatar/" + fileName);
							}
						}
						userService.changeAvatar(acc);
						resp.sendRedirect("myaccount?mess=Your information is changed!!!");
					} catch (FileUploadException e) {
							e.printStackTrace();
							resp.sendRedirect("myaccount?mess=Your information is unchanged!!! Some error is occured!");
						} catch (Exception e) {
							e.printStackTrace();
							resp.sendRedirect("myaccount?mess=Your information is unchanged!!! Some error is occured!");
						}
					}

				}

			}
		}



