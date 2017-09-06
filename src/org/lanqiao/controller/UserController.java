package org.lanqiao.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;

import com.google.gson.Gson;

@WebServlet(name = "usercontroller", urlPatterns = { "/usercontroller.do" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		org.lanqiao.service.UserService us=new org.lanqiao.service.impl.UserServiceImpl();
		String type=request.getParameter("type");
		if(type!=null&&type.equals("list")){
			List<User> list=us.listuser();
			Gson gson=new Gson();
			String ud=gson.toJson(list);
			response.getWriter().write(ud);
		}
		else if(type!=null&&type.equals("add")){
			String userid=UUID.randomUUID().toString();
			String uemail=request.getParameter("email");
			String uloginid=request.getParameter("loginid");
			String upassword=request.getParameter("upassword");
			String uaddress=request.getParameter("uaddress");
			String utel=request.getParameter("utel");
			String usex=request.getParameter("usex");
			String ustateid="B5868B7A06E54DAEB19658343D3A2B28";
			String uroleid="377D0AE90A804D289F301FB085A6E9AA";
			User user=new User(userid, uemail, uloginid, upassword, usex, uaddress, utel, ustateid, uroleid);
			us.insertUser(user);
			response.getWriter().write("1");
		}
		else if(type!=null&&type.equals("remove")){
			String userid=request.getParameter("userid");
			us.removeUser(userid);
			response.getWriter().write("1");
		}
		else if(type!=null&&type.equals("changepassword")){
			String upassword=request.getParameter("upassword");
			Cookie cookies[]=request.getCookies();
			for(Cookie cookie : cookies){
			    String uloginid=cookie.getValue();
			    User user=us.getUserByLoginId(uloginid);
			    user.setUpassword(upassword);
			    us.updateUser(user);
			    response.getWriter().write("1");
			}
			
		}
		else if(type!=null&&type.equals("update")){
			String email=request.getParameter("email");
			String loginid=request.getParameter("loginid");
			String upassword=request.getParameter("upassword");
			String uaddress=request.getParameter("uaddress");
			String utel=request.getParameter("utel");
			String usex=request.getParameter("usex");
			User user=us.getUserByLoginId(loginid);
			user.setEmail(email);
			user.setLoginid(loginid);
			user.setUpassword(upassword);
			user.setUaddress(uaddress);
			user.setUtel(utel);
			user.setUsex(usex);
			us.updateUser(user);
			response.getWriter().write("1");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
