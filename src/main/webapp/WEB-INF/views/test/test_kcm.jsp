<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>김 창 목</title>
</head>
<body>
<div class="body">
<div class="all">

<table>
  <caption>김창목 메뉴구조도</caption>
  <tr>
    <th>시스템명</th>
    <th>1dept</th>
    <th>2dept</th>
    <th>3dept</th>
    <th>비고</th>
  </tr>
  <tr>
    <td rowspan ='12'>회원시스템 </td>
    <td><a href="/cre8/member/memreg.jsp" target="_blank">회원가입</a></td>
    <td><a href="/cre8/member/login.jsp" target="_blank">로그인창</a></td>
    <td>-</td>
    <td>가입완료 후 로그인 창</td>   
  </tr>
 <tr>
 
    <td rowspan="3"><a href="/cre8/buy/cart.jsp" target="_blank">장바구니</a></td>
    <td rowspan="2"><a href="/cre8/buy/buylist.jsp" target="_blank">주문서작성&결제진행</a></td>
    <td>배송지입력</td>
    <td>주소API</td>
  </tr>
   <tr>
    <td>결제</td>
    <td>결제API</td>
  </tr>
  <tr>
    <td><a href="/cre8/buy/buy.jsp"  target="_blank">결제완료</a></td>
    <td>-</td>
    <td>결제가 완료되어야 이 페이지가 실행 / 결제취소시 장바구니로 돌아감</td>
  </tr>
  <tr>
    <td><a href="/cre8/index.jsp"  target="_blank">1대1상담</td>
    <td>카카오톡API</td>
    <td>-</td>
    <td>!!!사이드바!!!에 4번째 위치 
    		[sidebar.jsp]에 구현</td>   
  </tr>
  <tr>
    <td><a href="/cre8/mainlist/HotCreator.jsp"  target="_blank">인기작가</a></td>
    <td><a href="/cre8/creater/creatorDetail.jsp"  target="_blank">작가상세페이지</a></td>
    <td>-</td>
    <td>작가사진 클릭시 이동</td>   
  </tr>
  <tr>
    <td><a href="/cre8/mainlist/NewCreator.jsp"  target="_blank">신규작가</a></td>
    <td><a href="/cre8/creater/creatorDetail.jsp"  target="_blank">작가상세페이지</a></td>
    <td>-</td>
    <td>작가사진 클릭시 이동</td>   
  </tr>
   <tr>
	<td rowspan='5'>상품</td>
	<td><a href="/cre8/listimg/product_clothes.jsp" target="_blank">의류</a></td>
    <td rowspan='5'><a href="/cre8/mainlist/productDetail.jsp"  target="_blank">제품상세페이지</a></td>
	<td rowspan='5'>상세페이지 내에서 장바구니추가,바로구매가능</td>
	
  </tr>
  <tr>
   <td><a href="/cre8/listimg/product_furniture.jsp"  target="_blank">가전/가구</a></td>
  </tr>
  <tr>
   <td><a href="/cre8/listimg/product_cosmetics.jsp"  target="_blank">화장품</a></td>  
  </tr> 
  <tr>
   <td><a href="/cre8/listimg/product_interior.jsp"  target="_blank">인테리어</a></td>  
  </tr>
  <tr>
   <td><a href="/cre8/listimg/product_travel.jsp"  target="_blank">여행</a></td>  
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