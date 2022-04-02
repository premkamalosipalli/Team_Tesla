package com.movie.booking.entity;

public class LanguageEntity {

	int language_id;
	String language;
	int movie_id;

	public LanguageEntity() {
	}

	public LanguageEntity(int language_id, String language, int movie_id) {
		super();
		this.language_id = language_id;
		this.language = language;
		this.movie_id = movie_id;
	}

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

}
