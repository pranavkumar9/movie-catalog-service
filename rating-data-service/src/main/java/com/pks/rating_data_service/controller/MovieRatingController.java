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


	@GetMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable String userId)
	{
		List<Rating> ratings = Arrays.asList(
				new Rating(userId,77)
				);
//		int randomNumber = (int)(Math.random() * 10) + 1;
//		try
//		{
//			System.out.println("thread wait time is "+randomNumber);
//			Thread.sleep(randomNumber*1000);
//		}
//		catch (Exception e)
//		{
//
//		}
		UserRating userRating = new UserRating();
		userRating.setUserRatings(ratings);
		System.out.println("returning rating from controller");
		return userRating;
	}

	
}
