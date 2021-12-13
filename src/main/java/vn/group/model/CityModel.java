package vn.group.model;

public class CityModel {
	private int id;
	private String name;
	private int price;
	private int time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public CityModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CityModel(int id, String name, int price, int time) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.time = time;
	}
	
	

}
