/**
 * 크리에이터 시험 
 */

console.log("creator Module start");

var CreatorService = (function(){

	//물품삭제
	function remove(no, callback, error){
		$.ajax({
			type : 'delete',
			url : "/cre2/" + no,
			
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
		remove : remove
	};
})();
