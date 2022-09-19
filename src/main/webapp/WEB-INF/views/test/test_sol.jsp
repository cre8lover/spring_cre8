<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="body">
<div class="all">

<table>
  <caption>임소리 메뉴구조도</caption>
  <tr>
    <th>시스템명</th>
    <th>1dept</th>
    <th>2dept</th>
    <th>3dept</th>
    <th>비고</th>
  </tr>
  <tr>
    <td rowspan ='13'>작가시스템 </td>
    <td><a href="/cre8/creater/creReg.jsp"  target="_blank">크리에이터등록</a></td>
    <td>-</td>
    <td>-</td>
    <td>작가등록신청버튼</td>   
  </tr>
  <tr>
    <td rowspan ='12' ><a href="/cre8/creater/artistpage.jsp"  target="_blank">작가상품판매목록 + 마이페이지</a></td>
    <td rowspan= '3'><a href="/cre8/creater/artistpage.jsp"  target="_blank">일반상품</a></td>
    <td><a href="/cre8/listimg/product_registration.jsp"  target="_blank">상품등록</a></td>
    <td>[등록]버튼</td>   
  </tr>
  <tr>
    <td><a href="/cre8/listimg/product_registration2.jsp"  target="_blank">상품수정</a></td>
    <td>[수정]버튼</td>   
  </tr>
  <tr>
    <td>상품삭제</td>
    <td>[삭제]버튼</td>   
  </tr>
  <tr>
    <td rowspan= '3'><a href="/cre8/creater/artistpage.jsp">경매상품</a></td>
    <td><a href="/cre8/creater/auction_registration.jsp"  target="_blank">상품등록</a></td>
    <td>[등록]버튼</td>   
  </tr>
  <tr>
    <td><a href="/cre8/listimg/product_registration2.jsp"  target="_blank">상품수정</a></td>
    <td>[수정]버튼</td>   
  </tr>
  <tr>
    <td>상품삭제</td>
    <td>[삭제]버튼</td>   
  </tr>

  <tr>
    <td><a href="/cre8/creater/creReg2.jsp">정보수정</a></td>
    <td>-</td>
    <td>[정보수정]버튼</td>   
  </tr>
  <tr>
    <td><a href="/cre8/creater/Adlist.jsp">광고신청</a></td>
    <td>-</td>
    <td>[광고신청]버튼</td>   
  </tr>
  <tr>
    <td rowspan='4'><a href="/cre8/creater/jmh_salesHistory.jsp">판매현황</a></td>
    <td>판매내역</td>
    <td>[판매현황]버튼</td>   
  </tr>
  <tr>
    <td>판매정보</td>
    <td>탭</td>
  </tr>
  <tr>
    <td>이달의내역</td>
    <td>탭</td>
  </tr>
  <tr>
    <td>연간내역</td>
    <td>탭</td>
  </tr>
 
  
</table>


</div>
</body>
<style>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;800&display=swap');

a { 
/* text-decoration: none;  */
}
a:link, a:visited{
color: black;
}

.body {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #ccd7e8;
  width:100%;

}
.all{
width:95%
}
caption{
color:#071E3D;
font-size:20px;
text-align:left;
margin: 3px;
}

table {
  border-collapse: collapse;
  background-color: white;
  overflow: hidden;
  width: 80%;
  border-radius: 10px;
  margin: 40px;

}

th, td {
  font-family:'Motnserrat',sans-serif;
  text-align: center;
  font-size: 15px;
  padding: 10px;
    border: 1px solid Gainsboro;
}

th {
  background-color: #7691ab;
  color: white;
}
</style>
</html>