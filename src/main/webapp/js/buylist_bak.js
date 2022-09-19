/*
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
}

    function requestPay() {
//   var name = document.getElementsByClassName("itemname");
	alert(name);
   var IMP = window.IMP; // 생략 가능
   IMP.init("imp31724657"); // 예: imp00000000
      //IMP.request_pay(card, callback)
      IMP.request_pay({ // param
          pg: "kakaopay",
          pay_method: "kakaopay",
          merchant_uid: "ORD20200820-000002",
          name: "강파카",
          amount: 1500,
          buyer_email: "gildong@gmail.com",
          buyer_name: "홍길동",
          buyer_tel: "010-4242-4242",
          buyer_addr: "서울특별시 강남구 신사동",
          buyer_postcode: "01181"
      }, function (rsp) { // callback
          if (rsp.success) {
            $.ajax({
              url: "order", // 예: https://www.myservice.com/payments/complete
              type: "POST",
              contentType: "application/x-www-form-urlencoded; charset=utf-8",
                data: {
               pay_method:rsp.pay_method,
               merchant_uid:rsp.merchant_uid,
               name:rsp.name,
               amount:rsp.paid_amount,
               buyer_email:rsp.buyer_email,
               buyer_name:rsp.buyer_name,
               buyer_tel:rsp.buyer_tel,
               buyer_addr:rsp.buyer_addr,
               buyer_postcode:rsp.buyer_postcode
               
            },
            datatype:"json",
            success:function(data){
            
               location.replace("buy");//성공시 보낼페이지
            }
              })
             
             
          } else {

               location.href = "cart";//실패시 보낼 페이지

          }
      });
      
      

    app.use(bodyParser.json());
    
    // "/payments/complete"에 대한 POST 요청을 처리
    app.post("/payments/complete", async (req, res) => {
      try {
        const { imp_uid, merchant_uid } = req.body; // req의 body에서 imp_uid, merchant_uid 추출
      } catch (e) {
        res.status(400).send(e);
      }
    });
      
    app.use(bodyParser.json());
    // "/payments/complete"에 대한 POST 요청을 처리
    app.post("/payments/complete", async (req, res) => {
      try {
        const { imp_uid, merchant_uid } = req.body; // req의 body에서 imp_uid, merchant_uid 추출
        // 액세스 토큰(access token) 발급 받기
        const getToken = await axios({
          url: "https://api.iamport.kr/users/getToken",
          method: "post", // POST method
          headers: { "Content-Type": "application/json" }, // "Content-Type": "application/json"
          data: {
            imp_key: "8380566688234282", // REST API 키
            imp_secret: "MFVb0D1c5P7eJjYBtyNMj2hqoYEqcnoIbX48nnbktOQ5kMGQWBv6LHwyYevEOSQlAFdCl73K0Q34kkNt" // REST API Secret
          }
        });
        const { access_token } = getToken.data.response; // 인증 토큰
        // imp_uid로 아임포트 서버에서 결제 정보 조회
        const getPaymentData = await axios({
          url: `https://api.iamport.kr/payments/\${imp_uid}`, // imp_uid 전달
          method: "get", // GET method
          headers: { "Authorization": access_token } // 인증 토큰 Authorization header에 추가
        });
        const paymentData = getPaymentData.data.response; // 조회한 결제 정보
      } catch (e) {
        res.status(400).send(e);
      }
    });
    app.use(bodyParser.json());
    // "/payments/complete"에 대한 POST 요청을 처리
    app.post("/payments/complete", async (req, res) => {
      try {
        const { imp_uid, merchant_uid } = req.body; // req의 body에서 imp_uid, merchant_uid 추출
        // 액세스 토큰(access token) 발급 받기
        // imp_uid로 아임포트 서버에서 결제 정보 조회
        const paymentData = getPaymentData.data.response; // 조회한 결제 정보
        // DB에서 결제되어야 하는 금액 조회
        const order = await Orders.findById(paymentData.merchant_uid);
        const amountToBePaid = order.amount; // 결제 되어야 하는 금액
        // 결제 검증하기
        const { amount, status } = paymentData;
        if (amount === amountToBePaid) { // 결제금액 일치. 결제 된 금액 === 결제 되어야 하는 금액
          await Orders.findByIdAndUpdate(merchant_uid, { $set: paymentData }); // DB에 결제 정보 저장
          switch (status) {
            case "ready": // 가상계좌 발급
              // DB에 가상계좌 발급 정보 저장
              const { vbank_num, vbank_date, vbank_name } = paymentData;
              await Users.findByIdAndUpdate("// 고객 id ", { $set: { vbank_num, vbank_date, vbank_name }});
              // 가상계좌 발급 안내 문자메시지 발송
              SMS.send({ text: `가상계좌 발급이 성공되었습니다. 계좌 정보 \${vbank_num} \${vbank_date} \${vbank_name}`});
              res.send({ status: "vbankIssued", message: "가상계좌 발급 성공" });
              break;
            case "paid": // 결제 완료
              res.send({ status: "success", message: "일반 결제 성공" });
              break;
          }
        } else { // 결제금액 불일치. 위/변조 된 결제
          throw { status: "forgery", message: "위조된 결제시도" };
        }
      } catch (e) {
        res.status(400).send(e);
      }
    });

   }
*/  