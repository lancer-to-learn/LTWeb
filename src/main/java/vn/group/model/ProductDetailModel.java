package vn.group.model;

public class ProductDetailModel {
	private int pdId;
	private ProductModel product;
	private String screen;
	private String os;
	private String chip;
	private String ram;
	private String rom;
	private float weight;
	private String description;
	private int timeWarranty;
	public int getPdId() {
		return pdId;
	}
	public void setPdId(int pdId) {
		this.pdId = pdId;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getChip() {
		return chip;
	}
	public void setChip(String chip) {
		this.chip = chip;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getRom() {
		return rom;
	}
	public void setRom(String rom) {
		this.rom = rom;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTimeWarranty() {
		return timeWarranty;
	}
	public void setTimeWarranty(int timeWarranty) {
		this.timeWarranty = timeWarranty;
	}
	public ProductDetailModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDetailModel(int id, ProductModel product, String screen, String os, String chip, String ram, String rom, float weight,
			String description, int timeWarranty) {
		super();
		this.pdId = id;
		this.product = product;
		this.screen = screen;
		this.os = os;
		this.chip = chip;
		this.ram = ram;
		this.rom = rom;
		this.weight = weight;
		this.description = description;
		this.timeWarranty = timeWarranty;
	}
	
	
	
}
