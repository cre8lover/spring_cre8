<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
<meta charset="UTF-8">
<title>물품 관리</title>
</head>

 <%@ include file="/admin/adminmenu.jsp" %>

		<div class="khm_searchs">
		<form method="get">
		<h2 class="khm_category">물품관리</h2>
			<table>
				<tbody>
					<tr>
						<th>
							카테고리
						</th>
						<td>
							<input type="hidden">
							<select name="ssecession"  onchange="goSearch();">
								<option>전체</option>
								<option>의류</option>
								<option>가전/가구</option>
								<option>화장품</option>							
								<option>인테리어</option>							
								<option>여행</option>							
								<option>기타</option>							
							</select>
						</td>
						<th>
							등록날짜
						</th>
						<td colspan="3">
							<input type="text" value="" class="date" >
							~
							<input type="text">
						</td>
						<th>경매여부</th>
						<td>
							<input type="hidden">
							<input type="radio" name="value"> Y
							<input type="radio" name="value"> N
						</td>
						<th>검색어</th>
						<td>
							<select name="stype">
								<option value="">전체</option>
								<option value="">상품분류</option>
								<option value="">물품 이름</option>
								<option value="">작성일자</option>
								<option value="">경매여부</option>
							</select>
						</td>
						<td class="bno">
							<input type="text" name="sval" id="sval" value="" />
						</td>
						<td class="bno">
							<input type="submit" value="검색" >
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
		
	<div style="padding-top:2%">
		<table>
		  <thead>
		    <tr>
		      <th>
		      	번호
		      </th>
		      <th>상품 분류</th>
		      <th>물품 이름</th>
		      <th>물품 가격</th>
		      <th>등록 날짜</th>
		      <th>상품 상태</th>
		      <th>경매 여부</th>
		    </tr>
		  </thead>
		  <tbody>
		   	<c:forEach items="${item}" var="item">			  
			    <tr>
			      <td>${item.proSeqno }</td>
			      <td>${item.cat.catName }</td>
			      <td>${item.item.itemName }</td>
			      <td>${item.proPrice }</td>
			      <td>${item.proOpendate }</td>
			      <td>${item.proStat }</td>
			      <td>${item.item.aucSet.aucStat }</td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
	
 </body>
</html>
