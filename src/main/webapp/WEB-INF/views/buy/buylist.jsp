<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/buy/buylist.css">
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/changmok.css">
<title>buy</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

</head>
<body background="<%= request.getContextPath() %>/img/back.jpg">
<%@ include file="/header.jsp"%>
<%@ include file="/menu.jsp"%>
<div class="jmh_body3">
	<div class="body">
		<div class="leftSideBar"></div>
		<div class="content">
			<div class="mypage">
				<form style="color: #263343; font-size: 20px;">
				<br> <br> &nbsp;&nbsp;<i class="fa-solid fa-cart-shopping">
					&nbsp;</i><b>주문서 작성</b>
				<hr>
				</form>
				<center>
					<img class = "kcmimg" src = "<%= request.getContextPath() %>/img/buylist.png" style="width:70%;">
				
				<h3> 배송지를 작성해주세요.</h3>
				</center>	
							
					<hr>
				<div class="buyer">
					<form style="width:76%"> 
						<h2>구매자 정보</h2>
						<div class="buy">
							<a style="padding-right: 16px;"> 구매자 </a>
							<input type="text" id="name" readonly value="강홍묵"> 
						</div>
						<div class = "address">
							<a style="padding-right: 32px;"> 주소 </a>
							<input type="text" class="address" id="address_kakao" name="address" readonly placeholder="기본 주소" />
						    <input type="text" class="address" id="address_kakao_back"name="address_detail" placeholder="상세 주소 및 상세 건물명"/>
						</div>
						<div>
							<a> 전화번호 </a>
							<input type="hidden" id="phonnumber">
								<select name="ssecession"  onchange="goSearch();" style="width: 6%; height: 31px;" >
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
								</select>
							<input type="text" id="phon_front" placeholder="휴대폰 앞자리">
							<input type="text" id="phon_back" placeholder="휴대폰 뒷자리">
						</div>
						<div>
							<a>요청사항</a>
							<select name="choice"  onchange="" style="width: 35%; height: 31px;">
								<option value="">배송시 요청사항</option>	
								<option value="문 앞에 놓아주세요">문 앞에 놓아주세요</option>
								<option value="경비실에 맡겨주세요">경비실에 맡겨주세요</option>
								<option value="배송 전 휴대폰으로 연락주세요">배송 전 휴대폰으로 연락주세요</option>							
								<option value="파손위험이 있는 상품이니 조심히 다뤄주세">파손위험이 있는 상품이니 조심히 다뤄주세</option>							
								<option value="">직접입력</option>							
							</select>
						</div>
					</form>
				</div>
	
				
				<div class="buyer">
					<form style="width:76%"> 
						<h2>배송지정보</h2>
						<div class="buy">
							<input type="checkbox" id="checkbuyinfo"onchange="addrequals()"> 구매자정보와 동일 <br>
							<a style="padding-right: 16px;"> 구매자 </a>
							<input type="text" id="name2" value="강홍묵"> 
						</div>
						<div class = "address">
							<a style="padding-right: 32px;"> 주소 </a>
							<input type="text" class="address" id="address_kakao2" name="address" readonly placeholder="기본 주소" />
						    <input type="text" class="address" id="address_kakao_back2" name="bottom_address_detail" placeholder="상세 주소 및 상세 건물명"/>
						</div>
						<div>
							<a> 전화번호 </a>
							<input type="hidden">
								<select name="ssecession" onchange="goSearch();" style="width: 6%; height: 31px;" >
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
								</select>
							<input type="text" id="phon_front2" placeholder="휴대폰 앞자리">
							<input type="text" id="phon_back2" placeholder="휴대폰 뒷자리">
						</div>
						<div>
							<a>요청사항</a>
							<select name="choice"  onchange="" style="width: 35%; height: 31px;">
								<option value="">배송시 요청사항</option>	
								<option value="문 앞에 놓아주세요">문 앞에 놓아주세요</option>
								<option value="경비실에 맡겨주세요">경비실에 맡겨주세요</option>
								<option value="배송 전 휴대폰으로 연락주세요">배송 전 휴대폰으로 연락주세요</option>							
								<option value="파손위험이 있는 상품이니 조심히 다뤄주세">파손위험이 있는 상품이니 조심히 다뤄주세</option>							
								<option value="">직접입력</option>							
							</select>
						</div>
					</form>
				</div>

				
				
				
				<table class="kcmtable">
						<tr>
							<th style="width:20%">상품</th>
							<th style="width:60%">상품 설명</th>
							<th style="width:10%">상품 수량</th>
							<th style="width:10%">금액</th>
						</tr>
				</table>
				<c:set var = "total" value = "0" />
				<table class="kcmtable">
				<c:choose>
					<c:when test="${cartp != null }">
						<c:set value="${cartp}" var="listp"/>
						<c:forEach items="${listp}" var="cartp">
						 <c:set value="${cartp.pro}" var="pro"/>
						 <c:set value="${pro.item}" var="itemp"/>
						<tr>
<%-- 							<th rowspan='2' style="overflow:hidden;padding: 15px;width:20%;"><img class="jmh_imgsize" src="<%= request.getContextPath() %>/img/짜릿.png" alt="My Image"></th> --%>
							<th style="overflow:hidden;padding: 15px;width:20%;" ><img class="" src="/upload/thumbnail/${itemp.itemImg }" style="height:225px;"></th>
							<th style="width:60%"><a style="font-size:20px; line-height:0%;">${itemp.itemName }
								<input type="hidden" class="itemname" value="${itemp.itemName }"></a></th>
							<th style="width:10%">${cartp.cartAmount}</th>
								
							<th style="width:10%">${pro.proPrice * cartp.cartAmount }원</th>
						</tr>
						<input type="hidden" name="orderamount" value="${cartp.cartAmount}">
						<input type="hidden" name="cartseqno" value="${cartp.cartSeqno }">
						<c:set var= "total" value="${total + (pro.proPrice * cartp.cartAmount)}"/>
						</c:forEach>
						
					</c:when>
					
					
					<c:when test="${cartp == null }">
					<tr>
					<td style="text-align: center;"> 물건이 없습니다.
					</td>
					</tr>
					</c:when>
				</c:choose>	
					<tr>
						<th colspan="2" style="text-align:end;"> 총 주문금액 : </th>
						<th colspan="3" style="font-size: 30px;">${total }원 </th>
					</tr>	
				</table>
				
				
				<%-- <div style="float:right">${total }원</div> --%>
				<form>
					<input type="hidden" class="ordercount" value="${fn:length(listp)}">
					<input type="button" onclick="requestPay(${total})" class="bton" value="구매하기"> 
				</form>
			</div>
		</div>
		<div class="rightSideBar" style="z-index:-1"></div>
</div>
</div>
<div style="height:100%">
</div>
<div style="height:100%">
</div>
<div style="height:100%">
</div>
		<%@ include file="/footer.jsp" %>

</body>
<script src="https://kit.fontawesome.com/236f0b5985.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="<%= request.getContextPath() %>/js/buylist.js"></script>
</html>



















