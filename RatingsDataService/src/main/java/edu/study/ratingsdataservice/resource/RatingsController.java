package edu.study.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.study.ratingsdataservice.model.Rating;
import edu.study.ratingsdataservice.model.UserRating;

/**
 * API class for outputting a rating for a movieId 
 * 
 * API class for outputting a list of rating for a userId
 */

@RestController
@RequestMapping("/ratings")
public class RatingsController {
	
	@RequestMapping("/{movie_id}")
	public Rating getRarting (@PathVariable("movie_id") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("users/{user_id}")
	public UserRating getUserRarting (@PathVariable("user_id") String userId) {
		return new UserRating(Arrays.asList(
				new Rating("111", 5),
				new Rating("222", 4),
				new Rating("333", 3)
				));
	}

}
