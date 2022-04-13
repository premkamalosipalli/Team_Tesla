package com.movie.booking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.movie.booking.model.MovieDescDb;

@WebServlet("/MovieDesc")
public class MovieDescServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MovieDescDb movieDescDb = new MovieDescDb();
		
		movieDescDb.getMovie(request, response);
		request.setAttribute("user", session.getAttribute("userName"));
		RequestDispatcher display = request.getRequestDispatcher("view/MovieDesc.jsp");
		display.forward(request, response);
	}

}
