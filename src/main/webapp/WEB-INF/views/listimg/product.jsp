<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/listimg/product.css">
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
<h2 style="text-align:center;">작가 김창목 특별기획전</h2>
<main>
	<div class="responsive-container">
		<div class="grid">
		
			<c:set value="${proList}" var="mainList"/>
				<c:forEach items="${proList}" var="list">
				<c:set value="${list.item}" var="item"/>
		
			<div class="grid-column">
			
				<a class="product" href="<%= request.getContextPath() %>product/productDetail?seqno=${list.proSeqno}">
					<div class="product-image">
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

</body>
</html>
