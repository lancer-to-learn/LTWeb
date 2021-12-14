package vn.group.service.impl;

import vn.group.dao.UserDao;
import vn.group.dao.impl.UserDaoImpl;
import vn.group.model.AccountModel;
import vn.group.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao user = new UserDaoImpl();
	@Override
	public AccountModel getUser(String username, String password) {
		// TODO Auto-generated method stub
		return user.getUser(username, password);
	}
	@Override
	public void addUser(AccountModel acc) {
		// TODO Auto-generated method stub
		user.addUser(acc);
	}
	@Override
	public boolean checkUser(String username) {
		// TODO Auto-generated method stub
		return user.checkUser(username);
	}
	@Override
	public String getRolebyId(String id) {
		// TODO Auto-generated method stub
		return user.getRolebyId(id);
	}
	@Override
	public AccountModel getUser(int id) {
		// TODO Auto-generated method stub
		return user.getUser(id);
	}
	@Override
	public void editUser(AccountModel acc) {
		// TODO Auto-generated method stub
		user.editUser(acc);
		
	}
	@Override
	public void changToSeller(AccountModel acc) {
		user.changToSeller(acc);
		
	}
	@Override
	public void editImage(AccountModel acc) {
		user.editImage(acc);
		
	}
	@Override
	public void changPassword(AccountModel acc) {
		// TODO Auto-generated method stub
		user.changPassword(acc);
	}

}
