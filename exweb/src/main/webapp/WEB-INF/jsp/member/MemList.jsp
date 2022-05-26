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
		<!--jsp를 포함시키는 3가지 방법이 있다. -->
		<%-- <%@ include file="" %>
		<jsp:include page=""></jsp:include>
		<c:import url=""></c:import> --%>
		
		<!-- menu.jsp 포함 -->
		<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
		
		<h1>회원목록</h1>
		
		<a href='${pageContext.request.contextPath}/member/add.do'>회원추가</a><br>
		<a href='<c:url value="/member/add.do"/>'>회원추가</a><br>
		
		회원아이디 :회원이름 : 회원포인트<br>

		<c:forEach var="vo" items="${memList}">
		
		<!-- escapeXml="true"은 기본값이 트루이기 때문에 생략해도 된다. -->
		<!-- ${memPoin}는 정수형이기 떄문에 스크립트를 넣을수 없으므로 안씌워도 된다. -->
			<a href="${pageContext.request.contextPath}/member/edit.do?memId=${vo.memId}"><c:out value=" ${vo.memId}" escapeXml="true"/></a>
			 :<c:out value="${vo.memName}"/> 
			 : ${vo.memPoint}
			<!-- href 안의 memId는 속성값이기 때문에 스크립트가 실행되지 않음으로 c:out을 씌우지 않아도된다. -->
			<a href='${pageContext.request.contextPath}/member/del.do?memId=${vo.memId}'>삭제</a><br/>
			
		</c:forEach>

			
		</body>
		</html>
	

 