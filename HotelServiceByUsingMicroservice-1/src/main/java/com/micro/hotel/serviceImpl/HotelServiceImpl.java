package com.micro.hotel.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.hotel.entities.Hotel;
import com.micro.hotel.exception.ResourceNotFoundException;
import com.micro.hotel.repo.HotelRepository;
import com.micro.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private  HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		String hotelId= UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found !!"));
	}

	@Override
	public Hotel update(Hotel hotel) {
		String hotelId= UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel delete(String id) {
		// TODO Auto-generated method stub
		 hotelRepository.deleteById(id);
		 return hotelRepository.findById(id).orElseThrow(null);
	}

}
