<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/member/jmh_salesHistory.css">

<div class="jmh_mainpage">
	<div>
		<div class="tabs">
		    <input id="all" type="radio" name="tab_item" checked>
		    <label class="tab_item" for="all">판매 내역</label>
		    
		    <input id="programming" type="radio" name="tab_item">
		    <label class="tab_item" for="programming">판매 정보</label>
		    
		    <input id="monthsales" type="radio" name="tab_item">
		    <label class="tab_item" for="monthsales">이달의 내역</label>
		    
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
				<tr>
					<td class="jmh_saleshistoryboard">1
					</td>
					<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">이재신입니다.
					</td>
					<td class="jmh_saleshistoryboard">2022/08/02
					</td>
					<td class="jmh_saleshistoryboard">판매중
					</td>
					<td class="jmh_saleshistoryboard">999,990
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">2
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">3
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">4
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">5
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">6
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">7
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">8
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">9
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">10
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
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
				<tr>
					<td class="jmh_saleshistoryboard">2
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
					<td class="jmh_saleshistoryboard">999
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">3
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
					<td class="jmh_saleshistoryboard">999
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">4
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
					<td class="jmh_saleshistoryboard">999
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">5
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
					<td class="jmh_saleshistoryboard">999
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">6
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
					<td class="jmh_saleshistoryboard">999
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">7
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
					<td class="jmh_saleshistoryboard">999
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">8
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
					<td class="jmh_saleshistoryboard">999
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">9
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
					<td class="jmh_saleshistoryboard">999
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">10
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금
					</td>
					<td class="jmh_saleshistoryboard">999
					</td>
				</tr>
			</table>
			</div>
			<div class="tab_content" id="monthsales_content">
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
				<tr>
					<td class="jmh_saleshistoryboard">1
					</td>
					<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">이재신입니다.
					</td>
					<td class="jmh_saleshistoryboard">2022/08/02
					</td>
					<td class="jmh_saleshistoryboard">판매중
					</td>
					<td class="jmh_saleshistoryboard">999,990
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">2
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">3
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">4
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">5
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">6
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">7
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">8
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">9
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">10
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				</table>
			</div>
			<div class="tab_content" id="quarterlysales_content">
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
				<tr>
					<td class="jmh_saleshistoryboard">1
					</td>
					<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">이재신입니다.
					</td>
					<td class="jmh_saleshistoryboard">2022/08/02
					</td>
					<td class="jmh_saleshistoryboard">판매중
					</td>
					<td class="jmh_saleshistoryboard">999,990
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">2
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">3
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">4
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">5
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">6
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">7
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">8
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">9
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">10
					</td>
					<td class="jmh_saleshistoryboard .jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="<%= request.getContextPath() %>/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">판매물품명
					</td>
					<td class="jmh_saleshistoryboard">판매등록일
					</td>
					<td class="jmh_saleshistoryboard">판매현황
					</td>
					<td class="jmh_saleshistoryboard">판매금액
					</td>
				</tr>
				</table>
			</div>
		</div>
	</div> 
</div>