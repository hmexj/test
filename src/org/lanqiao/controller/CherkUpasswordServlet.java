package org.lanqiao.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cherkupasswordservlet", urlPatterns = { "/checkupassword.do" })
public class CherkUpasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upassword=request.getParameter("upassword");
		if(upassword==""){
			response.getWriter().write("0");
		}else{
		if(upassword.length()<6){
			response.getWriter().write("1");
		}else{
			if(upassword.matches("^\\d+$")||upassword.matches("^[a-zA-Z]+$")){
				response.getWriter().write("2");
			}
			else if(upassword.matches("^\\d+[a-zA-Z]+$")){
				response.getWriter().write("3");
			}
			else {if(upassword.matches("(?=(?:.*?\\d){2})(?=.*[a-z])(?=.*[A-Z])(?=(?:.*?[!@#$%*()_+^&}{:;?.]){1})(?!.*\\s)[0-9a-zA-Z!@#$%*()_+^&]*$")){
				response.getWriter().write("4");}
			}
		}
	}
		//else if()
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
