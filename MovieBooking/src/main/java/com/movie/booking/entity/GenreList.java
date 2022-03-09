package com.movie.booking.entity;

public class GenreList {
	int movieId;
	String movieName;
	String imageLocation;
	String movieGenre;
	String language;
	float movieCost;
	String length;
	Float price;
	String available;

	public GenreList() {
		super();
	}

	public GenreList(int movieId, String movieName, String imageLocation, String movieGenre, String language,
			float movieCost, String length, String available) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.imageLocation = imageLocation;
		this.movieGenre = movieGenre;
		this.language = language;
		this.movieCost = movieCost;
		this.length = length;
		this.available = available;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public float getMovieCost() {
		return movieCost;
	}

	public void setMovieCost(float movieCost) {
		this.movieCost = movieCost;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

}
