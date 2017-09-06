package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;

public class UserServiceImpl implements UserService {
	org.lanqiao.dao.UserDao dao=new org.lanqiao.dao.impl.UserDaoImpl();
	@Override
	public void insertUser(User user) {
		dao.insert(user);
	}
	@Override
	public User login(String loginid, String password) {
		User currentUser=dao.getUserByLoginid(loginid);
		User user=null;
		if(currentUser==null){
		return null;
		}
		if(currentUser!=null){
			if(currentUser.getUpassword().equals(password)){
				user=currentUser;
				return user;
			}
		 }
		return user;
	}
	@Override
	public User getUserByLoginId(String loginid) {
		return dao.getUserByLoginid(loginid);
	}
	@Override
	public void updateUser(User user) {
		dao.update(user);
	}
	@Override
	public User getUserByemail(String email) {
		return dao.getUserByemail(email);
	}
	@Override
	public List<User> listuser() {
		return dao.list();
	}
	@Override
	public void removeUser(String userid) {
		dao.remove(userid);
	}

}
