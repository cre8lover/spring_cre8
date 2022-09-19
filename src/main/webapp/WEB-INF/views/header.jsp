<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/sidebar.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/header.css">
	<div class="header" >
		<div class="logo">
		<a href="<%= request.getContextPath() %>/mainpage">
		<img src="<%= request.getContextPath() %>/img/logo.png" alt="index.html" style="float:left; height:95px; top:5px;  margin-left: 18%; ">
		</a>
		</div>
		
		<c:set value="${sess_id}" var="login" />
		<div class="dd">
			<c:if test="${login == null}" >
				<a href="<%= request.getContextPath() %>/buyer/cart">&nbsp;|&nbsp;장바구니</a>
				<a href="<%= request.getContextPath() %>/mem/memreg">&nbsp;|&nbsp;회원가입</a>
				<a href="<%= request.getContextPath() %>/mem/loginpage">로그인&nbsp;</a>
				
			</c:if>
			
			<c:if test="${login != null}" >
				<a href="<%= request.getContextPath() %>/buyer/cart">&nbsp;|&nbsp;장바구니</a>
				<a href="<%= request.getContextPath() %>/mem/mypage">&nbsp;|&nbsp;마이페이지</a>
				<a href="<%= request.getContextPath() %>/mem/loginout">로그아웃&nbsp;</a>
			</c:if>
		</div>  
		<div class="search">
			<fieldset class="field-container">
			  <input type="text" placeholder="Search..." class="field" />
			  <div class="icons-container">
			  <div class="icon-search"></div>
			  <div class="icon-close">
				  <div class="x-up"></div>
				  <div class="x-down"></div>
			  </div>
			  </div>
			</fieldset>
		</div>
		
		<br>
	</div>

</html>