package com.movie.booking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.movie.booking.model.RegistrationDb;

@SuppressWarnings("serial")
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	
	RegistrationDb registrationDb = new RegistrationDb();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		registrationDb.registerUser(request, response);

	}

}
