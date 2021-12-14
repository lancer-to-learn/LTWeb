package vn.group.model;

public class TotalMoneyModel {
	private float allTotal;
	private float soldTotal;
	private float waitingTotal;
	private float shippingTotal;
	private float canceledTotal;
	public float getAllTotal() {
		return allTotal;
	}
	public void setAllTotal(float allTotal) {
		this.allTotal = allTotal;
	}
	public float getSoldTotal() {
		return soldTotal;
	}
	public void setSoldTotal(float soldTotal) {
		this.soldTotal = soldTotal;
	}
	public float getWaitingTotal() {
		return waitingTotal;
	}
	public void setWaitingTotal(float waitingTotal) {
		this.waitingTotal = waitingTotal;
	}
	public float getShippingTotal() {
		return shippingTotal;
	}
	public void setShippingTotal(float shippingTotal) {
		this.shippingTotal = shippingTotal;
	}
	public float getCanceledTotal() {
		return canceledTotal;
	}
	public void setCanceledTotal(float canceledTotal) {
		this.canceledTotal = canceledTotal;
	}
	public TotalMoneyModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
