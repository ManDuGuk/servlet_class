<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset='UTF-8'>
		
		<title>Insert title here</title>
		</head>
		<body>
		<h1>학생변경</h1>
		
	
		<form action='${pageContext.request.contextPath}/student/edit.do' method='post'>
		학생 번호:<input type='text' name ='memId' value='${requestScope.memVO.memId}' readonly="readonly"> <br>
		학생 이름:<input type='text' name ='memName' value='${requestScope.memVO.memName}'> <br>
		학생 포인트:<input type='text' name ='memPoint' value='${requestScope.memVO.memPoint}'> <br>
		<input type='submit'>
		</form>
		
		
		</body>
		</html>