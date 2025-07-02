package com.pks.movie_catalog_service.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pks.movie_catalog_service.Model.CatalogItem;
import com.pks.movie_catalog_service.Model.Movie;
import com.pks.movie_catalog_service.Model.Rating;
import com.pks.movie_catalog_service.Model.UserRating;


@RestController
@RequestMapping("/catalog")
public class MovieRequestController {

	@Autowired
	private RestTemplate restTemplate;
	
	String movieBaseURL="http://MOVIE-INFO-SERVICE/movies/";
	String ratingBaseURL="http://rating-data-service/ratingData/users/";
	
	@GetMapping("/{movieId}")
	public List<CatalogItem> getCatalog(@PathVariable("movieId") String userId){
		
		//fetching movie rating from rating API call
		UserRating userRating = restTemplate.getForObject(ratingBaseURL+userId,UserRating.class);
		
		 
		//looping movie Id and fetching movie details by calling movie API
		 return userRating.getUserRatings().stream().map(rating -> {
		Movie movie = restTemplate.getForObject(movieBaseURL+rating.getMovieId(),Movie.class);
		 return new CatalogItem(movie.getName(),"Test",rating.getRating());
		})
		.collect(Collectors.toList());
		
		
	}
	
}
