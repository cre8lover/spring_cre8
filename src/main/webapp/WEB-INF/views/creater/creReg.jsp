<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/creater/creReg.css">
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/cre8.css">
<title>회원가입</title>
</head>
<body>
	<%@ include file="/header.jsp" %>
	<%@ include file="/menu.jsp" %>
	<%@ include file="/sidebar.jsp" %>
	
<div class="jmh_body">

	<div class="body" style="height:100%">
 		<div class="leftSideBar"></div>
		<div class="content" style="width:45%;"> 
		<form method="post" action="<%= request.getContextPath() %>/cre/artistpage">
		<div class="khm_box">
			<h2>기본정보</h2>
			<hr>
			
			<table>
			<tbody>
			    <tr>
			      <th>
					이름		      	
			      </th>
			      <td colspan='2'>
			      
				 <input type="text" value="${sess_name}" name= "name">
				  </td>
			    </tr>
			  
			    <tr>
			      <th>아이디</th>
			      <td colspan='2'>
			      	  <input type="text" id="id" name="id" value="${sess_id }" readonly style="background:lightgray; border: 0.1px solid;">
			      </td>
			    </tr>
			    <tr>
			    </tr>
			    <tr>
			      <th>비밀번호</th>
			      <td colspan='2'>
			      	  <input type="password" id="pw" name="pw" placeholder="비밀번호를 입력하세요">
			      </td>
			    </tr>
			    <tr>
			      <th>비밀번호 확인</th>
			      <td colspan='2'>
			      	  <input type="password" id="pw2" name="pw2" placeholder="비밀번호를 확인하세요">
			      </td>
			    </tr>
			    <tr>
			      <th rowspan='2'>연락처(택1 필수)</th>
			      <td>휴대전화</td>
			      <td>
	                <input type="text" id="mobile" name="tel" maxlength="16" placeholder="010-1234-5678">
	 			  </td>
			    </tr>
			    <tr>
			      <td>이메일</td>
			      <td>
					<input type="text" placeholder="cre8" name="eid">@
		      		<input type="hidden"  name="Domain">
		      		<select name="selDomain" >
		      			<option value="" >선택하세요</option>
		      			<option value="naver.com" >naver.com</option>
		      			<option value="daum.net" >daum.net</option>
		      			<option value="gmail.com" >gmail.com</option>
		       		</select>
				  </td>
			    </tr>
			  </tbody>
			</table>
		</div>
		
		<div class="khm_box">
			<h2>필수 정보</h2>
			<hr>
			
			<table>
			 <tbody>
			    <tr>
			      <th>
			      	상호명
			      </th>
			      <td>
					<input type="text" placeholder="상호명을 입력하세요" name="crecompany">
				  </td>
			    </tr>
			    <tr>
			      <th>연락처</th>
			      <td>
				    <input type="text" id="mobile" maxlength="16" placeholder="010-1234-5678" name="cretel">
				  </td>
			    </tr>
			    <tr>
			      <th>대표자 이름</th>
			      <td>
					<input type="text" placeholder="대표자 이름을 입력하세요" name="crename">
				  </td>
			    </tr>
			    <tr>
			      <th rowspan='2'>주소</th>
			      <td>
					<input type="text" id="address_kakao" name="address" readonly placeholder="주소를 입력하세요" name ="creadress">
				  </td>
			    </tr>
			    <tr>
			      <td>
			      	<input type="text" name="address_detail" placeholder="상세주소를 입력하세요" name="creadress2">
			      </td>
			    </tr>
			    <tr>
			      <th>사업자 등록번호</th>
			      <td>
					<input type="text" placeholder="사업자 등록번호를 입력하세요" name ="crenum">
				  </td>
			    </tr>
			    <tr>
			      <th>통신판매 신고번호</th>
			      <td>
					<input type="text" placeholder="통신판매 신고번호" name="crenum2">
				  </td>
			    </tr>
			  </tbody>
			</table>
		</div>
		
		<div class="khm_box">
			<h2>추가 정보</h2>
			<hr>
			
			<table>
			<tbody>
			    <tr>
			      <th>
			      	SNS정보
			      </th>
			      <td>
					<input type="button" value="sns" onclick="sns()" id='facebook' name="cresns">
					<script>
						function sns(){
						document.getElementById('facebook').onclick = "<input type="text" name="wow" placeholder="sns주소 입력">"
						}
					</script>
				  </td>
			    </tr>
			    <tr>
			      <th>경력사항 & 포트폴리오</th>
			      <td>
				    <textarea name="intro" style="width:100%; height:200px;" rows="5" cols="50" placeholder="경력사항 입력"></textarea>
				  </td>
			    </tr>
			    <tr>
			      <th>첨부파일</th>
			      <td>
					<div class="filebox">
					    <input class="upload-name" value="첨부파일" placeholder="첨부파일" name="creatt">
					    <label for="file"></label> 
					    <input type="file" id="file">
					</div>
				  </td>
			    </tr>
			  </tbody>
			</table>
			<input type="submit" id="khm_memreg" value="작가 등록 신청">

		</div>
		
		</form>
		</div>
		<div class="rightSideBar"></div> 
	</div>	
</div>			
	<div class="jmh_project">
</div>
		
 <%@ include file="/footer.jsp" %> 
 </body>
</html>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="<%= request.getContextPath() %>/js/creReg.js"></script>
