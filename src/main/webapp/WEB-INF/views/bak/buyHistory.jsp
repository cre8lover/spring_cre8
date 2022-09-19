<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">


<style>
.jmh_mainpagd {
	width:60%;
	height:100%;
}
.jmh_mainboardlength {
	width:100%;
	border-collapse: collapse;
}
.jmh_saleimgboard{
	width:100%;
	heigth:6vw;
}

.jmh_saleshistoryboard {
	border: 1px solid;
}
.jmh_saleboardwidth1{
	width:5%
}
.jmh_saleboardwidth2{
	width:10%;
	height:15%;
}
.jmh_saleboardwidth3{
	width:20%
}
.jmh_saleboardwidth4{
	width:10%
}
.jmh_saleboardwidth5{
	width:15%;
}
.jmh_saleboardimgwidth2{
	width:5%;
}

/* 탭 전체 스타일 */
.tabs {
  padding-bottom: 40px;
  margin: 0 auto;
  
 }

/* 탭 스타일 */
.tab_item {
  width: calc(70%/4);
  height: 50px;
  border-bottom: 3px solid #333333;
  background-color: #f8f8f8;
  line-height: 50px;
  font-size: 16px;
  text-align: center;
  color: #333333;
  display: block;
  float: left;
  text-align: center;
  font-weight: bold;
  transition: all 0.2s ease;
}
.tab_item:hover {
  opacity: 0.75;
}

/* 라디오 버튼 UI삭제*/
input[name="tab_item"] {
  display: none;
}

/* 탭 컨텐츠 스타일 */
.tab_content {
  display: none;
  clear: both;
  overflow: hidden;
}


/* 선택 된 탭 콘텐츠를 표시 */
#all:checked ~ #all_content,
#programming:checked ~ #programming_content,
#quarterlysales:checked ~ #quarterlysales_content,
#monthsales:checked ~ #monthsales_content{
  display: block;
}

/* 선택된 탭 스타일 */
.tabs input:checked + .tab_item {
  background-color: #333333;
  color: #fff;
}

.bton {
	margin-left: 5px;
	width: 99%;
	height: 60px;
	border-radius: 10px;
	background: #071E3d;
	color: white;
	cursor: pointer;
	border: none;
	font-size:20px;
}

.bton:hover {
	background-color: #21e6c1;
	color: black;
	cursor: pointer;
}


/*슬라이더*/

.slidecontainer {
  width: 100%;
}

.slider {
  -webkit-appearance: none;
  width: 100%;
  height: 40px;
  background: #d3d3d3;
  outline: none;
  opacity: 0.7;
  -webkit-transition: .2s;
  transition: opacity .2s;
  border-radius: 5px;
}

.slider:hover {
  opacity: 1;
}

.slider::-webkit-slider-thumb {
  -webkit-appearance: none;
  appearance: none;
  width: 50px;
  height: 50px;
  background: #21e6c1;
  cursor: pointer;
}

.slider::-moz-range-thumb {
  width: 25px;
  height: 25px;
  background: #04AA6D;
  cursor: pointer;
}
</style>

				



<div class="jmh_mainpage">
	<div>
		<div class="tabs">
		    <input id="all" type="radio" name="tab_item" checked>
		    <label class="tab_item" for="all">구매내역</label>
		    
		    <input id="programming" type="radio" name="tab_item">
		    <label class="tab_item" for="programming">경매참여내역</label>
		    
		    <input id="monthsales" type="radio" name="tab_item">
		    <label class="tab_item" for="monthsales">취소/반품/교환</label>
		    
		    <input id="quarterlysales" type="radio" name="tab_item">
		    <label class="tab_item" for="quarterlysales">찜한상품내역</label>
		    
		    <div class="tab_content" id="all_content">
		    	<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">구매번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">구매물품
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">구매물품명
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth4">구매일
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">수량
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6">금액
					</th>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">1
					</td>
					<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="/cre8/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">이재신입니다.
					</td>
					<td class="jmh_saleshistoryboard">2022/08/02
					</td>
					<td class="jmh_saleshistoryboard">1개
					</td>
					<td class="jmh_saleshistoryboard">99,990
					</td>
				</tr>
			
				</table>
			</div>
			    <div class="tab_content" id="programming_content">
					<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">경매번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">경매물품
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">경매물품명
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth4">경매참여일
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">입찰상태
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6">입찰금액
					</th>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">1
					</td>
					<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="/cre8/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">이재신입니다.
					</td>
					<td class="jmh_saleshistoryboard">2022/08/02
					</td>
					<td class="jmh_saleshistoryboard">낙찰완료
					</td>
					<td class="jmh_saleshistoryboard">99,990
					</td>
				</tr>
			</table>
			</div>
			<div class="tab_content" id="monthsales_content">
			<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">상품번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">상품
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">상품명
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth4">신청날짜
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">처리상태
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6">금액
					</th>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">1
					</td>
					<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="/cre8/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">이재신입니다.
					</td>
					<td class="jmh_saleshistoryboard">2022/08/02
					</td>
					<td class="jmh_saleshistoryboard">교환완료
					</td>
					<td class="jmh_saleshistoryboard">99,990
					</td>
				</tr>
				</table>
			</div>
			<div class="tab_content" id="quarterlysales_content">
			<table class="jmh_saleshistoryboard jmh_mainboardlength">
				<tr>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth1">상품번호
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth2">상품
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth3">상품명
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth4">찜한날짜
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth5">옵션
					</th>
					<th class="jmh_saleshistoryboard jmh_saleboardwidth6">금액
					</th>
				</tr>
				<tr>
					<td class="jmh_saleshistoryboard">1
					</td>
					<td class="jmh_saleshistoryboard jmh_saleboardimgwidth2"><img class="jmh_saleimgboard" src="/cre8/img/우투리.png">
					</td>
					<td class="jmh_saleshistoryboard">이재신입니다.
					</td>
					<td class="jmh_saleshistoryboard">2022/08/02
					</td>
					<td class="jmh_saleshistoryboard">(+고영재)
					</td>
					<td class="jmh_saleshistoryboard">99,990
					</td>
				</tr>
			</table>
			</div>
		</div>
	</div> 
</div>