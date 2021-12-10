package vn.group.dao;

import vn.group.model.AccountModel;

public interface UserDao {
	AccountModel getUser(String username, String password);
	void addUser(AccountModel acc);
	boolean checkUser(String username);
	String getRolebyId(String id);
}
