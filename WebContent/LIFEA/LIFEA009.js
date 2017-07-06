/**
 * 
 */
winInfo = new Object();
winInfo.closed = true;
function onClose() {
	if (winInfo != null && winInfo != 'undefined') {
		if (!winInfo.closed) {
			winInfo.close();
		}
	}
	window.close();
}

function onImplement(frm) {
	var jjscd = document.getElementById("jjscd");
	if (jjscd.value == "") {
		alert("事务所CD不能为空！");
		frm.jjscd.focus();
		return false;
	}
	frm.method="post";
	frm.target="_top";
	frm.action="LIFEA009";
	frm.submit();
}