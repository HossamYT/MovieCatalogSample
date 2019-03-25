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
	
	@RequestMapping("/{movie_id}")
	public Movie getMovieInfo(@PathVariable("movie_id") String movieId) {
		return new Movie(movieId, "Meet The Fockers", "Comedy , Family");
	}
}
