<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/buy/cart.css">
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/changmok.css">
<title>cart</title>
<script src="https://kit.fontawesome.com/236f0b5985.js"
	crossorigin="anonymous"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
</head>
<body background="img/back.jpg">
	<%@ include file="/header.jsp"%>
	<%@ include file="/menu.jsp"%>
	<div class="body">
		<div class="leftSideBar"></div>
		<div class="content">
			<div class="mypage">
				<form style="color: #263343; font-size: 20px;">
					<br> <br> &nbsp;&nbsp;<i
						class="fa-solid fa-cart-shopping"> &nbsp;</i><b>장바구니</b>
					<hr>
				</form>
				<center>
					<img class="kcmimg" src="<%= request.getContextPath() %>/img/cart_ing1.png" style="width: 70%;">
				</center>
			<form action="<%= request.getContextPath() %>/buyer/cart" method="post">
				<c:set value="${cartp}" var="listp"/>
				<div class="tabs">
				
		    <input id="all"  type="radio" name="tab_item" checked value="${fn:length(listp)}">
		    <label style ="border-bottom-left-radius: 20px; border-top-left-radius: 20px;" 
		    		class="tab_item" for="all">All(${fn:length(listp)+fn:length(lista)})</label>

		    
				
				
					<!-- All 목록 -->
					
				
				<table class="kcmtable">
					<thead>
						<tr>
							<th><input type="checkbox" id="allcheck" name="allcheck"></th>
							<th>이미지</th>
							<th>상품명</th>
							<th>수량</th>
							<th>가격</th>
							
						</tr>
					</thead>
					
					<tbody>
						
						<c:set var = "total" value = "0" />
						<c:forEach items="${listp}" var="cartp">
						 <c:set value="${cartp.pro}" var="pro"/>
						 <c:set value="${pro.item}" var="item"/>
						<tr>
							<th><input type="checkbox" name="allponecheck" value="${pro.proSeqno }"></th>
								
							<th><%-- <th><img src="<%= request.getContextPath() %>/img/b1.jpg"></th> --%>
								<a href="<%= request.getContextPath() %>/product/productDetail?seqno=${pro.proSeqno }">
									<img class="" src="/upload/thumbnail/${item.itemImg }" style="height:225px;">
								</a>
							</th>
								<th>${item.itemName }</th>
								<th>${cartp.cartAmount }</th>
								<th>${cartp.totalprice }</th>
						</tr>
							<c:set var= "total" value="${total + cartp.totalprice}"/>
						</c:forEach>

					</tbody>
				</table>
				
				<h1 style="text-align: right">Total Price: <c:out value="${total}"/> 원</h1>
				

				
					<input type="hidden" name="pro_list" value="">
					
					<input type="hidden" name="orderbutton" value="1" >
					<input type="hidden" name="total" value="${total}" > 
					<input type="submit" class="bton" value="주 문" > 
				</form>
					<input type="button" class="bton" value="선택삭제">
					

			</div>
			</div>
		</div>
		<div class="rightSideBar"></div>
		<br>
	
	</div>
	
<%@ include file="/footer.jsp" %>


</body>

<script>


$(document).ready(function() {
	$("input[name=allcheck]").click(function() {
		if($("input[name=allcheck]").is(":checked")) $("input[name=allponecheck]").prop("checked", true);
		else $("input[name=allponecheck]").prop("checked", false);
	});

	$("input[name=onecheck]").click(function() {
		var total = $("input[name=allponecheck]").length;
		var checked = $("input[name=allponecheck]:checked").length;

		if(total != checked) $("input[name=allcheck]").prop("checked", false);
		else $("input[name=allcheck]").prop("checked", true); 
	});
});


/*
	$("input[name=onecheck]").click(function(){ 
		
		var rowData = new Array();
		var tdArr = new Array();
		var checkbox = $("input[name=onecheck]:checked");
		
		// 체크된 체크박스 값을 가져온다
		checkbox.each(function(i) {
	
			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			// 체크된 row의 모든 값을 배열에 담는다.
			rowData.push(tr.text());
			
			// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
			var no = td.eq(1).text()
			var userid = td.eq(2).text();
			var name = td.eq(3).text();
			var email = td.eq(4).text();
			
			// 가져온 값을 배열에 담는다.
			tdArr.push(no);
			tdArr.push(userid);
			tdArr.push(name);
			tdArr.push(email);
			
			
	//		console.log(tdArr)
	//		console.log("no : " + no);
	//		console.log("userid : " + userid);
	//		console.log("name : " + name);
	//		console.log("email : " + email);
		});
		$("input[name=pro_list]").attr("value",tdArr);
	});
 */
</script>
</html>












