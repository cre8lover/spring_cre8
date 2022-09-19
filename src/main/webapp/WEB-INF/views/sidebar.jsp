<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/sidebar.css">
<script src="https://kit.fontawesome.com/8593beab87.js" crossorigin="anonymous"></script>
<div class="jmh_border">
<div class="jmh_navposition">
 <div class="jmh_navigation">
 	<ul>
 		<li class="jmh_list">
 			<a href="#">
 				<span class="jmh_icon"><i class="fa-solid fa-arrow-up"></i></span>
 				<span class="title">맨위로</span>
 			</a>
 		</li>
 		<li class="jmh_list">
 			<a href="<%= request.getContextPath() %>/mainpage">
 				<span class="jmh_icon"><i class="fa-solid fa-house"></i></span>
 				<span class="title">홈으로</span>
 			</a>
 		</li>
 		<li class="jmh_list">
 			<a href="<%= request.getContextPath() %>/buyer/cart">
 				<span class="jmh_icon"><i class="fa-solid fa-cart-shopping"></i></span>
 				<span class="title">장바구니</span>
 			</a>
 		</li>
 		<li class="jmh_list" id="kakao-talk-channel-chat-button"
  data-channel-public-id="_TxmUIxj"
  data-title="consult"
  data-size="large"
  data-color="yellow"
  data-shape="pc"
  data-support-multiple-densities="true">
 			<a id="channel-chat-button" href="#" onclick="void chatChannel();">
 				<span class="jmh_icon"><i class="fa-regular fa-comment"></i></span>
 				<span class="title">문의하기</span>
 			</a>
 		</li>
 	</ul>
 </div>
</div>
</div>
</body>

<script src="<%= request.getContextPath() %>/js/sidebar.js"></script>

<!-- <div
  id="kakao-talk-channel-chat-button"
  data-channel-public-id="_TxmUIxj"
  data-title="consult"
  data-size="large"
  data-color="yellow"
  data-shape="pc"
  data-support-multiple-densities="true">
	<a id="channel-chat-button" href="#" onclick="void chatChannel();">
	  <img
	    src="/tool/resource/static/img/button/channel/consult/consult_small_yellow_pc.png"
	  />
	</a>
</div> -->

