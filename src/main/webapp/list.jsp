<%@page import="java.net.URLEncoder"%>
<%@page import="com.moonlit.model.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>文章列表</h3>
<table border="1" width="100%">
<tr>
  <th>编号</th>
  <th>标题</th>
  <th>内容</th>
</tr>
<% 
	List<Article> articles = (List<Article>) request.getAttribute("articles");
	if (articles != null) {
		for (Article article : articles) {
			int id = article.getId();
			String title = article.getTitle();
			String content = article.getContent();
			//String title = URLEncoder.encode(article.getTitle(), "utf-8");
			//String content = URLEncoder.encode(article.getContent(), "utf-8");
%>
  <tr>
    <td><%=id %></td>
    <td><%=title %></td>
    <td><%=content.substring(0, content.length() > 10 ? 10 : content.length()) %></td>
  </tr>
<% 	
		}
	}
%>
</table>
<a href="add.jsp">添加新文章</a><br>
<a href="generate.do">一键生成静态博客</a>
</body>
</html>