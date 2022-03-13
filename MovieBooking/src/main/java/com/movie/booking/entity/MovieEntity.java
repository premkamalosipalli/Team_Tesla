package com.movie.booking.entity;

import java.sql.Date;

public class MovieEntity {
	
	int movieId;
	String movieName;
	float movieCost;
	float movieLength;
	String movieDesc;
	Date movieDate;

	public MovieEntity() {
	}

	
	public MovieEntity(int movieId, String movieName, float movieCost, float movieLength, String movieDesc, Date movieDate) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieCost = movieCost;
		this.movieLength = movieLength;
		this.movieDesc = movieDesc;
		this.movieDate = movieDate;
	}


	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public float getMovieCost() {
		return movieCost;
	}

	public void setMovieCost(float movieCost) {
		this.movieCost = movieCost;
	}

	public float getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(float movieLength) {
		this.movieLength = movieLength;
	}

	public String getMovieDesc() {
		return movieDesc;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}

	public Date getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}

	
}
