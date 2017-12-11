package com.coen.parkit.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;

@Document(collection = "reservation")
public class Reservation {
	
	@Id private String id;
	private String username;
	private String userId;
	private String parkinglotname;
	private String plan;
	private double amount;
	private String startTime;
	private String tansactionToken;
	
	
	public Reservation(){
		
	}
	
	public Reservation(String username,String userId, String parkinglotname,String plan,double amount,String startTime,String tansactionToken){
		
		this.username=username;
		this.userId = userId;
		this.parkinglotname =parkinglotname;
		this.plan = plan;
		this.amount = amount;
		this.startTime = startTime;
		this.tansactionToken= tansactionToken;
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getParkinglotname() {
		return parkinglotname;
	}
	public void setParkinglotname(String parkinglotname) {
		this.parkinglotname = parkinglotname;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@JsonIgnore
	public String getTansactionToken() {
		return tansactionToken;
	}
	public void setTansactionToken(String tansactionToken) {
		this.tansactionToken = tansactionToken;
	}
	
	
	
}
