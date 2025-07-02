package com.pks.rating_data_service.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pks.rating_data_service.model.Rating;
import com.pks.rating_data_service.model.UserRating;

@RestController
@RequestMapping("/ratingData")
public class MovieRatingController {

	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId)
	{
		return new Rating(movieId,5);
	}
	
	@GetMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable String userId)
	{
		List<Rating> ratings = Arrays.asList(
				new Rating("1111",4),
				new Rating("1213",77)
				);
		UserRating userRating = new UserRating();
		userRating.setUserRatings(ratings);
		return userRating;
	}

	
}
