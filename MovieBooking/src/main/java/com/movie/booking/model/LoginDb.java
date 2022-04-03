package com.movie.booking.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.booking.entity.RegistrationEntity;

public class LoginDb {
	

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	

	
	DbConnection con = new DbConnection();
	Statement stmt = null;
	ResultSet resultset = null;
	PrintWriter writer;
	RegistrationEntity register = new RegistrationEntity();

	public void validateUser(String emailId, String password, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		
		try {
			writer = response.getWriter();
			stmt = con.getConnection().createStatement();
			resultset = stmt.executeQuery("SELECT * FROM Registration WHERE EMAIL='" + emailId + "'");

			if (!(resultset.next())) {
				writer.println("User Credentials Not Found!Create an Account...");
				response.sendRedirect("view/signUp.jsp");

			} else {
				if (emailId.equals(resultset.getString("EMAIL"))

						&& password.equals(resultset.getString("PASSWORD"))) {

					register.setFirstName(resultset.getString(2));
					register.setLastName(resultset.getString(3));
					register.setMobile(resultset.getString(4));
					register.setEmail(resultset.getString(5));
					register.setZipCode(resultset.getString(6));
					register.setPassword(resultset.getString(7));
					request.setAttribute("register", register);
					session.setAttribute("userName", register.getFirstName());
					RequestDispatcher display = request.getRequestDispatcher("view/genres.jsp");
					display.forward(request, response);
				} else {
					writer.println("Invalid Credentials SignUp");
					response.sendRedirect("view/signUp.jsp");
				}
			}
		} catch (SQLException | ClassNotFoundException | IOException | ServletException e) {
			LOGGER.info("Error in Login Class");
			e.printStackTrace();
		}
		
	}

}
