<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/update.do?id=${data.id }" method="post">
	제목 : <input type="text" id ="title" name="title" value="${data.title}"> <br>
	저자 : <input type="text" id ="writer" name ="writer" value="${data.writer}"> <br>
	내용 : <input type="text" id ="contents" name ="contents" value="${data.contents}"> <br>
	<button type="submit">수정하기</button>
	</form>
</body>

</html>