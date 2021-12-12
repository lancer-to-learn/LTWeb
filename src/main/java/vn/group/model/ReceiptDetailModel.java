package vn.group.model;


public class ReceiptDetailModel {
	private int rdId;
	private ReceiptModel receipt;
	private ProductModel product;
	private int quantity;
	private float price;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRdId() {
		return rdId;
	}
	public void setRdId(int rdId) {
		this.rdId = rdId;
	}
	public ReceiptModel getReceipt() {
		return receipt;
	}
	public void setReceipt(ReceiptModel receipt) {
		this.receipt = receipt;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
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
	public ReceiptDetailModel(int id, ReceiptModel receipt, ProductModel product, int quantity, float price, String status) {
		super();
		this.rdId = id;
		this.receipt = receipt;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}
	
	
	
}
