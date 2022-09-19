<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/member/login.css">

<meta charset="UTF-8">
<script src="<%= request.getContextPath() %>/js/login.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/cre8.css">
<title>로그인</title>

</head>
	<%@ include file="/header.jsp" %>
	<%@ include file="/menu.jsp" %>
<div class="jmh_tnwjd">
	<div class="khm_loginbox">
		<img src="<%= request.getContextPath() %>/img/cre8.png" style="margin-top:3.5%;">
		<form name="logincheck" method="post" action="<%= request.getContextPath() %>/mem/login">
			<table class="khm_login">
				<tr>
					<td>
						<input name="id" id="id" type="text" placeholder="ID" required onsubmit="">
					</td>
					<td rowspan="2">
						<input type="submit" value="로그인">
					</td>
				</tr>
				<tr>
					<td>
						<input name="pw" id="pw" type="password" placeholder="PW" required>
					</td>
				</tr>
			</table>
			<c:set value="${err }" var="err" /> 
				<c:if test="${err != null }">
					<p style="color:red">${err} </p>
				</c:if>
				
				<c:set value="${lostid }" var="lost" /> 
				<c:if test="${lost != null }">
					<p style="color:red">${lost} </p>
				</c:if>

				<c:set value="${lostpw }" var="lostpw" /> 
				<c:if test="${lostpw != null }">
					<p style="color:red">${lostpw} </p>
				</c:if>
		</form>
			<p>
		<div class="khm_sns">
			<a href="<%= request.getContextPath() %>/mem/memreg"><img src="<%= request.getContextPath() %>/img/memreg.png" id = "icon"></a>
			<a href="javascript:logintop()"><img src="<%= request.getContextPath() %>/img/find.png" id = "icon"></a>
			<a href="#"><img src="<%= request.getContextPath() %>/img/face.png" id = "icon"></a>
			<a href="#"><img src="<%= request.getContextPath() %>/img/kakao.png" id = "icon"></a>
		</div>
	</div>
	
	<div id="modal" background="#2782A5">
		<div class="modal-content">
			<button onclick="closepage()" style="border : 1px solid; background-color: white; height: 30px; float: right; font-size: 15px;">X</button>
			<h2>아이디찾기</h2>
					
 				<form method="post" action="<%= request.getContextPath() %>/mem/findId">		
				  <input type="text" name="idemail"  class="text-field" placeholder="이메일을 입력하세요" maxlength="10" placeholder="ID" required>
				  <input type="submit" value="아이디찾기" class="submit-but" >
				</form>  
			<h2>비밀번호찾기</h2>
				
				  <form method="post" action="<%= request.getContextPath() %>/mem/findpw">
				  <input type="text" name="findid"  class="text-field" placeholder="아이디를 입력하세요" maxlength="10" placeholder="ID" required>
				  <input type="text"  name="e-mail" class="text-field" placeholder="이메일을 입력하세요" placeholder="E-Mail" required>
				  <input type="submit" value="임시비밀번호 발급" class="submit-but" >
				</form>  
		</div>
	</div>	
	
	
</div>
<%@ include file="/footer.jsp" %>
</body>
</html>

