package edu.study.movieinfoservice.resource;

/**
 * An end point class for outputting a movie 
 */
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.study.movieinfoservice.model.Movie;


@RestController
@RequestMapping("/movie")
public class MovieController {
	
	// Here we can also use @RequestParam but the URL will be different movie_id?=111
	// but since we are requesting a resource it should be @PathVariable 
	@RequestMapping("/{movie_id}")
	public Movie getMovieInfo(@PathVariable("movie_id") String movieId) {
		return new Movie(movieId, "Meet The Fockers", "Comedy , Family");
	}
}
