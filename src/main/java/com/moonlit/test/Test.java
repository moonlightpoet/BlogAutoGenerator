package com.moonlit.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moonlit.dao.ArticleDao;
import com.moonlit.model.Article;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        ArticleDao articleDao = (ArticleDao) context.getBean("jdbcTemplateArticleDao");
        Article article = new Article();
        for (int i = 1; i <= 3; i ++) {
        	article.setTitle("title " + i);
        	article.setContent("this is content " + i);
        	articleDao.create(article);
        }
        List<Article> articleList = articleDao.queryAll();
        for (Article a : articleList)
        	System.out.println(a);
	}
}
