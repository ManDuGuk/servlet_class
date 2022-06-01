<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		
		<title>Insert title here</title>
		</head>
		<body>
		
		<jsp:include page="/WEB-INF/jsp/menu2.jsp"/>
		
		<h1>학생목록</h1>
		
		<a href='${pageContext.request.contextPath}/student/add.do'>학생추가</a><br>
		
		
		학생번호: 학생이름 :학생포인트<br>

		<c:forEach var="vo" items="${stuList}">
		
			<a href="${pageContext.request.contextPath}/student/edit.do?memId=${vo.memId}"><c:out value=" ${vo.memId}" escapeXml="true"/></a>
			: ${vo.memName} : ${vo.memPoint}
			
			<a href='${pageContext.request.contextPath}/student/del.do?memId=${vo.memId}'>삭제</a>
			<br/>
		</c:forEach>

			
		</body>
		</html>