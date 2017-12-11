package com.coen.parkit.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parkingPrice")
public class ParkingPrice {
	@Id private String ID;
	private String name;
	private double price1hr;
	private double price3hr;
	private double priceMax;
	
	public ParkingPrice(){
		
	}
	
	public ParkingPrice(String name, double price1hr, double price3hr, double priceMax){
		this.name=name;
		this.price1hr=price1hr;
		this.price3hr= price3hr;
		this.priceMax = priceMax;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice1hr() {
		return price1hr;
	}
	public void setPrice1hr(double price1hr) {
		this.price1hr = price1hr;
	}
	public double getPrice3hr() {
		return price3hr;
	}
	public void setPrice3hr(double price3hr) {
		this.price3hr = price3hr;
	}
	public double getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(double priceMax) {
		this.priceMax = priceMax;
	}
	
	

}
