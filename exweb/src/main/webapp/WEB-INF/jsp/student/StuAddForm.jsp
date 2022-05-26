<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset='UTF-8'>
		
		<title>Insert title here</title>
		</head>
		<body>
		<h1>학생추가</h1>
		
	
		<form action='${pageContext.request.contextPath}/student/add.do' method='post'>
		학생 번호:<input type='text' name ='memId'> <br>
		학생 이름:<input type='text' name ='memName'> <br>
		회원 포인트:<input type='text' name ='memPoint'> <br>
		<input type='submit'>
		</form>
		
		
		</body>
		</html>
