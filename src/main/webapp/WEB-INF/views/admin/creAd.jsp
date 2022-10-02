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
			<div>
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
								<select name="classification" id="category">
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
								<button id="button">검색</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
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
		  </tbody>
		</table>
	</div>
	<div id="page" style="text-align: center;">
	
	</div>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/creAd.js"></script>
<script>



$(document).ready(function(){
	
var currentPage = 1;
showList(1);	

	$(document).on("click", "#button", function(e){
		console.log("search button click...!!");
		
		var marketingSearch = {
			key : $("#category").val(), 
			value : $("#search").val()
		}
		
		console.log("카테고리 검색 : " + marketingSearch.key);
		console.log("키워드 검색 : " + marketingSearch.value);
		
		marketingService.search(marketingSearch, function(Cnt, list){
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
				
				showPage(Cnt, currentPage);
			
		});
		
	});
			

	function showList(page){
		marketingService.getList({page:page || 1}, function(Cnt, list){
			console.log("마케팅 수 : " + Cnt)
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
				
			showPage(Cnt, currentPage);
			
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
			showList(currentPage);
		});
		
	});
	
function showPage(Cnt){
//	currentPage	 = 1;
	console.log("이거입니다!!!!!"+currentPage);
		var endPage = Math.ceil(currentPage/5.0)*5;
		var startPage = endPage - 4;
		console.log("endNum : " + endPage);
		console.log(Cnt);	
		var prev = startPage != 1;
		var next = false;
		
		if(endPage*10 >= Cnt){
			endPage = Math.ceil(Cnt/10.0);
		}
		if(endPage*10 < Cnt){
			next = true;
		}
		
		var str = "<div class='pageUL'>"
		if(prev){
			str += "<div class='page-link'>";
			str += "<a href='" + (startPage - 1) + "'> 이전페이지 </a></div>";
		}
		
		
		for(var i=startPage; i <= endPage; i++){
			var active = currentPage == i ? "active" : "";
			str += "<div class = 'page-link " + active + "'>"; //띄어쓰기 주의
			str += "<a href='" + i + "'>" + i + "</a></div>";
		}
		
		if(next){
			str += "<div class='page-link'>";
			str += "<a href='" + (endPage+1) + "'> 다음페이지 </a></div>";
		}
		
		str += "</div>"
//		console.log(str);
		$("#page").html(str);
	}
	
	/* 페이지 번호 클릭 */
	$("#page").on("click","a", function(e){
		console.log("page click...!!!!");
		e.preventDefault();
		
		var clickPage = $(this).attr("href")
		console.log("currentPage : " + clickPage);
		currentPage = clickPage;
		showList(currentPage);
	});
	
});


</script>
 </body>
</html>
