package com.moonlit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.moonlit.model.Article;

public class ArticleDao extends JdbcDaoSupport {
	class ArticleRowMapper implements RowMapper<Article> {
		public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
			Article article = new Article();
			article.setId(rs.getInt("id"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
			return article;
		}
	}
	public List<Article> queryAll() {
		return getJdbcTemplate().query("select * from blog", new ArticleRowMapper());
	}
	public void create(Article article) {
		getJdbcTemplate().update("insert into blog (title,content) values (?,?)",
				new Object[] { article.getTitle(), article.getContent() });
	}
	public void update(Article article) {
		getJdbcTemplate().update("update blog set title=?,content=? where id=?",
				new Object[] { article.getTitle(), article.getContent(), article.getId() });
	}
	public void delete(int id) {
		getJdbcTemplate().update("delete from blog where id=?", new Object[] { id });
	}
	public void deleteAll() {
		getJdbcTemplate().update("delete from blog");
	}
	
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/article_db";
    private static String userName = "root";
    private static String password = "password";
    private static Connection conn = null;
    private static Statement stmt = null;
	
	// spring JDBC met some trouble, change to normal JDBC method for a try
	public List<Article> queryAll_normal_jdbc() {
		List<Article> articleList = new ArrayList<Article>();
		try {
            Class.forName(driver);
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        }
        try {
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("connect database successful");
            stmt = conn.createStatement();
            String sql = "select * from blog";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	int id = rs.getInt("id");
            	String title = rs.getString("title");
            	String content = rs.getString("content");
            	Article article = new Article();
            	article.setId(id);
            	article.setTitle(title);
            	article.setContent(content);
            	articleList.add(article);
            }
        } catch (SQLException e) {
            System.out.println("SQLException异常"+e.getMessage());
            e.printStackTrace();
        }
		return articleList;
	}
}
