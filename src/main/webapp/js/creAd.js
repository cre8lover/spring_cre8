/**
 *  22/09/28 강홍묵 
 */
 
 
 var marketingService = (function(){
 console.log("marketing list.....");
 
 	function search(marketingSearch, callback, error){
 		var page = marketingSearch.page || 1;
 		var key = marketingSearch.key;
 		var value = marketingSearch.value;
 		
 		console.log("search????");
 		
 		$.getJSON("/master/search/" + page + "/" + key + "/" + value + ".json", function(data){
 			if(callback){
 				callback(data.cnt, data.list);
 			}	
 		}).fail(function(xhr, status, err){
 			if(err){
 				error();
 			}
 		});
 	}
 
 	function getList(param, callback, error){
 		var page = param.page || 1;
 		console.log("why????");
 		$.getJSON("/master/marketingList/" + page + ".json", function(data){
 			if(callback){
 				callback(data.cnt, data.list);
 			}	
 		}).fail(function(xhr, status, err){
 			if(err){
 				error();
 			}
 		});
 	}
 	
 	function update(marketing, callback, error){
		$.ajax({
			type : 'put',
			url : "/master/" + marketing.marSeqno,
			data : JSON.stringify(marketing),
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
	
	function add(marketing, callback){
	
		$.ajax({
			type : 'post',
			url  : '/master/add',
			data : JSON.stringify(marketing),
			contentType : "application/json; charset=utf-8", //제이슨 형태로 던져주겠다
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
	
	function remove(marSeqno, callback, error){
		$.ajax({
			type : 'delete',
			url : '/master/del/' + marSeqno,
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
 			update : update,
 			add : add,
 			remove : remove,
 			search : search
 	};
 
 })();