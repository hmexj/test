package org.lanqiao.controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.dao.impl.PasswordAnswerDaoImpl;
import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.User;
import org.lanqiao.service.impl.UserServiceImpl;

@WebServlet(name = "loginservlet", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uloginid=request.getParameter("uname");
		String upassword=request.getParameter("upassword");
		if(uloginid==""||upassword==""){
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else{
		org.lanqiao.service.UserService us=new org.lanqiao.service.impl.UserServiceImpl();
		org.lanqiao.dao.PasswordAnswerDao pa=new org.lanqiao.dao.impl.PasswordAnswerDaoImpl();
		User user=us.login(uloginid, upassword);
		if(user!=null){
			String userid=user.getUserid();
			PasswordAnswer passwordanswer=pa.get(userid);
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("passwordanswer", passwordanswer);
			String chk=request.getParameter("chk");
			if(chk!=null){
				Cookie cookie=new Cookie("uloginid", uloginid);
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			}
		}
			
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
