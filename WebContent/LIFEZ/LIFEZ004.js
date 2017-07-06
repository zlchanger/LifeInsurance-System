/**
 * 
 */
function onImplement(frm) {
	document.getElementById("actionexcute").value="implement";
	frm.method="post";
	frm.target="_top";
	frm.action="LIFEZ004";
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
	frm.action="LIFEZ004";
	frm.submit();
}