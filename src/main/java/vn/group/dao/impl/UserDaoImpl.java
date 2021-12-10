package vn.group.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.group.connection.DBConnect;
import vn.group.dao.UserDao;
import vn.group.model.AccountModel;

public class UserDaoImpl implements UserDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public AccountModel getUser(String username, String password) {
		String sql = "select * from Account where username=? and password=?";
		AccountModel acc = null;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				acc = new AccountModel(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
			}
			return acc;
		} catch (Exception e) {
			System.out.println(e);
		}
		return acc;
	}
	@Override
	public void addUser(AccountModel acc) {
		String sql = "INSERT INTO Account(username, password, role) VALUES (?,?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, acc.getUser());
			ps.setString(2, acc.getPass());
			ps.setString(3, acc.getPhone());
			ps.setString(4, acc.getEmail());
			ps.setInt(5, acc.getRole());
			ps.setString(4, acc.getImage());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean checkUser(String username) {
		String sql = "select username from Account where username=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			String check = null;
			while (rs.next()) {
				check = rs.getString(1);
			}
			if (check!=null)
				return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	@Override
	public String getRolebyId(String id) {
		String sql = "select name from Role where id=?";
		String role = null;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				role = rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return role;
	}

}
