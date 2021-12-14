package vn.group.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.group.connection.DBConnect;
import vn.group.dao.ShipDao;
import vn.group.model.BrandModel;
import vn.group.model.ShipModel;
import vn.group.service.BrandService;
import vn.group.service.UserService;
import vn.group.service.impl.BrandServiceImpl;
import vn.group.service.impl.UserServiceImpl;

public class ShipDaoImpl implements ShipDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	BrandService brandService = new BrandServiceImpl();
	UserService userService = new UserServiceImpl();
	
	@Override
	public boolean insert(ShipModel sm) {
		String sql = "INSERT INTO Laptop.dbo.Ship(cityName, shipPrice, timeWarranty) "
				+ "VALUES (?,?,?)";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sm.getsName());
			ps.setInt(2, sm.getsPrice());
			ps.setInt(3, sm.getsTime());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(ShipModel sm) {
		String sql = "UPDATE Laptop.dbo.Ship SET cityName = ?, shipPrice = ?, timeWarranty = ? WHERE id = ?";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sm.getsName());
			ps.setInt(2, sm.getsPrice());
			ps.setInt(3, sm.getsTime());
			ps.setInt(4, sm.getsId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM Laptop.dbo.Ship WHERE id = ?";

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
	public List<ShipModel> getAllShip() {
		List<ShipModel> list = new ArrayList<ShipModel>();
		String sql = "select * from Ship;";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
			while (rs.next()) {
				ShipModel brand = new ShipModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(brand);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public ShipModel getShipById(int id) {
		ShipModel brand = new ShipModel();
		String sql = "select * from Ship where id=?;";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();		
			while (rs.next()) {
				brand =  new ShipModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return brand;
	}

}
