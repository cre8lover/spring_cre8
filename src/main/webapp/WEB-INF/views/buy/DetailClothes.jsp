<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/buy/DetailClothes.css">
<link rel ="stylesheet" href="<%= request.getContextPath() %>/css/detailcss.css"> 
<script src="https://kit.fontawesome.com/236f0b5985.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<%@ include file="/header.jsp" %>
	<%@ include file="/menu.jsp" %>
<body background="<%= request.getContextPath() %>/img/back.jpg">

	<div class="leftSideBar"></div>

	<div class="body">
		<div class="mypage">
			<div>
				<c:set value="${detailList}" var="detailList"/>
				<c:set value="${detailList.getItem() }" var="item" />
			<h4> &nbsp;&nbsp;&nbsp; <i class="fa-solid fa-house-user"> &nbsp; </i> ${detailList.companyname}</h4>
			</div>
			<center>
				<table class="jmh_table">
					<tr>
						<td rowspan='8' class="jmh_saleimg"><img class="jmh_imgsize"
							src="${item.itemImg}" alt="My Image"></td>
						<td colspan='2' class="jmh_star"><span style="float: right">리뷰 ${detailList.reviewcount}개 &nbsp;</span>
						</td>
					</tr>
					<tr>
						<td colspan='2'><h1 class="jmh_title2">${item.itemName}</h1></b></td>
					</tr>
					<tr class="jmh_info2">
						<td colspan = '2'>${detailList.proDetail}</td>
					</tr>
				
					<tr>
						<td class="jmh_buyprice" ><span>기본가</span>
						<td class="jmh_buyprice"><span><strike> ▼ ${detailList.proPrice} 원 </strike></span></td>
					</tr>				
					<tr>
						<td class="jmh_buyprice">할인적용가</td>
						<td class="jmh_buyprice"> ${detailList.discount }원</td>
					</tr>
					<tr>
						<td class="jmh_buyprice">수량</td>
					    <td class="jmh_buyprice">
					      <div class="qty">					
					        <div class="minus"><button onclick="javascript:change_qty2('m')" style="width:27px; height:27px; border: none;">▼</div>
					
					        <input type="text" name="ct_qty" id="ct_qty" value="1" readonly="readonly">
					
					        <div class="plus"><button onclick="javascript:change_qty2('p')" style="width:27px; height:27px; border: none;">▲</div>
					      </div>	
					    </td>
					</tr>
					<tr>
						<td class="jmh_buyprice">구매금액</td>
						<td class="jmh_buyprice"> <a id="total_amount">${detailList.proSaleprice}</a>원</td>
				
					</tr>
					<tr>
					<form>
					<td>
						<a href = "<%= request.getContextPath() %>/buyer/buylist"><input type="button" class="bton" value="바로구매"></a>
					</td>
					<td>
						<a href = "<%= request.getContextPath() %>/buyer/cart"><input type="button" class="bton" value="장바구니"></a>
					</td>	
					</form>
					</tr>
					</center>
				</table>

				
				<hr style=" width : 100%; height : 2px; background-color : #071e3d;">
				
				<!-- TAB CONTROLLERS -->
<input id="panel-1-ctrl" style="display:none;"
       class="panel-radios" type="radio" name="tab-radios" checked >
<input id="panel-2-ctrl" style="display:none;"
       class="panel-radios" type="radio" name="tab-radios">
<input id="panel-3-ctrl" style="display:none;"
       class="panel-radios" type="radio" name="tab-radios">

<input id="nav-ctrl" style="display:none;"
       class="panel-radios" type="checkbox" name="nav-checkbox">



