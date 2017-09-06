package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.News;
import org.lanqiao.entity.PasswordAnswer;
import org.lanqiao.entity.User;
import org.lanqiao.service.impl.PasswordAnswerServiceImpl;
@WebServlet(name = "dispacher", urlPatterns = { "/dispacher.do" })
public class DispacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String cid=request.getParameter("cid");
		if(type!=null && type.equals("news") && id!=null){
			//根据id取新闻的信息.....
			org.lanqiao.service.NewsService ns = new org.lanqiao.service.impl.NewsServiceImpl();
			News news = ns.getNewsById(id);
			System.out.println(news);
			request.setAttribute("news", news);
			request.getRequestDispatcher("/WEB-INF/title.jsp").forward(request, response);
		}
		else if(type!=null && type.equals("goods") && id!=null){
			//根据id取新闻的信息.....
			org.lanqiao.service.GoodsService gs= new org.lanqiao.service.impl.GoodsServiceImpl();
			Goods goods = gs.getGoodsBygid(id);
			request.setAttribute("goods", goods);
			org.lanqiao.service.CategoryService cs=new org.lanqiao.service.impl.CategoryServiceImpl();
			Category category=cs.getcategory(cid);
			request.setAttribute("category", category);
			request.getRequestDispatcher("/WEB-INF/detail.jsp").forward(request, response);
		}
		else if(type!=null&&type.equals("reg")){
			request.getRequestDispatcher("/WEB-INF/regedit.jsp").forward(request, response);
		}else if(type!=null&&type.equals("loginsuccess")){
			//判断有cookie;
			Cookie[] cookies = request.getCookies();
			Cookie userCookie = null;
			for(Cookie c:cookies){
				if(c.getName().equals("uloginid")){
					userCookie = c;
					break;
				}
			}
			if(userCookie!=null){
				String uloginid = userCookie.getValue();
				//根据帐号找此用户;
				org.lanqiao.service.UserService us =new org.lanqiao.service.impl.UserServiceImpl();
				org.lanqiao.service.PasswordAnswerService pa=new org.lanqiao.service.impl.PasswordAnswerServiceImpl();
				User user =us.getUserByLoginId(uloginid);
				String userid=user.getUserid();
				PasswordAnswer passwordanswer=pa.getpasswordanswer(userid);
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("passwordanswer", passwordanswer);
			}else{
			request.getSession().invalidate();
			}
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else if(type!=null && type.equals("final") ){
			request.getRequestDispatcher("/WEB-INF/my.jsp").forward(request, response);
		}else if(type!=null && type.equals("modify") ){
			request.getRequestDispatcher("/WEB-INF/modifyuserinfo.jsp").forward(request, response);
		}else if(type!=null && type.equals("cart")){
			request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
		}else if(type!=null && type.equals("order")){
			request.getRequestDispatcher("/WEB-INF/order.jsp").forward(request, response);
		}else if(type!=null && type.equals("orderfinal")){
			request.getRequestDispatcher("/WEB-INF/orderfinal.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
