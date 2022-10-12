<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    


<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/creater/artistpage.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="../menu.jsp" %>
<body background="<%= request.getContextPath() %>/img/back.jpg">
      <div id="leftSideBar"> </div>
      <div class="body" >
      
      
      
<div class="tabs">
  <input type="radio" name="tabs"  id="tabone" checked="checked">
  <label for="tabone">일반상품</label>
  <div class="tab">
   <div class="mypage">
      <p class="mysale"><b>나의 판매내역</b></p><br><br><br><br><br>

         <div id="productView" class="product-grid">
            <c:set value ="${prolist}" var = "prolist" />
            <c:forEach items= "${prolist}" var="list">
                <div class="product span3">
         <a href="<%= request.getContextPath() %>/product/productDetail?seqno=${list.proSeqno}">
                    <div class="pro-img">
                        <img class="" src="/upload/thumbnail/${list.item.itemImg}" style="  width: 250px; height: 250px;" >
                    </div>
         </a>
                    <h3 class="product-name">
                        <p><b>${list.item.itemDetail }</b></p>
                    </h3>
                    
                    <p class="product-info">
                        <p>재고 : ${list.proAmount } </p>
                    </p>
                            
                    <p class="product-price">
                        <p>총 판매금액 : ${list.proSaleprice }
                    </p>
                    
                    <div style="text-align: center;">
                      <button class="custom-btn btn-1 cn1"  onclick = "newwindow('<%= request.getContextPath() %>/cre/product_registration?seqno=${list.proSeqno}','modify');" >수정</button>
                  <%-- <button class="custom-btn btn-1" id="cn2" onclick = "prodelete('${list.proSeqno}')">삭제</button> --%>
                  <button data-no = "${list.proSeqno}" class="custom-btn btn-1 cn2"  <%-- onclick = "prodelete('${list.proSeqno}')" --%>>삭제</button>
                  </div>
                </div>
            </c:forEach>
         </div>
         
         
         <div class="info2">
            <img class="" src="<%= request.getContextPath() %>/img/user.png" style="height:150px; width:150px; border-radidus:50%;">
            <p class= name2><b>${sess_name}&nbsp;</b>님</p>
            <div class="proreg cn4">
           		 <a href ="javascript:newwindow('<%= request.getContextPath() %>/cre/product_registration','add');">등록</a>
            </div> 
            <p class="sum">총 정산금액</p>
            <p class="price2">${total }원</p>
            <div class="frame">
               <button class="custom-btn btn-2" onclick = "newwindow('<%= request.getContextPath() %>/cre/cremodify','modify');">정보수정</button>
               <button class="custom-btn btn-2" onclick = "location.href='<%= request.getContextPath() %>/cre/Adlist'">광고신청</button>
               <button class="custom-btn btn-2" onclick = "newwindow('<%= request.getContextPath() %>/cre/salesHistory','sale');">판매현황</button>
            </div>
         </div>
      
   </div>
  </div>
  
  <input type="radio" name="tabs" id="tabtwo">
  <label for="tabtwo">경매상품</label>
  <div class="tab">
