package com.pks.movie_catalog_service.Model;

import java.util.List;

public class UserRating {
	
	public List<Rating> userRatings;

	public UserRating() {
		
	}

	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}
	
	

}
