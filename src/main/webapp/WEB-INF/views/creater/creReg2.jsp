<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/creater/creReg2.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/cre8.css">
<title>회원가입</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

</head>
<body>
<c:set value="${cre }" var="cre"/>
<div class="jmh_body">

   <div class="body" style="height:100%">
       <div class="leftSideBar"></div>
      <div class="content" style="width:100%;"> 
      <%-- <form action="<%= request.getContextPath() %>/cre/cremodifyreg" method="post" > --%>
      <div class="khm_box">
         <h2>기본정보</h2>
         <hr>
         
         <table>
         <tbody>
             <tr>
               <th>아이디</th>
               <td colspan='2'>
                    <input type="text" id="id" name="id" value="${sess_id}" readonly style="background:lightgray; border: 0.1px solid;">
               </td>
             </tr>
             <tr>
             </tr>
             <tr>
               <th>비밀번호</th>
               <td colspan='2'>
                    <input type="password" id="pw" name="pw" placeholder="비밀번호를 입력하세요"><a style="color:red">*회원정보와 동일한 비밀번호를 넣으세요</a>
               </td>
             </tr>
             <tr>
               <th rowspan='2'>연락처(택1 필수)</th>
               <td>휴대전화</td>
               <td>
                   <input type="text" id="mobile" name="mobile" maxlength="16" placeholder="010-1234-5678"
                   value="${cre.mem.memTel != null ? cre.mem.memTel :""}">
               </td>
             </tr>
             <tr>
               <td>이메일</td>
               <td>
                  
               <input type="text" value="${cre.mem.memEmail != null ? cre.mem.memEmail : ""}"placeholder="cre8" name="emailfirst">@
                  <input type="hidden"  name="Domain">
                  <select name="selDomain" >
                     <option value="${cre.mem.memEmail != null ? cre.mem.memId : "" }" >${cre.mem.memEmail != null ? cre.mem.memId : "선택하세요" }</option>
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
               <input type="text" placeholder="상호명을 입력하세요" value="${cre.creCompany != null ? cre.creCompany : "" }" name="cre_company">
              </td>
             </tr>
             <tr>
               <th>연락처</th>
               <td>
                <input type="text" id="crePhone" maxlength="16" placeholder="010-1234-5678" value="${cre.crePhone != null ? cre.crePhone : "" }" name="cre_phone">
              </td>
             </tr>
             <tr>
               <th>대표자 이름</th>
               <td>
               <input type="text" placeholder="대표자 이름을 입력하세요" value="${cre.creName != null ? cre.creName : "" }" name="cre_name">
              </td>
             </tr>
             <tr>
               <th rowspan='2'>주소</th>
               <td>
               <input type="text" id="address_kakao" name="address" readonly placeholder="주소를 입력하세요" 
               value="${cre.creAddress != null ? cre.creAddress : "" }">
              </td>
             </tr>
             <tr>
               <td>
                  <input type="text" name="address_detail" placeholder="상세주소를 입력하세요"/ >
               </td>
             </tr>
             <tr>
               <th>사업자 등록번호</th>
               <td>
               <input type="text" placeholder="사업자 등록번호를 입력하세요" value="${cre.creRegnum != null ? cre.creRegnum : "" }" name="cre_regnum">
              </td>
             </tr>
             <tr>
               <th>통신판매 신고번호</th>
               <td>
               <input type="text" placeholder="통신판매 신고번호" value="${cre.creSalenum != null ? cre.creSalenum : "" }" name="cre_salenum">
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
                <textarea name="snsinfo" style="width:100%; height:20px;" rows="5" cols="50" placeholder="sns정보">${cre.memSnsinfo}</textarea>
              </td>
             </tr>
             <tr>
               <th>경력사항 & 포트폴리오</th>
               <td>
                <textarea name="intro" style="width:100%; height:100px;" rows="5" cols="50" placeholder="경력사항 입력">${cre.crePot}</textarea>
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
         <input class= "cn3" type="submit" id="khm_memreg" value="정보 수정">

      </div>
      
      <!-- </form> -->
      </div>
      <div class="rightSideBar"></div> 
   </div>   
</div>         
   <div class="jmh_project">
</div>
      
      
 <script type="text/javascript" src="/js/creator.js"></script>	
	<script>
	/* var rno = '<c:out value="${list.proSeqno}" />'; */


	$(document).ready(function(){
	
		
	//크리에이터 정보 수정
		$(".cn3").on("click", function(e){
			 var creCompany = document.getElementsByName("cre_company")[0].value; 
			 var crePhone = document.getElementById("mobile").value;  
			 var creName =  document.getElementsByName("emailfirst")[0].value; 
			 var creAddress = document.getElementById("address_kakao").value;   
			 var creRegnum = document.getElementsByName("cre_regnum")[0].value;
			 var creSalenum = document.getElementsByName("cre_salenum")[0].value; 
			 var crePot = document.getElementsByName("intro")[0].value; 
			 var memid = document.getElementById("id").value; 
				
			 console.log("저라ㅣ언ㄹㄴ" + memid);
			 console.log("sdfssd" + creCompany);
		 
				var ccc ={creCompany : creCompany,
							crePhone : crePhone,
							creName : creName,
							creAddress : creAddress,
							creRegnum : creRegnum,
							creSalenum : creSalenum,
							crePot : crePot,
							memid : memid,
							};
		
		 CreatorService.update(ccc, function(result){
			
			 if(result == '크리에이터 수정완료'){
				 window.close();
				 }
				
			 });
		});
	});
	</script> 
		     
      
      
      
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