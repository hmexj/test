package org.lanqiao.service;

import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;

public interface GoodsService {
	public PageInfo<Goods> goodsList(String cid,int pagesize,int pageindex);
	public Goods getGoodsBygid(String gid);
}
