package com.movie.booking;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.booking.entity.Movie;


@WebServlet("/MovieDesc")
public class MovieDesc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		DbConnection con=new DbConnection();
		ResultSet resultset;
		PreparedStatement pstmt;
		HttpSession session = request.getSession();
		Movie movieData =new Movie(); 
		try {
			pstmt = con.getConnection().prepareStatement("SELECT * FROM  movie  where movieName =?");
			pstmt.setString(1, request.getParameter("movieName"));
			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				movieData.setMovieId(resultset.getInt(1));
				movieData.setMovieName(resultset.getString(2));
				movieData.setMovieCost(resultset.getFloat(3));
				movieData.setMovieLength(resultset.getFloat(4));
				movieData.setMovieDesc(resultset.getString(5));
				movieData.setMovieDate(resultset.getDate(6));
				request.setAttribute("list", movieData);
				request.setAttribute("user", session.getAttribute("userName"));
				RequestDispatcher display = request.getRequestDispatcher("MovieDesc.jsp");
				display.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.info("Error in ProductDesc Class");
			e.printStackTrace();
		}
	}

}
