package vn.group.service;

import java.util.List;

import vn.group.model.BrandModel;

public interface BrandService {
	List<BrandModel> getProminentBrand();
	List<BrandModel> getAllBrand();
	BrandModel getBrandById(int bId);
	BrandModel getBrandByName(String name);
	
	boolean insret(BrandModel bm);
	boolean delete(int id);
	boolean edit(BrandModel bm);
}
