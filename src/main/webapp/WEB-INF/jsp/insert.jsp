<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	등록하기	
	<form action="/insert.do" method="post" enctype="multipart/form-data">
		제목 : <input type="text" id="title" name="title"> <br>
		작가 : <input type="text" id="writer" name="writer"> <br>
		내용 : <input type="text" id="contents" name="contents"> <br>
		<input type="file" id="file" name="file"/> <br>
		<button type="submit">글쓰기</button>
	</form>

</body>
</html>