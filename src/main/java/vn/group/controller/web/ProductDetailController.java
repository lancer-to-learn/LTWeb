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
import vn.group.model.ProductDetailModel;
import vn.group.model.ProductModel;
import vn.group.service.BrandService;
import vn.group.service.ProductService;
import vn.group.service.impl.BrandServiceImpl;
import vn.group.service.impl.ProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/productdetail"})
public class ProductDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				resp.setContentType("text/html");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");
				String pId = req.getParameter("pid");
				int id = Integer.parseInt(pId);
				
				//Tạo các biến
				BrandService brandService = new BrandServiceImpl(); //làm việc với Brand
				ProductService productService =  new ProductServiceImpl(); //Làm việc với Product
				ProductModel product = productService.getProductById(id);
				ProductDetailModel productDetail = productService.getProductDetail(id);
				List<BrandModel> allBrand = brandService.getAllBrand(); 
				List<ProductModel> list = productService.getSellestProduct();
				
				
				//Truyền dữ liệu lên views
				req.setAttribute("allBrand", allBrand);
				req.setAttribute("product", product);
				req.setAttribute("productdetail", productDetail );
				req.setAttribute("list", list );

				//Khởi tạo DAO
				RequestDispatcher rq = req.getRequestDispatcher("/views/web/productdetail.jsp");
				rq.forward(req, resp);
	}

}
