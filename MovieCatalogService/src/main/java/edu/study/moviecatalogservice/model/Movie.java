package edu.study.moviecatalogservice.model;

/**
 * model class for the unMarshalling the output from movieInfoService in a Movie object  
 */

public class Movie {

	private String movieId;
	
	private String name;
	
	private String desc;
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String movieId, String name, String desc) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
