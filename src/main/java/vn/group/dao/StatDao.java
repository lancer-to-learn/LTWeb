package vn.group.dao;

import java.util.List;

import vn.group.model.StatModel;

public interface StatDao {
	List<StatModel> getBrandStat();
	List<StatModel> getMonthYearStat();
}
