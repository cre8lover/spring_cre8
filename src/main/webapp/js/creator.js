/**
 * 크리에이터 시험 
 */

console.log("creator Module start");

var CreatorService = (function(){

//물품삭제
function remove(no, callback, error){
$.ajax({
type : 'delete',
url : "/cre2/remove",
data :JSON.stringify(no), //객체 하나만을 넘길때는 이렇게 넘김! 
contentType : 'application/json; charset=utf-8',
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