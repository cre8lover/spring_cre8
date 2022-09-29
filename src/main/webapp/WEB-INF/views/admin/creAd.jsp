<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>    
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
<meta charset="UTF-8">
<title>마케팅 상품관리</title>
</head>
<script src="<%= request.getContextPath() %>/js/artistpage.js"></script>
 <%@ include file="../admin/adminmenu.jsp" %>
<c:set value="${marketing}" var="marketList" />
		<div class="khm_searchs">
		<h2 class="khm_category">마케팅 상품관리</h2>
			<form method="post">
				<table>
					<tbody>
						<tr>
							<th>
								등록일자
							</th>
							<td colspan="3">
								<input type="date" value="sdate" class="sdate" >
								~
								<input type="date" value="fdate" class="fdate" >
							</td>
							<th>검색어</th>
							<td>
								<select name="classification">
									<option value="999" <c:if test="${key.classification == '999'}">selected</c:if>>전체</option>
									<option value="mar_product" ${key.classification == 'mar_product' ? 'selected': '' }>상품이름</option>
									<option value="mar_company" ${key.classification == 'mar_company' ? 'selected': '' }>업체명</option>
									<option value="mar_ceo" ${key.classification == 'mar_ceo' ? 'selected': '' }>대표이름</option>
									<option value="mar_phone" ${key.classification == 'mar_phone' ? 'selected': '' }>업체번호</option>
									<option value="mar_regnum" ${key.classification == 'mar_regnum' ? 'selected': '' }>사업자번호</option>
								</select>
							</td>
							<td class="bno">
								<input type="text" name="keyword" id="search" value="${key.keyword }" />
							</td>
							<td class="bno">
								<input type="submit" value="검색" >
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		
		<div>
			<form class="khm_button">
				<input type="button" value="등록" onclick = "newwindow('<%= request.getContextPath() %>/master/adreg','reg');">
			</form>
		</div>

	<div>
		<table>
		  <thead>
		    <tr>
		      <th>수정</th>
		      <th>
		      	번호
		      </th>
		      <th>상품 이름</th>
		      <th>업체명</th>
		      <th>대표 이름</th>
		      <th>업체번호</th>
		      <th>사업자 번호</th>
		      <th>등록 날짜</th>
		      <th>삭제</th>
		    </tr>
		  </thead>
		  <tbody id = "Listpage">
		  <tr>
		      	<%-- <a href="javascript:newwindow('<%= request.getContextPath() %>/master/admodify?seqno=${market.marSeqno }','modi')"> --%>
		  </tr>
		  </tbody>
		</table>
	</div>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/creAd.js"></script>
<script>



$(document).ready(function(){
	
showList(1);	

	function showList(page){
		marketingService.getList({page:page || 1}, function(list){
//			console.log("마케팅 수 : " + marketCnt)
			var str= "";
			for(var i = 0, len=list.length || 0; i < len; i++){
				console.log("0번째 : "+list[0].marSeqno);

				str +=	"<tr>"
				str +=      "<td><button class='change' name='type' value='" + list[i].marSeqno + "'> 수정 </button></td>"
				str +=      "<td>" + list[i].no + "</td>"
				str +=      "<td>" + list[i].marProduct + "</td>"
				str +=      "<td>" + list[i].marCompany + "</td>"
				str +=      "<td>" + list[i].marCeo + "</td>"
				str +=      "<td>" + list[i].marPhone + "</td>"
				str +=      "<td>" + list[i].marRegnum + "</td>"
				str +=      "<td>" + list[i].marOpendate + "</td>"
				str +=      "<td><button class='delete' name='type' value='" + list[i].marSeqno + "'>삭제</button> </td>"
				str +=  "</tr>"

			}
			
				$("#Listpage").html(str);
		});
			
	}

	var marSeqno;
	/* 수정 윈도우창 */
	var path = "<%= request.getContextPath() %>";

	$(document).on("click", ".change", function(e){

		marSeqno = e.target.value;
		console.log("click!!!!!!!!!!!!!!yes!!!!!!!!!!!");
		
		console.log("시퀀스번호가 뭔가요 : "+marSeqno);
		var options = 'top=10, left=10, width=1000, height=1000, status=no, menubar=no, toolbar=no, resizable=no';
		var url = ''+path+'/master/admodify/'+marSeqno;
				
		 window.open(url, 'modi',options);
		
	});
	
	/* 댓글 삭제 */
	$(document).on("click", ".delete", function(e){
		marSeqno = e.target.value;
		console.log("댓글 삭제 번호 : " + marSeqno);
		
		marketingService.remove(marSeqno, function(result){
			alert(result);
			showList(1);
		});
		
	});
	
});


</script>
 </body>
</html>
