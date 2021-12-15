package vn.group.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.group.connection.DBConnect;
import vn.group.dao.StatDao;
import vn.group.model.StatModel;

public class StatDaoImpl implements StatDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<StatModel> getBrandStatById(int id) {
		List<StatModel> list = new ArrayList<StatModel>();
		
		String sql = "select bName, sum(E.total) as bTotal from " + 
				"(select D.name as bName, unitPrice*quantity as total, createDate " + 
				"from Laptop.dbo.ReceiptDetail as A inner join Laptop.dbo.Receipt as B on A.receiptId = B.id " + 
				"inner join Laptop.dbo.Product as C on C.id = A.productId " + 
				"inner join Laptop.dbo.Brand as D on D.id = C.brand " + 
				"where C.sellerId = ? ) as E group by bName";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();		
			while (rs.next()) {
				 StatModel stat = new StatModel(rs.getString(1), rs.getFloat(2), 0, 0);
				 list.add(stat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<StatModel> getMonthYearStat(int id) {
		List<StatModel> list = new ArrayList<StatModel>();
		
		String sql = "select YEAR(E.createDate) as cYear, Month(E.createDate) as cMonth, sum(E.total) as mTotal from " + 
				"(select D.name as bName, unitPrice*quantity as total, createDate " + 
				"from Laptop.dbo.ReceiptDetail as A inner join Laptop.dbo.Receipt as B on A.receiptId = B.id " + 
				"inner join Laptop.dbo.Product as C on C.id = A.productId " + 
				"inner join Laptop.dbo.Brand as D on D.id = C.brand " + 
				"where C.sellerId = ? ) as E group by MONTH(E.createDate), YEAR(E.createDate)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();		
			while (rs.next()) {
				 StatModel stat = new StatModel("", rs.getFloat(3), rs.getInt(2), rs.getInt(1));
				 list.add(stat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
