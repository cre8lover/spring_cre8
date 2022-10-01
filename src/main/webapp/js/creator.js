/**
 * 22/09/29 김창목 
 */

console.log("creator Module start");

var CreatorService = (function() {


	//크리에이터 등록
	function add(add, callback){
		console.log(" 등록 완료");

		$.ajax({
			type : 'post',
			url : '/cre/add',
			data : JSON.stringify(add),
			contentType : "application/json; charset=utf-8",
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
	
	
	//크리에이터 수정
	function update(ccc, callback, error){
		$.ajax({
			type : 'put',
			url : "/cre2/ccc", 
			data : JSON.stringify(ccc),
			contentType : "application/json; charset=utf-8",
			
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(status, er, xhr){
				if(error){
					error(er);
				}
			}
		});
	}
	
	
	// 물품삭제
	function remove(callback, error) {
		$.ajax({
			type : 'delete',
			url : "/cre2/remove",
			//data : JSON.stringify(no), // 객체 하나만을 넘길때는 이렇게 넘김!
			contentType : 'application/json; charset=utf-8',
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}
	
	
	//마케팅리스트
	function getList(param, callback, error){
		var bno = param.bno;
		
		$.getJSON("/cre/list/" + bno, function(data){
			if(callback){
				callback(data); //데이터로 결과값을 받겠다.
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	
	
	
	return {
		add : add,
		remove : remove,
		update : update,
		getList : getList
	};
	
	
	
})();