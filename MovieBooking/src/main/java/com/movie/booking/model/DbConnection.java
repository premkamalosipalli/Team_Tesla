package com.movie.booking.model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	Connection conn;
	
	// Initialize all the information regarding
			// Database Connection
	private String dbDriver;
	private String dbURL;

	// Database name to access
	private String dbUsername;
	private String dbPassword;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		
		
		dbDriver = "com.mysql.cj.jdbc.Driver";
		dbURL = "jdbc:mysql://localhost:3306/movieBooking";
		dbUsername = "root";
		dbPassword = "password";

		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		return conn;
	}

}
