package com.coen.parkit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coen.parkit.model.DataOutput;
import com.coen.parkit.model.ParkingPrice;
import com.coen.parkit.repository.ParkingPriceRepository;

@RestController
public class ParkingPriceController {

	@Autowired
	ParkingPriceRepository parkingPriceRepo;
	
	@CrossOrigin
	@RequestMapping(value="api/parkingprice")
	public ParkingPrice getParkingPrice(@RequestParam("parkingLot") String parkingLot){
		
		return parkingPriceRepo.findByName(parkingLot);
	}
	
	@RequestMapping(value="api/createparkingprice")
	public void createParkingPrice(){
		
		ParkingPrice pkp =new ParkingPrice();
		pkp.setName("Stationnment Superior Inc");
		pkp.setPrice1hr(2.0);
		pkp.setPrice3hr(5.0);
		pkp.setPriceMax(12.0);
		parkingPriceRepo.save(pkp);
		
		ParkingPrice pkp1 =new ParkingPrice();
		pkp1.setName("E M Parking Lot");
		pkp1.setPrice1hr(0.99);
		pkp1.setPrice3hr(2.99);
		pkp1.setPriceMax(8.0);
		parkingPriceRepo.save(pkp1);
		
		ParkingPrice pkp2 =new ParkingPrice();
		pkp2.setName("Safeway parking Limitee et populaire");
		pkp2.setPrice1hr(2.0);
		pkp2.setPrice3hr(5.0);
		pkp2.setPriceMax(12.0);
		parkingPriceRepo.save(pkp2);
		
		ParkingPrice pkp3 =new ParkingPrice();
		pkp3.setName("Stationnment de Montreal");
		pkp3.setPrice1hr(1.49);
		pkp3.setPrice3hr(4.99);
		pkp3.setPriceMax(12.99);
		parkingPriceRepo.save(pkp3);
		
		ParkingPrice pkp4 =new ParkingPrice();
		pkp4.setName("Place du Park");
		pkp4.setPrice1hr(2.0);
		pkp4.setPrice3hr(5.0);
		pkp4.setPriceMax(12.0);
		parkingPriceRepo.save(pkp4);
		
		ParkingPrice pkp5 =new ParkingPrice();
		pkp5.setName("Aylmer and Mayor Street");
		pkp5.setPrice1hr(2.0);
		pkp5.setPrice3hr(5.0);
		pkp5.setPriceMax(12.0);
		parkingPriceRepo.save(pkp5);
		
		ParkingPrice pkp6 =new ParkingPrice();
		pkp6.setName("1250 Rene-Levesque -Lot#802");
		pkp6.setPrice1hr(2.0);
		pkp6.setPrice3hr(5.0);
		pkp6.setPriceMax(12.0);
		parkingPriceRepo.save(pkp6);
	}
}
