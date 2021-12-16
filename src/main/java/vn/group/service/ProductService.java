package vn.group.service;

import java.util.List;


import vn.group.model.ProductDetailModel;
import vn.group.model.ProductModel;

public interface ProductService {
	List<ProductModel> getAllProduct();
	List<ProductModel> getTopProduct();
	List<ProductModel> getSellestProduct();
	List<ProductModel> pagingProduct(int index);
	List<ProductModel> pagingProductByBId(int index, int bId);
	int countProductByBId(int bId);
	int countProduct();
	List<ProductModel> searchProduct(String kw);
	ProductModel getProductById(int id);
	ProductDetailModel getProductDetail(int id);
	
	ProductModel getLastestProduct();
	boolean insret(ProductModel bm);
	boolean delete(int id);
	boolean edit(ProductModel bm);
	
	boolean insertDetail(ProductDetailModel dm);
	boolean deleteDetail(int id);
	boolean editDetail(ProductDetailModel dm);
	boolean sellProduct(int quantity, ProductModel pro);
	
}
