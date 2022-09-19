<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/cre8.css">
<script src="<%= request.getContextPath() %>/js/memreg.js"></script>
<title>회원가입</title>
</head>
<body>
	<%@ include file="/header.jsp" %>
	<%@ include file="/menu.jsp" %>
<div class="jmh_body">
	<div class="body">
		<div class="leftSideBar"></div>
		<div class="content"> 
		
		<h2>회원가입</h2>
		<hr>
						
		<c:set value="${page}" var="my" />
		
        <div class="khm_memreg">
            <div class="khm_content">
            <form name="cre8reg" method="post" action="<%= request.getContextPath() %>/mem/memregform" onsubmit="return regCheck()">
                <!-- 아이디 -->
                <div>
                    <h3>아이디</h3>
                    <input type="text" id="id" name="id" class="khm_text" maxlength="20" placeholder="아이디" onchange="idcheck('<%= request.getContextPath() %>')">
                    <input type="hidden" id="isidcheck">
                    <p id="idcheckmsg" style="color:red;"></p>
                </div>

                <!-- 비밀번호 -->
                <div>
                    <h3>비밀번호</h3>
                    <input type="password" name="pw" class="khm_pw" maxlength="20" placeholder="영문,숫자 포함 8자리">
                </div>

                <div>
                    <h3>비밀번호 재확인</h3>
                    <input type="password" name="pw2" class="khm_pw" maxlength="20" placeholder="영문,숫자 포함 8자리">
                </div>

                <!-- 이름 -->
                <div>
                    <h3>이름</h3>
                    <input type="text" name="name" class="khm_text" maxlength="20" placeholder="홍길동">
                </div>

                <!-- 생년월일 -->
                <div>
                    <h3>생년월일</h3>
                    <input type="text" name="birth" class="khm_text" maxlength="6" placeholder="주민번호앞 6자리">
                </div>

                <!-- 이메일 -->
                <div>
                    <h3>이메일</h3>
                    <input type="text" name="email" class="khm_text" maxlength="100" placeholder="ex) cre8@naver.com">
                </div>

                <!-- 핸드폰 -->
                <div>
                    <h3>휴대전화</h3>
                    <input type="tel" name="mobile" class="khm_text" maxlength="16" placeholder="ex) 01012345678">
                </div>

				<!-- 개인정보 동의 -->
				<div>
					<input name="check" id="check" type="checkbox" value="Y">개인정보 처리방침 동의 
				</div>
				
                <!-- 회원가입 -->
                <div>
					<input type="submit" id="khm_memreg" placeholder="회원가입">
                </div>

                </form>

            </div> 

        </div> 
		</div>
		
		<div class="rightSideBar"></div>
	</div>
</div>
	<div class="jmh_project">
</div>
<%@ include file="/footer.jsp" %>
</body>

</html>

<script type="text/javascript">
function checkag(){
	if(document.getElementById('check').checked){
		return ture
	} else {
		alert("개인정보 수집 및 이용에 대한 안내를 동의해 주세요");
	}
}
</script>
