package org.lanqiao.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.User;

@WebServlet(name = "checkuemailservlet", urlPatterns = { "/checkuemail.do" })
public class CheckUemailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail=request.getParameter("uemail");
		if(uemail==""){
			response.getWriter().write("0");
		}else{
			Pattern pattern = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
			if(pattern.matcher(uemail).matches()==false){
				    response.getWriter().write("3");
			}else{
				org.lanqiao.service.UserService us=new org.lanqiao.service.impl.UserServiceImpl();
				User user=us.getUserByemail(uemail);
				if(user!=null){
					response.getWriter().write("1");
				}
				if(user==null){
					response.getWriter().write("2");
				}
			}
	}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
