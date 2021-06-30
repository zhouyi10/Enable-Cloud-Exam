
$(document).ready(function(){
	setMinHeight(0);
});

//设置随着屏幕大小变化
window.addEventListener("resize",function(){
	setMinHeight(0);
});

//主体部分设置一个最低高度
function setMinHeight(Number){
	function MinHeight(minHight){
		if ($("#footer").length > 0) {
			var footerh=$("#footer").outerHeight();
			minHight=minHight-footerh;
			$(".mainContent").css('min-height',minHight);
		} else if($("#footer2").length > 0) {
			var footerh=$("#footer2").outerHeight();
			minHight=minHight-footerh;
			$(".mainContent").css('min-height',minHight);
		}
	}
	
    if ($(".header").length > 0) {
    	var minHight=$(window).height()-$(".header").outerHeight()-Number;
		MinHeight(minHight);
    }else if ($(".header3").length > 0) {
    	var minHight=$(window).height()-$(".header3").outerHeight()-Number;
		MinHeight(minHight);
    } else{
    	var minHight=$(window).height()-Number;
		MinHeight(minHight);
    }
}
