/*
 * @Author:L.Tap
 * @Description: 社会化分享
 */
(function($, window, document, undefined) {
    //插件初始化
    function init(target, options) {
        var settings = $.extend({}, $.fn.socialShare.defaults, options);
		//初始化各个组件
        var $msb_main = $msb_main = "<a class='msb_main'><img title='分享' src='/image/share_core_square.jpg' class='xwcms'></a>";
        var $social_group = "<div class='social_group'>"
		+ "<a target='_blank' class='msb_network_button weixin'>weixin</a>"
		+ "<a target='_blank' class='msb_network_button sina'>sina</a>"
		+ "<a target='_blank' class='msb_network_button tQQ'>tQQ</a>"
		+ "<a target='_blank' class='msb_network_button qZone'>qZone</a>"
		+ "<a target='_blank' class='msb_network_button douban'>douban</a>"
		+ "</div>";
        $(target).append($msb_main);
        $(target).append($social_group);
        $(target).addClass("socialShare");

		//添加QQ好友分享事件
		$(document).on("click",".msb_network_button.tQQ",function(){
			tQQ(this,settings);
		});
		//添加QQ空间分享事件
		$(document).on("click",".msb_network_button.qZone",function(){
			qZone(this,settings);
		});
		//添加新浪微博分享事件
		$(document).on("click",".msb_network_button.sina",function(){
			sinaWeibo(this,settings);
		});
		//添加豆瓣分享事件
		$(document).on("click",".msb_network_button.douban",function(){
			doubanShare(this,settings);
		});
		//添加微信分享事件
		$(document).on("click",".msb_network_button.weixin",function(){
			weixinShare(this,settings);
		});
        $(document).on("click",".msb_main",function(){
			if ($(this).hasClass("disabled")) return;
            var e = 500;//动画时间
            var t = 250;//延迟时间
            var r = $(this).parent().find(".msb_network_button").length;  //分享组件的个数
            var i = 60;
            var s = e + (r - 1) * t;
            var o = 1;
            var a = $(this).outerWidth();
            var f = $(this).outerHeight();
            var c = $(this).parent().find(".msb_network_button:eq(0)").outerWidth();
            var h = $(this).parent().find(".msb_network_button:eq(0)").outerHeight();
            var p = (a - c) / 2; //起始位置
            var d = (f - h) / 2; //起始位置
            var v = 0 / 180 * Math.PI;
            if (!$(this).hasClass("active")) {
                $(this).addClass("disabled").delay(s).queue(function(e) {
                    $(this).removeClass("disabled").addClass("active");
                    e()
                });
                $(this).parent().find(".msb_network_button").each(function() {
                    var n = -(p + (p + i * o) * Math.cos(v));  //结束位置
                    var r = -(d + (d + i * o) * Math.sin(v));  //结束位置
                    $(this).css({
                        display: "block",
                        left: p + "px",
                        top: d + "px"
                    }).stop().delay(t * o).animate({
                        left: n + "px",
                        top: r + "px"
                    }, e);
                    o++
                })
            } else {
                o = r;
                $(this).addClass("disabled").delay(s).queue(function(e) {
                    $(this).removeClass("disabled").removeClass("active");
                    e()
                });
                $(this).parent().find(".msb_network_button").each(function() {
                    $(this).stop().delay(t * o).animate({
                        left: p,
                        top: d
                    }, e);
                    o--
                })
            }
		});
        if ($(target).hasClass("active")) {
			$(".msb_main").click();
        }


    }

	function replaceAPI (api,options) {
		api = api.replace('{url}', options.url);
		api = api.replace('{title}', options.title);
		api = api.replace('{content}', options.content);
		api = api.replace('{pic}', options.pic);
		api = api.replace('{summary}',options.summary);

		return api;
	}

	function tQQ(target,options){
	    //var options = $.extend({}, $.fn.socialShare.defaults, options);
        options = loadShareInfo(target);
		window.open(replaceAPI(tqq,options));
	}

	function qZone(target,options){

		//var options = $.extend({}, $.fn.socialShare.defaults, options);
        options = loadShareInfo(target);
		window.open(replaceAPI(qzone,options));
	}

	function sinaWeibo(target,options){
		//var options = $.extend({}, $.fn.socialShare.defaults, options);
        options = loadShareInfo(target);
		window.open(replaceAPI(sina,options));
	}

	function doubanShare(target,options){

        options = loadShareInfo(target);
		window.open(replaceAPI(douban,options));
	}

	function weixinShare(target,options){
        options = loadShareInfo(target);
		window.open(replaceAPI(weixin,options));
	}

    $.fn.socialShare = function(options, param) {
        if(typeof options == 'string'){
		    var method = $.fn.socialShare.methods[options];
			if(method)
				return method(this,param);
		}else
			init(this,options);
    }


    //插件默认参数
    $.fn.socialShare.defaults = {
        url: window.location.href,
        title: document.title,
        content: '',
        pic: ''
    }

	//插件方法
	$.fn.socialShare.methods = {
		//初始化方法
		init:function(jq,options){
			return jq.each(function(){
				init(this,options);
			});
		},
		tQQ:function(jq,options){
			return jq.each(function(){
				tQQ(this,options);
			})
		},
		qZone:function(jq,options){
			return jq.each(function(){
				qZone(this,options);
			})
		},
		sinaWeibo:function(jq,options) {
			return jq.each(function(){
				sinaWeibo(this,options);
			});
		},
		doubanShare:function(jq,options) {
			return jq.each(function(){
				doubanShare(this,options);
			});
		},
		weixinShare:function(jq,options){
		    return jq.each(function(){
				weixinShare(this,options);
			});
	    }
	}


	//分享地址
	var qzone = 'http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url={url}&title={title}&pics={pic}&summary={summary}';
	var sina = 'http://service.weibo.com/share/share.php?url={url}&title={title}&pic={pic}&searchPic=false';
	var tqq = 'http://connect.qq.com/widget/shareqq/tagCloud.html?url={url}&title={title}&source={source}&desc={content}&pics={pic}&summary={summary}';
	var douban = 'http://www.douban.com/share/service?href={url}&name={title}&text={content}&image={pic}';
	var weixin = 'http://qr.liantu.com/api.php?text={url}';


})(jQuery, window, document);


function loadShareInfo(target) {
	var parent = $(target).parents(".socialShare");
	var result = {
        content: $(parent).data("content"),
        url: getRootPath() + $(parent).data("url"),
        title:$(parent).data("title"),
        summary: $(parent).data("desc") != null ? $(parent).data("desc") : 'MIYAOW个人博客分享,欢迎指教',
        pic: 'http://ovr5hz4v2.bkt.clouddn.com/avatar.jpg'
	};
	return result;
	
}

function getRootPath() {
    //获取当前网址
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名
    var projectName = pathName.substring(0,
        pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
}
