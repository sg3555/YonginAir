package com.airline.service;

import com.airline.vo.AirportVO;
import com.airline.dao.AirportDAO;

import java.util.ArrayList;

public class AirportService {
	private static AirportService airportservice = new AirportService();
	public AirportDAO airportdao = AirportDAO.getInstance();
	
	private AirportService() {}
	public static AirportService getInstance() {
		return airportservice;
	}
	
	public void setAirport(AirportVO vo) {
		airportdao.setAirport(vo);
	}
	
	public void updateAirportWeather(String airportid, String weather) {
		airportdao.updateAirportWeather(airportid, weather);
	}
	
	public void deleteAirport(String airportid) {
		airportdao.deleteAirport(airportid);
	}
	
	public ArrayList<AirportVO> getAirportList(){
		return airportdao.getAirportList();
	}
	
	public String getAirportName(String airportid) {
		return airportdao.getAirportName(airportid);
	}
	public String getAirportNation(String airportid) {
		return airportdao.getAirportNation(airportid);
	}

}
