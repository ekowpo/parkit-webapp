package com.coen.parkit.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parkingLot")
public class ParkingLot {
	
	@Id private String id;
	private String name;
	private String address;
	
	public ParkingLot(){
		
	}
	
	public ParkingLot(String name, String address){
		this.name=name;
		this.address=address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
