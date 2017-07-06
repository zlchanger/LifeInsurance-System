/**
 * 
 */
function onImplement(frm) {
	document.getElementById("actionexcute").value="alter";
	var user = document.getElementsByName("user");
	count = 0;
	for(i=0;i<user.length;i++){
        if(user[i].checked)
        	count++;
    }
	if (count == 0) {
		alert("请选择须处理的对象！");
		return false;
	}
	if (count > 1) {
		alert("请选择一个账号！");
		return false;
	}
	frm.method="post";
	frm.target="_top";
	frm.action="LIFEZ002";
	frm.submit();
}

function onClose() {
	window.opener=null;
	window.open('','_self');
	window.close();
}

function onDelete(frm) {
	document.getElementById("actionexcute").value="delete";
	var user = document.getElementsByName("user");
	count = 0;
	for(i=0;i<user.length;i++){
        if(user[i].checked)
        	count++;
    }
	if (count == 0) {
		alert("请选择须处理的对象！");
		return false;
	}
	frm.method="post";
	frm.target="_top";
	frm.action="LIFEZ002";
	frm.submit();
}