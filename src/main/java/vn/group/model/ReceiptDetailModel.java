package vn.group.model;


public class ReceiptDetailModel {
	private int rdId;
	private int rId;
	private int pId;
	private int quantity;
	private float price;
	public int getRdId() {
		return rdId;
	}
	public void setRdId(int rdId) {
		this.rdId = rdId;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public ReceiptDetailModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReceiptDetailModel(int rId, int pId, int quantity, float price) {
		super();
		this.rId = rId;
		this.pId = pId;
		this.quantity = quantity;
		this.price = price;
	}
	
	
}
