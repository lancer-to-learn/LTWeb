package vn.group.model;

import java.sql.Date;

public class ReceiptModel {
	private int rId;
	private AccountModel user;
	private Date date;
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public AccountModel getUser() {
		return user;
	}
	public void setUser(AccountModel user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public ReceiptModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReceiptModel(int id, AccountModel user, Date date, String status) {
		super();
		this.rId = id;
		this.user = user;
		this.date = date;
	}
	
	
	
	

}
