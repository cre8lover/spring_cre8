<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/buy/DetailClothes.css">
<link rel ="stylesheet" href="<%= request.getContextPath() %>/css/detailcss.css"> 
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/listimg/productcss.css">

</head>
<body>
	<%@ include file="/header.jsp" %>
	<%@ include file="/menu.jsp" %>
	<%@ include file="/banner/banner.jsp" %>


	<h2 style="text-align:center;">기러기 역삼역 별똥별 지금여기123jj3</h2>


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
	</div>
	</main>
	<%@ include file="/footer.jsp" %>
</body>
</html>