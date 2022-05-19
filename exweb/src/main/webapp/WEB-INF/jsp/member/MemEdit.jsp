<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset='UTF-8'>
		
		<title>Insert title here</title>
		</head>
		<body>
		<h1>회원변경</h1>
		
	
		<form action='${pageContext.request.contextPath}/member/edit.do' method='post'>
		회원 아이디:<input type='text' name ='memId' value='${requestScope.memVO.memId}' readonly="readonly"> <br>
		회원 비밀번호:<input type='password' name ='memPass' value='${requestScope.memVO.memPass}'> <br>
		회원 이름:<input type='text' name ='memName' value='${requestScope.memVO.memName}'> <br>
		회원 포인트:<input type='text' name ='memPoint' value='${requestScope.memVO.memPoint}'> <br>
		<input type='submit'>
		</form>
		
		
		</body>
		</html>