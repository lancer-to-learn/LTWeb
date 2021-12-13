package vn.group.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.group.connection.DBConnect;
import vn.group.dao.ReceiptDao;
import vn.group.model.ReceiptDetailModel;
import vn.group.model.ReceiptModel;
import vn.group.service.CityService;
import vn.group.service.ProductService;
import vn.group.service.UserService;
import vn.group.service.impl.CityServiceImpl;
import vn.group.service.impl.ProductServiceImpl;
import vn.group.service.impl.UserServiceImpl;
public class ReceiptDaoImpl implements ReceiptDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	UserService user = new UserServiceImpl();
	

	@Override
	public Boolean insert(ReceiptDetailModel receipt) {
		
		String sql = "insert into ReceiptDetail values (?, ?, ?, ?, ?, ?)";
		try {

			conn = new DBConnect().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, receipt.getReceipt().getrId());
			ps.setInt(2, receipt.getProduct().getpId());
			ps.setInt(3, receipt.getQuantity());
			ps.setFloat(4, receipt.getPrice());
			ps.setString(5, receipt.getStatus());
			ps.setInt(6, receipt.getCity().getId());

			rs = ps.executeQuery();

			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}

	@Override
	public ReceiptModel getReceipt() {
		String sql = "select top 1 * from Receipt order by (id) desc";
		try {

			conn = new DBConnect().getConnection();

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				return new ReceiptModel(rs.getInt(1), user.getUser(rs.getInt(2)), rs.getDate(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}

	@Override
	public ReceiptModel insertReceipt(ReceiptModel receipt) {
		ReceiptDaoImpl re = new ReceiptDaoImpl();
		String sql = "insert into Receipt(userId) values (?)";
		try {

			conn = new DBConnect().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, receipt.getUser().getId());

			rs = ps.executeQuery();

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return re.getReceipt();
	}


	@Override
	public List<ReceiptDetailModel> getReceiptByUser(int id) {
		ReceiptDaoImpl re = new ReceiptDaoImpl();
		ProductService pro = new ProductServiceImpl();
		CityService city = new CityServiceImpl();
		List<ReceiptDetailModel> list = new ArrayList<ReceiptDetailModel>();
		String sql = "select * from Receipt, ReceiptDetail where Receipt.id=ReceiptDetail.receiptId and Receipt.userId=?";
		
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();		
			while (rs.next()) {
				ReceiptDetailModel rec = new ReceiptDetailModel(rs.getInt(4), re.getReceiptById(rs.getInt(5)),
						pro.getProductById(rs.getInt(6)), rs.getInt(7), rs.getFloat(8), rs.getString(9), city.getCity(rs.getInt(10)));
				list.add(rec);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}



	@Override
	public List<ReceiptModel> getReceipt(int id) {
		List<ReceiptModel> list = new ArrayList<ReceiptModel>();
		String sql = "select * from Receipt where userId=?;";
		
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();		
			while (rs.next()) {
				ReceiptModel pro = new ReceiptModel(rs.getInt(1), user.getUser(rs.getInt(2)), rs.getDate(3));
				list.add(pro);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public ReceiptModel getReceiptById(int id) {
		String sql = "select * from Receipt where id=? ;";
		try {

			conn = new DBConnect().getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new ReceiptModel(rs.getInt(1), user.getUser(rs.getInt(2)), rs.getDate(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}



	

}
