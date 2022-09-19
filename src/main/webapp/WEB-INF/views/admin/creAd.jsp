<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
<meta charset="UTF-8">
<title>마케팅 상품관리</title>
</head>
<script src="<%= request.getContextPath() %>/js/artistpage.js"></script>

 <%@ include file="/admin/adminmenu.jsp" %>

		<div class="khm_searchs">
		<h2 class="khm_category">마케팅 상품관리</h2>
			<form method="post">
				<table>
					<tbody>
						<tr>
							<th>
								등록일자
							</th>
							<td colspan="3">
								<input type="date" value="sdate" class="date" >
								~
								<input type="date" value="fdate" class="date" >
							</td>
							<th>검색어</th>
							<td>
								<select name="classification">
									<option value="999" <c:if test="${key.classification == '999'}">selected</c:if>>전체</option>
									<option value="mar_product" ${key.classification == 'mar_product' ? 'selected': '' }>상품이름</option>
									<option value="mar_company" ${key.classification == 'mar_company' ? 'selected': '' }>업체명</option>
									<option value="mar_ceo" ${key.classification == 'mar_ceo' ? 'selected': '' }>대표이름</option>
									<option value="mar_phone" ${key.classification == 'mar_phone' ? 'selected': '' }>업체번호</option>
									<option value="mar_regnum" ${key.classification == 'mar_regnum' ? 'selected': '' }>사업자번호</option>
								</select>
							</td>
							<td class="bno">
								<input type="text" name="keysearch" id="search" value="${key.keyword }" />
							</td>
							<td class="bno">
								<input type="submit" value="검색" >
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		
		<div>
			<form class="khm_button">
				<input type="button" value="등록" onclick = "newwindow('<%= request.getContextPath() %>/master/adreg','reg');">
			</form>
		</div>

	<div>
		<table>
		  <thead>
		    <tr>
		      <th>수정</th>
		      <th>
		      	번호
		      </th>
		      <th>상품 이름</th>
		      <th>업체명</th>
		      <th>대표 이름</th>
		      <th>업체번호</th>
		      <th>사업자 번호</th>
		      <th>등록 날짜</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${marketing}" var="market">			  
			    <tr>
			    
			      <td>
			      	<a href="javascript:newwindow('<%= request.getContextPath() %>/master/admodify?seqno=${market.marSeqno }','modi')">
			      		<button>
			      		수정
			      		</button>
			      	</a>
			      	<input type="hidden" value="${market.marSeqno }" name="seqno">
			      </td>
			      <td>${market.no }</td>
			      <td>${market.marProduct }</td>
			      <td>${market.marCompany }</td>
			      <td>${market.marCeo }</td>
			      <td>${market.marPhone }</td>
			      <td>${market.marRegnum }</td>
			      <td>${market.marOpendate }</td>
			    
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>

 </body>
</html>
