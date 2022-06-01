<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset='UTF-8'>
		
		<title>Insert title here</title>
		</head>
		<body>
		<!-- menu.jsp 포함 -->
		<jsp:include page="/WEB-INF/jsp/menu2.jsp"/>
		
		
		<h1>로그인</h1>
		
	
		<form action='${pageContext.request.contextPath}/student/login.do' method='post'>
		학생 아이디:<input type='text' name ='memId'> <br>
		학생 이름:<input type='text' name ='memName'> <br>
	
		<input type='submit'>
		</form>
		
		
		</body>
		</html>