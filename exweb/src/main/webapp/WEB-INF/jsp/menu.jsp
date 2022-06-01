<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<!-- sessionScope를 생략해도 가능하다. -->
	<!-- Scope 영역은 순환하면서 순차적으로 검색해오기 때문에 생략가능하다. -->
	<!-- 로그인 서블릿에서 세션에 저장한 자료를 가져온다. session.setAttribute("loginUser", memVo);-->
		<c:if test="${sessionScope.loginUser==null}">
			<a href="${pageContext.request.contextPath}/member/login.do">로그인</a> |
			<a href="${pageContext.request.contextPath}/member/add.do">회원가입</a>
		</c:if>
		
		<c:if test="${sessionScope.loginUser!=null}">
			<c:out value="${sessionScope.loginUser.memName}"/>님
		<a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
		</c:if>
		<hr/>
	</div>
</body>
</html>