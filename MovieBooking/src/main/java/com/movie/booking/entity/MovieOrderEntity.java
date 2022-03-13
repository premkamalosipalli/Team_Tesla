package com.movie.booking.entity;

public class MovieOrderEntity {
	
	int order_id;
	int reg_id;
	String email;
	String movieName;
	float movieCost;
	int quantity;
	float totalCost;
	boolean orderStatus;
	
	public MovieOrderEntity(int order_id, int reg_id, String email, String movieName, float movieCost, int quantity,
			float totalCost, boolean orderStatus) {
		super();
		this.order_id = order_id;
		this.reg_id = reg_id;
		this.email = email;
		this.movieName = movieName;
		this.movieCost = movieCost;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.orderStatus = orderStatus;
	}

	public MovieOrderEntity() {
		super();
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getReg_id() {
		return reg_id;
	}

	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
