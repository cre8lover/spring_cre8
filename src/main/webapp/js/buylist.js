function addrequals(){
					var checkbuyinfo = document.getElementById("checkbuyinfo");
					
					if(checkbuyinfo.checked == true){
					var addr_front = document.getElementById("address_kakao");
					var addr_back = document.getElementById("address_kakao_back");
					var bottom_addr_front = document.getElementById("address_kakao2");
					var bottom_addr_back = document.getElementById("address_kakao_back2");
					
					var front_phone = document.getElementsByName("ssecession");
					
					var phone1 = document.getElementById("phon_front");
					var phone2 = document.getElementById("phon_back");
					
					var bottom_phone1 = document.getElementById("phon_front2");
					var bottom_phone2 = document.getElementById("phon_back2");
					
					var name = document.getElementById("name");
					var name2 = document.getElementById("name2");
					
					var choice = document.getElementsByName("choice");

					
					
					bottom_addr_front.value = addr_front.value; 
					bottom_addr_back.value = addr_back.value;
					front_phone[1].value = front_phone[0].value;
					bottom_phone1.value = phone1.value;
					bottom_phone2.value = phone2.value;
					name2.value = name.value;
					choice[1].value = choice[0].value;
				}
				}




window.onload = function(){
    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao").value = data.address; // 주소 넣기
                document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱
            }
        }).open();
    });
    
    document.getElementById("address_kakao2").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao2").value = data.address; // 주소 넣기
                document.querySelector("input[name=bottom_address_detail]").focus(); //상세입력 포커싱
            }
        }).open();
    });


}

    function requestPay(total) {
   const itemname = document.getElementsByClassName("itemname");
   const count = document.getElementsByClassName("ordercount");
   var total = total;
   var phonnumber = $("select[name=ssecession]").val();


   var name = document.getElementById("name").value;
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
	var cartlist = [];
	var ordersamount = [];
	const cartnum = document.getElementsByName("cartseqno");
	const orderamount = document.getElementsByName("orderamount");
	for (var i=0; i<cartnum.length; i++){
		cartlist.push(cartnum[i].value);
		ordersamount.push(orderamount[i].value);
	}
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
          name: itemname[0].value+"등 "+(count[0].value)+"건",
          amount: total,
          /*buyer_email: "gildong@gmail.com", 적는칸이없어서 주석*/
          buyer_name: name,
          buyer_tel: buyer_tel,
          buyer_addr: buyer_addr,
          /*buyer_postcode: "01181" 마찬가지로 적는칸이없네요?*/
      }, function (rsp) { // callback
          if (rsp.success) {
            $.ajax({
              url: "order", // 예: https://www.myservice.com/payments/complete
              type: "POST",
              /*async: false,*/
              traditional: true,
              contentType: "application/x-www-form-urlencoded; charset=utf-8",
                data: {
               pay_method:rsp.pay_method,
               merchant_uid:rsp.merchant_uid,
               name:rsp.name,
               amount:rsp.paid_amount,
               /*buyer_email:rsp.buyer_email,*/
               buyer_name:rsp.buyer_name,
               buyer_tel:rsp.buyer_tel,
               buyer_addr:rsp.buyer_addr,
               cart : cartlist,
               orderamount: ordersamount
               /*buyer_postcode:rsp.buyer_postcode*/
               
            },
            datatype:"json",
            success:function(data){
               location.href = "buy?seqno="+data;//성공시 보낼페이지
            }
              })
             
             
          } else {

               location.href = "cart";//실패시 보낼 페이지

          }
      });
      }