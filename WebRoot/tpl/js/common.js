(function(window){
    var pageHeight = window.innerHeight;
    if(typeof pageHeight != "number"){
        if(document.compatMode == "CSS1Compat"){//判断页面是否标准模式
            pageHeight = document.documentElement.clientHeight;
        }else{
            pageHeight = document.body.clientHeight;
        }
    }
    document.getElementById('wrap').style.cssText = "height:"+pageHeight+"px";

    //缓存
	cacheUtil = function(){};
	cacheUtil.IsNull = function(data){
		if(data == undefined || data == null){
			return true;
		}
		var t = data.replace(/(^\s*)|(\s*$)/g, "");
		if (t == "" || t == null || t == "undefined") {
			return true;
		} else {
			return false;
		}
	};
	cacheUtil.storage = {
		_storage : sessionStorage,
		cache : function(key,value){
			var str;
			if(Object.prototype.toString.call(value) === '[object Array]' ||
				Object.prototype.toString.call(value) === '[object Object]'	){
				str = JSON.stringify(value);
			}else{
				str = value;
			}
			this._storage.setItem(key,str);
		},
		getCache : function(key){
			var value = this._storage.getItem(key);
			return cacheUtil.IsNull(value) ? undefined : value;
		},
		removeCache : function(key){
			this._storage.removeItem(key);
		}
	};
	if(!window.eCacheUtil){
		window.eCacheUtil = cacheUtil;
	}
})(window);

//缓存key
var CacheKey = {
    quoteId:"quote_id",
    //订单号
    orderId : "order_id",
	//选择机型的name
    ModelName : "model_name",
    //选择机型的projectid
    ProjectId : "project_id",
	//img地址
	imgHref :"img_href",
	//测评故障name
	itemsName:"items_name",
	//测评故障id
	SelectItems : "select_items",
	SelectItems1 : "select_items1",
	//预付金额
    prePrice : "pre_price",
	//取件时间
	pickTime : "pick_time",
	resultMsg : "result_msg",
    percent : 'percent',

	//手机品牌id
	BrandId : "brand_id",
	//品牌name
	BrandName : "brand_name",
	//型号id
	ModelId : "model_id",
	//选择机型后的类型projectName
	ProjectName : "project_name",
	//来源
	source : "fm",
	userName:"user_name",
	userPhone:"user_phone",
	//抽奖手机号
	lotteryMobile:"lottery_mobile",
	//是否良品价估价
    isGood:"is_good"
};

//存值方法,新的值添加在首位
function setHistoryItems(keyword,keyid,imghref) {
    var _localStorage = localStorage,
        historyItems = _localStorage.historyItems;

    if (historyItems === undefined) {
        localStorage.historyItems = [keyword,keyid,imghref];
    } else {
        historyItems = [keyword,keyid,imghref] + '|' + historyItems.split('|').filter(function (e) {
            return e != keyword+','+keyid+','+imghref;
        }).join('|');
        localStorage.historyItems = historyItems;
    }
}

function getRealPath(){
    var pathName=location.pathname;
    var allPath=location.href;
    var pos=allPath.indexOf(pathName);
    var linkUrl=allPath.substring(0,pos);
    return linkUrl;
}

//http://39.108.6.107  && http://17t033o025.iok.la
var linkUrl=getRealPath();
var appId='wx2f9fa0184228af25';    

/**
 * 获取协议+域名+项目名+"/"的路径
 * @returns {String}
 */


 //**** 获取url后附带参数值
function GetQueryString(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null){
        return  unescape(r[2]);
    }
    return null;
}

//*** 弹出框、提示框
function alertTip(text) {
    $('.remind_delivery_bg .remind_delivery_cont p').text(text);
    $(".remind_delivery_bg").show();
    window.setTimeout(function(){ $(".remind_delivery_bg").fadeOut();},2000);
}

//*** 加载——遮盖方法
function fn_loading(){
    $("#mask_boxs").show();
}
//*** 加载——隐藏遮盖层
function loading_hide(){
    $("#mask_boxs").hide();
}

