package com.pms.dao;

import java.util.List;

import com.pms.domain.User;

public interface UserDao {

	public void insertData(User user);

	public boolean getUser(String email, String password);
	
	public String getUserIdByEmail(String email);
	
	public String getUserNameByEmail(String email);
	
	public List<User> getAllUser();
}
