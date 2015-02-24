package com.prokopiv.dao;

import java.util.List;

import com.prokopiv.bean.User;
import com.prokopiv.formvalidation.Pagination;

public interface UserDao {
	
	public boolean recoveryUser(String id);
	public boolean userExist(String login);

	public User getUserById(String id);
	public List<User> getUsersByLogin(String login);
	public List<User> getUsersByPhone(String phone);
	public List<User> getUsersByLastName(String lastName);
	public List<User> getUsers(Pagination pagination);
	
	public boolean insertUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(String id);
	
}
