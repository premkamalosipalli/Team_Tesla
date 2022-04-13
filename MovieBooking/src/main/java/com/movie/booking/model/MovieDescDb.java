package com.movie.booking.model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.booking.entity.ActorsEntity;
import com.movie.booking.entity.CastTeamEntity;
import com.movie.booking.entity.LanguageEntity;
import com.movie.booking.entity.MovieEntity;

public class MovieDescDb {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	DbConnection con = new DbConnection();
	ResultSet resultset;
	PreparedStatement pstmt;
	HttpSession session;
	
	public void getMovie(HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		MovieEntity movieData = new MovieEntity();
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

				getLanguages(movie_id, request);
				
				getActors(movie_id, request);
				
				getCastTeam(movie_id, request);

				getImageLocation(request);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.info("Error in ProductDesc Class");
			e.printStackTrace();
		}
		
	}
	
	private void getImageLocation(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		pstmt = con.getConnection().prepareStatement("SELECT movieLocation FROM  movies  where movieName =?");
		pstmt.setString(1, request.getParameter("movieName"));
		resultset = pstmt.executeQuery();
		while (resultset.next()) {
			String imageLocation = resultset.getString(1);
			request.setAttribute("imageLocation", imageLocation);
		}
	}
	
	private void getLanguages(int movie_id, HttpServletRequest request) throws ClassNotFoundException, SQLException{
		List<LanguageEntity> languageList = new ArrayList<LanguageEntity>();
		pstmt = con.getConnection().prepareStatement("SELECT * FROM language where movie_id=?");
		pstmt.setInt(1, movie_id);
		resultset = pstmt.executeQuery();
		while (resultset.next()) {
			int language_id = resultset.getInt(1);
			String language = resultset.getString(2);
			int movieLanguage_id = resultset.getInt(3);
			languageList.add(new LanguageEntity(language_id, language, movieLanguage_id));
			request.setAttribute("languageList", languageList);
		}
	}
	
	private void getActors(int movie_id, HttpServletRequest request) throws ClassNotFoundException, SQLException{

		List<ActorsEntity> actorsList = new ArrayList<ActorsEntity>();
		pstmt = con.getConnection().prepareStatement("SELECT * FROM actors where movie_id=?");
		pstmt.setInt(1, movie_id);
		resultset = pstmt.executeQuery();
		while (resultset.next()) {
			int actor_id = resultset.getInt(1);
			String fullName = resultset.getString(2);
			String role = resultset.getString(3);
			int movieActors_id = resultset.getInt(4);
			actorsList.add(new ActorsEntity(actor_id, fullName, role, movieActors_id));
			request.setAttribute("actorsList", actorsList);
		}
	}
	
	private void getCastTeam(int movie_id, HttpServletRequest request) throws ClassNotFoundException, SQLException{
		

		List<CastTeamEntity> castTeamList = new ArrayList<CastTeamEntity>();
		pstmt = con.getConnection().prepareStatement("SELECT * FROM cast_team where movie_id=?");
		pstmt.setInt(1, movie_id);
		resultset = pstmt.executeQuery();
		while (resultset.next()) {
			int castTeam_id = resultset.getInt(1);
			String fullName = resultset.getString(2);
			int experience = resultset.getInt(3);
			int movieCast_id = resultset.getInt(4);
			castTeamList.add(new CastTeamEntity(castTeam_id, fullName, experience, movieCast_id));
			request.setAttribute("castTeamList", castTeamList);
		}
	}

}
