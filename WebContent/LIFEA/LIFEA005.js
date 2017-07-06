/**
 * 
 */
function onImplement(frm) {
	var uktil = document.getElementsByName("uktil");
	count = 0;
	for(i=0;i<uktil.length;i++){
        if(uktil[i].checked)
        	count++;
    }
	if (count == 0) {
		alert("请选择须处理的对象！");
		return false;
	}
	if (count > 1) {
		alert("请选择一件处理契约！");
		return false;
	}
	frm.method="post";
	frm.target="_top";
	frm.action="LIFEA005";
	frm.submit();
}
function onClose() {
	window.opener=null;
	window.open('','_self');
	window.close();
}