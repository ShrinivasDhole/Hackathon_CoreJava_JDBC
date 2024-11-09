package com.pizza.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	static final String URL = "jdbc:mysql://localhost:3306/Pizza";
	static final String USER = "root";
	static final String PASS = "manager";
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL , USER , PASS);
	}

}