<div class="mypage">
      <p class="mysale"><b>나의 경매내역</b></p><br><br><br><br><br>

         <div id="productView" class="product-grid">
            <c:set value ="${auclist}" var = "auclist" />
            <c:forEach items= "${auclist}" var="list">
                <div class="product span3">
                <a href="<%= request.getContextPath() %>/auc/auctionDetail?seqno=${list.aucSeqno}">
                    <div class="pro-img">
                        <img class="" src="/upload/thumbnail/${list.item.itemImg}"   style="  width: 250px; height: 250px;" >
                    </div>

                  </a>

                    <h3 class="product-name">
                        <p><b>${list.aucDetail }</b></p>
                    </h3>
                    <p class="product-info">
                        <p>시작 금액 : ${list.aucPrice } </p>
                    </p>
                    <c:if test="${list.aucStat != 'END'}">        
                    <p class="product-price">
                        <p>현재 입찰가 : ${list.aucCloseprice }
                    </p>
                    </c:if>
					 <c:if test="${list.aucStat eq 'END'}">
                    <p class="product-price">
                        <p>낙찰가 : ${list.aucCloseprice }
                    </p>
                     </c:if>
					
					
                    
                    <div style="text-align: center;">
                       <c:if test="${list.aucStat eq 'WAIT'}">
                         <button class="custom-btn btn-1" onclick = "newwindow('<%= request.getContextPath() %>/cre/auction_reg?seqno=${list.aucSeqno}','modify');">수정</button>
                     <button data-aucseqno="${list.aucSeqno}" data-itemseqno="${list.item.itemSeqno }" class="custom-btn btn-1 aucdelBtn">삭제</button>
                     </c:if>
                     <c:if test="${list.aucStat eq 'AUC_ING'}">
                     <button class="custom-btn btn-1" onclick = "location.href='<%= request.getContextPath() %>/auc/auctionDetail?seqno=${list.aucSeqno}'">진행중</button>
                     </c:if>
                     <c:if test="${list.aucStat eq 'END'}">
                     <button class="custom-btn btn-1" >종료물품</button>
                     </c:if>
                  </div>
                </div>
            </c:forEach>
   
         </div>
         
         
         <div class="info2">
            <img class="" src="<%= request.getContextPath() %>/img/user.png" style="height:150px; width:150px; border-radidus:50%;">
            <p class= name2><b>${sess_name}&nbsp;</b>님</p>
            <div class="proreg">
            <a href ="javascript:newwindow('<%= request.getContextPath() %>/cre/auction_reg','add');">경매등록</a>
            </div> 
            <p class="sum">총 정산금액</p>
            <p class="price2">${total }원</p>
            <div class="frame">
               <button class="custom-btn btn-2 cn3" onclick = "newwindow('<%= request.getContextPath() %>/cre/cremodify','modify');">정보수정</button>
               <button class="custom-btn btn-2" onclick = "location.href='<%= request.getContextPath() %>/cre/Adlist'">광고신청</button>
               <button class="custom-btn btn-2" onclick = "newwindow('<%= request.getContextPath() %>/cre/salesHistory','sale');">판매현황</button>
            </div>
         </div>
      
      
   </div>
  </div>
</div>
</div>
   
<%--   <%@ include file="/footer.jsp" %>  --%>
<script type="text/javascript" src="/js/creator.js"></script>	
	<script>

	$(document).ready(function(){
		
		
		$(".aucdelBtn").on("click",function(e){
			var aucseqno = $(this).data("aucseqno");
			var itemseqno = $(this).data("itemseqno");
			var arr = {
					aucSeqno:aucseqno,
					itemSeqno:itemseqno
			}
	   		$.ajax({
	 			type:'delete',
	 			url : '/cre2/delete',
	 			data : JSON.stringify(arr),
	 			contentType : 'application/json; charset=utf-8',
	 			success : function(result, status, xhr){
	 					alert(result);
	 					location.reload();
	 			},
	 			error : function(xhr,status,er){
	 				if(error){
	 					er(error);
	 				}
	 			}
	 		
	 		});
			
			
			
			
		})
		
		
	/* //크리에이터 정보 수정
		$(".cn3").on("click", function(e){
			 var creCompany = '<c:out value="${Creator.creCompany}" />'; 
			 var crePhone = '<c:out value="${Creator.crePhone}" />'; 
			 var creName = '<c:out value="${Creator.creName}" />'; 
			 var creAddress = '<c:out value="${Creator.creAddress}" />'; 
			 var creRegnum = '<c:out value="${Creator.creRegnum}" />'; 
			 var creSalenum = '<c:out value="${Creator.creSalenum}" />'; 
			 var crePot = '<c:out value="${Creator.crePot}" />'; 
			 var memid = '<c:out value="${Creator.memid}" />'; 
		
		 var ccc ={creCompany : creCompany,
					crePhone : crePhone,
					creName : creName,
					creAddress : creAddress,
					creRegnum : creRegnum,
					creSalenum : creSalenum,
					crePot : crePot,
					memid : id
					};
		
		 CreatorService.update(ccc, function(result){
			
			 if(result == '크리에이터 수정완료'){
				 window.close();
				 }
				
			 });
		}); */
		
	//일반물품 삭제버튼 클릭시
	
		$(".cn2").on("click", function(e) {
				
				var pro = $(this).data("no");
				console.log("삭제" + pro);
			
				CreatorService.remove(pro, function(result) {
					alert(result);
					location.reload();
				});
			});
		});
	</script>  
<script src="<%= request.getContextPath() %>/js/artistpage.js"></script>

<script type="text/javascript" src="/js/creator.js"></script>
</body>


</html>