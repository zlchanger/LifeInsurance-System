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
	var jjscd= document.getElementById('jjscd');
	var userid= document.getElementById('userid');
	if (jjscd.value == "" && userid.value == "") {
		alert("检索条件不能为空！");
		frm.jjscd.focus();
		return false;
	}
	frm.method = "post";
	frm.target = "_top";
	frm.action = "LIFEZ001";
	frm.submit();
}