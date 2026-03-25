package com.pks.movie_info_service.controller;

import com.pks.movie_info_service.model.TMDBMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pks.movie_info_service.model.Movie;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	private final RestTemplate restTemplate;
	private final String accessToken;

	public MovieInfoController(RestTemplate restTemplate, @Value("${api_key}") String accessToken)
	{
		this.restTemplate=restTemplate;
		this.accessToken= accessToken;
	}
	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId)
	{
		System.out.println("Catalog called for: " + movieId);
//		try {
//			Thread.sleep(5000);
//		}
//		catch (Exception e)
//		{
//			System.out.println(e);
//		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setBearerAuth(accessToken);
		System.out.println("inside info controller");
		HttpEntity<Void> entity = new HttpEntity<>(httpHeaders);
		System.out.println("https://api.themoviedb.org/3/movie/"+movieId);
		ResponseEntity<TMDBMovie> respose = restTemplate.exchange("https://api.themoviedb.org/3/movie/"+movieId, HttpMethod.GET,entity,TMDBMovie.class);
		System.out.println("response is"+respose.toString());
		TMDBMovie tmbdMovie = respose.getBody();
		Movie movie = new Movie(tmbdMovie.getId(),tmbdMovie.getTitle(),tmbdMovie.getOverview());
		return movie;
	}
}
