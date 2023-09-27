package com.micro.user.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.user.service.entities.User;
import com.micro.user.service.services.UserService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController { 
	
	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	// create 
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
		
		
	    // single user get
	
	
	      int retryCount=1;
	
		@GetMapping("/{userId}")
//		@CircuitBreaker(name="ratingHotelBreaker", fallbackMethod="ratingHotelFallBack")
		@Retry(name="ratingHotelService",  fallbackMethod="ratingHotelFallBack")
//		@RateLimiter(name="UserRateLimiter", fallbackMethod= "ratingHotelFallBack")
		public ResponseEntity<User> getSingleUser(@PathVariable String userId){
			logger.info("Get Single User Handler: UserControler");
			logger.info("Retry Count: {}", retryCount);
			retryCount++;
			
			User user = userService.getUserById(userId);
			return ResponseEntity.ok(user);
			
		}
		
		
		
		// creating fallback method for circuit breaker
		public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex){
//			logger.info("Fallback is executed because service is down : ", ex.getMessage());
			
			User user= new User();
			user.setEmail("dummy@gmail.com");
			user.setName("Dummy");
			user.setAbout("This user is created dummy because some service is down");
			user.setUserId("141234");
		
			
			     
			return new ResponseEntity<>(user, HttpStatus.OK);
			
		}
		
		// all user get
		@GetMapping
		public ResponseEntity<List<User>>getAllUser() {
			List<User> allUser = userService.getAllUser();
			return ResponseEntity.ok(allUser);
			
			
		}

	}


