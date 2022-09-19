<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>의류</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/listimg/productcss.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

</head>
<body>
<%@ include file="/header.jsp" %>
	<%@ include file="/menu.jsp" %>
	<div class="mypage">
	<br>
	<h2>Clothes</h2>
	<div>
	
	  <input type="radio" id="pop" name="new" value="pop" checked>인기순
	  <input type="radio" id="new" name="new" value="new" >최신순
	
	<main>
		<div class="responsive-container">
			<div class="grid">
				
				<c:set value="${proList}" var="proList_clothes"/>
				<c:forEach items="${proList}" var="list">
				<c:set value="${list.item}" var="item"/>
				<div class="grid-column">
					<a href="<%= request.getContextPath() %>/product/productDetail?seqno=${list.proSeqno}">
							
						<div class="product-image" style = " width: 338.68px; height: 338.68px; object-fit: cover; background-color:#e6f2ff;">
							${item.itemImg}
						</div>
						<div class="product-content">
							<div class="product-info">
								<h2 class="product-title">${item.itemName}</h2>
								<p class="product-price">${list.proPrice} 원</p>
							</div>
							<button class="product-action">&#128151;</button>
						</div>
					</a>
				</div>
				</c:forEach>
			</div>	
				
				
			
	  			<div class="page-wrap">
	                    <ul class="page-nation">
	                        <li><a href="/board/listp=1">◀</a></li>
	                        <li><a href="/board/listp=1">1</a></li>
	                        <li><a href="/board/listp=2">2</a></li>
	                        <li><a href="/board/listp=3">3</a></li>
	                        <li><a href="/board/listp=4">4</a></li>
	                        <li><a href="/board/listp=5">5</a></li>
	                        <li><a href="/board/listp=5">▶</a></li>
	                    </ul>
	             </div>
	             
	   </div>
	</main>
	</div>
	</div>
<%@ include file="/footer.jsp" %>
</body>
</html>