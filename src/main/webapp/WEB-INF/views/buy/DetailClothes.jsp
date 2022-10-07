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
	<%@ include file="../header.jsp" %>
	<%@ include file="../menu.jsp" %>
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
							src="/upload/${item.itemImg}" alt="My Image"></td>
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
					     <%--  <div>재고수량 : ${detailList.proAmount} 개</div>	 --%>
					    </td>
					</tr>
					<tr>
						<td class="jmh_buyprice">구매금액</td>
						<td class="jmh_buyprice"> <a id="total_amount">${detailList.proSaleprice}</a>원</td>
				
					</tr>
					<tr>
					<form>
					<td>
						<%-- <a href = "<%= request.getContextPath() %>/buyer/buylist"> --%><input type="button" class="bton" id="orderBtn" value="바로구매"><!-- </a> -->
					</td>
					<td>
						<input type="button" class="bton" id="cartBuyBtn" value="장바구니">
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
        <button id='addReplyBtn'>댓글등록</button>
        <table class="khm_table" id="qnatable">
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
        			<td>
						수정
        			</td>
        			<td>
						삭제
        			</td>
        		</tr>
        	</thead>
        	<tbody id="QnAList">
        	</tbody>
        </table>
        <div id ='replyInput'>
			<textarea id='comment' name='comment' style='width:100%; height:60px;' rows='5' cols='50' placeholder='댓글을 입력하세요'></textarea>
		</div>
      </main>
    </section>
    
    <section id="panel-3">
      <main>
        <h2>Review</h2>
        <!-- 리뷰등록 -->
       <div class="comments-app" ng-app="commentsApp" ng-controller="CommentsController as cmntCtrl">

  <!-- From -->
  <div class="comment-form">
    <!-- Comment Avatar -->
    <div class="comment-avatar">
      <img src="https://cdn-icons-png.flaticon.com/512/456/456212.png">
    </div>

    <form class="form" name="form" ng-submit="form.$valid && cmntCtrl.addComment()" novalidate>
      <div class="form-row">
        <textarea
                  class="input"
                  ng-model="cmntCtrl.comment.text"
                  placeholder="리뷰를 입력하세요"
                  required></textarea>
      </div>



      <div class="form-row">
        <input type="submit" id="addReplyBtn" value="리뷰등록">
      </div>
    </form>
  </div>

  <!-- Comments List -->
  <c:forEach items="${detailList.getReviewSet()}" var="review">
    <!-- Comment -->
  <div class="comments">
    <div class="comment" ng-repeat="comment in cmntCtrl.comments | orderBy: '-date'">
      <!-- Comment Avatar -->
	      <div class="comment-avatar">
	        <img src="https://cdn-icons-png.flaticon.com/512/456/456212.png">
	      </div>

      <!-- Comment Box -->
	      <div class="comment-box">
	        <div class="comment-text" >${review.reviewContent}</div>
	        <div class="comment-footer">
	          <div class="comment-info">
	            <span class="comment-author" style = "float:left;">
	              <em ng-if="comment.anonymous">작성자 : </em>
	              <a ng-if="!comment.anonymous" >${review.mem.memId}</a>
	            </span>

	          </div>

	          <div class="comment-actions">
	            <button id="replyModifyBtn" style="border: none; background-color: transparent;">수정</button> |
				<button id="replyDeleteBtn" style="border: none; background-color: transparent;">삭제</button>
	          </div>
	        </div>
	      </div>
    </div>
  </div>
</c:forEach>

</div>

      </main>
    </section>
   
  </div>
</article>

				
		</div>
	</div>
<%@ include file="../footer.jsp" %>
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
  var max_qty = "<c:out value='${detailList.proAmount}'/>"; // 현재 재고
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

$(document).ready(function(){
	var seqno = "<c:out value='${detailList.proSeqno}'/>";
	
	$("#orderBtn").on("click",function(){
		location.href = "/product/nowbuy?seqno="+seqno+"&amount="+$("#ct_qty").val();
	});
	
	$("#cartBuyBtn").on("click",function(){
		var amount = $("#ct_qty").val();
		
		var id = "<c:out value='${sess_id}'/>";
		console.log("시퀀스"+seqno);
		console.log("수량"+amount);
		if(id != ""){
		var reg = {
				proSeqno : seqno,
				proAmount : amount,
				id : id
		};
		product.cartreg(reg, function(result){
			var ans = confirm("장바구니에 추가되었습니다. 장바구니로 이동할까요?");
			if (ans){
				location.href = "/buyer/cart";
			}else{
				location.reload();
			}
			
		})
		
		}else{
			alert("로그인후이용하세요");
		}
		
	});
});

</script>
<script>

var product = (function(){
	

	
	function cartreg(reg,callback,error){
		console.log("cartadd.....");
		$.ajax({
			type :'post',
			url : '/prductrest/cartadd',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(reg),
			success : function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, err){
				if(error){
				error(err);
				}
			}
		
		});
	};
	return{
		cartreg : cartreg
	};
	
})();

</script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/detailClothes.js"></script>
<script>
$(document).ready(function(){
var seqno = '<c:out value="${detailList.getProSeqno()}"/>'
var id = '<c:out value="${detailList.mem.memId}"/>'

	console.log("detail.jsp");
	console.log("시퀀스 번호 : " + seqno);

showList(1);	
	function showList(page){
		detailQnA.getList({seqno: seqno, page : page || 1}, function(list){
			console.log("list where");
			
			var str = "";
		
			 for(var i=0, len=list.length || 0; i <len; i++){
//				console.log("시퀀스 : " + list[i].qnaSeqno);
				str +=	"<tr>"
				str +=		"<td class='qna_seqno' id='qna' name='seqno' value='"+ list[i].qnaSeqno +"'>"+ list[i].qnaSeqno +"</td>"
				str +=		"<td colspan='2'>"+ list[i].qnaContent +"</td>"
				str +=		"<td>"+ list[i].memId +"</td>"
				str +=		"<td>"+ list[i].qnaDate +"</td>"
				str +=      "<td><button class='change' name='type' value='" + list[i].qnaSeqno + "'>수정</button> </td>"
				str +=      "<td><button class='delete' name='type' value='" + list[i].qnaSeqno + "'>삭제</button> </td>"
				str +=	"</tr>"
			}	 
			
			 $("#QnAList").html(str);
		});
		
	}
	
	
	var QnaNo;
	$(document).on("click", ".change", function(e){
		QnaNo = e.target.value;
		console.log("button click : " + QnaNo);
		
		detailQnA.get(QnaNo, function(data){ 
			console.log(data.qnaContent);
			document.getElementById("comment").value = data.qnaContent  
		}); 
	});
	
	$("#addReplyBtn").on("click", function(e){
		var comment = document.getElementById("comment").value;
		console.log("comment : " + comment);
		
		var QnaVo = {
				seqno : QnaNo,
				memId : id,
				qnaContent : comment
		}
		
		detailQnA.add(QnaVo, function(result){ 
			alert(result);
			document.getElementById("comment").value = "" 
			showList(1);
		}); 
	});
	
	
	$(document).on("click", ".delete", function(e){
		QnaNo = e.target.value;
		console.log("댓글 삭제 번호 : " + QnaNo);
		
		detailQnA.remove(QnaNo, function(result){
			alert(result);
			showList(1);
		});
		
	});
});



</script>
</body>
</html>