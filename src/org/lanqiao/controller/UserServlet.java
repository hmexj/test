package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.User;
import org.lanqiao.service.impl.PasswordAnswerServiceImpl;
import org.lanqiao.service.impl.UserServiceImpl;

@WebServlet(name = "userservlet", urlPatterns = { "/user.do" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getSession().getAttribute("code").toString().toLowerCase();
		String ucheckcode=request.getParameter("ucheckcode").toLowerCase();
		if(!code.equals(ucheckcode)){
			request.getRequestDispatcher("/WEB-INF/modifyuserinfo.jsp?").forward(request, response);
		}else{
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute("user");
			PasswordAnswer passwordanswer=(PasswordAnswer)session.getAttribute("passwordanswer");
			String upassword=request.getParameter("upassword");
			String usex=request.getParameter("usex");
			String utel=request.getParameter("utel");
			String uaddress=request.getParameter("uaddress");
			String aquestion=request.getParameter("uquestion");
			String answer=request.getParameter("answer");
			String email=request.getParameter("email");
			user.setUpassword(upassword);
			user.setUsex(usex);
			user.setUtel(utel);
			user.setUaddress(uaddress);
			passwordanswer.setAquestion(aquestion);
			passwordanswer.setAnswer(answer);
			passwordanswer.setEmail(email);
			org.lanqiao.service.UserService us=new org.lanqiao.service.impl.UserServiceImpl();
			org.lanqiao.service.PasswordAnswerService pa=new org.lanqiao.service.impl.PasswordAnswerServiceImpl();
			us.updateUser(user);
			pa.updatePasswordAnswer(passwordanswer);
			request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
