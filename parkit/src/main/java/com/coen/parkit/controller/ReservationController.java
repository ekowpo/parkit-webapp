package com.coen.parkit.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coen.parkit.model.DataOutput;
import com.coen.parkit.model.Reservation;
import com.coen.parkit.repository.ReservationRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ReservationController {
	
	@Autowired
	ReservationRepository reservationRepo;

	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="api/reserve")
	public Object getAllReservation(@RequestParam("username") String username, @RequestParam("userId") String userId){
		
		return new DataOutput(reservationRepo.findByUsernameAndUserId(username, userId));
		
		
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="api/reservation")
	public Reservation getReservation(@RequestParam("id") String id){
		
		return reservationRepo.findById(id);
		
		
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value="api/reserve")
	public Reservation getAllReservation(@RequestBody String reservation) throws JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		Reservation reserve = mapper.readValue(reservation, Reservation.class);
		reservationRepo.save(reserve);
		return reserve;
		
		
	}
	
	
}
