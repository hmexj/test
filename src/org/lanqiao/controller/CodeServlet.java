package org.lanqiao.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "codeServlet", urlPatterns = { "/codeServlet.do" })
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		//创建一个随机数对象
		String codes="";
		Random rand=new Random();
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<4;i++){
		int index=rand.nextInt(61);
		builder.append(chars.charAt(index));
		}
		codes=builder.toString();
		//创建一个内存中的图片，在图片中写入验证字符
		//a.创建一个内存中的图片
		BufferedImage bufferedImage=new BufferedImage(100, 35, BufferedImage.TYPE_INT_RGB);
		//b.绘制图片
		//拿到一个画笔，绘制图片及图片内容
		Graphics gs=bufferedImage.getGraphics();
		//填充颜色
		gs.setColor(Color.white);
		gs.fillRect(0, 0, 100, 34);
		//画边框
		gs.setColor(Color.red);
		gs.drawRect(1, 1, 98, 42);
		//画笔的颜色
		gs.setColor(Color.red);
		gs.setFont(new Font("宋体", Font.BOLD, 20));
		//画验证字符
		gs.drawString(codes, 20, 20);
		request.getSession().setAttribute("code", codes);
		//输出图片
		response.setContentType("image/jpeg");
		ImageIO.write(bufferedImage,"jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
