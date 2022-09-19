<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="content_right">
  <dl>
  <dt>수량</dt>
    <dd>
      <div class="qty">					
        <div class="minus"><button onclick="javascript:change_qty2('m')" style="width:27px; height:27px; border: none;">▼</div>

        <input type="text" name="ct_qty" id="ct_qty" value="1" readonly="readonly">

        <div class="plus"><button onclick="javascript:change_qty2('p')" style="width:27px; height:27px; border: none;">▲</div>
      </div>	
    </dd>
  </dl>
  <dl>
    <dt>총 금액</dt>
    <dd id="total_amount">160000</dd>
  </dl>
</div>
 
 
 
<script type="text/javascript">
Number.prototype.format = function(){
  if(this==0) return 0;

  var reg = /(^[+-]?\d+)(\d{3})/;
  var n = (this + '');

  while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');

  return n;
};
 

String.prototype.format = function(){
  var num = parseFloat(this);
  if( isNaN(num) ) return "0";

  return num.format();
};
    
var basic_amount = parseInt('160000');


function change_qty2(t){
  //var min_qty = '수량버튼'*1;
  var min_qty = 1;
  var this_qty = $("#ct_qty").val()*1;
  var max_qty = '5'; // 현재 재고
  if(t=="m"){
    this_qty -= 1;
    if(this_qty<min_qty){
      //alert("최소구매수량 이상만 구매할 수 있습니다.");
      alert("수량은 1개 이상 입력해 주십시오.");
      return;
      }
    }
    else if(t=="p"){
      this_qty += 1;
      if(this_qty>max_qty){
        alert("죄송합니다. 재고가 부족합니다.");
        return;
        }
    }

  var show_total_amount = basic_amount * this_qty;
  //$("#ct_qty_txt").text(this_qty); 
  $("#ct_qty").val(this_qty);
  $("#it_pay").val(show_total_amount);
  $("#total_amount").html(show_total_amount.format());
}

</script>
<style>

.qty{
display: -webkit-inline-box;
width: fit-content;
}

#ct_qty{
    width: 24px;
    text-align: center;
    font-size: 20px;
    border: none;
}


</style>
</body>
</html>