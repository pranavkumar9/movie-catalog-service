package com.pks.movie_catalog_service.controller;


import com.pks.movie_catalog_service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pks.movie_catalog_service.Model.CatalogItem;


import java.util.List;


@RestController
@RequestMapping("/catalog")
public class MovieRequestController {

	@Autowired
	private RatingService ratingService;



	@GetMapping(value = "/{movieId}",
			headers = "Accept=application/json")
	public List<CatalogItem> getCatalog(@PathVariable("movieId") String movieId){

			return ratingService.getCatalogItem(movieId);

	}

}
