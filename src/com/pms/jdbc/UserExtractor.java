package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pms.domain.User;

public class UserExtractor implements ResultSetExtractor<User> {

	@Override
	public User extractData(ResultSet result) throws SQLException, DataAccessException {

		User u = new User();
		u.setUserId(result.getInt(1));
		u.setUserName(result.getString(2));
		u.setUserEmail(result.getString(3));
		u.setUserPassword(result.getString(4));
		u.setUserPhoneno(result.getString(5));
		u.setUserGender(result.getString(6));
		u.setUserAddress(result.getString(7));
		return u;
	}

	/*
	 * @Override public User extractData(ResultSet resultSet) throws
	 * SQLException, DataAccessException {
	 * 
	 * User user = new User(int userId;String userName;String userEmail;String
	 * userPassword;String userPhoneno;String userGender;String userAddress)
	 * user.setUserId(resultSet.getInt(1));
	 * user.setUserName(resultSet.getString(2));
	 * user.setUserEmail(resultSet.getString(3));
	 * user.setUserPassword(resultSet.getString(4));
	 * user.setUserPhoneno(resultSet.getString(5));
	 * user.setUserGender(resultSet.getString(6));
	 * user.setUserAddress(resultSet.getString(7));
	 * 
	 * return user; }
	 */
}
