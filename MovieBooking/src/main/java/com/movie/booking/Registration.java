package com.movie.booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResultSet resultset;
		PreparedStatement pstmt;
		DbConnection con=new DbConnection();		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		try {
			pstmt = con.getConnection().prepareStatement("select email from  registration where email =?");
			pstmt.setString(1, request.getParameter("email"));
			resultset = pstmt.executeQuery();
			if (!resultset.next()) {// STLOC_ID is not present in the table then insert it in the table..
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
				request.getRequestDispatcher("/signUp.jsp").include(request, response);
			}
			request.getRequestDispatcher("/logIn.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			LOGGER.info("Error in Registration Class");
			e1.printStackTrace();
			
		}

	}

}
