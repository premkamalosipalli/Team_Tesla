package com.movie.booking.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationDb {
	

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	ResultSet resultset;
	PreparedStatement pstmt;
	DbConnection con = new DbConnection();
	PrintWriter writer;
	
	public void registerUser(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			writer = response.getWriter();
			pstmt = con.getConnection().prepareStatement("select email from  registration where email =?");
			pstmt.setString(1, request.getParameter("email"));
			resultset = pstmt.executeQuery();
			if (!resultset.next()) {
				pstmt = con.getConnection().prepareStatement(
						"insert into registration(firstName,lastName,mobile,email,zipCode,password) values(?,?,?,?,?,?)");
				pstmt.setString(1, request.getParameter("firstName"));
				pstmt.setString(2, request.getParameter("lastName"));
				pstmt.setString(3, request.getParameter("mobile"));
				pstmt.setString(4, request.getParameter("email"));
				pstmt.setString(5, request.getParameter("zipCode"));
				pstmt.setString(6, request.getParameter("password"));
				pstmt.executeUpdate();
				resultset.close();
			} else {
				writer.print("Email Already Exists");
				request.getRequestDispatcher("view/signUp.jsp").include(request, response);
			}
			request.getRequestDispatcher("view/logIn.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException | IOException | ServletException e1) {
			LOGGER.info("Error in Registration Class");
			e1.printStackTrace();

		}
		
	}

}
