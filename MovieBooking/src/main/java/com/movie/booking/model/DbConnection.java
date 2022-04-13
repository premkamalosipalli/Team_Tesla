package com.movie.booking.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	// Initialize all the information regarding
			// Database Connection
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	private String dbURL = "jdbc:mysql://localhost:3306/movieBooking";

	// Database name to access
	private String dbUsername = "root";
	private String dbPassword = "password";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Connection conn;

		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		return conn;
	}

}
