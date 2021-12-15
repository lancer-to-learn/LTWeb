package vn.group.service;

import java.util.List;

import vn.group.model.StatModel;

public interface StatService {
	List<StatModel> getBrandStatById(int id);
	List<StatModel> getMonthYearStat(int id);
	
	List<StatModel> modifyBrandStat();
	List<StatModel> modifYearStat();
	
	List<StatModel> getStatByYear(List<StatModel> stat, int year);
}
