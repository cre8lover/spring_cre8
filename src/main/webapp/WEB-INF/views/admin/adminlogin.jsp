<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/adminlogin.css">
<title>관리자 로그인</title>
</head>
<body>
	<div class="khm_adminloginbox">
		<img src="<%= request.getContextPath() %>/img/cre8.png" style="margin-top:2.5%">
		<h1 style = "color:white"> 관리자 페이지 </h1>
		<form method="post" action="<%= request.getContextPath() %>/master/adminMain">
			<table class="khm_adminlogin">
				<tr>
					<td>
						<input name="id" id="id" type="text" placeholder="ID">
					</td>
					<td rowspan="2">
						<input type="submit" value="로그인">
					</td>
				</tr>
				<tr>
					<td>
						<input name="pw" id="pw" type="password" placeholder="PW">
					</td>
				</tr>
			</table>
			
			<c:set value="${err2 }" var="err" /> 
				<c:if test="${err != null }">
					<p style="color:red">${err} </p>
				</c:if>
		</form>			
	</div>
</body>
</html>