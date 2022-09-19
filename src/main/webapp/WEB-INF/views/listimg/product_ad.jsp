<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/listimg/product_ad.css">
<meta charset="UTF-8">
<!-- <link rel ="stylesheet" href="css/products.css"> -->
<title>Insert title here</title>
</head>
	<%@ include file="/header.jsp" %>
	<%@ include file="/menu.jsp" %>
<body>
<h2 style="text-align:center;"><판매량UP!UP! 외부마케팅></h2>
<main>
	<div class="responsive-container">
		<div class="grid">
			
			<c:set value = "${marketing}" var = "marketing" />
			<c:forEach items="${marketing}" var = "list">
			<div class="grid-column">
				<a href="<%= request.getContextPath() %>/cre/marketingDetail?seqno=${list.marSeqno}">     
					<div class="product-image">
						<img class="" ${list.marImg}>
					</div>
					<div class="product-content">
						<div class="product-info">
						<!--a링크 달고 marseqno 로 넘어가게 수정!-->
							<h2 class="product-title">${list.marProduct}</h2>
							<p class="product-price">${list.marPrice}</p>
						</div>
						<button class="product-action">&#128151;</button>
					</div>
				
				</a>
		</div>
			</c:forEach>
			</div>
	</div>

	<%@ include file="/sidebar.jsp" %>
	<%@ include file="/footer.jsp" %>
</body>
</html>
