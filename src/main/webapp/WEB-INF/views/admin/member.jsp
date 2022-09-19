<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
<meta charset="UTF-8">
<title>회원관리</title>
</head>

 <%@ include file="/admin/adminmenu.jsp" %>
 
		<div class="khm_searchs">
		<form method="post" action="<%= request.getContextPath() %>/master/member">
		<h2 class="khm_category">회원관리</h2>
			<table>
				<tbody>
					<tr>
						<th>
							등급
						</th>
						<td>
							<select name="gory"  onchange="this.form.submit()">
								<option value="999" <c:if test="${key.category == '999'}">selected</c:if>>전체</option>
								<option value="A" ${key.category == 'A' ? 'selected': '' }>관리자</option>							
								<option value="U" ${key.category == 'U' ? 'selected': '' }>회원</option>
								<option value="C" ${key.category == 'C' ? 'selected': '' }>작가</option>
							</select>
						</td>
						<th>
							가입 날짜
						</th>
						<td colspan="3">
							<input type="date" value="" class="date" >
							~
							<input type="date">
						</td>
						<th>검색어</th>
						<td>
							<select name="classification">
								<option value="998" <c:if test="${key.classification == '998'}">selected</c:if>>전체</option>
								<option value="mem_id" ${key.classification == 'mem_id' ? 'selected': '' }>아이디</option>
								<option value="mem_name" ${key.classification == 'mem_name' ? 'selected': '' }>이름</option>
								<option value="mem_email" ${key.classification == 'mem_email' ? 'selected': '' }>이메일</option>
								<option value="mem_tel" ${key.classification == 'mem_tel' ? 'selected': '' }>전화번호</option>
							</select>
						</td>
						<td class="bno">
							<input type="text" name="keysearch" id="sval" value="${key.keyword }" />
						</td>
						<td class="bno">
							<input type="submit" value="검색" >
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
		
	<div style="padding-top:2%">
		<table>
		  <thead>
		    <tr>
		      <th>
		      	번호
		      </th>
		      <th>아이디</th>
		      <th>이름</th>
		      <th>전화번호</th>
		      <th>이메일</th>
		      <th>등급</th>
		      <th>가입날짜</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${member}" var="me">			  
			    <tr>
			      <td>${me.seqno}</td>
			      <td>${me.memId}</td>
			      <td>${me.memName}</td>
			      <td>${me.memTel}</td>
			      <td>${me.memEmail}</td>
			      <td>${me.memAuthSet.authName}</td>
			      <td>${me.memAuthSet.authDate}</td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>

 </body>
</html>

