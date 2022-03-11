package com.movie.booking.entity;

public class CastTeam {
	
	int castTeam_id;
	String fullName;
	int experience;
	int movie_id;

	public CastTeam() {
	}

	public CastTeam(int castTeam_id, String fullName, int experience, int movie_id) {
		super();
		this.castTeam_id = castTeam_id;
		this.fullName = fullName;
		this.experience = experience;
		this.movie_id = movie_id;
	}

	public int getCastTeam_id() {
		return castTeam_id;
	}

	public void setCastTeam_id(int castTeam_id) {
		this.castTeam_id = castTeam_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	
}
