package vn.group.model;

public class ProductImageModel {
	private int id;
	private int pId;
	private String image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public ProductImageModel(int pId, String image) {
		super();
		this.pId = pId;
		this.image = image;
	}
	public ProductImageModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
