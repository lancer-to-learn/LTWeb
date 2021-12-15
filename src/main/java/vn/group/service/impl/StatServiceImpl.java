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
	
}
