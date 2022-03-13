package com.movie.booking.entity;

public class ActorsEntity {
	
	int actor_id;
	String fullName;
	String role;
	int movie_id;

	public ActorsEntity() {
		// TODO Auto-generated constructor stub
	}

	public ActorsEntity(int actor_id, String fullName, String role, int movie_id) {
		super();
		this.actor_id = actor_id;
		this.fullName = fullName;
		this.role = role;
		this.movie_id = movie_id;
	}

	public int getActor_id() {
		return actor_id;
	}

	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	
}
