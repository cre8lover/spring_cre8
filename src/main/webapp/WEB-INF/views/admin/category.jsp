<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
<meta charset="UTF-8">
<title>카테고리 관리</title>

</head>

 <%@ include file="/admin/adminmenu.jsp" %>

		<div class="khm_searchs">
		<h2 class="khm_category">카테고리</h2>
		<form method="post" name="catesearch" action="<%= request.getContextPath() %>/master/category">
				<table>
					<tbody>
						<tr>
							<th>
								분류
							</th>

							<td>
								<input type="hidden">
								<select name="gory"  onchange="this.form.submit()">
									<option value="999" <c:if test="${key.category == 999}">selected</c:if>>전체</option>
									<option value="1" ${key.category == 1 ? 'selected': '' }>의류</option>
									<option value="2" ${key.category == 2 ? 'selected': '' }>가전/가구</option>
									<option value="3" ${key.category == 3 ? 'selected': '' }>화장품</option>							
									<option value="4" ${key.category == 4 ? 'selected': '' }>인테리어</option>							
									<option value="5" ${key.category == 5 ? 'selected': '' }>여행</option>							
									<option value="6" ${key.category == 6 ? 'selected': '' }>인기상품</option>							
								</select>
							</td>
							<th>
								등록일자
							</th>
							<td colspan="3">
								<input type="date" name="sdate" class="date" >
								~
								<input type="date" name="fdate" class="date" >
							</td>
							<th>검색어</th>
						<!--
							<td>
							 	<select name="stype" onchange="goSearch()">
									<option value="all">전체</option>
									<option value="">대분류</option>
									<option value="">소분류</option>
									<option value="">이름</option>
									<option value="">작성자</option>
								</select>
							</td>
						 -->	
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
		
		<!-- <div>
			<form class="khm_button">
				<input type="button" value="등록">
				<input type="button" value="수정">
				<input type="button" value="삭제">
			</form>
		</div> -->

	<div>
		<table>
		  <thead>
		    <tr>
		      <th>
		      	<input type="checkbox" name="check" id="check" onclick="">
		      </th>
		      <th>
		      	번호
		      </th>
		      <th>대분류</th>
		      <th>작성자</th>
		      <th>등록 날짜</th>
		    </tr>
		  </thead>
		  <tbody>
			  <c:forEach items="${cate}" var="gory">			  
			    <tr>
			      <td>
			      	<input type="checkbox" name="check" id="check" onclick="">
			      </td>
			      <td>${gory.catSeqno }</td>
			      <td>${gory.catName }</td>
			      <td>${gory.mem.memName }</td>
			      <td>${gory.catRegdate }</td>
			    </tr>
			  </c:forEach>
	    
		  </tbody>
		</table>
		
		<div class="page">
			<c:if test ="${pageMaker.prev}">
			  <a href="<%= request.getContextPath() %>/master/category?currentPage=${pageMaker.startPage-1}&tap_item=${cate}">&laquo;</a>
			</c:if>
			  <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			  	<a href="<%= request.getContextPath() %>/master/category?currentPage=${num }&tab_item=${cate}"
			  	class="${pageMaker.cri.currentPage == num ? "active" : "" }">${num}</a>
			   </c:forEach>
			  
			  <!-- <a class="active" href="#">2</a> -->
			<c:if test="${pageMaker.next}">
			  <a href="<%= request.getContextPath() %>/master/category?currentPage=${pageMaker.endPage+1}&tap_item=${cate}">&raquo;</a>
			</c:if>
		</div>
	</div>
<script>
function goSearch(){ 
	document.form1.submit(); 
	}
</script>
 </body>
</html>
