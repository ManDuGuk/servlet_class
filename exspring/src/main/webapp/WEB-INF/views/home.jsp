

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  modelVal에 저장한값: ${modelVal}</P>
<P>  modelmapVal에 저장한값: ${modelMapVal}</P>
<P>  mapVal에 저장한값: ${mapVal}</P>

<P>  @ModelAttribute로 저장한값: ${mv.myId}, ${mv.myName}</P>

 //MyVo vo//사용자가 정의한 클래스타입인 경우,객체의 속성(멤버변수)명과 동일한 이름의 파라미터값을 자동 저장
 //@ModelAttribute를 생략하면 ,클래스명의 첫글자만 소문자로 변경한 이름으로 모델에 저장
<P>  @ModelAttribute를 생략한값: ${myVo.myId}, ${myVo.myName}</P>

model.addAttribute("modelVal", "너부리" );
modelMap.addAttribute("modelMapVal", "포로리");
map.put("mapVal", "보노보노");


</body>
</html>
