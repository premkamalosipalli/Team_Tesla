package com.movie.booking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.booking.model.GenreSelectDB;

@WebServlet("/genreSelect")
public class GenreSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String genre = request.getParameter("genre");
		GenreSelectDB genreDb = new GenreSelectDB();
		@SuppressWarnings("rawtypes")
		List result = genreDb.getMovies(genre);
		request.setAttribute("styles", result);
		request.setAttribute("user", session.getAttribute("userName"));
		RequestDispatcher display = request.getRequestDispatcher("view/movies.jsp");
		display.forward(request, response);

	}

}
