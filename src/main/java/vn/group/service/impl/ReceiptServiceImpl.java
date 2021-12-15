package vn.group.service.impl;

import java.util.List;

import vn.group.dao.ReceiptDao;
import vn.group.dao.impl.ReceiptDaoImpl;
import vn.group.model.ReceiptDetailModel;
import vn.group.model.ReceiptModel;
import vn.group.service.ReceiptService;

public class ReceiptServiceImpl implements ReceiptService {
	ReceiptDao r = new ReceiptDaoImpl();
	@Override
	public Boolean insert(ReceiptDetailModel receipt) {
		// TODO Auto-generated method stub
		return r.insert(receipt);
	}

	@Override
	public ReceiptModel insertReceipt(ReceiptModel receipt) {
		// TODO Auto-generated method stub
		return r.insertReceipt(receipt);
	}

	@Override
	public ReceiptModel getReceiptById(int id) {
		// TODO Auto-generated method stub
		return r.getReceiptById(id);
	}

	@Override
	public List<ReceiptDetailModel> getReceiptByUser(int userId) {
		// TODO Auto-generated method stub
		return r.getReceiptByUser(userId);
	}

	@Override
	public List<ReceiptModel> getReceipt(int userId) {
		// TODO Auto-generated method stub
		return r.getReceipt(userId);
	}

	@Override
	public ReceiptModel getReceipt() {
		// TODO Auto-generated method stub
		return r.getReceipt();
	}

	@Override
	public int getQuantityReceipt(List<ReceiptDetailModel> listReceipt, String status) {
		// TODO Auto-generated method stub
		return r.getQuantityReceipt(listReceipt, status);
	}

	@Override
	public float getTotalMoney(List<ReceiptDetailModel> listReceipt, String status) {
		// TODO Auto-generated method stub
		return r.getTotalMoney(listReceipt, status);
	}

	@Override
	public Boolean editReceipt(ReceiptDetailModel receipt, String status) {
		// TODO Auto-generated method stub
		return r.editReceipt(receipt, status);
	}

	@Override
	public List<ReceiptDetailModel> getReceiptBySeller(int sellerId) {
		// TODO Auto-generated method stub
		return r.getReceiptBySeller(sellerId);
	}

	@Override
	public List<ReceiptDetailModel> getReceiptByAdmin() {
		// TODO Auto-generated method stub
		return r.getReceiptByAdmin();
	}

}
