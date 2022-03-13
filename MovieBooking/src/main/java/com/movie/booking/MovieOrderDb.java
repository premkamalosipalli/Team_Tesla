package com.movie.booking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.movie.booking.entity.MovieEntity;
import com.movie.booking.entity.MovieOrderEntity;
import com.movie.booking.entity.RegistrationEntity;

public class MovieOrderDb {

	DbConnection con = new DbConnection();
	PreparedStatement pstmt;
	ResultSet resultset;

	public void insertMovie(String firstName, String movieName, int quantity, boolean orderStatus) {
		
		MovieEntity movieData = retrieveMovie(movieName);
		RegistrationEntity userData = retrieveUser(firstName);
		
		try {
			pstmt = con.getConnection().prepareStatement("insert into movie_order"
					+ " (reg_id, email, movieName, movieCost, quantity, totalCost, orderStatus) "
					+ "values(?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, userData.getReg_id());
			pstmt.setString(2, userData.getEmail());
			pstmt.setString(3, movieData.getMovieName());
			pstmt.setFloat(4, movieData.getMovieCost());
			pstmt.setInt(5, quantity);
			pstmt.setFloat(6, quantity*movieData.getMovieCost());
			pstmt.setBoolean(7, orderStatus);
			int insertStatus = pstmt.executeUpdate();
	        if(insertStatus > 0) {
	            System.out.println("Record is inserted successfully !!!");
	         }
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	List<MovieOrderEntity> getOrder(String Name, boolean orderStatus){
		List<MovieOrderEntity> movieOrderList = new ArrayList<>();
		
		try {
			pstmt = con.getConnection().prepareStatement("select * from movie_order where movieName=? and orderStatus=?");
			pstmt.setString(1, Name);
			pstmt.setBoolean(2, orderStatus);
			resultset = pstmt.executeQuery();
			while(resultset.next()) {
				int order_id = resultset.getInt(1);
				int reg_id = resultset.getInt(2);
				String email = resultset.getString(3);
				String movieName = resultset.getString(4);
				float movieCost = resultset.getFloat(5);
				int movieQuantity = resultset.getInt(6);
				float totalCost = resultset.getFloat(7);
				boolean status = resultset.getBoolean(8);
				movieOrderList.add(new MovieOrderEntity(order_id, reg_id, email, movieName, movieCost, movieQuantity, totalCost, status));
			}  
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return movieOrderList;
	}
	
	public void updateOrderStatus(String email, boolean orderStatus) {
		try {
			pstmt = con.getConnection().prepareStatement("update movie_order set orderStatus="+false+" where email=? and orderStatus=?");
			pstmt.setString(1, email);
			pstmt.setBoolean(2, orderStatus);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public MovieEntity retrieveMovie(String movieName) {
		MovieEntity movieData = new MovieEntity();
		try {
			pstmt = con.getConnection().prepareStatement("select * from movie where movieName=?");
			pstmt.setString(1, movieName);
			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				movieData.setMovieId(resultset.getInt(1));
				movieData.setMovieName(resultset.getString(2));
				movieData.setMovieCost(resultset.getFloat(3));
				movieData.setMovieLength(resultset.getFloat(4));
				movieData.setMovieDesc(resultset.getString(5));
				movieData.setMovieDate(resultset.getDate(6));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return movieData;
	}

	public RegistrationEntity retrieveUser(String firstName) {

		RegistrationEntity registrationData = new RegistrationEntity();
		try {
			pstmt = con.getConnection().prepareStatement("select * from registration where firstName=?");
			pstmt.setString(1, firstName);
			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				registrationData.setReg_id(resultset.getInt(1));
				registrationData.setFirstName(resultset.getString(2));
				registrationData.setLastName(resultset.getString(3));
				registrationData.setMobile(resultset.getString(4));
				registrationData.setEmail(resultset.getString(5));
				registrationData.setZipCode(resultset.getString(6));
				registrationData.setPassword(resultset.getString(7));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return registrationData;
	}
}
