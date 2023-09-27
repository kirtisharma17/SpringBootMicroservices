package com.micro.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
