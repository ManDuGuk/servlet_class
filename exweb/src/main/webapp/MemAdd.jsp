<%@page import="com.exam.member.MemberVo"%>
<%@page import="com.exam.member.MemberDaoJdbc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!MemberDaoJdbc memberDao = new MemberDaoJdbc();%>


<%
request.setCharacterEncoding("UTF-8");
		MemberVo vo=new MemberVo();
		vo.setMemId(request.getParameter("memId"));
		vo.setMemPass(request.getParameter("memPass"));
		vo.setMemName(request.getParameter("memName"));
		vo.setMemPoint(Integer.parseInt(request.getParameter("memPoint")));
		int num = memberDao.insertMember(vo);
		
		response.sendRedirect(request.getContextPath()+"/MemberList.jsp");
%>		
		