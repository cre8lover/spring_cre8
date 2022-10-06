/**
 * 	디테일 Q&A 조회,등록,수정,삭제
 */

 console.log("Q&A js.......");
 
 var detailQnA = (function(){
 
 	function getList(param, callback, error){
		var seqno = param.seqno;
		var page = param.page || 1;
		
		$.getJSON("/product/" + seqno + "/" + page + ".json", function(data){
			if(callback){
				callback(data);
 			}
 		}).fail(function(xhr, status, err){
 			if(err){
 				error();
 			}		
 		});
 	}
 	
 	function add(QnaVo, callback){
		console.log("QnaVo add...")		
	
		$.ajax({
			type : 'post',
			url  : '/product/add',
			data : JSON.stringify(QnaVo),
			contentType : "application/json; charset=utf-8", 
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}	
			},
			error : function(xhr, status, er){
				if(error){
					error(er)
				}
			}
		});
	} 
 
 	return {
 			getList : getList,
 			add : add
 			};
 
 })();
 