package com.movie.booking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.movie.booking.entity.GenreList;
import com.movie.booking.entity.Registration;

public class GenreSelectDB {
	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
		List<GenreList> getMovies(String genreName) {
		List<GenreList> movieList = new ArrayList<GenreList>();
		DbConnection con=new DbConnection();
		ResultSet resultset;
		PreparedStatement pstmt;
		try {
			pstmt = con.getConnection().prepareStatement("SELECT * FROM  movie  where movieGenre =?");
			pstmt.setString(1, genreName);
			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				int movieId = resultset.getInt(1);
				String movieName = resultset.getString(2);
				String imageLocation = resultset.getString(3);
				String movieGenre = resultset.getString(4);
				String language = resultset.getString(5);
				float movieCost = resultset.getFloat(6);
				String length = resultset.getString(7);
				String available = resultset.getString(8);
				movieList.add(new GenreList(movieId, movieName, imageLocation, movieGenre, language, movieCost, length, available));
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			LOGGER.info("Error in BeerExpertDB Class");
			e1.printStackTrace();
			
			
		}
		return movieList;
	}

}
