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
@WebServlet(urlPatterns = {"/product","/san-pham"})
public class ProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		//Nhận biến từ view
		String bId = req.getParameter("bid");
		String indexPage = req.getParameter("index");
		//Khởi tạo DAO
		//Tạo các biến
		BrandService brandService = new BrandServiceImpl(); //làm việc với Brand
		ProductService productService =  new ProductServiceImpl(); //Làm việc với Product
		List<BrandModel> prominentBrand = brandService.getProminentBrand(); //Lấy thương hiệu nổi bật
		List<BrandModel> allBrand = brandService.getAllBrand(); 
		List<ProductModel> newestProduct = productService.getTopProduct(); 
		List<ProductModel> sallestProduct = productService.getSellestProduct();
		
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		int bId1 = Integer.parseInt(bId);
		
		BrandModel brand = null;
		
		if ("0".equals(bId)) { // All product
			int count = productService.countProduct();
			// chia trang cho count
			int endPage = count / 4;
			if (count % 4 != 0) {
				endPage++;
			}
			List<ProductModel> list = productService.pagingProduct(index);
			req.setAttribute("endP", endPage);
			req.setAttribute("allProduct", list);
		} else {
			brand = brandService.getBrandById(bId1);//Lấy brand theo id
			int count = productService.countProductByBId(bId1);
			int endPage = count / 4;
			if (count %  4!= 0) {
				endPage++;
			}
			List<ProductModel> listPC = productService.pagingProductByBId(index, bId1);
			req.setAttribute("allProduct", listPC);
			req.setAttribute("endP", endPage);
		}
		//Truyền dữ liệu lên views
		req.setAttribute("brandProminent", prominentBrand);
		req.setAttribute("allBrand", allBrand);
		req.setAttribute("brand", brand);
		req.setAttribute("newestProduct", newestProduct);
		req.setAttribute("sallestProduct", sallestProduct);
		req.setAttribute("tagactive", bId);
		req.setAttribute("tag", index);
		RequestDispatcher rq = req.getRequestDispatcher("/views/web/product.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		super.doPost(req, resp);
	}

}
