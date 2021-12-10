package vn.group.service.impl;

import java.util.List;

import vn.group.dao.BrandDao;
import vn.group.dao.impl.BrandDaoImpl;
import vn.group.model.BrandModel;
import vn.group.service.BrandService;

public class BrandServiceImpl implements BrandService{
	BrandDao brand = new BrandDaoImpl();

	@Override
	public List<BrandModel> getProminentBrand() {
		// TODO Auto-generated method stub
		return brand.getProminentBrand();
	}

	@Override
	public List<BrandModel> getAllBrand() {
		// TODO Auto-generated method stub
		return brand.getAllBrand();
	}

	@Override
	public BrandModel getBrandById(int bId) {
		// TODO Auto-generated method stub
		return brand.getBrandById(bId);
	}
	
}
