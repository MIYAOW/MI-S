//============================================================
//JS验证,提供中文,正整数,长度,email,URL地址等验证
//============================================================

/**
 * 验证是否是邮件
 * @returns Boolean
 */
function isEmail(email) {
	var pattern = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i
	return pattern.test(email);
}

/**
 * 是否包含空格
 * @param string
 * @returns
 */
function isSpaces(string) {
	return /\s/.test(string);
}

/**
 * 验证是否是URL地址
 * @param url
 * @returns Boolean
 */
function isUrl(url){
	var urlRegex = /^(http|https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i
	return urlRegex.test(url);
} 

/**
 * 验证是否是汉字
 * @param string
 * @returns Boolean
 */
function isChineseCharacter(string){
	var strReg = /[\u4E00-\u9FA5]/gi;
	return strReg.test(string);
}

/**
 * 验证是否是中文全角
 * @param string
 * @returns Boolean
 */
function isFullSymbols(string){
	var fullSymbolsReg = /[\uFE30-\uFFA0]/gi;
	return fullSymbolsReg.test(string)
}

/**
 * 验证是否是正整数
 * @param string
 * @returns
 */
function isPositiveInteger(string){
	var integerReg = /^[1-9]\d*$/;
	return integerReg.test(string);
}

/**
 * 验证是否是电话号码(国内)
 * 格式:0755-88888888
 * @returns
 */
function isTelephone(telephone) {
	var telephoneReg = /^0?\d{2,3}\-\d{7,8}$/
	return telephoneReg.test(telephone)
}

/**
 * 验证是否是QQ号码
 * @param string
 * @returns Boolean
 */
function isQQNumber(string){
	var qqNumberReg = /^[1-9][0-9]{4,}$/;
	return qqNumberReg.test(string)
}

/**
 * 验证是否是邮政编码
 * @returns Boolean
 */
function isPostCode(postCode){
	var postCode = /^[1-9]d{5}(?!d)$/;
	return postCode.test(postCode);
}

/**
 * 验证是否是IPV4地址
 * @returns Boolean
 */
function isIP(ip){
	var ipReg = /^d+.d+.d+.d+$/;
	return ipReg.test(ip);
}

/**
 * 是否只正浮点型
 * @returns Boolean
 */
function isFloat(string) {
	var reg = /^[1-9]d*.d*|0.d*[1-9]d*$/;
	return reg.test(string);
}

/**
 * 是否是手机号码
 * @param string
 * @returns Boolean
 */
function isMobile(string) {
	var reg = /^0?(13[0-9]|15[0123456789]|18[012356789]|14[57]|17[0-9])[0-9]{8}$/;
	return reg.test(string);
}

/**
 * 校验是否为空
 * @param str
 * @returns {Boolean}
 */
function isEmpty(str) {
	if (!str || $.trim(str).length <= 0||str==null||str==undefined)
		return true;
	return false;
}

/**
 * 是否是指定长度
 * @param str
 * @param length
 */
function isSpecifyLength(str,minLen,maxLen) {
	if ($.trim(str).length >= minLen && $.trim(str).length <= maxLen)
		return true;
	return false;
}

/**
 * 是否含有特殊符号
 * @param str
 * @returns {Boolean}
 */
function isSpecialSymbols(str) {
	var pattern = new RegExp("[`~!@#$^&*()={}':;',\\[\\].<>/?~！@#￥……&*（）{}【】‘；：”“'。，、？]");
	return pattern.test(str);
}

/**
 * 非零开头的数字
 * @param str
 * @returns {Boolean}
 */
function isNumber(str) {
	var reg = /^(0|[1-9][0-9]*)$/;
	return reg.test(str);
}

/**
 * 时间对比YYYY-MM-DD
 * @param d1
 * @param d2
 */
function compareDate(start,end) {
	var d1 = new Date(start.replace(/\-/g, "\/"));
	var d2 = new Date(end.replace(/\-/g, "\/"));
	return d1 > d2
}

/**
 * 包名
 */
function isPackageName(packageName) {
	var reg = /^([a-zA-Z]+[.][a-zA-Z]+)[.]*.*$/;
	return reg.test(packageName);
}

/**
 * 是否含有特殊符号不包含小数点
 * @param str
 * @returns {Boolean}
 */
function isSpecialSymbolsNoPoint(str) {
	var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\]<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
	return pattern.test(str);
}