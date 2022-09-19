<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <html>
    <body>
   <link rel="stylesheet" href="<%= request.getContextPath() %>/css/member/change_password.css">
<script src="<%= request.getContextPath() %>/js/change_password.js"></script>

 <!-- 비밀번호찾기-->
	<div id="modal2" background="#2782A5">
	<div class="modal-content">
		<button onclick="closepage()" style="border : 1px solid; background-color: white; height: 30px; float: right; font-size: 15px;">X</button>
		<center>
		<h2>비밀번호 변경</h2>
		</center>
			  <form method="post" action="#">	
			  *아이디를 입력하세요
			  <input type="text" name="id"  class="text-field" value="" maxlength="10" placeholder="ID" required>
			  *현재비밀번호를 입력하세요
			  <input type="password" name="n_password"  class="text-field" value="" maxlength="15" required>
			  *변경할비밀번호를 입력하세요
			  <input type="password"  name="c_password" class="text-field" value="" maxlength="15" required>
			  <input type="submit" value="비밀번호 변경" class="submit-but" >
			</form>  
	</div>
	</div>

	 </body>
    </html>