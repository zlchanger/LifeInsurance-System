/**
 * 
 */
function onImplement(frm) {
	frm.method="post";
	frm.target="_top";
	frm.action="LIFEA007";
	frm.submit();
}

function onClose() {
	window.opener=null;
	window.open('','_self');
	window.close();
}