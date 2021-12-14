package vn.group.dao;

import java.util.List;

import vn.group.model.CityModel;

public interface CityDao {
	List<CityModel> getAllCity();
	CityModel getCity(int id);
	CityModel getCity(String name);
}
