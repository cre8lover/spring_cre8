<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/listimg/sale.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<main>
	<div class="responsive-container">
		<div class="grid">
			<div class="grid-column">
			
				<a class="product" href="<%= request.getContextPath() %>/mainlist/productDetail.jsp">
					<div class="product-image">
						<img src="https://assets.codepen.io/285131/cosmonaut.jpg" />
					</div>
					<div class="product-content">
						<div class="product-info">
							<h2 class="product-title">[KCM ART] 안녕,지구!</h2>
							<p class="product-price">188,000 원</p>
						</div>
						<button class="product-action">&#128151;</button>
					</div>
				</a>

				<a class="product" href="<%= request.getContextPath() %>/mainlist/productDetail.jsp">
					<div class="product-image">
						<img src="https://assets.codepen.io/285131/hand-drawn-monster-milkshake.jpg" />
					</div>
					<div class="product-content">
						<div class="product-info">
							<h2 class="product-title">[KCM ART]단거위에 단거</h2>
							<p class="product-price">174,000 원</p>
						</div>
						<button class="product-action">&#128151;</button>
					</div>
				</a>
				<a class="product" href="<%= request.getContextPath() %>/mainlist/productDetail.jsp">
					<div class="product-image">
							<img src="https://assets.codepen.io/285131/pink-pastel-juicy-banana.jpg" />
					</div>
					<div class="product-content">
						<div class="product-info">
							<h2 class="product-title">[KCM ART]바나나는 원래 핑크다</h2>
							<p class="product-price">188,000 원</p>
						</div>
						<button class="product-action">&#128151;</button>
					</div>
				</a>
				

			</div>
			<div class="grid-column">
				<a class="product" href="<%= request.getContextPath() %>/mainlist/productDetail.jsp">
					<div class="product-image">
						<img src="https://assets.codepen.io/285131/palmistry.jpg" />
					</div>
					<div class="product-content">
						<div class="product-info">
							<h2 class="product-title">[KCM ART]내손을잡아!</h2>
							<p class="product-price">178,000 원</p>
						</div>
						<button class="product-action">&#128151;</button>
					</div>
				</a>
				<a class="product" href="<%= request.getContextPath() %>/mainlist/productDetail.jsp">
					<div class="product-image"> 
						<img src="https://assets.codepen.io/285131/fish-gas-mark.jpg" />
					</div>
					<div class="product-content">
						<div class="product-info">
							<h2 class="product-title">[KCM ART]심연의 물고기</h2>
							<p class="product-price">125,000 원</p>
						</div>
						<button class="product-action">&#128151;</button>
					</div>
				</a>
				<a class="product" href="<%= request.getContextPath() %>/mainlist/productDetail.jsp">
					<div class="product-image">
						<img src="https://assets.codepen.io/285131/mysterious-gangster-character-style.jpg" />
					</div>
					<div class="product-content">
						<div class="product-info">
							<h2 class="product-title">[KCM ART]냥아치</h2>
							<p class="product-price">188,000 원</p>
						</div>
						<button class="product-action">&#128151;</button>
					</div>
				</a>				
			</div>
			
			<div class="grid-column">
				<a class="product" href="<%= request.getContextPath() %>/mainlist/productDetail.jsp">
					<div class="product-image">
						<img src="https://assets.codepen.io/285131/adventure.jpg" />
					</div>
					<div class="product-content">
						<div class="product-info">
							<h2 class="product-title">[KCM ART]블루보틀</h2>
							<p class="product-price">165,000 원</p>
						</div>
						<button class="product-action">&#128151;</button>
					</div>
				</a>
				<a class="product" href="<%= request.getContextPath() %>/mainlist/productDetail.jsp">
					<div class="product-image">
						<img src="https://assets.codepen.io/285131/illustration-hand-with-cigarette-icon.jpg" />
					</div>
					<div class="product-content">
						<div class="product-info">
							<h2 class="product-title">[KCM ART]난 담배를 끊었어</h2>
							<p class="product-price">165,000 원</p>
						</div>
						<button class="product-action">&#128151;</button>
					</div>
				</a>
				<a class="product" href="<%= request.getContextPath() %>/mainlist/productDetail.jsp">
					<div class="product-image">
							<img src="https://assets.codepen.io/285131/pink-pastel-juicy-banana.jpg" />
					</div>
					<div class="product-content">
						<div class="product-info">
							<h2 class="product-title">[KCM ART]바나나는 원래 핑크다</h2>
							<p class="product-price">188,000 원</p>
						</div>
						<button class="product-action">&#128151;</button>
					</div>
				</a>
			</div>
			
			
		</div>
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
</main>


</body>
</html>