/**
 * 
 */
function onChang(frm) {
	var userid = document.getElementById("userid"); 
	var passwd = document.getElementById("passwd");
	var newpasswd = document.getElementById("newpasswd");
	var confirmpasswd = document.getElementById("confirmpasswd");
	if (userid.value == null || userid.value == "") {
		alert("用户ID不能为空！");
		frm.userId.focus();
		return false;
	}
	if (passwd.value == null || passwd.value == "") {
		alert("现在的密码不能为空！");
		frm.passwd.focus();
		return false;
	}
	if (newpasswd.value == null || newpasswd.value == "") {
		alert("新密码不能为空！");
		frm.newpasswd.focus();
		return false;
	}
	if (confirmpasswd.value == null || confirmpasswd.value == "") {
		alert("确认密码不能为空！");
		frm.confirmpasswd.focus();
		return false;
	}
	if (newpasswd.value != confirmpasswd.value) {
		alert("确认密码与新密码不一致！");
		frm.confirmpasswd.focus();
		return false;
	}
	frm.method="post";
	frm.target="_top";
	frm.action="LIFEA006";
	frm.submit();
}

function onClose() {
	window.opener=null;
	window.open('','_self');
	window.close();
}