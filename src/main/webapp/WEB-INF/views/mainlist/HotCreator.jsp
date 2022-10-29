<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/mainlist/HotCreator.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="../header.jsp"%>
	<%@ include file="../menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

</head>
<body>

<h1 style = "text-align: center">Hot Cre8</h1>

<div class="container">
        <c:forEach items="${crelist}" var="list">
<a href="<%= request.getContextPath() %>/main/Detail?memid=${list.mem.memId}">
  <div class="card card0" style="background: url(/upload/${list.mem.att.savefilename}) center center no-repeat; background-size:300px;">
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



<%@ include file="../footer.jsp" %>



</body>
<script>
$(document).ready(function(){
	
	$('.card0').hover(function() {
		$(this).css("background-position","left");
		$(this).css("background-size","500px");
	},function(){
		$(this).css("background-position","center");
		$(this).css("background-size","300px");
	});
	
});
</script>
</html>