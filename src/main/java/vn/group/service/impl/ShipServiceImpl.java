package vn.group.service.impl;

import java.util.List;

import vn.group.dao.ShipDao;
import vn.group.dao.impl.ShipDaoImpl;
import vn.group.model.ShipModel;
import vn.group.service.ShipService;

public class ShipServiceImpl implements ShipService {
	ShipDao ship = new ShipDaoImpl();
	
	@Override
	public boolean insert(ShipModel sm) {
		// TODO Auto-generated method stub
		return ship.insert(sm);
	}

	@Override
	public boolean edit(ShipModel sm) {
		// TODO Auto-generated method stub
		return ship.edit(sm);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return ship.delete(id);
	}

	@Override
	public List<ShipModel> getAllShip() {
		// TODO Auto-generated method stub
		return ship.getAllShip();
	}

	@Override
	public ShipModel getShipById(int id) {
		// TODO Auto-generated method stub
		return ship.getShipById(id);
	}

}
