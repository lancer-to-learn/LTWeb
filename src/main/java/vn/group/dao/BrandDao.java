package vn.group.dao;

import java.util.List;

import vn.group.model.BrandModel;

public interface BrandDao {
	List<BrandModel> getProminentBrand();
	List<BrandModel> getAllBrand();
	BrandModel getBrandById(int bId);
	BrandModel getBrandByName(String name);

	boolean insert(BrandModel bm);
	boolean delete(int id);
	boolean edit(BrandModel bm);
}
