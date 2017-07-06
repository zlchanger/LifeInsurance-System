/**
 * 
 */
function onClose() {
	window.opener=null;
	window.open('','_self');
	window.close();
}

function onImplement(frm) {
	var jjscd = document.getElementById("jjscd");
	var userid = document.getElementById("userid");
	if (jjscd.value == "") {
		alert("事务所CD不能为空！");
		frm.jjscd.focus();
		return false;
	}
	if (userid.value == "") {
		alert("用户名ID不能为空！");
		frm.userid.focus();
		return false;
	}
	frm.method="post";
	frm.target="_top";
	frm.action="LIFEZ005";
	frm.submit();
}