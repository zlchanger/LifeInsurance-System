/**
 * 
 */
function onSearch(frm) {
	frm.method = "post";
	frm.target = "_top";
	frm.action = "LIFEA002EX";
	frm.submit();
}
function onImplement(frm) {
	var tsky = document.getElementsByName("tsky");
	var iky = document.getElementsByName("iky");
	var lky = document.getElementsByName("lky");
	tcount = 0;
	icount = 0;
	lcount = 0;
	for(i=0;i<tsky.length;i++){
        if(tsky[i].checked)
        	tcount++;
    }
	for(i=0;i<iky.length;i++){
        if(iky[i].checked)
        	icount++;
    }
	for(i=0;i<lky.length;i++){
        if(lky[i].checked)
        	lcount++;
    }
	count = tcount + icount + lcount;
	if(count == 0) {
		alert("请选择须处理的契约！");
		return false;
	}
	if(count > 8) {
		alert("选择的契约大于8件！");
	}
	frm.method = "post";
	frm.target = "_top";
	frm.action = "LIFED001";
	frm.submit();
}
function onClose(frm) {
	window.opener=null;
	window.open('','_self');
	window.close();
}