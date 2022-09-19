<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/creater/jmh_salesHistory.css">
<meta charset="UTF-8">
<title>광고상품 주문내역조회</title>
</head>

 <%@ include file="/admin/adminmenu.jsp" %>

		<div class="khm_searchs">
		<h2 class="khm_category">광고상품 주문관리</h2>
			<form method="get">
				<table>
					<tbody>
						<tr>
							<th>
								등록일자
							</th>
							<td colspan="3">
								<input type="date" name="sdate" value="sdate" class="date" selected>
								~
								<input type="date" name="fdate" value="fdate" class="date" selected>
							</td>
							<th>검색어</th>
							<td>
								<select name="classification">
									<option value="998" <c:if test="${key.classification == '998'}">selected</c:if>>전체</option>
									<option value="mar_product" ${key.classification == 'mar_product' ? 'selected': '' }>판매 물품명</option>
									<option value="mem_name" ${key.classification == 'mem_name' ? 'selected': '' }>구매자</option>
									<option value="mar_stat" ${key.classification == 'mar_stat' ? 'selected': '' }>판매 현황</option>
								</select>
							</td>
							<td class="bno">
								<input type="text" name="keysearch" id="sval" value="${key.keyword }" />
							</td>
							<td class="bno">
								<input type="submit" value="검색" >
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>

	<div class="tabs">
		    <input id="programming" type="radio" name="tab_item" checked>
		    <label class="tab_item" for="programming">판매 정보</label>
		    
		    <input id="monthsales" type="radio" name="tab_item">
		    <label class="tab_item" for="monthsales">월간 내역</label>
		    
		    <input id="quarterlysales" type="radio" name="tab_item">
		    <label class="tab_item" for="quarterlysales">연간 내역</label>
		    
			    <div class="tab_content" id="programming_content">
					<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">판매번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">판매물품명
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">판매등록일
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth4">구매자
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">구매 수량
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">판매 금액
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6">총 금액
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6">판매 현황
					</th>
				</tr>
				<c:forEach items="${list}" var="list">
					<tr>
						<td class="jmh_saleshistoryboard">${list.marSeqno }
						</td>
						<td class="jmh_saleshistoryboard">${list.marProduct }
						</td>
						<td class="jmh_saleshistoryboard">${list.marOpendate }
						</td>
						<td class="jmh_saleshistoryboard">${list.marInfo }
						</td>
						<td class="jmh_saleshistoryboard">${list.cnt }
						</td>
						<td class="jmh_saleshistoryboard">${list.marPrice }
						</td>
						<td class="jmh_saleshistoryboard">${list.marDetail }
						</td>
						<td class="jmh_saleshistoryboard">${list.marStat }
						</td>
					</tr>	
				</c:forEach>	
			</table>
			</div>
			<div class="tab_content" id="monthsales_content">
			<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">판매번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth4">기간
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">판매 건수
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6 totalamount">월간 총액
					</th>
				</tr>
				
			  	<c:forEach items="${month}" var="mon">			  
					<tr>
						<td class="jmh_saleshistoryboard">${mon.marSeqno }
						</td>
						<td class="jmh_saleshistoryboard">${mon.marOpendate }
						</td>
						<td class="jmh_saleshistoryboard">${mon.cnt }
						</td>
						<td class="jmh_saleshistoryboard">${mon.marPrice }
						</td>
					</tr>
				</c:forEach>
				
				</table>
			</div>
			<div class="tab_content" id="quarterlysales_content">
			<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">판매번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth4">기간
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">판매 건수
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6 totalamount">연간 총액
					</th>
				</tr>
			  	<c:forEach items="${year}" var="yea">			  
					<tr>
						<td class="jmh_saleshistoryboard">${yea.marSeqno }
						</td>
						<td class="jmh_saleshistoryboard">${yea.marOpendate }
						</td>
						<td class="jmh_saleshistoryboard">${yea.cnt }
						</td>
						<td class="jmh_saleshistoryboard">${yea.marPrice }
						</td>
					</tr>
				</c:forEach>
				</table>
			</div>
		</div>

 </body>
</html>
