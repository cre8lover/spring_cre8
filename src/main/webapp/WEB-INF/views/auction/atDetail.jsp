<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/auction/atDetail.css">

<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
</head>
<body>
<div>
		<c:set value="${detail}" var="detail"/>
	 	<c:set value="${detail.item}" var="item"/>
	<table class="jmh_table">
		<tr>
			<td rowspan='11' class="jmh_saleimg">
			<%-- <img class="jmh_imgsize" src="<%= request.getContextPath() %>/img/우투리.png" alt="My Image"> --%>
			<div> <img  style="width:100%;" class="" src="/upload/${item.itemImg}"></div>
			</td>
			<td class="jmh_star" colspan = 2>
			<h4> &nbsp;&nbsp; <i class="fa-solid fa-house-user"> &nbsp; </i>${detail.aucDetail }</h4>
			</td>
			
		</tr>
		<tr>
			<td colspan = 2><h1 class="jmh_title">${item.itemName}</h1>
			</td>
		</tr>
		<tr>
			<td class="jmh_saleprice" >
				<span style="font-size:20px;"><strike>시작가 :${detail.aucPrice }원</strike></span>
			</td>
			<td class="jmh_saleprice">  <span style="font-size:25px;"><b> 현재가 :${detail.aucCloseprice }원 </b></span></td>
		</tr>

		<tr>
			<td colspan='2'>
				<div class="tabs">
				    <input id="all" type="radio" name="tab_item" checked>
				    <label class="tab_item" for="all">상세 정보</label>
				    
				    <input id="programming" type="radio" name="tab_item">
				    <label class="tab_item" for="programming">작가경력사항</label>
				    
				    <div class="tab_content" id="all_content">
				    	${detail.aucShortdetail }<br>
				        작품: 그림<br>
				        크기: 100x100cm<br>
				       	소재: FSC paper
				    </div>
				    <div class="tab_content" id="programming_content">
				    ${detail.aucShortdetail }
						이 그림은 맥주 마시기 대회에서 우승한 이재신을 위한 사진입니다
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td class="jmh_sailprice3">현재 입찰수
			</td>
			<td class="jmh_sailprice2">${detail.aucHits }명
			</td>
		</tr>
		<tr>
			<td class="jmh_buyprice">
			</td>
			<td class="jmh_buyprice2" style="color:red">
				<div class="sec7-text-box">
				  <p>종료날짜</p>
				  <p class="runTimeCon">${detail.aucFinish}</p>
				  <hr/>
				  <div class="time">
				    <span id="d-day-hour">00</span>
				    <span class="col">:</span>
				    <span id="d-day-min">00</span>
				    <span class="col">:</span>
				    <span id="d-day-sec">00</span>
				  </div>
				</div>
			</td>
		</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
		<tr>
		<td colspan="2">
			
		<div class="slidecontainer">
	 	 <input type="range" min="${detail.aucCloseprice + 1000}" max="${detail.aucCloseprice *10}" value="${detail.aucCloseprice }"step="1000" class="slider" id="myRange">
	 	 
		</div>
		</td>
		</tr>
		
			
			<tr>
				<td class="jmh_price" colspan='2'>
				<!-- <span style="font-size:35px; margin:0;"><p>희망입찰가 &nbsp;&nbsp;<span id="demo"> </span>원</p></span> -->
				<span style="font-size:35px; margin:0;"><p>희망입찰가<input type="text" name="dlqckfrk" id="demo" value="" style="border: none;text-align:right; font-size:35px; width: 35%;">원</p></span>
				</td>
				
			</tr>
			
		
		<tr>
		
		<td colspan='2'>
			<form action="<%= request.getContextPath() %>/auc/aucnow" method="post" id="aucnow" onsubmit="return moneyCheck('${sess_id}')">
				<input type="hidden" name="money" id="money" value="">
				<input type="hidden" name="seqno"  value="${detail.aucSeqno}">
				<div id="timeover">
				<!-- <a href = "<%= request.getContextPath() %>/buy/auctionDetail.jsp"><input type="button" class="bton" value="입찰하기"></a> -->
				<input type='button' onclick='timeover()' class='bton' value='지금은 입찰 할 수 없습니다.'>
				
				</div>
			</form>
		</td>
		
		</tr>
	</table>
	<input type="hidden" id="finish" value="${detail.aucFinish}">
</div>
<center>
	<div style="padding:2%">
		<table style="border:1px solid; width:70%;">
			<tr>
				<td>
					입찰 참여자
				</td>
				<td>
					입찰 일자
				</td>
				<td>
					입찰 가격
				</td>
			</tr>
<c:set value="${detail.aucNowingSet}" var="aucn"/>
<c:forEach items="${aucn}" var="aucnow" varStatus="i">

<c:if test="${i.first}"> 
<input type="hidden" id="bestmoney" value="${aucnow.mem.memId }">
</c:if>

			<tr>
				<td>
					${aucnow.mem.memName }
				</td>
				<td>
					${aucnow.aucnowDate }
				</td>
				<td>
					${aucnow.aucnowLastprice }원
				</td>
			</tr>
</c:forEach>
		</table>
	</div>
	
</center>

<script src="https://kit.fontawesome.com/236f0b5985.js" crossorigin="anonymous"></script>
<script src="<%= request.getContextPath() %>/js/atDetail.js"></script>

</body>
</html>