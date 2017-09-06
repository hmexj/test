package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.lanqiao.dao.OrderDetailDao;
import org.lanqiao.entity.OrderDetail;
import org.lanqiao.util.DBUtil;

public class OrderDetaiDaoImpl implements OrderDetailDao {

	@Override
	public void insert(OrderDetail detail) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			//1拿到连接
			conn = DBUtil.getConnection();
			//2创建PreparedStatement对象;
			String sql="insert into t_orderdetail values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, detail.getOrderdetailid());
			ps.setString(2, detail.getGtitle());
			ps.setDouble(3, detail.getGsalprice());
			ps.setInt(4, detail.getGnumber());
			ps.setString(5, detail.getOrderid());
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
