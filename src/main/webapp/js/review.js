/**
 * 	디테일 Q&A 조회,등록,수정,삭제
 */

 console.log("Q&A js.......");
 
 var detailReview = (function(){
 
 	function reviewList(param, callback, error){
		var seqno = param.seqno;
		var page = param.page || 1;
		
		$.getJSON("/review/" + seqno + "/" + page + ".json", function(data){
			if(callback){
				callback(data);
 			}
 		}).fail(function(xhr, status, err){
 			if(err){
 				error();
 			}		
 		});
 	}
	
 	function reviewadd(QnaVo, callback){
		console.log("QnaVo add...")		
	
		$.ajax({
			type : 'post',
			url  : '/review/reviewadd',
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
 	
	function reviewget(reviewNo, callback, error){
		$.get("/review/" + reviewNo + ".json", function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	
	function reviewremove(reviewSeqno, callback, error){
		$.ajax({
			type : 'delete',
			url : '/review/del/' + reviewSeqno,
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
 			reviewList : reviewList,
 			reviewadd : reviewadd,
 			reviewget : reviewget,
 			reviewremove : reviewremove
 			};
 
 })();
 