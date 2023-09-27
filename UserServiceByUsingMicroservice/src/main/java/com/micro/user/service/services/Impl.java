package com.micro.user.service.services;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.user.service.entities.Hotel;
import com.micro.user.service.entities.Rating;
import com.micro.user.service.entities.User;
import com.micro.user.service.exception.ResourceNotFoundException;
import com.micro.user.service.externaService.HotelService;
import com.micro.user.service.repository.UserRepository;



@Service
public class Impl implements UserService {
	
	@Autowired
	private UserRepository  userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger=LoggerFactory.getLogger(Impl.class);
	
	

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
	String randomUserId =	UUID.randomUUID().toString();
	user.setUserId(randomUserId);
	

		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		//implement RATING SERVICE CALL : USING RSET TEMPLATE
		return userRepository.findAll();
	}

//	@Override
//	public User getUserById(String userId) {
//		// TODO Auto-generated method stub
//		User user =userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server !!"+ userId));
//		// fetch rating of the above user from Rating Service
//		//http://localhost:8083/ratings/user/d80259b4-d70b-4f08-bccc-c0d0a88e1398
//		Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/ "+user.getUserId(), Rating[].class);
//		logger.info("{}", ratingOfUser);
//		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
//		List<Rating> ratingList = ratings.stream().map(rating->{
//			//api call to hotel service to get the hotel
//			//http://localhost:8082/hotels/91980c34-d915-4ba1-814b-b44a27330d74
//			   ResponseEntity<Hotel> forEntity =     restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//			 Hotel hotel =  forEntity.getBody();
//			 logger.info("response status code {}",forEntity.getStatusCode());
//			//set the hotel to reating 
//			 rating.setHotel(hotel);
//			//return rating
//			return rating;
//		}).collect(Collectors.toList());
//		
//		user.setRating(ratingList);
//		
//		
//		return user;
//	}
	
	
	
	
	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		User user =userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server !!"+ userId));
		// fetch rating of the above user from Rating Service
		//http://localhost:8083/ratings/user/d80259b4-d70b-4f08-bccc-c0d0a88e1398
		Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/ "+user.getUserId(), Rating[].class);
		
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		List<Rating> ratingList = ratings.stream().map(rating->{
			//api call to hotel service to get the hotel
			//http://localhost:8082/hotels/91980c34-d915-4ba1-814b-b44a27330d74
//			   ResponseEntity<Hotel> forEntity =     restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
           Hotel hotel = hotelService.getHotel(rating.getHotelId());
			 rating.setHotel(hotel);
			//return rating
			return rating;
		}).collect(Collectors.toList());
		
		user.setRating(ratingList);
		
		
		return user;
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stubs
		userRepository.deleteById(id);
		System.out.println("delete user that id "+ id);
		
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
