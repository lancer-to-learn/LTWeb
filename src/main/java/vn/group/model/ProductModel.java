package vn.group.model;

public class ProductModel {
	private int pId;
	private String pName;
	private float pPrice;
	private BrandModel brand;
	private String pImage;
	private AccountModel seller;
	private int pAmount;
	private int pAmountSelled;
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
	public BrandModel getBrand() {
		return brand;
	}
	public void setBrand(BrandModel brand) {
		this.brand = brand;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public AccountModel getSeller() {
		return seller;
	}
	public void setSeller(AccountModel seller) {
		this.seller = seller;
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
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductModel(int id, String pName, float pPrice, BrandModel brand, String pImage, AccountModel seller, int pAmount,
			int pAmountSelled) {
		super();
		this.pId = id;
		this.pName = pName;
		this.pPrice = pPrice;
		this.brand = brand;
		this.pImage = pImage;
		this.seller = seller;
		this.pAmount = pAmount;
		this.pAmountSelled = pAmountSelled;
	}
	
	

}
