$(document).ready(function(){
	 $(".flip").click(function(e){
		e.preventDefault();
        $('.panel'+$(this).attr('id')).toggle();
	 });
});