<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/mainlist/NewCreator.css">
<%@ include file="../header.jsp"%>
	<%@ include file="../menu.jsp"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>

</head>
<body>

<h1 style = "text-align: center">New Cre8</h1>

<div class="container">
<div class="container">
        <c:forEach items="${crelist}" var="list">
<a href="<%= request.getContextPath() %>/main/Detail?memid=${list.mem.memId}">
  <div class="card card0" style="background: url(/upload/${list.mem.att.attName}) center center no-repeat;">
    <div class="border" >
       <h2>${list.mem.memName}</h2>
      <div class="icons" >
        <i class="fa fa-instagram" aria-hidden="true">${list.mem.memSnsinfo}</i>
        <i class="fa fa-twitter" aria-hidden="true">${list.mem.memSnsinfo}</i>
        <i class="fa fa-facebook" aria-hidden="true">${list.mem.memSnsinfo}</i>
      </div>
    </div>
  </div>
  </a>
        </c:forEach>
</div>
</div>
<%@ include file="../footer.jsp" %>




</body>
<script>
$(document).ready(function(){
	
	$('.card0').hover(function() {
		$(this).css("background-position","left"); 
	},function(){
		$(this).css("background-position","center");
	});
	
});
</script>

</html>