window.request = {
    queryString: function (paramName) {
        var reg = new RegExp("(^|&)" + paramName + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return "";
    },
    getUrlParam: function () {
        var symbol = window.location.href.indexOf("?") + 1;
        if (symbol == 0) {
            return "";
        }
        var urlLength = window.location.href.length;
        return window.location.href.substring(symbol, urlLength).replace("#", "");
    }
};
String.prototype.endWith = function (s) {
    if (s == null || s == "" || this.length == 0 || s.length > this.length) return false;
    if (this.substring(this.length - s.length) == s) return true;
    else return false;
    return true;
};
String.prototype.startWith = function (s) {
    if (s == null || s == "" || this.length == 0 || s.length > this.length)
        return false;
    if (this.substr(0, s.length) == s)
        return true;
    else
        return false;
    return true;
};
Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, 
        "d+": this.getDate(), 
        "h+": this.getHours(), 
        "m+": this.getMinutes(), 
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S": this.getMilliseconds()
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};
Date.prototype.cut = function (dayNum) {
	this.setDate(this.getDate() - dayNum);
	return this;
};
Date.prototype.add = function (dayNum) {
	this.setDate(this.getDate() + dayNum);
	return this;
};
window.Thread = {
	sleep:function(seconds){
		 var e = new Date().getTime() + seconds;
		 while (new Date().getTime() <= e) {}
	}
};
$(function(){
	$('*[data-options*="initclose:true"]').each(function(){
		$(this).window('close');
	});
});