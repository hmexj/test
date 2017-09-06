package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.Goods;

public interface CategoryDao {
	public List<Category> list();
	public Category get(String cid);
}
