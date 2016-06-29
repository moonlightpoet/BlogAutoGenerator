package com.moonlit.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.moonlit.model.Article;
import com.moonlit.service.ArticleService;

@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// do nothing here
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//title = URLEncoder.encode(title, "utf-8");
		//content = URLEncoder.encode(content, "utf-8");
		
		Article article = new Article();
		article.setTitle(title);
		article.setContent(content);
		ArticleService.create(article);
		
		req.getRequestDispatcher("/finishadd.jsp").forward(req, resp);
	}
}
