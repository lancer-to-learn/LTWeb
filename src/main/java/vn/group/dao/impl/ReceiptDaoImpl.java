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
			if (ps.execute())
				return true;
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

			ps.execute();
			
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
		String sql = "select * from Receipt, ReceiptDetail where Receipt.id=ReceiptDetail.receiptId and Receipt.userId=? order by (Receipt.createDate) desc";
		
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

	@Override
	public int getQuantityReceipt(List<ReceiptDetailModel> listReceipt, String status) {
		if (status.contains("All"))
			return listReceipt.size();
		else
		{
			int quantity = 0;
			for (ReceiptDetailModel item: listReceipt)
				if (item.getStatus().contains(status))
					quantity += 1;
			return quantity;
			
		}
	}

	@Override
	public float getTotalMoney(List<ReceiptDetailModel> listReceipt, String status) {
		if (status.contains("All")) {
			float total = 0;
			for (ReceiptDetailModel item: listReceipt)
				total += item.getPrice()*item.getQuantity();
			return total;
		}
		else
		{
			float total = 0;
			for (ReceiptDetailModel item: listReceipt)
				if (item.getStatus().contains(status))
					total += item.getPrice()*item.getQuantity();
			return total;
			
		}
	}

	@Override
	public Boolean editReceipt(ReceiptDetailModel receipt, String status) {
		String sql = "update ReceiptDetail set status=? where id=?";
		try {

			conn = new DBConnect().getConnection();

			ps = conn.prepareStatement(sql);
			
			ps.setString(1, status);
			ps.setInt(2, receipt.getRdId());

			return ps.execute();

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public List<ReceiptDetailModel> getReceiptBySeller(int sellerId) {
		ReceiptDaoImpl re = new ReceiptDaoImpl();
		ProductService pro = new ProductServiceImpl();
		CityService city = new CityServiceImpl();
		List<ReceiptDetailModel> list = new ArrayList<ReceiptDetailModel>();
		String sql = "select * from (select ReceiptDetail.id, receiptId, productId, quantity, unitPrice, status, city\r\n" + 
				"from ReceiptDetail, Product where ReceiptDetail.productId=Product.id and Product.sellerId=?) \r\n" + 
				"as Q inner join Receipt on Q.receiptId=Receipt.id order by (Receipt.createDate) desc;";
		
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sellerId);
			rs = ps.executeQuery();		
			while (rs.next()) {
				ReceiptDetailModel rec = new ReceiptDetailModel(rs.getInt(1), re.getReceiptById(rs.getInt(2)),
						pro.getProductById(rs.getInt(3)), rs.getInt(4), rs.getFloat(5), rs.getString(6), city.getCity(rs.getInt(7)));
				list.add(rec);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public List<ReceiptDetailModel> getReceiptByAdmin() {
		ReceiptDaoImpl re = new ReceiptDaoImpl();
		ProductService pro = new ProductServiceImpl();
		CityService city = new CityServiceImpl();
		List<ReceiptDetailModel> list = new ArrayList<ReceiptDetailModel>();
		String sql = "select * from (select ReceiptDetail.id, receiptId, productId, quantity, unitPrice, status, city\r\n" + 
				"from ReceiptDetail, Product, Account where ReceiptDetail.productId=Product.id and Product.sellerId=Account.id and Account.role=1) \r\n" + 
				"as Q inner join Receipt on Q.receiptId=Receipt.id order by (Receipt.createDate) desc;";
		
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();		
			while (rs.next()) {
				ReceiptDetailModel rec = new ReceiptDetailModel(rs.getInt(1), re.getReceiptById(rs.getInt(2)),
						pro.getProductById(rs.getInt(3)), rs.getInt(4), rs.getFloat(5), rs.getString(6), city.getCity(rs.getInt(7)));
				list.add(rec);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}



	

}
