  function moneyCheck(id){
	var bestid = document.getElementById("bestmoney");
	var ids = id;
	var is = bestid.value;
   if(bestid.value === ids){
		alert('이미 최고 입찰자입니다.');
		return false;
   }else if(ids != ''){
		return true;
	} else {
      alert('로그인후 이용하세요');
      return false;
   }
}    

function dlqckf(){
	var ans = confirm("입찰하시겠습니까?");
	
	if (ans){
	$("#dlqckf").click( function() {

    	alert("정보가 수정되었습니다.");
         
         $('#aucnow').submit();
            
      
      });
	}
}
var slider = document.getElementById("myRange");
var output = document.getElementById("demo");
var money = document.getElementById("money");
var numberformat = slider.value;
numberformat = Number(numberformat.replaceAll(',', ''));
output.value = numberformat.toLocaleString('ko-KR');

money.value = slider.value;

slider.oninput = function(e) {
  output.value = this.value;
  money.value = this.value;
  
  var value = e.target.value;
  value = Number(value.replaceAll(',', ''));
  if(isNaN(value)) {
    input.value = 0;
  }else {
    const formatValue = value.toLocaleString('ko-KR');
    input.value = formatValue;
  }
}

const input = document.querySelector('#demo');
input.addEventListener('keyup', function(e) {
	var value = e.target.value;
	value = Number(value.replaceAll(',', ''));
	if(isNaN(value)) {
		input.value = 0;
	}else {
		const formatValue = value.toLocaleString('ko-KR');
		input.value = formatValue;
	}
})

function equalsmoney(best){
	var number = Number(output.value.replaceAll(',', ''));
	if(number % 1000 == 0){
		console.log("통과");
	
		if(number > best){
		money.value = number;
		/*money.value = output.value;*/
		}else{
			alert("가격을 다시 책정해 주세요");
		}
	}else{
		alert("1000원단위로만 작성해 주세요");
	}
}




var bestid = document.getElementById("bestmoney");
var id = document.getElementById("logingid");
	
function remaindTime() {
	
	var end2 = document.getElementById("finish").value;
	var tag = document.getElementById("timeover")
	
    var now = new Date(); //현재시간을 구한다. 
    var open = new Date(end2);
  
    var nt = now.getTime(); // 현재의 시간만 가져온다
    var ot = open.getTime(); // 오픈시간만 가져온다
  
  
  	if(nt<ot){ //현재시간이 오픈시간보다 이르면 오픈시간까지의 남은 시간을 구한다.   
     sec = parseInt(ot - nt) / 1000;
     hour = parseInt(sec/60/60);
     sec = (sec - (hour*60*60));
     min = parseInt(sec/60);
     sec = parseInt(sec-(min*60));
  
     if(hour<10){hour="0"+hour;}
     if(min<10){min="0"+min;}
     if(sec<10){sec="0"+sec;}
      $("#d-day-hour").html(hour);
      $("#d-day-min").html(min);
      $("#d-day-sec").html(sec);
      tag.innerHTML = "<input type='button' id='Btnaucnow' class='bton Btnaucnow' value='입찰하기'>"
   } else{ //현재시간이 종료시간보다 크면
	   if(bestid.value == id.value){
			tag.innerHTML = "<input type='button' class='bton auctionbuyBtn' value='구매하기'>"
	   }
   /* $("#d-day-hour").html('00');	
    $("#d-day-min").html('00');
    $("#d-day-sec").html('00');*/
   }
  }
  setInterval(remaindTime,500); //1초마다 검사를 해주면 실시간으로 시간을 알 수 있다.

function timeover(){
	
	alert('경매시간이 종료되었습니다.');
}

$(document).on("click",".auctionbuyBtn",function(){
	$(".auctionbuymain").show();
	
});
	
$(document).on("click",".closeBtn",function(){
	$(".auctionbuymain").hide();
	
});


$(document).on("click",".aucbuyBtn",function(){
	console.log("구매하기");
	requestPay();
});



