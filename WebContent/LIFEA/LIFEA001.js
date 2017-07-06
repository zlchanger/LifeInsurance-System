/**
 * 2017/03/23
 */
function onBack() {
	if (confirm("您确定要退出本页吗？")){
		window.opener=null;
		window.open('','_self');
		window.close();
	}
	else{}
}

function onClose() {
	if (confirm("您确定要关闭本页吗？")){
		window.opener=null;
		window.open('','_self');
		window.close();
	}
	else{}
}

function onImplement(frm) {
	var member = document.getElementById("member");
	var copcd = document.getElementById("copcd");
	var telephone = document.getElementById("telephone");
	var kekno = document.getElementById("kekno");
	if (member.value == "" && copcd.value == "" && kekno.value == "") {
		alert("检索条件不全！");
		frm.member.focus();
		return false;
	}
	if (member.value == "" && telephone.value == "" && kekno.value =="") {
		alert("检索条件不全！");
		frm.member.focus();
		return false;
	}
	if (copcd.value == "" && telephone.value == "" && kekno.value == "") {
		alert("检索条件不全！");
		frm.copcd.focus();
		return false;
	}
	frm.method="post";
	frm.target="_top";
	frm.action="LIFEA001"
	frm.submit();
}

function onChanged(frm) {
//	var insurance = document.getElementsByName("insurance1");
//	for(var i=0;i<insurance.length;i++)
//	{
//	     if(insurance[i].checked){
//	      return radioes[i].value;
//	     }
//	}
	return false;
}

function onSelected(frm) {
	return false;
}