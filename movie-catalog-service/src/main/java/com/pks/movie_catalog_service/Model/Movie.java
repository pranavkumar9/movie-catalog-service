package com.pks.movie_catalog_service.Model;

public class Movie {

	private String movieId;
	private String Name;
	public Movie(String movieId, String name) {
		super();
		this.movieId = movieId;
		Name = name;
	}
	public Movie() {
		super();
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", Name=" + Name + "]";
	}
	
	
}
