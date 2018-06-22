package com.airline.service;

import com.airline.vo.UserVO;
import com.airline.dao.UserDAO;

import java.util.ArrayList;

public class UserService {
	private static UserService userservice = new UserService();
	public UserDAO userdao = UserDAO.getInstance();
	
	private UserService() {}
	public static UserService getInstance() {
		return userservice;
	}
	
	public void setUser(UserVO vo) {
		userdao.setUser(vo);
	}
	
	public UserVO getUser(String id) {
		return userdao.getUser(id);
	}
	
	public void updateUserPw(String id, String pw) {
		userdao.updateUserPw(id,pw);
	}
	public void updateUserName(String id, String name) {
		userdao.updateUserName(id,name);
	}
	public void updateUserMail(String id, String mail) {
		userdao.updateUserMail(id,mail);
	}
	public void updateUserNation(String id, String nation) {
		userdao.updateUserNation(id,nation);
	}
	public void updateUserMoney(String id, int money) {
		userdao.updateUserMoney(id,money);
	}
	
	public void deleteUser(String id) {
		userdao.deleteUser(id);
	}
	
	public ArrayList<UserVO> getUserList(){
		ArrayList<UserVO>list=userdao.getUserList();
		return list;
	}

}
