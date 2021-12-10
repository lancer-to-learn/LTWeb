package vn.group.model;

public class BrandModel {
	private int bId;
	private String bName;
	private String bImage;
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbImage() {
		return bImage;
	}
	public void setbImage(String bImage) {
		this.bImage = bImage;
	}
	public BrandModel(int bId, String bName, String bImage) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bImage = bImage;
	}
	public BrandModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
