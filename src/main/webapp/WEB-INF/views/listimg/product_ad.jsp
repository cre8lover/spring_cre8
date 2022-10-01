<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/listimg/product_ad.css">
<meta charset="UTF-8">
<!-- <link rel ="stylesheet" href="css/products.css"> -->
<title>Insert title here</title>
</head>
<%-- 	<%@ include file="../header.jsp" %>
	<%@ include file="../menu.jsp" %> --%>
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

	<%@ include file="../sidebar.jsp" %>
	<%-- <%@ include file="../footer.jsp" %> --%>
<script type="text/javascript" scr="js/creator.js"></script>	
<script>
	$(document).ready(function(){
		
		function showList(){
			replyService.getList(function(list){
				
							
				/* 댓글이 없는 경우 */
				if(list == null || list.length == 0){
					$(".grid").html(""); //아무것도 안보이면됨
					return;
				}
				/* 댓글이 있는 경우 */
				var str ="";
				for(var i =0, len=list.length || 0; i< len; i++){
					console.log(list[i]);
					str += "<div class= 'grid-column>'"
					str += "<div class='product-image'>"
					str +=	"<img "+list[i].marImg+">"
					str += "</div>"
					str += "<div class='product-content'>"
					str += "<div class='product-info'>"
					str += "<h2 class='product-title'>"+list[i].marProduct+"</h2>"
					str += "<p class='product-price'>"+list[i].marPrice+"</p>"
					str += "</div>"
					str += "</div>"
					
					
					str += "</div>"
				}
				$(".grid").html(str);
			});
		}
		
		
	});
</script>	
</body>
</html>
