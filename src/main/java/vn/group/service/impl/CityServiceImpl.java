package vn.group.service.impl;

import java.util.List;

import vn.group.dao.CityDao;
import vn.group.dao.impl.CityDaoImpl;
import vn.group.model.CityModel;
import vn.group.service.CityService;

public class CityServiceImpl implements CityService{
	
	CityDao city = new CityDaoImpl();

	@Override
	public List<CityModel> getAllCity() {
		// TODO Auto-generated method stub
		return city.getAllCity();
	}

	@Override
	public CityModel getCity(int id) {
		// TODO Auto-generated method stub
		return city.getCity(id);
	}

	@Override
	public CityModel getCity(String name) {
		// TODO Auto-generated method stub
		return city.getCity(name);
	}

}
