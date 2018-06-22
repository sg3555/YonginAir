package com.airline.service;

import com.airline.dao.ProfitDAO;

public class ProfitService {
	private static ProfitService profitservice = new ProfitService();
	public ProfitDAO profitdao = ProfitDAO.getInstance();
	
	private ProfitService() {}
	public static ProfitService getInstance() {
		return profitservice;
	}
	
	public void setMoeny(int money) {
		profitdao.setMoney(money);
	}
	public int getMoney() {
		return profitdao.getMoney();
	}
}
