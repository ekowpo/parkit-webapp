package com.coen.parkit.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.coen.parkit.model.DataOutput;
import com.coen.parkit.model.ParkingLot;
import com.coen.parkit.model.ParkingLotDistance;
import com.coen.parkit.repository.ParkingLotRepository;


@RestController
public class ParkingLotController {
	
	@Autowired
	ParkingLotRepository parkingLotRepository;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value="api/parkinglot")
	public Object parkinglot(@RequestParam("location") String location){
		List<ParkingLotDistance> distList = new ArrayList<>();
	
		
		try {
			System.out.println(parkingLotRepository.findAll());
			//JSONObject myResponseObj = new JSONObject(respond.toString());
			List<ParkingLot> parking= parkingLotRepository.findAll();
			StringBuilder destination = new StringBuilder();
				for(int i=0; i<parking.size();i++ )
				{
					destination.append(parking.get(i).getAddress());
					if(i<parking.size()-1)
					{
						destination.append(" | ");
						
					}
				}
			StringBuilder urlbuilding = new StringBuilder();
			urlbuilding.append("https://maps.googleapis.com/maps/api/distancematrix/json?origins=");
			urlbuilding.append((URLEncoder.encode(destination.toString(),"UTF-8").toString()));
			urlbuilding.append("&destinations=");
			urlbuilding.append(URLEncoder.encode(location,"UTF-8").toString());
			urlbuilding.append("&mode=walking");
			urlbuilding.append("&language=en-En");
			urlbuilding.append("&key=");
			urlbuilding.append("AIzaSyATDsY8UOwSIj52Jd1_mJxxMvw2DBAaWD4");
			System.out.println(urlbuilding.toString());
			
			URL url = new URL(urlbuilding.toString());
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			con.setDoOutput(true);
			//int responseCode = con.getResponseCode();
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), Charset.forName("UTF-8")));
			String inputLine;
			StringBuffer respond = new StringBuffer();
			while((inputLine = in.readLine())!=null){
				respond.append(inputLine);
			}
			in.close();
			System.out.println(respond.toString());
			JSONObject myResponseObj = new JSONObject(respond.toString());
			
			System.out.println("v: "+myResponseObj.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").getString("text"));
			for(int i=0; i<parking.size(); i++){
				
				ParkingLotDistance eachParkingDistance = new ParkingLotDistance();
				eachParkingDistance.setName(parking.get(i).getName());
				eachParkingDistance.setDistance(myResponseObj.getJSONArray("rows").getJSONObject(i).getJSONArray("elements").getJSONObject(0).getJSONObject("distance").getString("text"));
				eachParkingDistance.setMins(myResponseObj.getJSONArray("rows").getJSONObject(i).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").getString("text"));
				
			
				distList.add(eachParkingDistance);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		finally{
		return new DataOutput(distList);
		}
		
	}
	
	

	
}
