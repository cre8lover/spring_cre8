<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/member/mypage.css">
	<%@ include file="/header.jsp" %>
	<%@ include file="/menu.jsp" %>
<meta charset="UTF-8" name="viewport" content="initial-scale=1.0, maximum-scale=1.0, width=device-width">

<script src="<%= request.getContextPath() %>/js/mypage.js"></script>

<title>mypage</title>
</head>
<body background="<%= request.getContextPath() %>/img/back.jpg" onload="plz('${change}')">
<div class="jmh_body2">
	<div class="body">
		<div class="leftSideBar">
		</div>
			<div class="content">
			
			
			<div class="mypage"> 
				<c:set value="${page}" var="my" />
				<div class="profile">

						<img src="/upload/thumbnail/${my.att.attThumb.fileName }" style="height:225px; width: 225px; border-radius: 50%;">	

					<h3>${my.memName}님 환영합니다!</h3>
					<button style="float:center;" onclick="newwindow('<%= request.getContextPath() %>/mem/meminfo','info')">정보수정</button>
					<button style="float:center;" onclick="newwindow('<%= request.getContextPath() %>/mem/buyHistory','buylist')">구매내역</button>
					<button style="float:center;" onclick="location.href='<%= request.getContextPath() %>/cre/creReg'">작가등록</button>
				
				</div>
				<table class="table-fill" style="margin-top:100px">
				<thead>
					<tr>
						<th class="text-left" colspan="2" style="height:0px;">MY PAGE</th>
					</tr>
				</thead>
					<tbody class="table-hover">
						<tr>
							<td class="text-left">아이디</td>
							<td class="text-left">${my.memId}</td>
						</tr>
						<tr>
							<td class="text-left">비밀번호</td>
							<td class="text-left" onclick="pwChange()"><button>비밀번호변경</button></td>
						</tr>
						<tr>
							<td class="text-left">이메일</td>
							<td class="text-left">${my.memEmail}</td>
						</tr>
						<tr>
							<td class="text-left">휴대폰번호</td>
							<td class="text-left">${my.memTel}</td>
						</tr>
						<tr>
							<td class="text-left">주소</td>
							<td class="text-left">${my.addressSet.addAddress}</td>
						</tr>
					</tbody>
				</table>
		
		
		 <!-- 비밀번호찾기-->
			<div id="modal2" background="#2782A5">
				<div class="modal-content">
					<button onclick="closepage()" style="border : 1px solid; background-color: white; width:18px;height: 18px; float: right; font-size: 15px;">X</button>
					<h3>비밀번호 변경</h3>
					<form method="post" action="<%= request.getContextPath() %>/mem/changepw">	
						<a style="text-align:left;">아이디를 입력하세요</a>
						<input type="text" name="find_id"  class="text-field" value="" maxlength="10" placeholder="ID" required>
						<a style="text-align:left;">현재비밀번호를 입력하세요</a>
						<input type="password" name="n_password"  class="text-field" value="" maxlength="15" required>
						<a style="text-align:left;">변경할비밀번호를 입력하세요</a>
						<input type="password"  name="c_password" class="text-field" value="" maxlength="15" required>
						<input type="submit" value="비밀번호 변경" class="submit-but" >
					</form>  
				</div>
			</div>
			</div>
			<div class="rightSideBar">
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
function plz(msg){
//	var msg = document.getElementsByName("change");
	//alert(msg);
	var alert_msg;
	var modal_pop;
	
	if(msg != "null"){
		if(msg == "ok") {
			alert_msg ="비밀번호가 변경되었습니다";
			modal_pop = false;
			alert(alert_msg);
		}
		
		if(msg == "pwfail"){
			alert_msg ="비밀번호를 확인해주세요.";
			modal_pop = true;
			alert(alert_msg);	
		};
		
		if(msg == "no_member"){
			alert_msg ="아이디를 확인해주세요.";
			modal_pop = true;
			alert(alert_msg);
		}
		
		if(modal_pop == true) {
			document.getElementById("modal2").style.display = "block";
		}
	}
}

</script>
<%@ include file="/footer.jsp" %>
</body>
</html>

