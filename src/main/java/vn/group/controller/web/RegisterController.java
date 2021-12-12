package vn.group.controller.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import javax.servlet.http.Part;

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
			/*try {
			Path uploadPart = Paths.get(Constant.DIR);
			if (!Files.exists(uploadPart))
				Files.createDirectory(uploadPart);
			//Part part = req.getPart("image");
				
				userService.addUser(acc);
				resp.sendRedirect("login");
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		}
	}
}
