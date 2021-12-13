package vn.group.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.group.connection.DBConnect;
import vn.group.dao.CityDao;
import vn.group.model.CityModel;

public class CityDaoImpl implements CityDao{
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<CityModel> getAllCity() {
		List<CityModel> list = new ArrayList<CityModel>();
		String sql = "select * from Ship";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
			while (rs.next()) {
				CityModel brand = new CityModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(brand);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public CityModel getCity(int id) {
		String sql = "select * from Ship where id=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();		
			while (rs.next()) {
				return new CityModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public CityModel getCity(String name) {
		String sql = "select * from Ship where cityName=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();		
			while (rs.next()) {
				return new CityModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