var aucnowingService = (function(){


	function add(aucnow, callback){
 		console.log("aucnow add.....");
 		
 		$.ajax({
 			type: 'post',
 			url : '/aucnow/add',
 			data : JSON.stringify(aucnow),
 			contentType : 'application/json; charset=utf-8',
 			success : function(result, status, xhr){
 				if (callback){
 					callback(result);
 				}
 			},
 			error : function (xhr, status, er){
 				if (error) {
 					error(er);
 				}
 			}
 		
 		});
 	}
	 	
  	
  	function getList(param, callback, error){
 		var bno = param.bno;
 		var page = param.page || 1;
 		
 		$.getJSON("/aucnow/list/"+bno+"/"+page+".json",function(data){
 			if(callback){
 				callback(data.total,data.anlist);
 			}
 		}).fail(function(xhr,status,err){ 
 			if(error){
 				error();
 			}
 		});
 	}	
	 	
	 	
	 	
	 	
 	return {
 		add : add,
 		getList : getList
	};
 	
})();



function requestPay(){
		var aucseqno = $("input[name='seqno']").val();
		var name = $("#logingname").val();
		var aucAmount = $("#aucAmount").val();
		var aucname = $(".jmh_title").text();
		var finishmoney = $("#aucprice").val();
/*		console.log(finishmoney);
		console.log(aucseqno);
		console.log(name);
		console.log(aucname);*/
		
	   var phonnumber = $("select[name=ssecession]").val();
	   
	   var buyer_addr_front = document.getElementById("address_kakao").value;
	   var buyer_addr_back = document.getElementById("address_kakao_back").value;
	   var phon_front = document.getElementById("phon_front").value;
	   var phon_back = document.getElementById("phon_back").value;
	  
		var buyer_addr = buyer_addr_front + buyer_addr_back;
		var buyer_tel = phonnumber+phon_front+phon_back;
		
		var now = new Date();
		var month = ('0' + (now.getMonth() + 1)).slice(-2);
		var day = ('0' + now.getDate()).slice(-2);
		
		var orderdate = now.getFullYear()+""+month+""+day;
		
		var hours = ('0' + now.getHours()).slice(-2); 
		var minutes = ('0' + now.getMinutes()).slice(-2);
		var seconds = ('0' + now.getSeconds()).slice(-2); 
		
		// (3) 0 <= random <= 9
		const ran = Math.floor(Math.random() * 1000);
		//cartnum = JSON.stringify(cartnum);
		//alert(cartnum);
		
		var ordertime = hours + '' + minutes  + '' + seconds+''+ran;
		
		
	   var IMP = window.IMP; // 생략 가능
	   IMP.init("imp31724657"); // 예: imp00000000
	      //IMP.request_pay(card, callback)
	      IMP.request_pay({ // param
	          pg: "kakaopay",
	          pay_method: "kakaopay",
	          merchant_uid: "ORD"+orderdate+"-"+ordertime,
	          name: aucname,
	          amount: finishmoney,
	          /*buyer_email: "gildong@gmail.com", 적는칸이없어서 주석*/
	          buyer_name: name,
	          buyer_tel: buyer_tel,
	          buyer_addr: buyer_addr
	          /*buyer_postcode: "01181" 마찬가지로 적는칸이없네요?*/
	          
	      }, function (rsp) { // callback
	          if (rsp.success) {
	            $.ajax({
	              url: "/auc/order", // 예: https://www.myservice.com/payments/complete
	              type: "POST",
	              /*async: false,*/
	              traditional: true,
	              contentType: "application/x-www-form-urlencoded; charset=utf-8",
	                data: {
	               pay_method:rsp.pay_method,
	               merchant_uid:rsp.merchant_uid,
	               name:rsp.name,
	               aucprice:rsp.paid_amount,
	               amount:aucAmount,
	               /*buyer_email:rsp.buyer_email,*/
	               buyer_name:rsp.buyer_name,
	               buyer_tel:rsp.buyer_tel,
	               buyer_addr:rsp.buyer_addr,
	               aucSeqno : aucseqno,
	               /*buyer_postcode:rsp.buyer_postcode*/
	            },
	            datatype:"json",
	            success:function(data){
	            	
	               location.href = "/auc/buy?seqno="+data;//성공시 보낼페이지
	            }
	              })
	             
	             
	          } else {
					/*console.log(document.referrer);*/
	/*               location.href = document.referrer;//실패시 보낼 페이지*/

	          }
	      });
	      }




