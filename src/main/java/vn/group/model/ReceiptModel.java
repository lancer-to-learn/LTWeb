package vn.group.model;

import java.sql.Date;

public class ReceiptModel {
	private int rId;
	private int uId;
	private Date date;
	private String status;
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ReceiptModel(int uId, Date date, String status) {
		super();
		this.uId = uId;
		this.date = date;
		this.status = status;
	}
	public ReceiptModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
