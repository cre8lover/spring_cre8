<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/creater/jmh_salesHistory.css">

<div class="jmh_mainpage">
	<div>
		<div class="tabs">
		    <input id="all" type="radio" name="tab_item" checked>
		    <label class="tab_item" for="all">판매 내역</label>
		    
		    <input id="programming" type="radio" name="tab_item">
		    <label class="tab_item" for="programming">판매 정보</label>
		    
		    <input id="monthsales" type="radio" name="tab_item">
		    <label class="tab_item" for="monthsales">월간 내역</label>
		    
		    <input id="quarterlysales" type="radio" name="tab_item">
		    <label class="tab_item" for="quarterlysales">연간 내역</label>
		    
		    <div class="tab_content" id="all_content">
		    	<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">판매번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">판매물품
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">판매물품명
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth4">판매등록일
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">판매현황
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6">판매금액
					</th>
				</tr>
				<c:forEach items="${cre }" var="pro">
				<tr>
					<td class="jmh_saleshistoryboard">${pro.item.itemAmount}
					</td>
					<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2">${pro.item.itemImg }
					</td>
					<td class="jmh_saleshistoryboard">${pro.item.itemName}
					</td>
					<td class="jmh_saleshistoryboard">${pro.proOpendate}
					</td>
					<td class="jmh_saleshistoryboard">${pro.proStat} (${pro.proDetail })
					</td>
					<td class="jmh_saleshistoryboard">${pro.proAmount }
					</td>
				</tr>
				</c:forEach>
				</table>
			</div>
			    <div class="tab_content" id="programming_content">
					<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">판매번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">판매물품
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">판매물품명
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth4">구매자 이름
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">구매자 번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6">구매자 주소
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6">구매 수량
					</th>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">1
					</td>
					<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">이재신입니다.
					</td>
					<td class="jmh_saleshistoryboard">고영재
					</td>
					<td class="jmh_saleshistoryboard">010-XXXX-XXXX
					</td>
					<td class="jmh_saleshistoryboard">서울 어딘가
					</td>
					<td class="jmh_saleshistoryboard">999
					</td>
				</tr>
			</table>
			</div>
			<div class="tab_content" id="monthsales_content">
			<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">판매월
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">판매건수
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">총 판매금액
					</th>
				</tr>
				<c:forEach items="${month}" var="pro">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">${pro.proDetail }
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">${pro.proClosedate }
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">${pro.proOpendate }원
					</th>
				</tr>
				</c:forEach>

				</table>
			</div>
			<div class="tab_content" id="quarterlysales_content">
			<table class="jmh_saleshistoryboard jmh_mainboardlength">
					<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">판매년도
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">판매건수
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">총 판매금액
					</th>
				</tr>
				
				<c:forEach items="${year}" var="pro">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">${pro.proDetail }
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">${pro.proClosedate }
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">${pro.proOpendate }원
					</th>
				</tr>
				</c:forEach>
				
				
				</table>
			</div>
		</div>
	</div> 
</div>