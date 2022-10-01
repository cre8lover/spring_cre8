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
				<span style="font-size:35px; margin:0;"><p>희망입찰가<input type="text" name="dlqckfrk" id="demo" value="" 
				style="border: none;text-align:right; font-size:35px; width: 35%;" onchange="equalsmoney('${detail.aucCloseprice }')">원</p></span>
				</td>
				
			</tr>
			
		
		<tr>
		
		<td colspan='2'>
			<%-- <form action="<%= request.getContextPath() %>/auc/aucnow" method="post" id="aucnow" onsubmit="return moneyCheck('${sess_id}')"> --%>
				<input type="hidden" name="money" id="money" value="">
				<input type="hidden" name="seqno" id="seqno" value="${detail.aucSeqno}">
				<div id="timeover">
				<!-- <a href = "<%= request.getContextPath() %>/buy/auctionDetail.jsp"><input type="button" class="bton" value="입찰하기"></a> -->
				<input type='button' onclick='timeover()' class='bton' value='지금은 입찰 할 수 없습니다.'>
				
				</div>
			<!-- </form> -->
		</td>
		
		</tr>
	</table>
	<input type="hidden" id="finish" value="${detail.aucFinish}">
</div>
<center>
	<div style="padding-top:2%; padding-bottom:0;">
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
		</table>
	</div>
 <c:set value="${detail.aucNowingSet}" var="aucn"/>
<c:forEach items="${aucn}" var="aucnow" varStatus="i">

<c:if test="${i.first}">
	<input type="hidden" id="bestmoney" value="${aucnow.mem.memId }">
</c:if>

</c:forEach>
<%--			
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
 --%>

	<div style="padding:2%; padding-top:0;">
		<table style="border:1px solid; width:70%;" id = "auc_price">
		
		</table>
	</div>
	<div id="pagelink" style="width:20vW;">
	
	</div>
</center>

<script src="https://kit.fontawesome.com/236f0b5985.js" crossorigin="anonymous"></script>
<script src="<%= request.getContextPath() %>/js/atDetail.js"></script>

<script>
$(document).on("click",".Btnaucnow" ,function(){ 
	
		var seqno = '<c:out value="${detail.aucSeqno}"/>'
		var id = "<c:out value='${sess_id}'/>"
		var bestid = document.getElementById("bestmoney");
		
		console.log(money.value);
		console.log(seqno);
		console.log(bestid);
		console.log(id);
		
		if(id == ""){
			alert('로그인후 이용하세요');
		}else if (bestid !== null && bestid.value == id){
			alert('이미 최고 입찰자입니다.');
		}else{
			
			var ans = confirm(money.value+"원 입찰 하시겠습니까?")
			
			if(ans){
			var aucnow = {
				 id : id,
				 aucseqno : seqno,
				 price : money.value
				 };
 			aucnowingService.add(aucnow, function(result){
					alert(result); 
			location.href= "auctionDetail?seqno="+seqno;
			 }); 
 			
			}
			
		}

});

$(document).ready(function(){


	
	var currentPage = 1;
	showList(1);
		function showList(page){
			aucnowingService.getList({bno:seqno.value, page:page}, function(replyCnt,list){
			/* 댓글이 없는 경우 */
			if(list == null || list.length == 0){
				$("#auc_price").html("");
				return;
			}
			
			/* 댓글이 있는 경우 */
			var str="";
			for(var i = 0, len=list.length || 0; i < len; i++){
				str += "<tr>";
				str += "	<td>";
				str += 			list[i].memName
				str += "	</td>";
				str += "	<td>";
				str += 			list[i].aucnowDate
				str += "	</td>";
				str += "	<td>";
				str += 			""+list[i].aucnowLastprice+"원"
				str += "	</td>";
				str += "</tr>";
			}
			console.log(str);
			$("#auc_price").html(str);
//			console.log(replyCnt)
			showReplyPage(replyCnt);
		});
	}
		
	/* 댓글 페이지 리스트 출력 */
	function showReplyPage(replyCnt){
//		var currentPage = 1;
		
		var endPage = Math.ceil(currentPage/5.0)*5;
		var startPage = endPage - 4;
		
		console.log("endPage:"+endPage);
		
		var prev = startPage != 1;
		var next = false;
		
		if (endPage * 5 >= replyCnt){
			endPage = Math.ceil(replyCnt/5.0);	
		}
		if(endPage * 5 < replyCnt){
			next = true;
		}
		
		var str = "<ul class='pageUL' style='display: flex; list-style:none; justify-content: space-around;'>";
		
		if(prev){
			str += "<li class='page-link'>";
			str += "<a href='"+(startPage-1)+"'> 이전페이지</a></li>";
		}
		
		for (var i=startPage; i <= endPage; i++){
			var active = currentPage == i ? "active" : "";
			str += "<li class='page-link " + active + "'>";
			str += "<a href='" +i+ "'>" +i+ "</a></li>";
		}
		if (next){
			str += "<li class='page-link'>";
			str += "<a href='" +(endPage+1)+ "'>다음페이지</a></li>";
		}
		
		str += "</ul>";
		console.log(str);
		$("#pagelink").html(str);
		
	}
	
	$("#pagelink").on("click", "li a", function(e){
		console.log("page click...........");
		e.preventDefault(); //a태그를 눌러도 href링크로 이동하지 않게
		var clickPage = $(this).attr("href");
		
		console.log("currentPage : " + clickPage);
		currentPage = clickPage;
		showList(currentPage);
		
	});
});

</script>

</body>

</html>