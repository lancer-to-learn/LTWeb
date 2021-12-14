package vn.group.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.group.connection.DBConnect;
import vn.group.dao.BrandDao;
import vn.group.model.BrandModel;

public class BrandDaoImpl implements BrandDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<BrandModel> getProminentBrand() {
		/**
		 * Lấy những thương hiệu nổi bật
		 */
		List<BrandModel> list = new ArrayList<BrandModel>();
		//Lấy 4 thương hiệu nổi bật nhất dựa trên số sản phẩm của thương hiệu đó
		String sql = "select id, name, image from Brand inner join (select top 4 brand, "
				+ "count(Amount) as SL from Product group by brand)\r\n" + 
				"as Q on Q.brand=Brand.id";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
			while (rs.next()) {
				BrandModel brand = new BrandModel(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(brand);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public List<BrandModel> getAllBrand() {
		List<BrandModel> list = new ArrayList<BrandModel>();
		String sql = "select * from Brand;";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
			while (rs.next()) {
				BrandModel brand = new BrandModel(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(brand);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public BrandModel getBrandById(int bId) {
		BrandModel brand = new BrandModel();
		String sql = "select * from Brand where id=?;";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bId);
			rs = ps.executeQuery();		
			while (rs.next()) {
				brand =  new BrandModel(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return brand;
	}

	@Override
	public boolean insert(BrandModel bm) {
		String sql = "INSERT INTO Laptop.dbo.Brand(name, image) "
				+ "VALUES (?,?)";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bm.getbName());
			ps.setString(2, bm.getbImage());
			
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM Laptop.dbo.Brand WHERE id = ?";

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
	public boolean edit(BrandModel bm) {
		String sql = "UPDATE Laptop.dbo.Brand SET name = ?, image = ? WHERE id = ?";
		try {
//			System.out.println(bm.getbId());
//			System.out.println(bm.getbName());
//			System.out.println(bm.getbImage());
			
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bm.getbName());
			ps.setString(2, bm.getbImage());
			ps.setInt(3, bm.getbId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public BrandModel getBrandByName(String name) {
		BrandModel brand = new BrandModel();
		String sql = "select top 1 * from Brand where name = ?;";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();		
			while (rs.next()) {
				brand =  new BrandModel(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return brand;
	}

}
