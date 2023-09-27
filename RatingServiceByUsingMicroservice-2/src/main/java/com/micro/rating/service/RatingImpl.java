package com.micro.rating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.rating.entities.Rating;
import com.micro.rating.repository.RatingRepo;

@Service
public class RatingImpl implements RatingService {
	
	@Autowired
	private RatingRepo repository;


	@Override
	public Rating createRating(Rating rating) {
		// TODO Auto-generated method stub
		return  repository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return repository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return repository.findByHotelId(hotelId);
	}

}
