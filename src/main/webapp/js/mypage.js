	function pwChange(){
			document.getElementById("modal2").style.display="block";
	}
	function closepage(){
		document.getElementById("modal2").style.display="none";
	}
	
	function newwindow(url, name){
		var options = 'top=10, left=10, width=1000, height=1000, status=no, menubar=no, toolbar=no, resizable=no';
			window.open(url,name,options);
			
	}
	