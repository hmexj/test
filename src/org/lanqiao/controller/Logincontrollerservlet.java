package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;

@WebServlet(name = "logincontrollerservlet", urlPatterns = { "/logincontroller.do" })
public class Logincontrollerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uloginid=request.getParameter("uloginid");
		String upassword=request.getParameter("upassword");
		org.lanqiao.service.UserService us=new org.lanqiao.service.impl.UserServiceImpl();
		User user=us.login(uloginid,upassword);
		if(user!=null){
				Cookie cookie=new Cookie("uloginid", uloginid);
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
				response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
