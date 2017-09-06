package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.User;

public interface UserService {
	public void insertUser(User user);
	public User login(String loginid,String password);
	public User getUserByLoginId(String loginid);
	public void updateUser(User user);
	public User getUserByemail(String email);
	public List<User> listuser();
	public void removeUser(String userid);
}
