<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	순번 : ${data.id} <br>
	제목 : ${data.title} <br>
	작가 : ${data.writer} <br>
	내용 : ${data.contents} <br>
	날짜 : ${data.dt} <br>
	시간 : ${data.tm} <br>
	조회수 : ${data.cnt} <br>
	<c:if test="${data.fName ne null}">
		<img src="/file/${data.fName}" width="500" height="500"/><br>
	</c:if>

	<input type="button" value="수정하기" onclick="location.href='/updatePage.do?id=${data.id}'">
	<input type="button" value="삭제하기" onclick="location.href='/delete.do?id=${data.id}'">	
</body>
</html>