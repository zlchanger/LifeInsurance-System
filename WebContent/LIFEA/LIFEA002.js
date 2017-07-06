/**
 * 2017/3/28
 */
function onAgree(frm) {
	frm.method = "post";
	frm.target = "_blank";
	frm.action = "LIFEA002";
	frm.submit();
}

function onSearch(frm) {
	frm.method = "post";
	frm.target = "_top";
	frm.action = "LIFEA002EX";
	frm.submit();
}
function onAdtler(frm) {
	var dhis = document.getElementsByName("alter");
	hiscount = 0;
	for(i=0;i<dhis.length;i++){
        if(dhis[i].checked)
        	hiscount++;
    }
	if (hiscount == 0) {
		alert("请选择要修正的历史记录！");
		return false;
	}
	if (hiscount > 1) {
		alert("请选择一条要修正的历史纪录！");
		return false;
	}
	frm.method = "post";
	frm.target = "_top";
	frm.action = "LIFEE000";
	frm.submit();
}

function onClo(frm) {
	window.opener=null;
	window.open('','_self');
	window.close();
}