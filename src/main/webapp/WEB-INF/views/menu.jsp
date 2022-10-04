<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel ="stylesheet" href="<%= request.getContextPath() %>/css/changmok.css">
<script src="https://kit.fontawesome.com/236f0b5985.js" crossorigin="anonymous"></script>
<body>
<div class="reset">
	<nav class ="kcmnavbar">
		<ul class="kcmmenu">
			<li><a href="<%= request.getContextPath() %>/main/HotCreator"><i class="fa-solid fa-child-reaching testshow"></i><br>인기작가</a></li>
			<li><a href="<%= request.getContextPath() %>/main/NewCreator"><i class="fa-solid fa-thumbs-up testshow"></i><br>신규작가</a></li>
		<%-- 	<li><a href="<%= request.getContextPath() %>/cre/creReg"><i class="fa-solid fa-palette"></i><br>크리에이터</a></li> --%>
			<li><a href="<%= request.getContextPath() %>/auc/auction"><i class="fa-regular fa-handshake testshow"></i><br>경 매</a></li>
			<li><a name ="category"class="category" data-category="1"  href="<%= request.getContextPath() %>/product/cate/1"><i class="fa-solid fa-shirt"></i><br>의 류</a></li>
			<li><a name ="category" class="category" data-category="2" href="<%= request.getContextPath() %>/product/cate/2"><i class="fa-solid fa-computer"></i><br>가전/가구</a></li>
			<li><a name ="category" class="category" data-category="3" href="<%= request.getContextPath() %>/product/cate/3"><i class="fa-solid fa-soap"></i><br>화장품</a></li>
			<li><a name ="category" class="category"  data-category="4" href="<%= request.getContextPath() %>/product/cate/4"><i class="fa-solid fa-bed"></i><br>인테리어</a></li>
			<li><a name ="category" class="category" data-category="5" href="<%= request.getContextPath() %>/product/cate/5"><i class="fa-solid fa-plane"></i><br>여 행</a></li>
			<li><a data-category="6" href="<%= request.getContextPath() %>/master/adminlogin"><i class="fa-solid fa-file-lines"></i><br>기 타</a></li> 
		</ul>
	</nav>	
		<hr width = "100%" color = "#071E3D" size = "3">
</div>
</body>
<script>
</script>
</html>