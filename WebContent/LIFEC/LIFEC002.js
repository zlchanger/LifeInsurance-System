/**
 * 
 */
function onAlter(frm) {
	document.getElementById("actionexcute").value="alter";
	frm.method = "post";
	frm.target = "_top";
	frm.action = "LIFEC002";
	frm.submit();
}

function onImplement(frm) {
	document.getElementById("actionexcute").value="implement";
	frm.method = "post";
	frm.target = "_top";
	frm.action = "LIFEC002";
	frm.submit();
}

function onClose(frm) {
	window.opener=null;
	window.open('','_self');
	window.close();
}