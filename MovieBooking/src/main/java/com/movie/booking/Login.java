package com.movie.booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DbConnection con=new DbConnection();
		Statement stmt = null;
		ResultSet resultset = null;
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("email", request.getParameter("email"));
		try {
			stmt = con.getConnection().createStatement();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		try {
			resultset = stmt.executeQuery(
					"SELECT EMAIL,PASSWORD FROM Registration WHERE EMAIL='" + session.getAttribute("email") + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (!(resultset.next())) {
				writer.println("User Credentials Not Found!Create an Account...");
				response.sendRedirect("signUp.jsp");

			} else {
				if (request.getParameter("email").equals(resultset.getString("EMAIL"))

						&& request.getParameter("password").equals(resultset.getString("PASSWORD"))) {
					RequestDispatcher display = request.getRequestDispatcher("genres.jsp");
					display.forward(request, response);
				} else {
					writer.println("Invalid Credentials SignUp");
					response.sendRedirect("signUp.jsp");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.info("Error in Login Class");
			e.printStackTrace();
		}

	}

}
