<%@page import="org.lanqiao.entity.Cart"%>
<%@page import="org.lanqiao.util.CartUtil"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.lanqiao.entity.CookieItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%!
	//从购物车(cookie)中取出所有商品;
	private List<CookieItem> getItems(HttpServletRequest request){
		Cookie[] cookies=request.getCookies(); //拿到本机器，本域名下所有cookie;
		if(cookies==null) return null;
		Cookie cart = null;
		for(Cookie c : cookies){
			if(c.getName().equals("cart")){
				cart = c;
			}
		}
		if(cart ==null){ //说明购物车没有商品
			return null;
		}
		String json =  cart.getValue(); //json格式商品数据
		Gson gson = new Gson();
		TypeToken<List<CookieItem>> listType = new TypeToken<List<CookieItem>>() { //指定集合元素类型;
        };
		List<CookieItem> list = gson.fromJson(json, listType.getType());
		return list;
	}
%>
<%
	List<CookieItem> list = this.getItems(request);
	List<Cart> cart = CartUtil.convertCookieItemListToCartList(list);
	request.setAttribute("cart", cart);
%>