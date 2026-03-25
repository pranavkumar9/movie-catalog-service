package com.pks.movie_catalog_service.service;

import com.pks.movie_catalog_service.Model.Movie;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.pks.movie_catalog_service.Model.Rating;
import com.pks.movie_catalog_service.Model.CatalogItem;



@Service
public class MovieInfoService {

    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(MovieInfoService.class);


    String movieBaseURL="http://MOVIE-INFO-SERVICE/movies/";

    @CircuitBreaker(name="movieInfo",fallbackMethod = "fallback")
    public CatalogItem getCatalogItem(Rating rating)
    {
        logger.info("movie info service called");
        Movie movie = restTemplate.getForObject(movieBaseURL + rating.getMovieId(), Movie.class);
        logger.info("movie info details "+movie.toString());
        logger.info("movie info"+movie);
        return new CatalogItem(movie.getName(),movie.getOverview(),rating.getRating());
    }

    public CatalogItem fallback(Rating rating,Throwable ex)
    {
        logger.info("External called to movieInfo failed "+ex.getMessage());
        return new CatalogItem("zero","zeroD",rating.getRating());
    }





}