//*** 确认提示
function confirmTip(title, msg, callback){
    if(!msg){
        return;
    }
    if(!title){
        title = "系统提示";
    }
    $(".popup_content .popup_title").text(title);
    $(".popup_content .popup_font").text(msg);
    $(".popup_but .cancel").hide();
    $(".popup_bg, .popup_content").show();
    //点击确认
    $(".popup_but .confirm").unbind("click").click(function(){
        $(".popup_bg, .popup_content").hide();
        if (callback) {
            callback();
        }
    });
}
//*** 带确认/取消按钮提示框
function realAlert(title, msg, callback){
    if(!msg){
        return;
    }
    if(!title){
        title = "系统提示";
    }
    $(".popup_content .popup_title").text(title);
    $(".popup_content .popup_font").text(msg);
    //隐藏取消按钮
    $(".popup_but .cancel").show();
    $(".popup_bg, .popup_content").show();
    //点击确认
    $(".popup_but .confirm").unbind("click").click(function(){
        $(".popup_bg, .popup_content").hide();
        if (callback) {
            callback();
        }
    });
}
//*** 关闭弹出框
function closePopup(){
	$(".popup_bg, .popup_content").hide();
	loading_hide();
	$('#pay').hide();
	$('#payCont').removeClass('active');
}
/**
 * 关闭窗口
 */
function closeWindow(){
    var userAgent = navigator.userAgent;
    if (userAgent.indexOf("Firefox") != -1 || userAgent.indexOf("Chrome") !=-1) {
        //window.location.replace("about:blank");
        var w = window.open('about:blank', '_self', '');
        w.close();
    }else{
        window.opener=null;
        window.open('', '_self', '');
        window.close();
    }
}
//去除文本首尾的空格
String.prototype.trim=function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
String.prototype.ltrim=function(){
    return this.replace(/(^\s*)/g,"");
}
String.prototype.rtrim=function(){
    return this.replace(/(\s*$)/g,"");
}

//四舍五入
Number.prototype.fixed=function(n){  
	with(Math)return round(Number(this)*pow(10,n))/pow(10,n);
};

//判断是否有indexOf方法
if (!Array.indexOf) {  
    Array.prototype.indexOf = function (obj) {  
        for (var i = 0; i < this.length; i++) {  
            if (this[i] == obj) {  
                return i;  
            }  
        }  
        return -1;  
    }  
}

//对Date的扩展，将 Date 转化为指定格式的String   
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
//例子：   
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
Date.prototype.format = function(fmt){
	var o = {   
			"M+" : this.getMonth()+1,                 //月份   
			"d+" : this.getDate(),                    //日   
			"h+" : this.getHours(),                   //小时   
			"m+" : this.getMinutes(),                 //分   
			"s+" : this.getSeconds(),                 //秒   
			"q+" : Math.floor((this.getMonth()+3)/3), //季度   
			"S"  : this.getMilliseconds()             //毫秒   
			};   
	if(/(y+)/.test(fmt)){
		fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
	}
	for(var k in o){
		if(new RegExp("("+ k +")").test(fmt)){
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
		}
	}
	return fmt;   
}

function getDateDayFormat(day){
	var now = new Date();
	now.setDate(now.getDate() + day);
	return now.format("yyyy-MM-dd");
}

function getDateHourFormat(hour){
	var now = new Date();
	now.setHours(now.getHours() + hour);
	return now.format("yyyy-MM-dd hh:mm:ss");
}

function getTimeStr(remainTime){
    var hh = parseInt(remainTime / 60 / 60, 10);//计算剩余的分钟数  
    var mm = parseInt(remainTime / 60 % 60, 10);//计算剩余的分钟数  
    var ss = parseInt(remainTime % 60, 10);//计算剩余的秒数  
    if(hh == 0){
	    return checkTime(mm) + ":" + checkTime(ss);
    }else{
    	return checkTime(hh) + ":" + checkTime(mm) + ":" + checkTime(ss);
    }
}

