package vn.group.service;

import java.util.List;

import vn.group.model.StatModel;

public interface StatService {
	List<StatModel> getBrandStat();
	List<StatModel> getMonthYearStat();
	
}
