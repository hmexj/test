package org.lanqiao.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.lanqiao.entity.User;

public class Usertest {
	@Test
	public void listtest(){
		org.lanqiao.service.UserService us=new org.lanqiao.service.impl.UserServiceImpl();
		List<User> list=new ArrayList<User>();
		list=us.listuser();
		System.out.println(list);
	}
}
