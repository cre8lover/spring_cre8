<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/member/buyHistory.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script src="<%= request.getContextPath() %>/js/buyHistory.js"></script>

	<c:set value="${buy}" var="buy" />		  
<c:set var = "total" value = "0" />
<div class="jmh_mainpage">
	<div>
		<div class="tabs">
		    <input id="all" type="radio" name="tab_item" checked>
		    <label class="tab_item" for="all">구매내역</label>
		    
		    <input id="programming" type="radio" name="tab_item">
		    <label class="tab_item" for="programming">경매참여내역</label>
		    
		    <input id="monthsales" type="radio" name="tab_item">
		    <label class="tab_item" for="monthsales">취소/반품/교환</label>
		    
			<div class="tab_content" id="all_content">
		    	<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">구매번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">구매물품
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">구매물품명
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth4">구매일
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">수량
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6">금액
					</th>
				</tr>
				<c:forEach items="${buy}" var="list">	
				<c:set var= "total" value="${total + 1}"/>
					<tr class="flip" style="cursor:pointer;" id="${total}">
						<td class="jmh_saleshistoryboard" > ${list.proSeqno }
						</td>
						<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2">${list.item.itemImg }
						</td>
						<td class="jmh_saleshistoryboard" >${list.item.itemName }
						</td>
						<td class="jmh_saleshistoryboard">${list.ordersSet.orderDate }
						</td>
						<td class="jmh_saleshistoryboard">${list.ordersSet.orderAmount }
						</td>
						<td class="jmh_saleshistoryboard">${list.ordersSet.orderTotalprice }
						</td>
					</tr>
					<tr class="panel${total}" style="display:none;">
					<td  colspan='6' id="block">
						<%@ include file="/buy/buyDetail.jsp" %>
					</td>
					</tr>
				</c:forEach>
				</table>
			
			
				<div ></div>
			</div>
			    <div class="tab_content" id="programming_content">
					<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">경매번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">경매물품
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">경매물품명
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth4">경매참여일
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">입찰상태
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6">입찰금액
					</th>
				</tr>
				
				<c:forEach items="${car2}" var="ing">			  
					<tr>
						<td class="jmh_saleshistoryboard">${ing.auc.aucSeqno }
						</td>
						<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2">${ing.auc.aucImg }
						</td>
						<td class="jmh_saleshistoryboard">${ing.auc.item.itemName }
						</td>
						<c:forEach items="${ing.auc.aucNowingSet}" var="nowing">			  
							<td class="jmh_saleshistoryboard">${nowing.aucnowDate }
							</td>
						</c:forEach>	
						<td class="jmh_saleshistoryboard">${ing.auc.aucStat }
						</td>
						<td class="jmh_saleshistoryboard">${ing.auc.aucCloseprice }
						</td>
					</tr>
				</c:forEach>
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1" colspan='7'>경매 종료
					</th>
				</tr>
				<c:forEach items="${cart}" var="end">			  
					<tr>
						<td class="jmh_saleshistoryboard">${end.cartSeqno }
						</td>
						<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2">${end.pro.item.itemImg }
						</td>
						<td class="jmh_saleshistoryboard">${end.pro.item.itemName }
						</td>
						<td class="jmh_saleshistoryboard">${end.ordersSet.orderDate }
						</td>
						<td class="jmh_saleshistoryboard">${end.auc.aucStat }
						</td>
						<td class="jmh_saleshistoryboard">${end.ordersSet.orderTotalprice }
						</td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div class="tab_content" id="monthsales_content">
			<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">상품번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">상품
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">상품명
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth4">신청날짜
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">처리상태
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6">금액
					</th>
				</tr>
				<c:forEach items="${stat}" var="stat">			  
					<tr>
						<td class="jmh_saleshistoryboard">${stat.proAmount }
						</td>
						<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2">${stat.item.itemImg }
						</td>
						<td class="jmh_saleshistoryboard">${stat.item.itemName }
						</td>
						<td class="jmh_saleshistoryboard">${stat.ordersSet.orderDate }
						</td>
						<td class="jmh_saleshistoryboard">${stat.ordersSet.orderdetailSet.orderdetailStat }
						</td>
						<td class="jmh_saleshistoryboard">${stat.proPrice }
						</td>
					</tr>
				</c:forEach>	
				</table>
			</div>
		</div>
	</div> 
</div>