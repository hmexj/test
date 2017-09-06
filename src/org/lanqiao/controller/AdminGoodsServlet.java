package org.lanqiao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Category;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;

import com.google.gson.Gson;

@WebServlet(name = "admingoodsservlet", urlPatterns = { "/goodsservlet.do" })
public class AdminGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String pageindex = request.getParameter("pageIndex");
//		String pagesize=request.getParameter("pageSize");
		if(pageindex==null){
			pageindex="1";
		}
		if(cid==null){
			cid="1";
		}
		int pagesize=10;
		
		//根据cid找此类型 所有商品;....
		org.lanqiao.service.GoodsService gs =new org.lanqiao.service.impl.GoodsServiceImpl();
		PageInfo<Goods> pageinfo=  gs.goodsList(cid, pagesize,Integer.parseInt(pageindex));
		Gson gson=new Gson();
		response.getWriter().write(gson.toJson(pageinfo));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
