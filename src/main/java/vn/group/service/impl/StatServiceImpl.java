package vn.group.service.impl;

import java.util.List;

import vn.group.dao.StatDao;
import vn.group.dao.impl.StatDaoImpl;
import vn.group.model.StatModel;
import vn.group.service.StatService;

public class StatServiceImpl implements StatService{
	StatDao statdao = new StatDaoImpl();
	
	@Override
	public List<StatModel> getBrandStatById(int id) {
		// TODO Auto-generated method stub
		return statdao.getBrandStatById(id);
	}

	@Override
	public List<StatModel> getMonthYearStat(int id) {
		// TODO Auto-generated method stub
		return statdao.getMonthYearStat(id);
	}

	@Override
	public List<StatModel> modifyBrandStat(List<StatModel> stat) {
		// TODO Auto-generated method stub
		return statdao.modifyBrandStat(stat);
	}

	@Override
	public List<StatModel> modifYearStat(List<StatModel> stat) {
		// TODO Auto-generated method stub
		return statdao.modifYearStat(stat);
	}

	@Override
	public List<StatModel> getStatByYear(List<StatModel> stat, int year) {
		// TODO Auto-generated method stub
		return statdao.getStatByYear(stat, year);
	}
	
}
