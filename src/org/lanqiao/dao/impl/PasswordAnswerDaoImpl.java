package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.dao.PasswordAnswerDao;
import org.lanqiao.entity.Category;
import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.util.DBUtil;

public class PasswordAnswerDaoImpl implements PasswordAnswerDao {

	@Override
	public void insert(PasswordAnswer passwordAnswer) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into t_passwordanswer values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, passwordAnswer.getAnswerid());
			ps.setString(2, passwordAnswer.getAquestion());
			ps.setString(3, passwordAnswer.getAnswer());
			ps.setString(4, passwordAnswer.getEmail());
			ps.setString(5, passwordAnswer.getUserid());
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
	public void update(PasswordAnswer passwordAnswer) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update t_passwordanswer set aquestion=?,answer=?,email=?,userid=? where anwerid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, passwordAnswer.getAquestion());
			ps.setString(2, passwordAnswer.getAnswer());
			ps.setString(3, passwordAnswer.getEmail());
			ps.setString(4, passwordAnswer.getUserid());
			ps.setString(5, passwordAnswer.getAnswerid());
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
	public PasswordAnswer get(String userid) {
		PasswordAnswer passwordanswer = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1获取连接
			conn = DBUtil.getConnection();
			//2通过连接创建preparedstatement对象;
			String sql="select * from t_passwordanswer where userid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			//3执行操作
			rs = ps.executeQuery();
			//4取数据;
			if(rs.next()){
				passwordanswer=new PasswordAnswer(rs.getString("anwerid"), rs.getString("aquestion"), rs.getString("answer"), rs.getString("email"), rs.getString("userid"));
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
		return passwordanswer;
	}

}
