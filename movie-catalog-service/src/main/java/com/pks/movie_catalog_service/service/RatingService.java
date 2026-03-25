package com.pks.movie_catalog_service.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.pks.movie_catalog_service.Model.UserRating;
import com.pks.movie_catalog_service.Model.CatalogItem;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RatingService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieInfoService movieInfoService;

    private final Logger logger = LoggerFactory.getLogger(RatingService.class);

    String ratingBaseURL="http://rating-data-service/ratingData/users/";


    @CircuitBreaker(name="ratingService",fallbackMethod = "fallback")
    public List<CatalogItem> getCatalogItem(String userId) {

        logger.info("calling external Rating API");
        UserRating userRating =
                restTemplate.getForObject(ratingBaseURL + userId, UserRating.class);

        logger.info("User rating details"+userRating);
        return userRating.getUserRatings()
                .stream()
                .map(movieInfoService::getCatalogItem)
                .collect(Collectors.toList());
    }

    public List<CatalogItem> fallback(String userId, Throwable ex)
    {
        logger.info("External call to rating service failed , Reason : "+ex.getMessage());
        UserRating userRating = (UserRating) List.of(userId,1);
        return userRating.getUserRatings()
                .stream()
                .map(movieInfoService::getCatalogItem)
                .collect(Collectors.toList());

    }
}
