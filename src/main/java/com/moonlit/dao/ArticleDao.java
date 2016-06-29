package com.moonlit.dao;

import java.util.List;
import java.beans.Transient;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	@Transient
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
}
