package com.airline.service;

import com.airline.vo.PlaneVO;
import com.airline.dao.PlaneDAO;

import java.util.ArrayList;

public class PlaneService {
	private static PlaneService planeservice = new PlaneService();
	public PlaneDAO planedao = PlaneDAO.getInstance();
	
	private PlaneService() {}
	public static PlaneService getInstance() {
		return planeservice;
	}
	
	public void setPlane(PlaneVO vo) {
		planedao.setPlane(vo);
	}
	
	public PlaneVO getPlane(String planeid) {
		return planedao.getPlane(planeid);
	}
	
	public void deletePlane(String planeid) {
		planedao.deletePlane(planeid);
	}
	public ArrayList<PlaneVO> getPlaneList(){
		ArrayList<PlaneVO>list=planedao.getPlaneList();
		return list;
	}

}
