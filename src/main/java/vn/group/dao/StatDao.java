package vn.group.dao;

import java.util.List;

import vn.group.model.StatModel;

public interface StatDao {
	List<StatModel> getBrandStatById(int id);
	List<StatModel> getMonthYearStat(int id);
}
