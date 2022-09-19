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
  <caption>최다영 메뉴구조도</caption>
  <tr>
    <th>시스템명</th>
    <th>1dept</th>
    <th>2dept</th>
    <th>3dept</th>
    <th>비고</th>
  </tr>
  <tr>
    <td rowspan ='17'>회원시스템 </td>
    <td rowspan='9'><a href="/cre8/member/mypage.jsp"  target="_blank">마이페이지</a></td>
    <td>회원정보조회</td>
    <td>-</td>
    <td>-</td>
    
    
  </tr>
  <tr>
    <td>비밀번호변경</td>
    <td>-</td>
    <td>버튼-모달</td>
  </tr>
  <tr>
    <td><a href="http://localhost:8080/cre8/member/meminfo.jsp"  target="_blank">회원정보수정</a></td>
    <td>배송지관리</td>
    <td>새창</td>
  </tr>
  <tr>
    <td rowspan='6'><a href="/cre8/member/buyHistory.jsp"  target="_blank">구매내역조회</a></td>
    <td>상세구매내역조회</td>
    <td>클릭하면 아래로 열림</td>
  </tr>
  <tr>
    <td>경매참여내역조회</td>
    
    <td>탭</td>
 
  </tr>
  <tr>
    <td>취소내역조회</td>
    <td>탭</td>
  </tr>
  <tr>
    <td>반품내역조회</td>
    <td>탭</td>
  </tr>
  <tr>
    <td>교환내역조회</td>
    <td>탭</td>
  </tr>
  <tr>
    <td>찜한상품내역조회</td>
    <td>탭</td>
  </tr>
  <tr>
    <td rowspan='8'><a href="/cre8/auction/auction.jsp"  target="_blank">경매</a></td>
    <td rowspan='3'>경매물품조회</td>
    <td>인기순조회</td>
    <td>라디오정렬</td>
  </tr>
  <tr>
    <td>최신순조회</td>
    <td>라디오정렬</td>
  </tr>
  <tr>
    <td>마감입박순조회</td>
    <td>라디오정렬</td>
  </tr>
  <tr>
    <td rowspan='5'><a href="/cre8/auction/auctionDetail.jsp"  target="_blank">경매물품상세조회</a></td>
    <td>입찰참여자조회</td>
    <td>-</td>
  </tr>
  <tr>
    <td>현재입찰가조회</td>
    <td>-</td>
  </tr>
  <tr>
    <td>상세정보조회</td>
    <td>탭</td>
  </tr>
  <tr>
    <td>작가설명조회</td>
    <td>탭</td>
  </tr>
  <tr>
    <td>입찰하기</td>
    <td>알럿창</td>
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