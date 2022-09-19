<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/buy/buy.css">
<meta charset="UTF-8">

<title>buy</title>
<script src="https://kit.fontawesome.com/236f0b5985.js"
	crossorigin="anonymous"></script>

</head>







<body background="<%= request.getContextPath() %>/img/back.jpg">

	<%@ include file="/header.jsp"%>
	<%@ include file="/menu.jsp"%>

	<div class="body">
		<div class="leftSideBar"></div>
		<div class="content">
			<div class="mypage">
				<form style="color: #263343; font-size: 30px;">
				<br> <br> &nbsp;&nbsp;<i class="fa-solid fa-cart-shopping">
					&nbsp;</i><b>구매완료</b>
				<hr>
				</form>
				<div>
				<center>
					<img src="<%= request.getContextPath() %>/img/buy.png" style="width: 70%;">
				
				<h3> 상품을 구매해 주셔서 감사합니다.</h3>
				
				
			<table class="kcmtable" ">
						<tr>
							<th>상품명</th>
							<th>주문수량</th>
							<th>상품가격</th>
							<th>총 주문금액</th>
						</tr>
				</table>
				<table class="kcmtable2" >
						<c:set value="${cartp}" var="listp"/>
						<c:forEach items="${listp}" var="cartp">
						 <c:set value="${cartp.pro}" var="pro"/>
						 <c:set value="${pro.item}" var="itemp"/>
						<tr>
							<th>${itemp.itemName}</th>
							<th>${cartp.orderAmount}</th>
							<th>${pro.proPrice }</th>
							<th>${pro.proPrice * cartp.orderAmount }</th>
						</tr>
						</c:forEach>

				</table>
				<br>
			<a href ="<%= request.getContextPath() %>/index.jsp"type="button" class="bton"><img src = "<%= request.getContextPath() %>/img/home.png" style="width : 80px;"></a>
			<br>
			<a style="font-size: 20px;">HOME</a>
				</center>
				</div>
			</div>
			

		</div>
		</div>
		<%@ include file="/footer.jsp" %>
		<div class="rightSideBar"></div>
</body>
</html>



















