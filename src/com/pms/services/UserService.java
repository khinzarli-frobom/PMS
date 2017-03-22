package com.pms.services;

import java.util.List;

import com.pms.domain.User;

public interface UserService {
	
	public boolean getUser(String email, String password);

	public void insertData(User user);

	public String getUserIdByEmail(String email);
	
	public String getUserNameByEmail(String email);

	public List<User> getAllUser();
	
}
