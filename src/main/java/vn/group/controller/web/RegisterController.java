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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.group.model.AccountModel;
import vn.group.service.UserService;
import vn.group.service.impl.UserServiceImpl;
import vn.group.utils.Constant;
//import vn.group.utils.Constant;

@MultipartConfig
@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/signup", "/dang-ky" })
public class RegisterController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Khởi tạo DAO
		RequestDispatcher rq = req.getRequestDispatcher("/views/login/signup.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserService user = new UserServiceImpl();
		AccountModel account = new AccountModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");

			List<FileItem> items = servletFileUpload.parseRequest(req);
			// name, image
			for (FileItem item : items) {
				if (item.getFieldName().equals("username")) {
					account.setUser(item.getString());
				} else if (item.getFieldName().equals("password")) {
					account.setPass(item.getString());
				} else if (item.getFieldName().equals("phone")) {

					account.setPhone(item.getString());
				} else if (item.getFieldName().equals("email")) {
					account.setEmail(item.getString());
				} else if (item.getFieldName().equals("image")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/avatar/" + fileName);
					item.write(file);
					account.setImage("avatar/" + fileName);
				}
			}
			account.setRole(3);
			if (user.checkUser(account.getUser()) == true) {
				req.setAttribute("message", "Username is used by other!!");
				req.getRequestDispatcher("/views/login/signup.jsp").forward(req, resp);
				return;
			} else {
				user.addUser(account);
				resp.sendRedirect(req.getContextPath()+"/login");
				return;
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("message", "Some error occured!!");
		req.getRequestDispatcher("/views/login/signup.jsp").forward(req, resp);
		return;
	}

}
