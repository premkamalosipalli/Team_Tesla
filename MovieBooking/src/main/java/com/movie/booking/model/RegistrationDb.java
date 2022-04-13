package com.movie.booking.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationDb {


	ResultSet resultset;
	PreparedStatement pstmt;
	DbConnection con = new DbConnection();
	PrintWriter writer;
	
	public void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
		
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
		
	}

}
