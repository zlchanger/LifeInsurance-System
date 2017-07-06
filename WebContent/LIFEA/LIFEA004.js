/**
 * 
 */
function onclose(){
	window.opener=null;
	window.open('','_self');
	window.close();
}
function onImplememt(frm) {
	var uktkno = document.getElementById("uktkno");
	var kekno = document.getElementById("kekno");
	if (uktkno.value == "" && kekno.value == "") {
		alert("检索条件不全！");
		frm.uktkno.focus();
	}
	frm.method="post";
	frm.target="_blank";
	frm.action="LIFEA004"
	frm.submit();
	onclose();
}