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

function onAlter(frm) {
	document.getElementById("actionexcute").value="alter";
	frm.method = "post";
	frm.target = "_top";
	frm.action = "LIFEE002";
	frm.submit();
}

function onImplement(frm) {
	document.getElementById("actionexcute").value="implement";
	frm.method = "post";
	frm.target = "_top";
	frm.action = "LIFEE002";
	frm.submit();
}