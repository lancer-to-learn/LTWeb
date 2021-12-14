package vn.group.model;

public class QuantityModel {
	private int allQuantity;
	private int soldQuantity;
	private int waitingQuantity;
	private int shippingQuantity;
	private int canceledQuantity;
	public int getAllQuantity() {
		return allQuantity;
	}
	public void setAllQuantity(int allQuantity) {
		this.allQuantity = allQuantity;
	}
	public int getSoldQuantity() {
		return soldQuantity;
	}
	public void setSoldQuantity(int soldQuantity) {
		this.soldQuantity = soldQuantity;
	}
	public int getWaitingQuantity() {
		return waitingQuantity;
	}
	public void setWaitingQuantity(int waitingQuantity) {
		this.waitingQuantity = waitingQuantity;
	}
	public int getShippingQuantity() {
		return shippingQuantity;
	}
	public void setShippingQuantity(int shippingQuantity) {
		this.shippingQuantity = shippingQuantity;
	}
	public int getCanceledQuantity() {
		return canceledQuantity;
	}
	public void setCanceledQuantity(int canceledQuantity) {
		this.canceledQuantity = canceledQuantity;
	}
	public QuantityModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
