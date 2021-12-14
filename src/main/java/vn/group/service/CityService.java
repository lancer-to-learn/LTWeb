package vn.group.service;

import java.util.List;

import vn.group.model.CityModel;

public interface CityService {
	List<CityModel> getAllCity();
	CityModel getCity(int id);
	CityModel getCity(String name);

}
