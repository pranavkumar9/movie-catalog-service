package com.pks.movie_info_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

	private String movieId;
	private String name;
	private String overview;
	public Movie(String movieId, String name,String overview) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.overview = overview;

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
		return this.name;
	}
	public void setName(String name) { this.name = name; }
	public String getOverview() {return overview; }
	public void setOverview(String overview) {
		this.overview = overview; }

	@Override
	public String toString() {
		return "Movie{" +
				"movieId='" + movieId + '\'' +
				", name='" + name + '\'' +
				", overView='" + overview + '\'' +
				'}';
	}
}
