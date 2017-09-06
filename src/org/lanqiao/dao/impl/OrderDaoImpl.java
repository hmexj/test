package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.lanqiao.dao.OrderDao;
import org.lanqiao.entity.Order;
import org.lanqiao.util.DBUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void insert(Order order) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1拿到连接
			conn = DBUtil.getConnection();
			//2创建PreparedStatement对象;
			String sql="insert into t_order values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, order.getOrderid());
			ps.setString(2, order.getGid());
			ps.setString(3, order.getUserid());
			ps.setDouble(4, order.getTotalprice());
			
			java.sql.Date sqlDate = new Date(order.getOrderdate().getTime());
			ps.setDate(5, sqlDate);
			//3执行操作;
			ps.executeUpdate();
		}catch(Exception e){}
		finally{
			//5关闭对象
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
