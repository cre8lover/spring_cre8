<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/cre8.css">
<title>회원가입</title>
</head>
<body>
	<div class="body">
		<div class="leftSideBar"></div>
		<div class="content"> 
		
			<div class="khm_memtext">
			<div>
				<img src="<%= request.getContextPath() %>/img/cre8.png" style="margin-top:3.5%;">
			</div>
				<h2>회원가입</h2>
				<hr>
				<div>
					<form method="post" onsubmit="">
						<table class="khm_memreg">
							<tr>
							<td>
								*아이디<br>
	     						<input type="text" name="id" id="id" size="15">
							</td>
							</tr>
							<tr>
							<td>
								*비밀번호<br>
								<input type="password" name="passwd" id="passwd" size="15" required></td>
							</tr>
							<tr>
							<td>
								*비밀번호 확인<br>
								<input type="password" name="repasswd" id="repasswd" size="15" required></td>
							</tr>
							<tr>
							<td>
								*이름<br>
								<input type="text" name="mname" id="mname" size="15" required></td>
							</tr>
							<tr>
								<td>
									*전화번호<br>
									<input type="text" name="tel" id="tel" size="15" >
									<button>인증요청</button>
								</td>
							</tr>
							<tr>
								<th colspan = "2">
									<input type="submit" value="회원가입">
								</th>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		<div class="rightSideBar"></div>
	</div>
    
</body>
</html>