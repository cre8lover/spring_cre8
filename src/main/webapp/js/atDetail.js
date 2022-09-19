//
  
  function moneyCheck(id){
	var bestid = document.getElementById("bestmoney");
	let ids = id;
	let is = bestid.value;
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

output.value = slider.value;
money.value = slider.value;

slider.oninput = function() {
  output.value = this.value;
  money.value = this.value;
}




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
      tag.innerHTML = "<input  type='submit' class='bton' value='입찰하기'>"
   } 
   /*else{ //현재시간이 종료시간보다 크면
   tag.innerHTML = "<input type='button' onclick='timeover()' class='bton' value='입찰종료'>"*/
   
   /* $("#d-day-hour").html('00');	
    $("#d-day-min").html('00');
    $("#d-day-sec").html('00');
   }*/
  }
  setInterval(remaindTime,500); //1초마다 검사를 해주면 실시간으로 시간을 알 수 있다.

function timeover(){
	
	alert('경매시간이 종료되었습니다.');
}