<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<body>
    
<div class="khm_header">
 	<img src="<%= request.getContextPath() %>/img/cre8.png">
	<h2 style="color:white">관리자모드</h2>
</div>

<div class="khm_topnav">
  <a href="<%= request.getContextPath() %>/mem/mainpage">쇼핑몰</a>
  <a href="<%= request.getContextPath() %>/master/category">메뉴 카테고리 관리</a>
  <a href="<%= request.getContextPath() %>/master/member">회원 관리</a>
<%--   <a href="<%= request.getContextPath() %>/master/item">물품 관리</a> --%>
  <a href="<%= request.getContextPath() %>/master/creAd">마케팅 관리</a>
  <a href="<%= request.getContextPath() %>/master/adCheck">광고주문 내역확인</a>
  <a href="<%= request.getContextPath() %>/master/logout" style="float:right">로그아웃</a>
</div>

<script>
	var current;
	var khm_topnav = document.querySelector('.khm_topnav');
	
	function clickHandler(e){
		if(current){
			current.classList.remove('khm_topnav-active');
		}
		e.target.classList.add('khm_topnav-active');
		current = e.target;
	}
	
	khm_topnav.addEventListener('click',clickHandler);
</script>