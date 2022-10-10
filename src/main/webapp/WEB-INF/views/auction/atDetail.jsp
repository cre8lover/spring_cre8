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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


</head>
<body>
<div>
		<c:set value="${detail}" var="detail"/>
	 	<c:set value="${detail.item}" var="item"/>
	<table class="jmh_table">
		<tr>
			<td rowspan='8' class="jmh_saleimg">
			<%-- <img class="jmh_imgsize" src="<%= request.getContextPath() %>/img/우투리.png" alt="My Image"> --%>
			<div> <img  style="width:96%;" class="jmh_saleimg " src="/upload/${item.itemImg}"></div>
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
				<span style="font-size:20px;"><strike>시작가 : &nbsp; <fmt:formatNumber value="${detail.aucPrice }" pattern="#,###"/>원</strike></span>
			</td>
			  
			<td class="jmh_saleprice">  <span style="font-size:20px;"><b> 현재가 : &nbsp; <fmt:formatNumber value="${detail.aucCloseprice }" pattern="#,###"/>원 </b></span></td>
		</tr>



			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			<tr>
			<td colspan="2">
				
			<div class="slidecontainer">
			
		 	 <input type="range" min="${detail.aucCloseprice + 1000}" max="${detail.aucCloseprice *10}" value="${detail.aucCloseprice }" step="1000" class="slider" id="myRange">
<%-- 		 	 <input type="range" min="${detail.aucCloseprice + 1000}" max="${detail.aucCloseprice *10}" value="${detail.aucCloseprice }" step="1000" class="slider" id="myRange"> --%>
		 	 
			</div>
			</td>
			</tr>
		
			
			<tr>
				<td class="jmh_price" colspan='2'>
				<!-- <span style="font-size:35px; margin:0;"><p>희망입찰가 &nbsp;&nbsp;<span id="demo"> </span>원</p></span> -->
				<span style="font-size:25px; margin:0;"><p>희망입찰가<input type="text" name="dlqckfrk" id="demo" value="" 
				style="border: none;text-align:right; font-size:35px; width: 35%;" onchange="equalsmoney('${detail.aucCloseprice }')">원</p></span>
				</td>
				
			</tr>
			<tr>
			<td colspan="2"  style="color:#D2001A; text-align: end;" >
			<b>
				  <a class="runTimeCon">종료일시: ${detail.aucFinish}</a>
				  <div class="time"> 남은시간:
				    <span id="d-day-hour">00</span>
				    <span class="col">:</span>
				    <span id="d-day-min">00</span>
				    <span class="col">:</span>
				    <span id="d-day-sec">00</span>
				  </div>
			</b>	
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
			
			<tr>
			<td colspan='3'>
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

	</table>
	<input type="hidden" id="finish" value="${detail.aucFinish}">
</div>
<hr>
<center>
<div class="memberlist">
	<h3>입찰참여자(${detail.aucHits }명)</h3>
	<section class="memberlist_users">
		<div class="memberlist_users_container">
		<div class="listform">
		
		<br>
<div id="auc_price">
		<div class="memberlist-item">
			<div class="memberlist-item_avatar">
				<div class="memberlist-item_memberavatar">
					<span>
						<span>
						<img src="https://cdn-icons-png.flaticon.com/512/4526/4526838.png"/>
						</span>
					</span>
				</div>
			</div>
			<div class="memberlist-item_username">
				<p class="memberlist-item_username-username">ID: ${aucnow.mem.memName }</p>
			</div>
			<div class="memberlist-item_userinfo">
				<div class="memberlist-item_userinfo-item">
					<span><h4>입찰일시</h4></span>
					<span>${aucnow.aucnowDate }</span>
				</div>
				<span class="memberlist-item_userinfo-sep"></span>
				<div class="memberlist-item_userinfo-item">
					<span><h4>입찰가격</h4></span>
					<span>${aucnow.aucnowLastprice }</span>
				</div>
			</div> 
		</div>
</div>

</div>


	</div>
	
	</section>
</center>
<center>
	<div id="pagelink" style="width:20vW;"></div>
</center>

</div>

 <c:set value="${detail.aucNowingSet}" var="aucn"/>
<c:forEach items="${aucn}" var="aucnow" varStatus="i">
<c:if test="${i.first}">
	<input type="hidden" id="bestmoney" value="${aucnow.mem.memId }">
