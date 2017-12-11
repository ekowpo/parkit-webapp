package com.coen.parkit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coen.parkit.model.ParkingLot;
import com.coen.parkit.model.ParkingPrice;

public interface ParkingPriceRepository extends CrudRepository<ParkingPrice, String>{
	
	List<ParkingPrice> findAll();
	
	ParkingPrice findByName(String name);

}
