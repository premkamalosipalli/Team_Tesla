package com.movie.booking.entity;

public class GenreList {
	String movieName;
	String imageLocation;
	String movieGenre;

	public GenreList() {
		super();
	}

	public GenreList(String movieName, String imageLocation, String movieGenre) {
		this.movieName = movieName;
		this.imageLocation = imageLocation;
		this.movieGenre = movieGenre;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	

}
