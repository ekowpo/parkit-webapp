package com.coen.parkit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coen.parkit.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, String>{

	List<Reservation> findByUsernameAndUserId(String username,String userId);
	Reservation findById(String id);
}


