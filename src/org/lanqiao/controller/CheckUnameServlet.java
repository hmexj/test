package org.lanqiao.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;
import org.lanqiao.service.impl.UserServiceImpl;


@WebServlet(name = "checkunameservlet", urlPatterns = { "/check.do" })
public class CheckUnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uloginid=request.getParameter("uname");
		if(uloginid==""){
			response.getWriter().write("0");
		}else{
		org.lanqiao.service.UserService us=new org.lanqiao.service.impl.UserServiceImpl();
		User user=us.getUserByLoginId(uloginid);
		if(user!=null){
			response.getWriter().write("1");
		}
		if(user==null){
			response.getWriter().write("2");
		}
	}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
