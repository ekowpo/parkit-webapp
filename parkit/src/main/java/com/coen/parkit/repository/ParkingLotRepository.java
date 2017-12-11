package com.coen.parkit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coen.parkit.model.ParkingLot;

public interface ParkingLotRepository extends CrudRepository<ParkingLot, String>{
	
	List<ParkingLot> findAll();
	
	ParkingLot findByAddress(String address);
	
	ParkingLot findById(String id);

}
