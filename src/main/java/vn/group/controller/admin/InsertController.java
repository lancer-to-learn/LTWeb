package vn.group.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.taglibs.standard.lang.jstl.FloatingPointLiteral;

import vn.group.model.AccountModel;
import vn.group.model.BrandModel;
import vn.group.model.ProductDetailModel;
import vn.group.model.ProductModel;
import vn.group.model.ShipModel;
import vn.group.service.BrandService;
import vn.group.service.ProductService;
import vn.group.service.ShipService;
import vn.group.service.UserService;
import vn.group.service.impl.BrandServiceImpl;
import vn.group.service.impl.ProductServiceImpl;
import vn.group.service.impl.ShipServiceImpl;
import vn.group.service.impl.UserServiceImpl;
import vn.group.utils.Constant;

@WebServlet(urlPatterns = {"/admin/insert/list-brand","/admin/insert/list-city", "/admin/insert/list-product"})
public class InsertController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8553291888043305743L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("list-brand"))
		{
			BrandService brandservice = new BrandServiceImpl();
			BrandModel brand = new BrandModel();
			
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			servletFileUpload.setHeaderEncoding("UTF-8");	
			try {
				resp.setContentType("text/html");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");

				List<FileItem> items = servletFileUpload.parseRequest(req);
				//name, image
				for (FileItem item : items) {
					if (item.getFieldName().equals("brandname")) {
						brand.setbName(item.getString());
					} else if (item.getFieldName().equals("image")) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/brand/" + fileName);
						item.write(file);
						brand.setbImage("brand/" + fileName);
					}
				}
				brandservice.insret(brand);
				resp.sendRedirect(req.getContextPath() + "/admin/list-brand");	
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (url.contains("list-city"))
		{
			ShipModel ship = new ShipModel();
			ShipService shipservice = new ShipServiceImpl();
			try {
				resp.setContentType("text/html");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");
				
				ship.setsName(req.getParameter("cityname"));
				ship.setsPrice(Integer.parseInt(req.getParameter("shipprice")));
				ship.setsTime(Integer.parseInt(req.getParameter("shiptime")));
				
				shipservice.insert(ship);
				resp.sendRedirect(req.getContextPath() + "/admin/list-city");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if (url.contains("list-product"))
		{
			ProductService productservice = new ProductServiceImpl();
			ProductModel product = new ProductModel();
			ProductDetailModel detail = new ProductDetailModel();
			
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			servletFileUpload.setHeaderEncoding("UTF-8");	
			try {
				resp.setContentType("text/html");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");

				List<FileItem> items = servletFileUpload.parseRequest(req);
				//name, image
				for (FileItem item : items) {
					if (item.getFieldName().equals("name")) {
						product.setpName(item.getString());
					}
					else if (item.getFieldName().equals("price"))
					{
						product.setpPrice(Float.parseFloat(item.getString()));
					}
					else if(item.getFieldName().equals("brand"))
					{
						BrandService brandservice = new BrandServiceImpl();
						BrandModel brand = brandservice.getBrandByName(item.getString());
						
						product.setBrand(brand);
					}
					else if (item.getFieldName().equals("amount"))
					{
						product.setpAmount(Integer.parseInt(item.getString()));
					}
					else if (item.getFieldName().equals("image")) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/product/" + fileName);
						item.write(file);
						product.setpImage("product/" + fileName);
					}
					HttpSession session = req.getSession();
					Object user = session.getAttribute("acc");
					AccountModel account = new AccountModel();
					if (user != null)
						account = (AccountModel)user;
					product.setSeller(account);
				}
				productservice.insret(product);
				product = productservice.getLastestProduct();
				
				for (FileItem item : items) {
					if (item.getFieldName().equals("screen")) {
						detail.setScreen(item.getString());
					}
					else if (item.getFieldName().equals("os"))
					{
						detail.setOs(item.getString());
					}
					else if(item.getFieldName().equals("chip"))
					{
						detail.setChip(item.getString());
					}
					else if (item.getFieldName().equals("ram"))
					{
						detail.setRam(item.getString());
					}
					else if (item.getFieldName().equals("rom"))
					{
						detail.setRom(item.getString());
					}
					else if (item.getFieldName().equals("weight"))
					{
						detail.setWeight(Float.parseFloat(item.getString()));
					}
					else if (item.getFieldName().equals("description"))
					{
						detail.setDescription(item.getString("UTF-8"));
					}
					else if (item.getFieldName().equals("warranty"))
					{
						detail.setTimeWarranty(Integer.parseInt(item.getString()));;
					}
					detail.setProduct(product);
				}
				productservice.insertDetail(detail);
				resp.sendRedirect(req.getContextPath() + "/admin/list-product");	
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
