package com.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pms.dao.UserDao;
import com.pms.domain.User;

public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userdao;

	public boolean getUser(String email, String password) {
		return userdao.getUser(email, password);
	}

	@Override
	public void insertData(User user) {
		userdao.insertData(user);
	}

	public String getUserIdByEmail(String email) {
		return userdao.getUserIdByEmail(email);

	}

	public String getUserNameByEmail(String email) {
		return userdao.getUserNameByEmail(email);
	}

	public List<User> getAllUser() {
		return userdao.getAllUser();
	}
}
