package com.movie.booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Connection conn;
		// Initialize all the information regarding
		// Database Connection
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/movies";

		// Database name to access
		String dbUsername = "root";
		String dbPassword = "password";

		Class.forName(dbDriver);
		conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		return conn;
	}

}
