<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>新建一篇文章</h1>
<form action="add.do" id="blogform" method="post">
标题：<input type="text" name="title" /><br>
内容：<br>
<textarea name="content" rows="30" cols="50"></textarea><br>
<input type="submit" value="新建" />
</form>
</body>
</html>