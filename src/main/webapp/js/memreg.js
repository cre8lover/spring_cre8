function idcheck(path) {
		
		var id = document.forms["cre8reg"]["id"].value;
		
		var x = new XMLHttpRequest();
		
		x.onreadystatechange = function(){
			
			var msg = document.getElementById("idcheckmsg");
			
			if(x.readyState === 4 && x.status === 200){
				console.log("ok");
				var rsp = x.responseText.trim(); 
				document.getElementById("isidcheck").value = rsp;
				
				if(rsp == 0){
					msg.innerHTML="사용가능한 아이디 입니다.";
				} else {
					msg.innerHTML="중복된 아이디 입니다.";
				}
				
			} else {
				console.log("서버에러(403,404)");
			}
		};
		
		x.open("get", path+"/mem/idCheck?id="+id, true);
		x.send();
		
	}
	
	
function regCheck() {
		//비밀번호 체크
		var pw = document.forms["cre8reg"]["pw"].value;
		var pw2 = document.forms["cre8reg"]["pw2"].value;

		if(!pw.eqauls(pw2)) {
			alert("비밀번호를 확인해 주세요.");
			return false;
		}
		
		//생년월일 체크
		var birth = document.froms["cre8reg"]["birth"].value;
		if(birth.length <6){
			alert("생년월일을 확인해주세요.");
			return false;
		}
		
}			