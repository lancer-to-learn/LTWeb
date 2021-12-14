package vn.group.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.group.connection.DBConnect;
import vn.group.dao.ProductDao;
import vn.group.model.ProductDetailModel;
import vn.group.model.ProductModel;
import vn.group.service.BrandService;
import vn.group.service.UserService;
import vn.group.service.impl.BrandServiceImpl;
import vn.group.service.impl.UserServiceImpl;

public class ProductDaoImpl implements ProductDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	BrandService brandService = new BrandServiceImpl();
	UserService userService = new UserServiceImpl();
	
	

	@Override
	//Lấy tất cả sản phẩm
	public List<ProductModel> getAllProduct() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product;";
		
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
			while (rs.next()) {
				ProductModel pro = new ProductModel(rs.getInt(1), rs.getString(2), rs.getFloat(3),
						brandService.getBrandById(rs.getInt(4)), rs.getString(5), userService.getUser(rs.getInt(6)), rs.getInt(7), rs.getInt(8));
				list.add(pro);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	//Lấy những sản phẩm mới nhất
	public List<ProductModel> getTopProduct() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select top 6 * from Product;";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
			while (rs.next()) {
				ProductModel pro = new ProductModel(rs.getInt(1), rs.getString(2), rs.getFloat(3),
						brandService.getBrandById(rs.getInt(4)), rs.getString(5), userService.getUser(rs.getInt(6)), rs.getInt(7), rs.getInt(8));
				list.add(pro);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	//Lấy những sản phẩm bán chạy nhất
	public List<ProductModel> getSellestProduct() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select top 6 * from Product order by amountSelled Desc;";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
			while (rs.next()) {
				ProductModel pro = new ProductModel(rs.getInt(1), rs.getString(2), rs.getFloat(3),
						brandService.getBrandById(rs.getInt(4)), rs.getString(5), userService.getUser(rs.getInt(6)), rs.getInt(7), rs.getInt(8));
				list.add(pro);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	//Phân trang tất cả sản phẩm
	@Override
	public List<ProductModel> pagingProduct(int index) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product order by id offset ? row fetch next 4 row only";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index-1)*3);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				ProductModel pro = new ProductModel(rs.getInt(1), rs.getString(2), rs.getFloat(3),
						brandService.getBrandById(rs.getInt(4)), rs.getString(5), userService.getUser(rs.getInt(6)), rs.getInt(7), rs.getInt(8));
				list.add(pro);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	//Phân trang sản phẩm theo brand
	@Override
	public List<ProductModel> pagingProductByBId(int index, int bId) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product where brand=? order by id offset ? row fetch next 4 row only";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bId);
			ps.setInt(2, (index-1)*3);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				ProductModel pro = new ProductModel(rs.getInt(1), rs.getString(2), rs.getFloat(3),
						brandService.getBrandById(rs.getInt(4)), rs.getString(5), userService.getUser(rs.getInt(6)), rs.getInt(7), rs.getInt(8));
				list.add(pro);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	//Đếm sản phẩm theo brand
	@Override
	public int countProductByBId(int bId) {
		String sql = "select count(id) from Product where brand=?";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bId);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	//Tìm kiếm sản phẩm
	@Override
	public List<ProductModel> searchProduct(String kw) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select * from Product where name like N'%?%'";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, kw);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				ProductModel pro = new ProductModel(rs.getInt(1), rs.getString(2), rs.getFloat(3),
						brandService.getBrandById(rs.getInt(4)), rs.getString(5), userService.getUser(rs.getInt(6)), rs.getInt(7), rs.getInt(8));
				list.add(pro);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public int countProduct() {
		String sql = "select count(id) from Product";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public ProductModel getProductById(int id) {
		
		String sql = "select * from Product where id=?";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				return new ProductModel(rs.getInt(1), rs.getString(2), rs.getFloat(3),
						brandService.getBrandById(rs.getInt(4)), rs.getString(5), userService.getUser(rs.getInt(6)), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {
			System.out.print("Eror:"+e);
		}
		return null;
	}

	@Override
	public ProductDetailModel getProductDetail(int id) {
		String sql = "select * from ProductDetail where productId = ?;";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ProductDaoImpl p = new ProductDaoImpl();
			ps.setInt(1, id);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào List
			while (rs.next()) {
				return new ProductDetailModel(rs.getInt(1), p.getProductById(id), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getFloat(8), 
						rs.getString(9), rs.getInt(10));
			}
		} catch (Exception e) {
			System.out.print("Eror:"+e);
		}
		return null;
	}
	
	public static void main(String[] args) {
		ProductDetailModel product = new ProductDetailModel();
		ProductDaoImpl n = new ProductDaoImpl();
		product = n.getProductDetail(1);
		System.out.println(product);
	}

	@Override
	public boolean insret(ProductModel bm) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Laptop.dbo.Product(name, price, brand, image, sellerId, amount, amountSelled) "
				+ "VALUES (?,?,?,?,?,?,?)";
		
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bm.getpName());
			ps.setFloat(2, bm.getpPrice());
			ps.setInt(3, bm.getBrand().getbId());
			ps.setString(4, bm.getpImage());
			ps.setInt(5, bm.getSeller().getId());
			ps.setInt(6, bm.getpAmount());
			ps.setInt(7, 0);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Laptop.dbo.Product WHERE id = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(ProductModel bm) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Laptop.dbo.Product SET name = ?, price = ?, "
				+ "brand = ?, image = ?, amount = ? WHERE id = ?";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bm.getpName());
			ps.setFloat(2, bm.getpPrice());
			ps.setInt(3, bm.getBrand().getbId());
			ps.setString(4, bm.getpImage());
			ps.setInt(5, bm.getpAmount());
			ps.setInt(6, bm.getpId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean insertDetail(ProductDetailModel dm) {
		String sql = "INSERT INTO Laptop.dbo.ProductDetail(productId, screen, os, chip, ram, rom, weight, description, timeWarranty) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dm.getProduct().getpId());
			ps.setString(2, dm.getScreen());
			ps.setString(3, dm.getOs());
			ps.setString(4, dm.getChip());
			ps.setString(5, dm.getRam());
			ps.setString(6, dm.getRom());
			ps.setFloat(7, dm.getWeight());
			ps.setString(8, dm.getDescription());
			ps.setInt(9, dm.getTimeWarranty());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteDetail(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Laptop.dbo.ProductDetail WHERE productId = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean editDetail(ProductDetailModel dm) {
		String sql = "UPDATE Laptop.dbo.ProductDetail SET screen = ?, os = ?, chip = ?, ram = ? "
				+ ",rom = ?, weight = ?, description = ?, timeWarranty = ? where id = ?";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dm.getScreen());
			ps.setString(2, dm.getOs());
			ps.setString(3, dm.getChip());
			ps.setString(4, dm.getRam());
			ps.setString(5, dm.getRom());
			ps.setFloat(6, dm.getWeight());
			ps.setString(7, dm.getDescription());
			ps.setInt(8, dm.getTimeWarranty());
			ps.setInt(9, dm.getPdId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ProductModel getLastestProduct() {
		String sql = "SELECT * FROM Laptop.dbo.Product WHERE id=(SELECT max(id) FROM Laptop.dbo.Product)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			
			BrandDaoImpl p = new BrandDaoImpl();
			UserDaoImpl u = new UserDaoImpl();
			rs = ps.executeQuery();
			while (rs.next()) {
				return new ProductModel(rs.getInt(1), rs.getString(2), rs.getFloat(3), p.getBrandById(rs.getInt(4)), rs.getString(5), u.getUser(rs.getInt(6)), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {
			System.out.print("Eror:"+e);
		}
		return null;
	}
	

}
