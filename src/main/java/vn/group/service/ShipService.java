package vn.group.service;

import java.util.List;

import vn.group.model.ShipModel;

public interface ShipService {
	boolean insert(ShipModel sm);
	boolean edit(ShipModel sm);
	boolean delete(int id);
	
	List<ShipModel> getAllShip();
	ShipModel getShipById(int id);
}
