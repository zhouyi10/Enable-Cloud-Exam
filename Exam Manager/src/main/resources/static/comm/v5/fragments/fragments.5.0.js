
$(document).attr("title","三三云学堂");
$(document.head).append("<meta name=\"referrer\" content=\"no-referrer\"/>");

var headerFn = function(){
    // logo图片
    $(".main .header .header_tp > img.logoImg").on('click', function() {
        window.location.href = window.location.href.replace(window.location.pathname, '');
    });

}

//滚动条高度判断返回顶部按钮是否出现
function scrolltopFn($scrollTops){
	//加入点击返回按钮
	var $backBtn=$("<div id='backtop-btn' class='backtop-btn'><i></i></div>");
	if ($("#backtop-btn").length == 0) {
		$("body").append($backBtn);
	}
	scrollFn($scrollTops);
	$("#backtop-btn").on('click',function(){
		$('body,html').animate({scrollTop:0},500);
	})
}

function scrollFn($scrollTops){
	if ($scrollTops>($(window).height()/1.5)) {
		$("#backtop-btn").show();
	}else{
		$("#backtop-btn").hide();
	}
}
$(document).ready(function(){
	$(window).scroll(function(){
		var $scrollTop=$(window).scrollTop();
		scrollFn($scrollTop)
	});
    reSizeContent();
    $(window).resize(function () {
        reSizeContent();
    });
});

function reSizeContent() {
    var headerHeight = $("#header").height();
    var footerHeight = $("#footer").height();
    $("#content").css("min-height", window.innerHeight - headerHeight - footerHeight - 44);
}

var header = window.header = {
    menuJson : null,
    menuJsonHeader : null,
    menuMap: {},
    init : function() {
        var _this = this;
        if (_this.menuJson == null || _this.menuJson == '') {
            return;
        }
        if (_this.menuJsonHeader == null || _this.menuJsonHeader == '') {
            return;
        }
        if (typeof _this.navMenu == "string") {
            _this.menuJson = JSON.parse(_this.menuJson);
            _this.menuJsonHeader = JSON.parse(_this.menuJsonHeader);
        }
        if($('.header_bt')){
            $('.header_bt').hide();
        }
        _this.initNavigation();
        headerFn();
        _this.buildBreadcrumbs();
    },
    initNavigation : function() {
        var _this = this;
        var menuTopKey = null;
        var menuChildKey = null;
        if (sessionStorage) {
            menuTopKey = sessionStorage.getItem('_menu_50_top_key_');
            menuChildKey = sessionStorage.getItem('_menu_50_child_key_');
        }
        if (menuTopKey == null || menuTopKey == undefined  || menuTopKey.trim() == '') {
            menuTopKey = $.cookie('_menu_50_top_key_');
            if (menuTopKey != null && menuTopKey != undefined  && menuTopKey.trim() != '' && sessionStorage) {
                sessionStorage.setItem('_menu_50_top_key_', menuTopKey);
            }
        }
        if (menuChildKey == null || menuChildKey == undefined  || menuChildKey.trim() == '') {
        	menuChildKey = $.cookie('_menu_50_child_key_');
            if (menuChildKey != null && menuChildKey != undefined  && menuChildKey.trim() != '' && sessionStorage) {
                sessionStorage.setItem('_menu_50_child_key_', menuChildKey);
            }
        }

	        if(!$.isEmptyObject(_this.menuJsonHeader)) {
	            var topMenuHtml = "";
	            var i = 0;
	            _this.menuJsonHeader.forEach(function(element){
	            	_this.menuMap[element.menuId] = element;
	            	if (i == 0 && $.isEmptyObject(menuTopKey)) {
	            		topMenuHtml += _this.appendTopMemuHtml(element, true);
	            		menuTopKey = element.menuId;
	            	} else {
	            		topMenuHtml += _this.appendTopMemuHtml(element);
	            	}
	                i ++;
	            });
	            $("#topMenu").html(topMenuHtml);
	        }
	        
	        if(!$.isEmptyObject(_this.menuJson)) {
	            var navigationHtml = "";
	            var i = 0;
	            _this.menuJson.forEach(function(element){
	            	_this.menuMap[element.menuId] = element;
	            	if (i == 0 && $.isEmptyObject(menuTopKey)) {
	            		navigationHtml += _this.appendNavigationHtml(element, true);
	            		menuChildKey = element.menuId;
	            	} else {
	            		navigationHtml += _this.appendNavigationHtml(element);
	            	}
	                i ++;
	            });
	            $("#navigation").html(navigationHtml);
	        }
	        menuTopKey = sessionStorage.getItem('_menu_50_top_key_');
	        $("#"+ menuTopKey).addClass("active");
	        menuChildKey = sessionStorage.getItem('_menu_50_child_key_');
	        $("#"+ menuChildKey).addClass("a_list_active");
    },
    changeChildren: function(menuId) {
    	$("#"+ menuId).addClass("active");
    	var _this = this;
    	var menu = _this.menuMap[menuId];
    	sessionStorage.setItem('_menu_50_top_key_', menuId);
    	sessionStorage.removeItem("_menu_50_child_key_");
    	document.location.href = menu.url;
    },
    appendTopMemuHtml: function(menu, isActive) {
    	return '<div id="'+menu.menuId+'" class="' + (isActive ? 'tab active' : 'tab') + '" onclick="header.changeChildren(\''+menu.menuId+'\')">'+menu.name+'</div>';
    },
    appendNavigationHtml : function(menu, isActive) {
        return '<a id="'+menu.menuId+'" class="a_list ' + (isActive ? 'a_list_active' : '') + '" onclick="checkChildMenu(\''+menu.menuId+'\',\''+menu.url+'\')" >'+menu.name+'</a>';
    },
    buildBreadcrumbs: function (type) {
    }
};

function  checkChildMenu(menuId, menuUrl) {
	$("#"+ menuId).addClass("a_list_active");
	sessionStorage.setItem('_menu_50_child_key_', menuId);
	document.location.href = menuUrl;
	header.buildBreadcrumbs("child");
}
// 底部
var footer = {
    "_logoSrc": "/comm/img/xclogo.png",
    "address": "学创教育科技有限公司&emsp;&emsp;地址：武汉市光谷国际广场B座20楼&emsp;&emsp;电话：+86-027-87107188",
    "version" : "三三云学堂 V5.00",
    "copyright": "Copyright © 2016-2018 学创教育科技有限公司.All rights reserved.",
    "init": function() {
        var footer = '<div style="text-align: center;font-size: 12px;">';
        footer += '<p>' + this.version + '</p>';
        footer += '<p>' + this.copyright + '</p>';
        footer += '</div>';
        $(".footer").append(footer);
    }
}
