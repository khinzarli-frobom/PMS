package com.pms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.pms.domain.User;
import com.pms.jdbc.UserRowMapper;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;

	@Override
	public boolean getUser(String email, String password) {

		List<User> userList = new ArrayList<User>();
		boolean flag = true;

		String sql = "Select * From user where useremail='" + email + "' and userpassword='" + password + "'";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		if (userList.isEmpty())
			flag = false;

		return flag;
	}

	@Override
	public void insertData(User user) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO user "
				+ "(username, useremail, userpassword,userphoneno,usergender,useraddress) VALUES (?,?,?,?,?,?)";

		template.update(sql, new Object[] { user.getUserName(), user.getUserEmail(), user.getUserPassword(),
				user.getUserPhoneNo(), user.getUserGender(), user.getUserAddress() });

	}

	public String getUserIdByEmail(String email) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		String sql = "select userid from user where useremail=?";
		String userid = template.queryForObject(sql, new Object[] { email }, String.class);
		return userid;
	}

	public String getUserNameByEmail(String email) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		String sql = "select username from user where useremail=?";
		String username = template.queryForObject(sql, new Object[] { email }, String.class);
		return username;
	}

	public List<User> getAllUser() {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		String sql = "select * from user";
		List<User> list = new ArrayList<User>();
		list = template.query(sql, new UserRowMapper());
		return list;
	}

}