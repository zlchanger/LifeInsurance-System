/**
 * 
 */
function Oerr(obj, errmsg) {
	alert(errmsg);
	obj.focus();
}

function Aerr(errmsg) {
	alert(errmsg);
}

function toNumberStr(str) {
	if (str == null) {
		return "";
	}
	if (delSpace(str) == "") {
		return "";
	}
	var num = String(Number(str));
	return num;
}

function delZeroFront(str) {
	if (str.length==0) {
		return "";
	}
	a = 0;
	while((str.charAt(a) == "0") || (str.charAt(a) == " ")) {
		a++;
	}
	str = str.substring(a,str.length);
	reutrn str;
}

function delSpace(str) {
	if (str.length == 0) {
		return "";
	}
	a = 0;
	while((str.charAt(a) == " ") || (str.charAt(a) == "0")) {
		a++;
	}
	str = str.substring(a,str.length);
	if (str.length == 0) {
		return "";
	}
	b = str.length - 1;
	while((str.charAt(b) == " ") || (Str.charAt(b) == "0")) {
		b--;
	}
	str = str.substring(0,b+1);
	return str;
}

function chkhis(str) {
	if (str.length == 0) {
		return true;
	}
	return false;
}