<!-- TABS LIST -->
<ul id="tabs-list">
    <!-- MENU TOGGLE -->
    <label id="open-nav-label" for="nav-ctrl"></label>
    <li id="li-for-panel-1">
      <label class="panel-label"
             for="panel-1-ctrl">제품상세</label>
    </li><!--INLINE-BLOCK FIX
 --><li id="li-for-panel-2">
      <label class="panel-label"
             for="panel-2-ctrl">Q&A</label>
    </li><!--INLINE-BLOCK FIX

 --><li id="li-for-panel-3">
      <label class="panel-label"
             for="panel-3-ctrl">리뷰★</label>
    </li><!--INLINE-BLOCK FIX
 --><!-- <li id="li-for-panel-4" class="last">
      <label class="panel-label"
             for="panel-4-ctrl">함께 본 상품</label>
    </li> -->
    <label id="close-nav-label" for="nav-ctrl">Close</label> 
</ul>

<!-- THE PANELS -->
<article id="panels">
  <div class="container">
    <section id="panel-1">
      <main>
        <h2>제품상세</h2>
        <img src="https://13inch.ecn.cdn.infralab.net/13inchBrandLab/DunDrop/2022/0728/1111/02.jpg">

        
      </main>
    </section>
    <section id="panel-2">
       <main>
        <h2>Q&A</h2>
        <table class="khm_table">
        	<thead>
        		<tr>
        			<td>
						번호
        			</td>
        			<td colspan='2'>
						문의/답변
        			</td>
        			<td>
						작성자
        			</td>
        			<td>
						작성일자
        			</td>
        		</tr>
        	</thead>
        	<tbody>
        	<c:forEach items="${detailList.getQnaSet()}" var="qna">
        		<tr>
        			<td>
						${qna.qnaSeqno}
        			</td>
        			<td colspan='2'>
						${qna.qnaContent}
        			</td>
        			<td>
						${qna.memid }
        			</td>
        			<td>
						${qna.qnaDate}
        			</td>
        		</tr>
        		</c:forEach>
        	</tbody>
        </table>
      </main>
    </section>
    
    <section id="panel-3">
      <main>
        <h2>★리뷰★</h2>
        <table class="khm_table">
        
        	<thead>
        		<tr>
        			<td>
						번호
        			</td>
        			<td colspan='2'>
						리뷰내용
        			</td>
        			<td>
						작성자
        			</td>
        		
        		</tr>
        	</thead>
        	<tbody>
        		<c:forEach items="${detailList.getReviewSet()}" var="review">
        		<tr>
        			<td>
						${review.reviewSeqno}
        			</td>
        			<td colspan='2'>
						${review.reviewContent}
        			</td>
        			<td>
						${review.mem.memId}
        			</td>
        		
        		</tr>
        		
        		</c:forEach>
        	
        	</tbody>
        </table>
      </main>
    </section>
   
  </div>
</article>

				
		</div>
	</div>
<%@ include file="/footer.jsp" %>
	<div class="rightSideBar"></div>
	
	 
<script type="text/javascript">
Number.prototype.format = function(){
  if(this==0) return 0;

  var reg = /(^[+-]?\d+)(\d{3})/;
  var n = (this + '');

  while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');

  return n;
};
 

String.prototype.format = function(){
  var num = parseFloat(this);
  if( isNaN(num) ) return "0";

  return num.format();
};
    
var basic_amount = parseInt('${detailList.proSaleprice}');


function change_qty2(t){
  //var min_qty = '수량버튼'*1;
  var min_qty = 1;
  var this_qty = $("#ct_qty").val()*1;
  var max_qty = '5'; // 현재 재고
  if(t=="m"){
    this_qty -= 1;
    if(this_qty<min_qty){
      //alert("최소구매수량 이상만 구매할 수 있습니다.");
      alert("수량은 1개 이상 입력해 주십시오.");
      return;
      }
    }
    else if(t=="p"){
      this_qty += 1;
      if(this_qty>max_qty){
        alert("죄송합니다. 재고가 부족합니다.");
        return;
        }
    }

  var show_total_amount = basic_amount * this_qty;
  //$("#ct_qty_txt").text(this_qty); 
  $("#ct_qty").val(this_qty);
  $("#it_pay").val(show_total_amount);
  $("#total_amount").html(show_total_amount.format());
}

</script>

</body>
</html>