package com.movie.booking.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.booking.entity.ActorsEntity;
import com.movie.booking.entity.CastTeamEntity;
import com.movie.booking.entity.LanguageEntity;
import com.movie.booking.entity.MovieEntity;
import com.movie.booking.model.DbConnection;

@WebServlet("/MovieDesc")
public class MovieDescServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DbConnection con = new DbConnection();
		ResultSet resultset, resultset1, resultset2, resultset3, resultset4;
		PreparedStatement pstmt, pstmt1, pstmt2, pstmt3, pstmt4;
		HttpSession session = request.getSession();
		MovieEntity movieData = new MovieEntity();
		List<LanguageEntity> languageList = new ArrayList<LanguageEntity>();
		List<ActorsEntity> actorsList = new ArrayList<ActorsEntity>();
		List<CastTeamEntity> castTeamList = new ArrayList<CastTeamEntity>();
		int movie_id;
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
				request.setAttribute("movieList", movieData);
				movie_id = movieData.getMovieId();

				pstmt1 = con.getConnection().prepareStatement("SELECT * FROM language where movie_id=?");
				pstmt1.setInt(1, movie_id);
				resultset1 = pstmt1.executeQuery();
				while (resultset1.next()) {
					int language_id = resultset1.getInt(1);
					String language = resultset1.getString(2);
					int movieLanguage_id = resultset1.getInt(3);
					languageList.add(new LanguageEntity(language_id, language, movieLanguage_id));
					request.setAttribute("languageList", languageList);
				}
				pstmt2 = con.getConnection().prepareStatement("SELECT * FROM actors where movie_id=?");
				pstmt2.setInt(1, movie_id);
				resultset2 = pstmt2.executeQuery();
				while (resultset2.next()) {
					int actor_id = resultset2.getInt(1);
					String fullName = resultset2.getString(2);
					String role = resultset2.getString(3);
					int movieActors_id = resultset2.getInt(4);
					actorsList.add(new ActorsEntity(actor_id, fullName, role, movieActors_id));
					request.setAttribute("actorsList", actorsList);
				}

				pstmt3 = con.getConnection().prepareStatement("SELECT * FROM cast_team where movie_id=?");
				pstmt3.setInt(1, movie_id);
				resultset3 = pstmt3.executeQuery();
				while (resultset3.next()) {
					int castTeam_id = resultset3.getInt(1);
					String fullName = resultset3.getString(2);
					int experience = resultset3.getInt(3);
					int movieCast_id = resultset3.getInt(4);
					castTeamList.add(new CastTeamEntity(castTeam_id, fullName, experience, movieCast_id));
					request.setAttribute("castTeamList", castTeamList);
				}

				pstmt4 = con.getConnection().prepareStatement("SELECT movieLocation FROM  movies  where movieName =?");
				pstmt4.setString(1, request.getParameter("movieName"));
				resultset4 = pstmt4.executeQuery();
				while (resultset4.next()) {
					String imageLocation = resultset4.getString(1);
					request.setAttribute("imageLocation", imageLocation);
				}
				request.setAttribute("user", session.getAttribute("userName"));
				RequestDispatcher display = request.getRequestDispatcher("view/MovieDesc.jsp");
				display.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.info("Error in ProductDesc Class");
			e.printStackTrace();
		}
	}

}
