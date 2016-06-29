package com.moonlit.service;

import java.beans.Transient;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moonlit.dao.ArticleDao;
import com.moonlit.model.Article;

public class ArticleService {
	@Transient
	public static List<Article> queryAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
	    ArticleDao articleDao = (ArticleDao) context.getBean("jdbcTemplateArticleDao");
	    List<Article> articles = articleDao.queryAll();
		return articles;
	}
	public static void main(String[] args) {
		List<Article> list = queryAll();
		for (Article article : list) {
			System.out.println(article);
		}
	}
}
