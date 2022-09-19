<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/mainlist/HotCreator.css">
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="/header.jsp"%>
	<%@ include file="/menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

</head>
<body>

<h1 style = "text-align: center">Hot Cre8</h1>

<div class="container">
        <c:forEach items="${crelist}" var="list">
<a href="<%= request.getContextPath() %>/cre/Detail">
  <div class="card card0">
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




<%@ include file="/footer.jsp" %>



</body>
</html>