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
				if(er){
					error(er)
				}
			}
		});
	} 
 	
	function get(QnaNo, callback, error){
		$.get("/product/" + QnaNo + ".json", function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	
	function update(QnaVo, callback, error){
		console.log("수정 댓글 : " + QnaVo.seqno);
		$.ajax({
			type : 'put',
			url : "/product/update/" + QnaVo.seqno,
			data : JSON.stringify(QnaVo),
			contentType : "application/json; charset=utf-8",
			
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			
			error : function(){
				if(error){
					error()
				}
			}
		});
	}	
	
	function remove(QnaNo, callback, error){
		$.ajax({
			type : 'delete',
			url : '/product/del/' + QnaNo,
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
 
 	return {
 			getList : getList,
 			add : add,
 			get : get,
 			update : update,
 			remove : remove
 			};
 
 })();
 