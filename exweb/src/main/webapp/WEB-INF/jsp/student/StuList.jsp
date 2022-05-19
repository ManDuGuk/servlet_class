<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		
		<title>Insert title here</title>
		</head>
		<body>
		<h1>학생목록</h1>
		
		<a href='${pageContext.request.contextPath}/stu/addform.do'>학생추가</a><br>
		
		
		학생번호: 학생이름 :학생포인트<br>

		<c:forEach var="vo" items="${stuList}">
		
			${vo.memId} : ${vo.memName} : ${vo.memPoint}
			<a href='${pageContext.request.contextPath}/stu/del.do?memId=${vo.memId}'>삭제</a>
			<a href='${pageContext.request.contextPath}/stu/update.do?memName=${vo.memName}'>수정</a><br/>
		</c:forEach>

			
		</body>
		</html>