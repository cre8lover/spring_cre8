<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
<meta charset="UTF-8">
<title>관리자 메인</title>
</head>

<%@ include file="/admin/adminmenu.jsp" %>

<div class="khm_manage">
	<a>신규주문 0건</a>
	<a>취소요청 0건</a>
	<a>반품관리 0건</a>
	<a>교환관리 0건</a>
	<a>건의사항 0건</a>
</div>

</body>
</html>
