package com.movie.booking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.movie.booking.entity.GenreList;

public class GenreSelectDB {
	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
		List<GenreList> getMovies(String genreName) {
		List<GenreList> movieList = new ArrayList<GenreList>();
		DbConnection con=new DbConnection();
		ResultSet resultset;
		PreparedStatement pstmt;
		try {
			pstmt = con.getConnection().prepareStatement("SELECT * FROM  movies  where movieGenre =?");
			pstmt.setString(1, genreName);
			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				String movieName = resultset.getString(1);
				String movieGenre = resultset.getString(2);
				String imageLocation = resultset.getString(3);
				movieList.add(new GenreList(movieName, imageLocation, movieGenre));
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			LOGGER.info("Error in BeerExpertDB Class");
			e1.printStackTrace();
			
			
		}
		return movieList;
	}

}
