package vn.group.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.group.model.BrandModel;
import vn.group.model.ProductModel;
import vn.group.service.BrandService;
import vn.group.service.ProductService;
import vn.group.service.impl.BrandServiceImpl;
import vn.group.service.impl.ProductServiceImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home","/trang-chu"})
public class HomeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//Cài đặt cấu hình
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		//Tạo các biến
		BrandService brandService = new BrandServiceImpl(); //làm việc với Brand
		ProductService productService =  new ProductServiceImpl(); //Làm việc với Product
		List<BrandModel> prominentBrand = brandService.getProminentBrand(); //Lấy thương hiệu nổi bật
		List<BrandModel> allBrand = brandService.getAllBrand(); 
		List<ProductModel> newestProduct = productService.getTopProduct(); 
		List<ProductModel> sallestProduct = productService.getSellestProduct();
		
		//testing
		//Truyền dữ liệu lên views
		req.setAttribute("brandProminent", prominentBrand);
		req.setAttribute("allBrand", allBrand);
		req.setAttribute("newestProduct", newestProduct);
		req.setAttribute("sallestProduct", sallestProduct);
		//Khởi tạo DAO
		RequestDispatcher rq = req.getRequestDispatcher("/views/home.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.doPost(req, resp);
	}
}

