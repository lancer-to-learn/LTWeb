package vn.group.model;

public class StatModel {
	private String brandName;
	private Float total;
	private int month;
	private int year;
	public StatModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatModel(String brandName, Float total, int month, int year) {
		super();
		this.brandName = brandName;
		this.total = total;
		this.month = month;
		this.year = year;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
}
