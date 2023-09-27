package com.micro.rating.service;

import java.util.List;

import com.micro.rating.entities.Rating;

public interface RatingService {
	
	//create
	
	Rating createRating(Rating rating);
	
	//getAll rating
	
	List<Rating>getAllRating();
	
	//get all by userId
	List<Rating> getRatingByUserId(String userId);
	
	//get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);
	

}
