/**
 * 
 */
function onImplement(frm) {
	document.getElementById("actionexcute").value="implement";
	var jjscd = document.getElementById("jjscd");
	var userid = document.getElementById("userid");
	if (jjscd.value == "") {
		alert("请填入事务所CD!");
		frm.jjscd.focus();
		return false;
	}
	if (userid.value == "") {
		alert("请填入用户ID!");
		frm.userid.focus();
		return false;
	}
	frm.method="post";
	frm.target="_top";
	frm.action="LIFEZ003";
	frm.submit();
}

function onClose() {
	window.opener=null;
	window.open('','_self');
	window.close();
}

function onBack(frm) {
	document.getElementById("actionexcute").value="back";
	frm.method="post";
	frm.target="_top";
	frm.action="LIFEZ003";
	frm.submit();
}
