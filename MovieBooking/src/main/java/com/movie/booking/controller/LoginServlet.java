package com.movie.booking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import com.movie.booking.model.LoginDb;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	LoginDb loginDb = new LoginDb();
	private HttpSession session;
	private String emailId;
	private String password;
	Result result = JUnitCore.runClasses(JWebUnitTest.class);

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession();

		emailId = request.getParameter("email");
		password = request.getParameter("password");
		session.setAttribute("email", emailId);

		loginDb.validateUser(emailId, password, request, response, session);
		
		//testing for login page
		loginDb.userLogin(emailId, password);

	}

}
