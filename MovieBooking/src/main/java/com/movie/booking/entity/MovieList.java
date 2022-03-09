package com.movie.booking.entity;

public class MovieList {
	
	String movieGenre;
	String movieName;
	String imageLocation;
	String language;
	float movieCost;
	float totalcost;
	int movieId;
	String currency;
	int quantity;
	float subtotal;
	
	
	public MovieList() {
		super();
	}
	public MovieList(String movieGenre, String movieName, String imageLocation, String language, float movieCost,
			float totalcost, int movieId, String currency, int quantity, float subtotal) {
		this.movieGenre = movieGenre;
		this.movieName = movieName;
		this.imageLocation = imageLocation;
		this.language = language;
		this.movieCost = movieCost;
		this.totalcost = totalcost;
		this.movieId = movieId;
		this.currency = currency;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
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
	public float getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(float totalcost) {
		this.totalcost = totalcost;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	
}
