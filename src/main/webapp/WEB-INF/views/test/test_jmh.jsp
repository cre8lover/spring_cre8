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
  <caption>정무형 메뉴구조도</caption>
  <tr>
    <th>시스템명</th>
    <th>1dept</th>
    <th>2dept</th>
    <th>3dept</th>
    <th>비고</th>
  </tr>
  <tr>
    <td rowspan ='12'>관리자시스템 </td>
    <td><a href="/cre8/admin/adminlogin.jsp"  target="_blank">관리자로그인</a></td>
    <td>-</td>
    <td>-</td>
    <td>로그인버튼클릭</td>   
  </tr>
  <tr>
    <td rowspan='3'><a href="/cre8/admin/member.jsp"  target="_blank">회원관리</a></td>
    <td>인기작가관리</td>
    <td>-</td>
    <td rowspan='3'>라디오정렬</td>   
  </tr>
  <tr>
    <td>최신작가관리</td>
    <td>-</td>
  </tr>
  <tr>
    <td>등급별조회</td>
    <td>-</td>
  </tr>
  <tr>
    <td><a href="/cre8/admin/category.jsp"  target="_blank">카테고리관리</a></td>
    <td>-</td>
    <td>-</td>
    <td>-</td>   
  </tr>
  <tr>
    <td rowspan='3'><a href="/cre8/admin/creAd.jsp" target="_blank">광고상품관리</a></td>
    <td>상품등록</td>
    <td>-</td>
    <td>버튼-새창</td>   
  </tr>
  <tr>
    <td>상품수정</td>
    <td>-</td>
    <td>버튼-새창</td>   
  </tr>
  <tr>
    <td>상품삭제</td>
    <td>-</td>
    <td>버튼</td>   
  </tr>
  <tr>
    <td rowspan='4'><a href="/cre8/admin/creAd2.jsp"  target="_blank">광고주문내역확인</a></td>
    <td rowspan='4'>주문내역조회</td>
    <td>주문내역</td>
    <td>탭</td>
  </tr>
  <tr>
    <td>주문정보</td>
    <td>탭</td>
  </tr>
  <tr>
    <td>월정산</td>
    <td>탭</td>
  </tr>
  <tr>
    <td>연정산</td>
    <td>탭</td>
  </tr>
  <tr>
  	<td rowspan='2'>회원시스템
  	</td>
  	<td><a href="/cre8/buy/buylist.jsp" target="_blank">주문서작성&결제진행</a></td>
    <td>결제</td>
    <td>결제API</td>
    <td>결제가 완료되어야 이 페이지가 실행 / 결제취소시 장바구니로 돌아감</td>
  </tr>
   <tr>
   	<td><a href="/cre8/auction/auction.jsp"  target="_blank">경매</a></td>
    <td><a href="/cre8/auction/auctionDetail.jsp"  target="_blank">경매물품상세조회</a></td>
    <td>입찰</td>
    <td>-</td>
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