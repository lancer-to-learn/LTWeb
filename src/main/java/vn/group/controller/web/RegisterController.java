package vn.group.controller.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.group.model.AccountModel;
import vn.group.service.UserService;
import vn.group.service.impl.UserServiceImpl;
//import vn.group.utils.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/signup", "/dang-ky" })
public class RegisterController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// Khởi tạo DAO
		RequestDispatcher rq = req.getRequestDispatcher("/views/login/signup.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountModel acc = new AccountModel();
		acc.setUser(req.getParameter("username"));
		acc.setPass(req.getParameter("password"));
		acc.setEmail(req.getParameter("email"));
		acc.setPhone(req.getParameter("phone"));
		acc.setRole(3);
		UserService userService = new UserServiceImpl();
		if (userService.checkUser(acc.getUser()) == true) {
			req.setAttribute("message", "Tài khoản đã được sử dụng");
			req.getRequestDispatcher("/views/login/signup.jsp").forward(req, resp);
		} else {
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			try {
				List<FileItem> items = servletFileUpload.parseRequest(req);
				for (FileItem item : items) {
					if (item.getFieldName().equals("image")) {
						if (item.getSize()>0) {
							String originalFileName = item.getName();
							int index = originalFileName.lastIndexOf(".");
							String ext = originalFileName.substring(index + 1);
							String fileName = System.currentTimeMillis() + "." + ext;
							// File file = new File(Constant.DIR + "/category/" + fileName);
							File file = new File("/static/img/" + fileName);
							item.write(file);
							acc.setImage("/static/img/" + fileName);
						} 
						else
							acc.setImage(null);
					}
				}
				userService.addUser(acc);
				resp.sendRedirect("login");
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
