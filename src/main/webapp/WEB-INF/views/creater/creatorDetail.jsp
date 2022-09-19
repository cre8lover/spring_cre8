<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/creater/creatorDetail.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/8593beab87.js" crossorigin="anonymous"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

</head>


<body>
<%@ include file="/sidebar2.jsp" %>
	<div class="container" id="top">
		<c:set value="${detailList}" var="list" />
		<div class="slide-bar" id="slidebar">
			<div class="bar" id="bar"></div>
		</div>
		<div class="text-block" id="textone">
			<h1>${list.mem.memName}</h1>
		</div>
		<div class="text-block" id="texttwo">
			<h1>${list.creCompany}</h1>
		</div>
	</div>

	<button id="changeBtn"><i class="fa-solid fa-otter"></i></button>
	

<div id="title" class="slide header">
  <img src = "<%= request.getContextPath() %>/Artwork/김창목.jpg"style = "width : 550px; height : 700px;">
  
  <h1>Oil-pastel Creator</h1>
</div>

<div id="slide1" class="slide">
  <div class="title">
    <h1>OilPastel</h1>
    <center>
	  <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 350px; height : 400px;"> 
	  <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 350px; height : 400px;"> 
	  <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 350px; height : 400px;"> 
	  <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 350px; height : 400px;"> 
  </center>
  </div>
</div>

<div id="slide2" class="slide">
	
  <div class="title" style ="width : 100%;">
	  <center>
	  <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 350px; height : 400px;"> 
	  <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 350px; height : 400px;"> 
	  <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 350px; height : 400px;"> 
	  <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 350px; height : 400px;"> 
	</center>
  </div>
  <div class="title">
	   <center>
	  <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 350px; height : 400px;"> 
	  <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 350px; height : 400px;"> 
	  <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 350px; height : 400px;"> 
	  <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 350px; height : 400px;"> 
  </center>
  </div>
</div>

<div id="slide3" class="slide">
  <div class="title">
    <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 700px; height : 400px;"> 
    <img src="<%= request.getContextPath() %>${list.mem.memImg}" style = "width : 600px; height : 400px;"> 
    
  </div>
</div>

<div id="slide4" class="slide header">
<div>

</div>
    <h1>The End</h1>
    <h3>Artwork 문의 : 010-1234-1234</h3>
    <h3>사업장 주소 : 경기도 수원시 영통구 </h3>
</div>

<script src="https://kit.fontawesome.com/8593beab87.js" crossorigin="anonymous"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/gsap-latest-beta.min.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/CustomEase3.min.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/DrawSVGPlugin3.min.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/ScrambleTextPlugin3.min.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/SplitText3.min.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/MorphSVGPlugin3.min.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/CustomBounce3.min.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/CustomWiggle3.min.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/InertiaPlugin.min.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/Draggable3.min.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/EasePack3.min.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/Flip.min.js"></script>
<script src="<%= request.getContextPath() %>/js/creatorDetail.js"></script>






</body>
</html>