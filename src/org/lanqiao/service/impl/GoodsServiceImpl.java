package org.lanqiao.service.impl;

import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	private org.lanqiao.dao.GoodsDao dao = null;
	public GoodsServiceImpl() {
		dao = new org.lanqiao.dao.impl.GoodsDaoImpl();
	}
	@Override
	public PageInfo<Goods> goodsList(String cid, int pagesize, int pageindex) {
		return dao.list(cid, pagesize, pageindex);
	}
	@Override
	public Goods getGoodsBygid(String gid) {
		return dao.get(gid);
	}

}
