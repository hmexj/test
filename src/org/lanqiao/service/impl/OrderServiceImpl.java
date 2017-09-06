package org.lanqiao.service.impl;

import org.lanqiao.entity.Order;
import org.lanqiao.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private org.lanqiao.dao.OrderDao dao = new org.lanqiao.dao.impl.OrderDaoImpl();
	@Override
	public void insertOrder(Order order) {
		dao.insert(order);
	}

}
