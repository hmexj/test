package org.lanqiao.service.impl;

import org.lanqiao.entity.OrderDetail;
import org.lanqiao.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {
	private org.lanqiao.dao.OrderDetailDao dao = new org.lanqiao.dao.impl.OrderDetaiDaoImpl();
	@Override
	public void insertOrderDetail(OrderDetail detail) {
		dao.insert(detail);
	}

}
