// 弹出窗口公共方法
function autoCloseAlert(msg,second){
	new $.flavr({
	    content     : msg,
	    autoclose   : true,
	    timeout     : second  
	});
}