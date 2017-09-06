package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.User;

public interface UserDao {
	public void insert(User user);
	public User getUserByLoginid(String loginid);
	public void update(User user);
	public User getUserByemail(String email);
	public List<User> list();
	public void remove(String userid);
}
