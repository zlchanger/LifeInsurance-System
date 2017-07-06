/**
 * 
 */
function goNext(frm){
	var jgyCd= document.getElementById('jgyCd');
	var userId = document.getElementById('userId');
	var passWd = document.getElementById('password');
	
	if (jgyCd.value == "") {
		alert("事务所CD不能为空！");
		frm.jgyCd.focus();
		return false;
	}
	if (userId.value == "") {
		alert("用户ID不能为空！");
		frm.userId.focus();
		return false;
	}
	if (passWd.value == "") {
		alert("密码不能为空！");
		frm.password.focus();
		return false;
	}
	frm.method="post";
	frm.action="LIFEV002";
	frm.submit();
}
