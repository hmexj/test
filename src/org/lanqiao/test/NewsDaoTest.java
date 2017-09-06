package org.lanqiao.test;

import java.util.List;

import org.junit.Test;
import org.lanqiao.dao.impl.NewsDaoImpl;
import org.lanqiao.entity.News;

public class NewsDaoTest {
	@Test
	public void testDao(){
		org.lanqiao.dao.impl.NewsDaoImpl dao = new NewsDaoImpl();
//		List<News> list =  dao.list();
//		System.out.println(list);
		dao.get("1");
	}
}