function getHourTimeStr(remainTime){
    var hh = parseInt(remainTime / 60 / 60, 10);//计算剩余的分钟数  
    var mm = parseInt(remainTime / 60 % 60, 10);//计算剩余的分钟数  
    var ss = parseInt(remainTime % 60, 10);//计算剩余的秒数  
    return checkTime(hh) + ":" + checkTime(mm) + ":" + checkTime(ss);
}

//获取当月中最后一天
function getlastday(year,month)
{
    var new_year = year;    //取当前地年份
    var new_month = month++;//取下一个月地第一天，方便计算（最后一天不固定）
    if(month>12)            //如果当前大于12月，则年份转到下一年
    {
        new_month -=12;        //月份减
        new_year++;            //年份增
    }
    var new_date = new Date(new_year,new_month,1);                //取当年当月中地第一天
    return (new Date(new_date.getTime()-1000*60*60*24)).getDate();//获取当月最后一天日期
}

function checkTime(i){    
    if (i < 10) {    
        i = "0" + i;    
    }    
    return i;
}

/**
 * 判断是否是空
 * @param value
 */
function isEmpty(value){
	if(value == null || value == "" || value == "undefined" || value == undefined || value == "null"){
		return true;
	}
	else{
		value = value.replace(/\s/g,"");
		if(value == ""){
			return true;
		}
		return false;
	}
}

/**
 * 判断是否是数字
 */
function isNumber(value){
	if(!value || !value.trim()){
		return false;
	}
	if(isNaN(value)){
		return false;
	}
	else{
		return true;
	}
}

/*
* 数据格式化
* @param val 要格式化的数据
* @param n 格式化后的小数位数
*/
function dataFormat(val, n) {
	if (isNaN(val)) return "";
	if (n == undefined || n == null || isNaN(n)) n = 2;
 
	return new Number(val).toFixed(n);
}


/**
 * 只包含中文和英文
 * @param cs
 * @returns {Boolean}
 */
function isGbOrEn(value){
    var regu = "^[a-zA-Z\u4e00-\u9fa5]+$";
    var re = new RegExp(regu);
    if (value.search(re) != -1){
      return true;
    } else {
      return false;
    }
}

/**
 * 检查邮箱格式
 * @param email
 * @returns {Boolean}
 */
function check_email(email){  
   if(email){
   var myReg=/(^\s*)\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*(\s*$)/;
   if(!myReg.test(email)){return false;}
   return true;
   }
   return false;
}


/**
 * 检查邮编
 * 
 * @param zip
 * @returns {Boolean}
 */
function check_zip(zip) {
	var regu = /^\d{6}$/;
	var re = new RegExp(regu);
	if (!re.test(zip)) {
		return false;
	}
	return true;
}

/**
 * 检查手机号码
 * 
 * @param mobile
 * @returns {Boolean}
 */
function check_mobile(mobile) {
	var regu = /^\d{11}$/;
	var re = new RegExp(regu);
	if (!re.test(mobile)) {
		return false;
	}
	return true;
}

/**
 * 检查身份证号码(中间位为*)
 * 
 * @param idCard
 * @returns {Boolean}
 */
function check_idCard_new(idCard) {
	var regu = null;
	var re = null;
	if(idCard.length == 15){
		regu =  /^\d{4}\*\*\*\*\*\*\*\d{4}$/;
	}else if(idCard.length == 18){
		regu =  /^\d{4}\*\*\*\*\*\*\*\*\*\*\d{3}(\d|X|x)$/;
	}else{
		return false;
	}
	re = new RegExp(regu);
	if (!(re.test(idCard) || check_idCard(idCard))) {
		return false;
	}
	return true;
}

/**
 * 获取随机数
 */
function getRandomStr(len){
	var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
	var v_len = len;
	if(len == undefined || len == 0){
		v_len = 20;
	}
	var res = "";
	for(var i = 0; i < v_len ; i ++) {
		var id = Math.ceil(Math.random()*35);
		res += chars[id];
	}
	return res;
}

