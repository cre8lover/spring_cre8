<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/banner/banner.css">
	<meta charset='utf-8'>
	<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>

<div class="section" >
	<input type="radio" name="slide" id="slide01" checked >
	<input type="radio" name="slide" id="slide02" >
	<input type="radio" name="slide" id="slide03" >
	<div class="slidewrap">
		
		<ul class="slidelist">
			<!-- 슬라이드 영역 -->
			<li class="slideitem">
				<a>
					<div class="textbox">
						<!-- <p>첫번째 슬라이드 입니다.</p> -->
					</div>
					<img src="<%= request.getContextPath() %>/img/banner1.png">
				</a>
			</li>
			<li class="slideitem">
				<a>
					
					<div class="textbox">
						<!-- <p>두번째 슬라이드 입니다.</p> -->
					</div>
					<img src="<%= request.getContextPath() %>/img/banner2.png">
				</a>
			</li>
			<li class="slideitem">
				<a>
					
					<div class="textbox">
						<!-- <p>세번째 슬라이드 입니다.</p> -->
					</div>
					<img src="<%= request.getContextPath() %>/img/banner3.png">
				</a>
			</li class="slideitem">

			<!-- 좌,우 슬라이드 버튼 -->
			<div class="slide-control">
				<div>
					<label for="slide03" class="left"></label>
					<label for="slide02" class="right"></label>
				</div>
				<div>
					<label for="slide01" class="left"></label>
					<label for="slide03" class="right"></label>
				</div>
				<div>
					<label for="slide02" class="left"></label>
					<label for="slide01" class="right"></label>
				</div>
			</div>

		</ul>
		<!-- 페이징 -->
		<ul class="slide-pagelist">
			<li><label for="slide01"></label></li>
			<li><label for="slide02"></label></li>
			<li><label for="slide03"></label></li>
		</ul>
	</div>

	
</div>

<script>

$(document).ready(function(){
   const gogogo = setInterval(sliderGo, 3000);
   var i = 1;
	  function sliderGo(){
		 if (i > 3){
			 i = 1;
		 }else{
			 i += 1;
		 }
		 $("input:radio[id='slide0"+i+"']").prop('checked', true); 
	  }
});

	   
</script>	
</body>
</html>
    