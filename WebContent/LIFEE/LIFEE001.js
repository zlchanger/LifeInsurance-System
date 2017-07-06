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

function onBack(frm) {
	document.getElementById("actionexcute").value="back";
	frm.method = "post";
	frm.target = "_top";
	frm.action = "LIFEE001";
	frm.submit();
}

function onImplement(frm) {
	document.getElementById("actionexcute").value="implement";
	var kanama= document.getElementById('kanama');
	var ukContent= document.getElementById('ukContent');
	var jjscd= document.getElementById('jjscd');
	var userid= document.getElementById('userid');
	if (kanama.value == "") {
		alert("契约者名不能为空！");
		frm.kanama.focus();
		return false;
	}
	if (ukContent.value == "") {
		alert("受付内容不能为空！");
		frm.ukContent.focus();
		return false;
	}
	if (jjscd.value == "") {
		alert("事务所CD不能为空！");
		frm.jjscd.focus();
		return false;
	}
	if (userid.value == "") {
		alert("用户名不能为空！");
		frm.userid.focus();
		return false;
	}
	frm.method = "post";
	frm.target = "_top";
	frm.action = "LIFEE001";
	frm.submit();
}