</c:if>
</c:forEach>
	<input type="hidden" id="logingid" value="${sess_id }">
	<input type="hidden" id="logingname" value="${sess_name}">
	<input type="hidden" id="aucAmount" value="${detail.aucAmount}">
	<input type="hidden" id="aucprice" value="${detail.aucCloseprice }">
	

<div class="auctionbuymain">
	<div class="auctionbuy">
		<button class="closeBtn"style="float:right;">닫기</button>
		<h3> 배송지를 작성해주세요.</h3>
			<hr>
			<div class="buyer">
				<form style="width:76%"> 
					<h2>구매자 정보</h2>
					<div class="buy">
						<a style="padding-right: 16px;"> 구매자 </a>
						<input type="text" id="name" value="강홍묵"> 
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
					<input type='button' class="bton aucbuyBtn" value="구매하기">
				</form>
			</div>
	</div>
</div>

<style>
.auctionbuymain {
	position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: white;
    width: 60%;
}
</style>




<script src="https://kit.fontawesome.com/236f0b5985.js" crossorigin="anonymous"></script>
<script src="<%= request.getContextPath() %>/js/atDetail.js"></script>

<script>



window.onload = function(){
    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao").value = data.address; // 주소 넣기
                document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱
            }
        }).open();
    });
}



	

	

$(document).on("click",".Btnaucnow" ,function(){ 
	
		var seqno = '<c:out value="${detail.aucSeqno}"/>'
		var bestid = document.getElementById("bestmoney");
		var id = "<c:out value='${sess_id}'/>"

		/* console.log(money.value);
		console.log(seqno);
		console.log(bestid);
		console.log(id); */
		
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
	$(".auctionbuymain").hide();
	
	var currentPage = 1;
	showList(1);
		function showList(page){
			aucnowingService.getList({bno:seqno.value, page:page}, function(replyCnt,list){
			if(list == null || list.length == 0){
				$("#auc_price").html("");
				return;
			}
			
			var str="";
			for(var i = 0, len=list.length || 0; i < len; i++){
				var listnumber = list[i].aucnowLastprice;
				listnumber = Number(listnumber.replaceAll(',', ''));
				listnumber = listnumber.toLocaleString('ko-KR');
		/* 			str +=	"<div class='memberlist'>"
					str +=	"<section class='memberlist_users'>";
					str +=	"<div class='memberlist_users_container'>";
					str +=	"<br>"; */
					str +=	"<div class='memberlist-item'>";
					str +=	"<div class='memberlist-item_avatar'>";
					str +=	"	<div class='memberlist-item_memberavatar'>";
					str +=	"		<span>";
					str +=	"			<span>";
					str +=	"			<img src='https://cdn-icons-png.flaticon.com/512/4526/4526838.png'/>";
					str +=	"			</span>";
					str +=	"		</span>";
					str +=	"	</div>";
					str +=	"</div>";
					str += "<div class='memberlist-item_username'>";
					str += "<p class='memberlist-item_username-username'>"+list[i].memName+"</p>";
					str += "</div>";
					str += "<div class='memberlist-item_userinfo'>";
					str +=	"<div class='memberlist-item_userinfo-item'>";
					str +=	"	<span> <h4>입찰일시</h4> </span>";
					str +=	"	<span> "+list[i].aucnowDate+" </span>";
					str +=	"</div>";
					str +=	"<span class='memberlist-item_userinfo-sep'></span>";
					str +=	"<div class='memberlist-item_userinfo-item'>";
					str +=	"	<span><h4>입찰가격</h4></span>";
					str +=		"<span>"+listnumber+"원</span>";
/* 					str +=		"<span>"+list[i].aucnowLastprice+"원</span>"; */
					str +=	"</div>";
					str +=	"		</div>";
					str +=	"		</div>";
/* 					str +=	"	</div>";
					str +=	"	</section>";
					str +=	"</div>"; */
					
			}
			/* console.log(str); */
			$("#auc_price").html(str);
			
			showReplyPage(replyCnt);
		});
	}
		
	function showReplyPage(replyCnt){
		
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
			str += "<a href='"+(startPage-1)+"'> ◀</a></li>";
		}
		
		for (var i=startPage; i <= endPage; i++){
			var active = currentPage == i ? "active" : "";
			str += "<li class='page-link '>";
			str += "<a href='" +i+ "'class= '" + active + "'>" +i+ "</a></li>";
		}
		if (next){
			str += "<li class='page-link'>";
			str += "<a href='" +(endPage+1)+ "'> ▶ </a></li>";
		}
		
		str += "</ul>";
		/* console.log(str); */
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