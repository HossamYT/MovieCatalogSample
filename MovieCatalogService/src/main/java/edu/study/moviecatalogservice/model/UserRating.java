package edu.study.moviecatalogservice.model;

/**
 * model class used only for wrapping a list of Rating objects  
 */

import java.util.List;

public class UserRating {
	
	private List<Rating> userRatings;

		
	public UserRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRating(List<Rating> userRatings) {
		super();
		this.userRatings = userRatings;
	}


	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}
	
	

}
