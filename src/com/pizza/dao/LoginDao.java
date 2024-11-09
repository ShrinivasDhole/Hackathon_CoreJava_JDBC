package com.pizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pizza.entity.Pizza_Customers;
import com.pizza.utility.DBUtils;

public class LoginDao implements AutoCloseable {

	Connection connection;

	static Pizza_Customers pc;

	public LoginDao() throws SQLException {
		connection = DBUtils.getConnection();
	}

	public void signUp(String name, String password, String mobile, String address, String email) throws SQLException {
		String query = "INSERT INTO pizza_customers (Name , Password , Mobile , Address , Email) values ( ? , ? , ? , ? , ?)";

		try (PreparedStatement iCust = connection.prepareStatement(query)) {
			iCust.setString(1, name);
			iCust.setString(2, password);
			iCust.setString(3, mobile);
			iCust.setString(4, address);
			iCust.setString(5, email);

			int c = iCust.executeUpdate();
			if (c == 1) {
				System.out.println("---------------------------");
				System.out.println("Sign Up Successfull !");
				System.out.println("---------------------------");
			} else {
				System.out.println("---------------------------");
				System.out.println("Sign Up not Successfull !");
				System.out.println("---------------------------");
			}
		}
	}

	public Pizza_Customers signIn(String email, String password) throws SQLException {
		String query = "Select * from pizza_customers where email = ? and password = ?";

		try (PreparedStatement fCust = connection.prepareStatement(query)) {
			fCust.setString(1, email);
			fCust.setString(2, password);
			ResultSet rs = fCust.executeQuery();
			rs.next();
			pc = new Pizza_Customers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			if (pc != null) {
				System.out.println("----------------------------");
				System.out.println("Logged in successfully ...");
				System.out.println("----------------------------");
				return pc;
			} else {
				System.out.println("-------------------");
				System.out.println("Not Logged in ...");
				System.out.println("-------------------");
				return null;
			}
		}

	}
	
	public boolean signOut() {
		if(pc !=null) {
			pc = null;
			System.out.println("--------------");
			System.out.println("Signed Out !");
			System.out.println("--------------");
			return true;
		}
		return false;
	}

	@Override
	public void close() throws Exception {
		connection.close();

	}

}
