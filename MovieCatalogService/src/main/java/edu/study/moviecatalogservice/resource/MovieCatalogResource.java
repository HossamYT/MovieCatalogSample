package edu.study.moviecatalogservice.resource;
/**
 * This class is a controller class which is used to consume two microServices 
 * MovieInfoServie and RatingDataService; so you input the userId and output
 * list movie catalogs = (Movie Class) + rating details (Rating Class) 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.study.moviecatalogservice.model.CatalogItem;
import edu.study.moviecatalogservice.model.Movie;
import edu.study.moviecatalogservice.model.Rating;
import edu.study.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	// this is used for calling the microService and it's a singleton
	@Autowired
	private RestTemplate restTemplate;
	
	// rest API inputs userId and outputs movie catalog
	@RequestMapping("/{user_id}")
	public List<CatalogItem> getCatalog (@PathVariable("user_id") String userId){
		
		// the output list
		List<CatalogItem> catalogList = new ArrayList<CatalogItem>();
		
		// the output list of RatingDataService
		List<Rating> ratedMovieList;
		
		// the output of MovieInfoService
		Movie movie;
		
		// get all rated moviesIds from RatingsInfoService and UserRating object is just a wrapper for the ratingList
		// so restTemplate calls the URL of ratingDataService and output the list of ratedMovies inside a wrapper class userRating 
		/*UserRating userRating = restTemplate.getForObject("http://localhost:8082/ratings/users/"+userId, UserRating.class); this is the explicit URL*/
		UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratings/users/"+userId, UserRating.class);
		
		ratedMovieList = userRating.getUserRatings(); 
		
		// for each movieId call movieInfoService
		for (Rating ratedMovie : ratedMovieList) {
		
			// restTemplate calls the second service movieInfoService by movieId and outputs the Movie object
			/*movie =  restTemplate.getForObject("http://localhost:8081/movie/" + ratedMovie.getMovieId(), Movie.class);this is the explicit URL*/
			movie =  restTemplate.getForObject("http://movie-info-service/movie/" + ratedMovie.getMovieId(), Movie.class);
			
			// putting the 1st output (Rating object list from wrapper class) and 2nd output (Movie object) together in the MovieCatalog object
			catalogList.add(new CatalogItem(movie.getName(), movie.getDesc(), ratedMovie.getRating()));
		}
		
		return catalogList;	
	}
}
//new CatalogItem("Departed", "Action, Crime, Thriller, Police", 5)