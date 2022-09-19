<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/buy/buyDetail.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="body">
<div class="bodyunderdiv">

<table>
  <caption>◈주문내역조회</caption>
  <tr>
    <th>주문번호</th>
    <th>주문일</th>
    <th>주문금액</th>
    <th>주문상태</th>
    <th>교환</th>
    <th>환불</th>
  </tr>
  <c:forEach items="${order}" var="ship">			  
	  <tr>
	    <td>220803-${ship.orders.orderSeqno }</td>
	    <td>${ship.orders.orderDate }</td>
	    <td>${ship.orders.orderTotalprice }</td>
	    <td>${ship.shipStatus }</td>
	    <td><button>교환신청</button>
	    <td><button>환불신청</button>
	  </tr>
  </c:forEach>
</table>

<table>
  <caption>◈상세내역조회</caption>
  <tr>
    <th>결제방법</th>
    <th>배송업체(운송장번호)</th>
    <th>배송지</th>
    <th>배송조회</th>
    <th>영수증출력</th>
  </tr>
  <c:forEach items="${detail}" var="ship">
	  <tr>
	    <td>${ship.orders.orderdetailSet.orderdetailWay }</td>
	    <td>${ship.waybillSet.waybillName }( ${ship.waybillSet.waybillNumber } )</td>
	    <td>${ship.address.addAddress }</td>
	    <td><button>배송조회</button></td>
	    <td><button>영수증출력</button></td>
	  </tr>
  </c:forEach>	  

</table>
</div>
</div>
</body>

</html>