package com.micro.hotel.service;

import java.util.List;

import com.micro.hotel.entities.Hotel;

public interface HotelService {
	 
	//create
	Hotel create(Hotel hotel);
	
	// get All
	List<Hotel> getAll();
	
	//get single
	Hotel get(String id);
	
	//get Update
	Hotel update(Hotel hotel);
	
	//  delete
	
	Hotel delete(String id);
	

}
