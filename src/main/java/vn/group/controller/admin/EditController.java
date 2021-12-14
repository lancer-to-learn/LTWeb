package vn.group.controller.admin;

import java.util.List;
import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jboss.classfilewriter.constpool.IntegerEntry;

import vn.group.controller.web.ProductDetailController;
import vn.group.dao.impl.BrandDaoImpl;
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

@WebServlet(urlPatterns = { "/admin/edit/list-brand", "/admin/edit/list-city","/admin/edit/list-product" })
public class EditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9126517763880270962L;
	BrandService brandservicce = new BrandServiceImpl();
	ShipService shipservice = new ShipServiceImpl();
	ProductService productservice = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("list-brand"))
		{
			String id = req.getParameter("id");
			BrandModel brand = brandservicce.getBrandById(Integer.parseInt(id));
			req.setAttribute("brand", brand);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/custombrand.jsp");
			dispatcher.forward(req, resp);
		}
		else if (url.contains("list-city"))
		{
			String id = req.getParameter("id");
			ShipModel ship = shipservice.getShipById(Integer.parseInt(id));
			req.setAttribute("ship", ship);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/customcity.jsp");
			dispatcher.forward(req, resp);
		}
		else if (url.contains("list-product"))
		{
			String id = req.getParameter("id");
			ProductModel product = productservice.getProductById(Integer.parseInt(id));
			ProductDetailModel detail = productservice.getProductDetail(Integer.parseInt(id));
			List<BrandModel> brands = brandservicce.getAllBrand();
			
			req.setAttribute("brands", brands);
			req.setAttribute("detail", detail);
			req.setAttribute("product", product);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/customproduct.jsp");
			dispatcher.forward(req, resp);
		}
	}

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
				
				for (FileItem item : items) {
					if (item.getFieldName().equals("brandid")) {
						brand.setbId(Integer.parseInt(item.getString()));
					}
					else if (item.getFieldName().equals("brandname"))
					{
						brand.setbName(item.getString("UTF-8"));
					}
					else if (item.getFieldName().equals("image")) {
						if (item.getSize() > 0) {
							String originalFileName = item.getName();
							int index = originalFileName.lastIndexOf(".");
							String ext = originalFileName.substring(index + 1);
							String fileName = System.currentTimeMillis() + "." + ext;
							File file = new File(Constant.DIR + "/brand/" + fileName);
							item.write(file);
							brand.setbImage("brand/" + fileName);
						} else {
							brand.setbImage(null);
						}
					}
				}
				brandservice.edit(brand);
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
			try {
				resp.setContentType("text/html");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");
				
				ship.setsId(Integer.parseInt(req.getParameter("cityid")));
				ship.setsName(req.getParameter("cityname"));
				ship.setsPrice(Integer.parseInt(req.getParameter("shipprice")));
				ship.setsTime(Integer.parseInt(req.getParameter("shiptime")));
				
				shipservice.edit(ship);
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
					if(item.getFieldName().equals("productid"))
					{
						product.setpId(Integer.parseInt(item.getString()));
					}
					else if (item.getFieldName().equals("name")) {
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
						if (item.getSize() > 0) {
							String originalFileName = item.getName();
							int index = originalFileName.lastIndexOf(".");
							String ext = originalFileName.substring(index + 1);
							String fileName = System.currentTimeMillis() + "." + ext;
							File file = new File(Constant.DIR + "/product/" + fileName);
							item.write(file);
							product.setpImage("product/" + fileName);
						} else {
							product.setpImage(null);
						}
					}
				}
				productservice.edit(product);
				
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
					else if (item.getFieldName().equals("detailid"))
					{
						detail.setPdId(Integer.parseInt(item.getString()));
					}
					detail.setProduct(product);
				}
				productservice.editDetail(detail);
				resp.sendRedirect(req.getContextPath() + "/admin/list-product");	
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
