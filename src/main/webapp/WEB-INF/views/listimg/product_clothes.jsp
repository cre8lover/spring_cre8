<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>의류</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/listimg/productcss.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

</head>
<body>
<%@ include file="../header.jsp" %>
	<%@ include file="../menu.jsp" %>
	<div class="mypage">
	<br>
	<h2>Clothes</h2>
	<div>
	
	  <input type="radio" id="pop" name="new" value="pop" checked>인기순
	  <input type="radio" id="new" name="new" value="new" >최신순
	
	<main>
		<div class="responsive-container">
			<div id="grid"class="grid">
				
				<%-- <c:set value="${proList}" var="proList_clothes"/>
				<c:forEach items="${proList}" var="list">
				<c:set value="${list.item}" var="item"/>
				<div class="grid-column">
					<a href="<%= request.getContextPath() %>/product/productDetail?seqno=${list.proSeqno}">
							
						<div class="product-image" style = " width: 338.68px; height: 338.68px; object-fit: cover; background-color:#e6f2ff;">
							<img src="/upload/thumbnail/${item.itemImg}" alt="My Image">
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
				</c:forEach> --%>
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
<%@ include file="../footer.jsp" %>
<script>








$(document).ready(function(){
	
 	var currentPage = 1;
	var category = "<c:out value='${category}'/>";
	showList(category);
	var page = 1;
	var path = '<%= request.getContextPath() %>';
	$('a[name="category"]').on("click",function(e){
/* 	$(".kcmmenu").children('li').children('a').on("click",function(e){ */
		category = $(this).data("category");
		console.log("click"+category);
		e.preventDefault();
		showList(category,page);
	});
	
	function showList(category,page){
		
		mainlist.getList({page:page, category:category}, function(replyCnt,list){
		if(list == null || list.length == 0){
			$("#grid").html("");
			return;
		}
			
		var str="";
		for(var i = 0, len=list.length || 0; i < len; i++){
			console.log(list[i].item_name);
			str += "<div class='grid-column'>";
			str +=		"<a href='"+ path +"/product/productDetail?seqno="+list[i].pro_seqno+"'>";
			str +=			"<div class='product-image' style = ' width: 338.68px; height: 338.68px; object-fit: cover; background-color:#e6f2ff;'>";
			str +=				"<img  src='/upload/thumbnail/"+list[i].item_img+"'  style = ' width: 338.68px; height: 338.68px; object-fit: cover; alt='My Image'>";
			str +=			"</div>";
			str +=			"<div class='product-content'>";
			str +=				"<div class='product-info'>";
			str +=					"<h2 class='product-title'>"+list[i].item_name+"</h2>";
			str +=					"<p class='product-price'>"+list[i].pro_price+" 원</p>";
			str +=				"</div>";
			str +=			"<button class='product-action'>&#128151;</button>";
			str +=			"</div>";
			str +=		"</a>";
			str +=	"</div>";
		}
		
			/* console.log(str); */
			$("#grid").html(str);
			showReplyPage(replyCnt);
		});
	}

	function showReplyPage(replyCnt){
		
		var endPage = Math.ceil(currentPage/5.0)*5;
		var startPage = endPage - 4;
		
		console.log("endPage:"+endPage);
		
		var prev = startPage != 1;
		var next = false;
		
		if (endPage * 5 >= replyCnt){
			endPage = Math.ceil(replyCnt/5.0);	
		}
		if(endPage * 5 < replyCnt){
			next = true;
		}
		
		var str = "<ul class='page-nation' style='display: flex; list-style:none; justify-content: space-around;'>";
		
		if(prev){
			str += "<li class='page-link'>";
			str += "<a href='"+(startPage-1)+"'> 이전페이지</a></li>";
		}
		
		for (var i=startPage; i <= endPage; i++){
			var active = currentPage == i ? "active" : "";
			str += "<li class='page-link " + active + "'>";
			str += "<a href='" +i+ "'>" +i+ "</a></li>";
		}
		if (next){
			str += "<li class='page-link'>";
			str += "<a href='" +(endPage+1)+ "'>다음페이지</a></li>";
		}
		
		str += "</ul>";
		/* console.log(str); */
		$(".page-wrap").html(str);
		
	}
	
	$(".page-wrap").on("click", "li a", function(e){
		console.log("page click...........");
		e.preventDefault(); //a태그를 눌러도 href링크로 이동하지 않게
		var clickPage = $(this).attr("href");
		
		console.log("currentPage : " + clickPage);
		currentPage = clickPage;
		showList(category,currentPage);
		
	});
	
});




var mainlist = (function(){

	 	
  	
  	function getList(param, callback, error){
 		var category = param.category;
 		var page = param.page || 1;
 		
 		$.getJSON("/mainrest/list/"+category+"/"+page+".json",function(data){
 			if(callback){
 				callback(data.total,data.list);
 			}
 		}).fail(function(xhr,status,err){ 
 			if(error){
 				error();
 			}
 		});
 	}	
	 	
	 	
 	return {
 		getList : getList
	};
 	
})();




</script>


</body>
</html>