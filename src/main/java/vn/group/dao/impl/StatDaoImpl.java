package vn.group.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.group.connection.DBConnect;
import vn.group.dao.StatDao;
import vn.group.model.BrandModel;
import vn.group.model.ProductModel;
import vn.group.model.StatModel;
import vn.group.service.BrandService;
import vn.group.service.impl.BrandServiceImpl;

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

	@Override
	public List<StatModel> modifyBrandStat(List<StatModel> stat) {
		BrandService brandservice = new BrandServiceImpl();
		List<BrandModel> allbrand = brandservice.getAllBrand();
		List<StatModel> pros = new ArrayList<StatModel>();
		
		for (int i = 0; i < allbrand.size(); i++) 
		{
			BrandModel bm = allbrand.get(i);
			int flag = 0;
			for (int j=0;j< stat.size(); j++)
			{
				StatModel sm = stat.get(j);
				if (bm.getbName().trim().equals(sm.getBrandName().trim())) {
					flag = 1;
					pros.add(sm);
				}
			}
			if (flag == 0) {
				pros.add(new StatModel(bm.getbName(), (float) 0, 0, 0));
			}
		}
		return pros;
	}

	@Override
	public List<StatModel> modifYearStat(List<StatModel> stat) {
		List<StatModel> pros = new ArrayList<StatModel>();
		StatModel sm = new StatModel();
		for (int i = 1; i < 13; i++) 
		{
			int flag = 0;
			for (int j=0;j< stat.size(); j++)
			{
				sm = stat.get(j);
				if (i == sm.getMonth()) {
					flag = 1;
					pros.add(sm);
				}
			}
			if (flag == 0) {
				pros.add(new StatModel("", (float) 0, i, sm.getYear()));
			}
		}
		return pros;
	}

	@Override
	public List<StatModel> getStatByYear(List<StatModel> stat, int year) {
		// TODO Auto-generated method stub
		return null;
	}
}
