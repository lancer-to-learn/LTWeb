package vn.group.model;

public class ShipModel {
	private int sId;
	private String sName;
	private int sPrice;
	private int sTime;
	public ShipModel(int sId, String sName, int sPrice, int sTime) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sPrice = sPrice;
		this.sTime = sTime;
	}
	public ShipModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsPrice() {
		return sPrice;
	}
	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}
	public int getsTime() {
		return sTime;
	}
	public void setsTime(int sTime) {
		this.sTime = sTime;
	}
	@Override
	public String toString() {
		return "ShipModel [sId=" + sId + ", sName=" + sName + ", sPrice=" + sPrice + ", sTime=" + sTime + "]";
	}
	
	
}
