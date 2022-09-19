<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <html>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/member/findPassWord_modal.css">
    <body>
   
<script src="<%= request.getContextPath() %>/js/findPassWord_modal.js"></script>

 <!-- 비밀번호찾기-->
	<div id="modal" background="#2782A5">
	<div class="modal-content">
		<button onclick="closepage()" style="border : 1px solid; background-color: white; height: 30px; float: right; font-size: 15px;">X</button>
		<h2>아이디찾기</h2>
				
			  <form method="post" action="#">	
			  <input type="text" name="email"  class="text-field" value="이메일을 입력하세요" maxlength="10" placeholder="ID" required>
			  <input type="submit" value="아이디찾기" class="submit-but" >
			</form>  
		<h2>비밀번호찾기</h2>
			
			  <form method="post" action="#">
			  <input type="text" name="id"  class="text-field" value="아이디를 입력하세요" maxlength="10" placeholder="ID" required>
			  <input type="text"  name="e-mail" class="text-field" value="이메일을 입력하세요" placeholder="E-Mail" required>
			  <input type="submit" value="임시비밀번호 발급" class="submit-but" >
			</form>  
	</div>
	</div>
	

	 </body>
    </html>