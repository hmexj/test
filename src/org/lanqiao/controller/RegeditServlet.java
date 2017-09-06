package org.lanqiao.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.User;

@WebServlet(name = "regeditservlet", urlPatterns = { "/regedit.do" })
public class RegeditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getSession().getAttribute("code").toString().toLowerCase();
		String ucheckcode=request.getParameter("ucheckcode").toLowerCase();
		if(!code.equals(ucheckcode)){
			request.getRequestDispatcher("/WEB-INF/regedit.jsp?").forward(request, response);
		}
		String uemail=request.getParameter("uemail");
		String uloginid=request.getParameter("uloginid");
		String upassword=request.getParameter("upassword");
		String usex=request.getParameter("usex");
		String utel=request.getParameter("utel");
		String uaddress=request.getParameter("uaddress");
		String userid=UUID.randomUUID().toString();
		String ustateid="B5868B7A06E54DAEB19658343D3A2B28";
		String uroleid="377D0AE90A804D289F301FB085A6E9AA";
		User user=new User(userid, uemail, uloginid, upassword, usex, uaddress, utel, ustateid, uroleid);
		org.lanqiao.service.UserService us=new org.lanqiao.service.impl.UserServiceImpl();
		us.insertUser(user);
		
		String aquestion=request.getParameter("aquestion");
		String answer=request.getParameter("answer");
		String email=request.getParameter("ubackupemail");
		String answerid=UUID.randomUUID().toString();
		org.lanqiao.service.PasswordAnswerService pas=new org.lanqiao.service.impl.PasswordAnswerServiceImpl();
		PasswordAnswer passwordanswer=new PasswordAnswer(answerid, aquestion, answer, email, userid);
		pas.insertPasswordAnswer(passwordanswer);
		request.getRequestDispatcher("/WEB-INF/regeditsuccess.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
