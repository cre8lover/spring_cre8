<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/cre8/css/cre8.css">
<title>회원가입</title>
</head>
<body>

	
<div class="jmh_body">

	<div class="body" style="height:100%">
 		<div class="leftSideBar"></div>
		<div class="content" style="width:100%;"> 
		<form>
		<div class="khm_box">
			<h2>기본정보</h2>
			<hr>
			
			<table>
			<tbody>
			    <tr>
			      <th>아이디</th>
			      <td colspan='2'>
			      	  <input type="text" id="id" name="id" value="강홍묵" readonly style="background:lightgray; border: 0.1px solid;">
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
			      <th rowspan='2'>연락처(택1 필수)</th>
			      <td>휴대전화</td>
			      <td>
	                <input type="text" id="mobile"  maxlength="16" placeholder="010-1234-5678">
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
					<input type="text" placeholder="상호명을 입력하세요">
				  </td>
			    </tr>
			    <tr>
			      <th>연락처</th>
			      <td>
				    <input type="text" id="mobile" maxlength="16" placeholder="010-1234-5678">
				  </td>
			    </tr>
			    <tr>
			      <th>대표자 이름</th>
			      <td>
					<input type="text" placeholder="대표자 이름을 입력하세요">
				  </td>
			    </tr>
			    <tr>
			      <th rowspan='2'>주소</th>
			      <td>
					<input type="text" id="address_kakao" name="address" readonly placeholder="주소를 입력하세요" />
				  </td>
			    </tr>
			    <tr>
			      <td>
			      	<input type="text" name="address_detail" placeholder="상세주소를 입력하세요"/>
			      </td>
			    </tr>
			    <tr>
			      <th>사업자 등록번호</th>
			      <td>
					<input type="text" placeholder="사업자 등록번호를 입력하세요">
				  </td>
			    </tr>
			    <tr>
			      <th>통신판매 신고번호</th>
			      <td>
					<input type="text" placeholder="통신판매 신고번호">
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
					<input type="button" value="sns" onclick="sns()" id='facebook'>
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
				    <textarea name="intro" style="width:100%; height:100px;" rows="5" cols="50" placeholder="경력사항 입력"></textarea>
				  </td>
			    </tr>
			    <tr>
			      <th>첨부파일</th>
			      <td>
					<div class="filebox">
					    <input class="upload-name" value="첨부파일" placeholder="첨부파일">
					    <label for="file"></label> 
					    <input type="file" id="file">
					</div>
				  </td>
			    </tr>
			  </tbody>
			</table>
			<input type="submit" id="khm_memreg" value="정보 수정">

		</div>
		
		</form>
		</div>
		<div class="rightSideBar"></div> 
	</div>	
</div>			
	<div class="jmh_project">
</div>
		
 </body>
</html>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
window.onload = function(){
    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao").value = data.address; // 주소 넣기
                document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱
            }
        }).open();
    });
}

</script>

<style>
body {
  color: #666;
  font: 14px/24px "Open Sans", "HelveticaNeue-Light", "Helvetica Neue Light", "Helvetica Neue", Helvetica, Arial, "Lucida Grande", Sans-Serif;
}
 table {
  border-collapse: separate;
  border-spacing: 0;
  width: 100%;
  border-collapse: collapse;
  
}
th,td {
  padding: 6px 15px;
}
th {
  color: black;
  text-align: left;
}

th,td {
  border: 1px solid #c6c9cc;
}
td:first-child {
  border-left: 1px solid #c6c9cc;
}

.khm_box{
	margin-top:3%;
}

input[type=text]{
	width: 40%;
    height: 21px;
    border: none;
}
input[type=password]{
	width: 40%;
    height: 21px;
 border: none;
}
</style>