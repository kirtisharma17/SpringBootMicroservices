package com.micro.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.rating.entities.Rating;
import com.micro.rating.service.RatingService;

@RequestMapping("/ratings")
@RestController
public class RatingController {
	
	@Autowired
	private RatingService ratingService ;
	
	//create rating
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
		
		}
	// get all
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.ok(ratingService.getAllRating());
		
	}
	// getRating by userId
	@GetMapping("/user/{userId}")
	   public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
			return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
			
		}
	   
	   @GetMapping("/hotel/{hotelId}")
	   public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
			return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
			
		}


}
