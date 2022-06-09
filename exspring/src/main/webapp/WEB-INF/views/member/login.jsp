<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset='UTF-8'>
		
		<title>Insert title here</title>
		</head>
		<body>
		<!-- menu.jsp 포함 -->
		<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
		
		
		<h1>로그인</h1>
		
	
		<form action='${pageContext.request.contextPath}/member/login.do' method='post'>
		회원 아이디:<input type='text' name ='memId'> <br>
		회원 비밀번호:<input type='password' name ='memPass'> <br>
	
		<input type='submit'>
		</form>
		
		
		</body>
		</html>