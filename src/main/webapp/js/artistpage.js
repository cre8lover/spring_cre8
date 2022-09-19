function newwindow(url, name){
	var options = 'top=10, left=10, width=1000, height=1000, status=no, menubar=no, toolbar=no, resizable=no';
		window.open(url,name,options);
		
	}

function prodelete(seqno){
	var rs = confirm('정말로 삭제하시겠습니까?');
	if (rs){
		location.href="prodel?proseqno="+seqno;
	}

}