package vn.group.service;

import vn.group.model.AccountModel;

public interface UserService {
	AccountModel getUser(String username, String password);
	AccountModel getUser(int id);
	void addUser(AccountModel acc);
	boolean checkUser(String username);
	String getRolebyId(String id);
}
