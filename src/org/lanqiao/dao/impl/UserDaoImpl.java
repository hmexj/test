package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;
import org.lanqiao.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void insert(User user) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into t_users values(?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getLoginid());
			ps.setString(4, user.getUpassword());
			ps.setString(5, user.getUsex());
			ps.setString(6, user.getUaddress());
			ps.setString(7, user.getUtel());
			ps.setString(8, user.getUstateid());
			ps.setString(9, user.getUroleid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
					if(ps!=null)
					ps.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	@Override
	public User getUserByLoginid(String loginid) {
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建PreparedStatement对象;
			String sql="select * from t_users where loginid= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			//3执行操作
			rs = ps.executeQuery();
			//4取数据;
			if(rs.next()){
				user =new User(rs.getString("userid"), rs.getString("email"), rs.getString("loginid"), rs.getString("upassword"), rs.getString("usex"), rs.getString("uaddress"), rs.getString("utel"), rs.getString("ustateid"), rs.getString("uroleid"));
			}
		}catch(Exception e){
			
		}
		finally{
			//5关闭对象
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public void update(User user) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update t_users set email=?,loginid=?,upassword=?,usex=?,uaddress=?,utel=?,ustateid=?,uroleid=? where userid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getLoginid());
			ps.setString(3, user.getUpassword());
			ps.setString(4, user.getUsex());
			ps.setString(5, user.getUaddress());
			ps.setString(6, user.getUtel());
			ps.setString(7, user.getUstateid());
			ps.setString(8, user.getUroleid());
			ps.setString(9, user.getUserid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
					if(ps!=null)
					ps.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

	@Override
	public User getUserByemail(String email) {
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建PreparedStatement对象;
			String sql="select * from t_users where email= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			//3执行操作
			rs = ps.executeQuery();
			//4取数据;
			if(rs.next()){
				user =new User(rs.getString("userid"), rs.getString("email"), rs.getString("loginid"), rs.getString("upassword"), rs.getString("usex"), rs.getString("uaddress"), rs.getString("utel"), rs.getString("ustateid"), rs.getString("uroleid"));
			}
		}catch(Exception e){
			
		}
		finally{
			//5关闭对象
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public List<User> list() {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="select * from t_users";
			ps = conn.prepareStatement(sql);
			//3执行操作
			rs = ps.executeQuery();
			//4取数据;
			while(rs.next()){
				User user=new User(rs.getString("userid"),rs.getString("email"),rs.getString("loginid"),rs.getString("upassword"),rs.getString("usex"),rs.getString("uaddress"),rs.getString("utel"),rs.getString("ustateid"),rs.getString("uroleid"));
				list.add(user);
			}
		}catch(Exception e){
			
		}
		finally{
			//5关闭对象
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void remove(String userid) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from t_users where userid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
					if(ps!=null)
					ps.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
