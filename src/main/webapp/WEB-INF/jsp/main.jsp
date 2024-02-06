<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript" src="/js/main.js"></script>

<script type="text/javascript" src="https://uicdn.toast.com/tui.pagination/v3.4.0/tui-pagination.js"></script>
<link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>

<link rel="stylesheet" href="https://uicdn.toast.com/chart/latest/toastui-chart.min.css" />
<script src="https://uicdn.toast.com/chart/latest/toastui-chart.min.js"></script>

</head>

<body>
board List
<input type="button" value="그래프" onclick="location.href='/chart.do'"/>
<%-- 	<table border="1">
	<thead>
		<tr>
			<th>순번</th>
			<th>제목</th>
			<th>작가</th>
			<th>내용</th>
			<th>날짜</th>
			<th>시간</th>
			<th>조회수</th>
		</tr>
		</thead>
		<tbody id="tb"></tbody>
 		<c:forEach var="item" items="${data}">
			<tr>
				<td><a href="detail.do?id=${item.id}">${item.id}</a></td>
				<td>${item.title}</td>
				<td>${item.writer}</td>
				<td>${item.contents}</td>
				<td>${item.dt}</td>
				<td>${item.tm}</td>
				<td>${item.cnt}</td>
			</tr>
		</c:forEach>
	</table> --%>
	<div id="grid"></div>
	<div id="pageNum"></div>
	<input type="button" value="글쓰기" onclick="location.href='insertPage.do'">
	<div id="chart"></div>
</body>