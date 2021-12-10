package vn.group.model;

public class ProductModel {
	private int pId;
	private String pName;
	private float pPrice;
	private int pBrand;
	private String pImage;
	private int pSeller;
	private int pAmount;
	private int pAmountSelled;
	
	
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public float getpPrice() {
		return pPrice;
	}
	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}
	public int getpBrand() {
		return pBrand;
	}
	public ProductModel(int pId, String pName, float pPrice, int pBrand, String pImage, int pSeller, int pAmount,
			int pAmountSelled) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pBrand = pBrand;
		this.pImage = pImage;
		this.pSeller = pSeller;
		this.pAmount = pAmount;
		this.pAmountSelled = pAmountSelled;
	}
	public void setpBrand(int pBrand) {
		this.pBrand = pBrand;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public int getpSeller() {
		return pSeller;
	}
	public void setpSeller(int pSeller) {
		this.pSeller = pSeller;
	}
	public int getpAmount() {
		return pAmount;
	}
	public void setpAmount(int pAmount) {
		this.pAmount = pAmount;
	}
	public int getpAmountSelled() {
		return pAmountSelled;
	}
	public void setpAmountSelled(int pAmountSelled) {
		this.pAmountSelled = pAmountSelled;
	}

}
