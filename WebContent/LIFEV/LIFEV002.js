/**
 * 
 */
callWinInfo = new Object();
callWinInfo.closed = true;

function gonext(frm, prm) {
	url = "LIFEV002Link?parm="+prm;
	prop = "width=740, height=430, menubar=yes, scrollbars=yes, resizable=yes, status=yes";
	if (!callWinInfo.closed) {
		callWinInfo.name="callWindow"+(new Date().getTime());
		callWinInfo.close();
	}
	callWinInfo = window.open("", "callWindow", prop);
	callWinInfo.location.replace(url);
	callWinInfo.focus();
}

function goalter(frm, prm, prm2) {
	url = "LIFEV002Link?parm="+prm+"&parm2="+prm2;
	prop = "width=740, height=430, menubar=yes, scrollbars=yes, resizable=yes, status=yes";
	if (!callWinInfo.closed) {
		callWinInfo.name="alterWindow"+(new Date().getTime());
		callWinInfo.close();
	}
	callWinInfo = window.open("", "alterWindow", prop);
	callWinInfo.location.replace(url);
	callWinInfo.focus();
}

function gomodify(frm, prm) {
	url = "LIFEV002Link?parm="+prm;
	prop = "width=740, height=430, menubar=yes, scrollbars=yes, resizable=yes, status=yes";
	if (!callWinInfo.closed) {
		callWinInfo.name="modifyWindow"+(new Date().getTime());
		callWinInfo.close();
	}
	callWinInfo = window.open("", "modifyWindow", prop);
	callWinInfo.location.replace(url);
	callWinInfo.focus();
}

function gosearch(frm, prm) {
	url = "LIFEV002Link?parm="+prm;
	prop = "width=740, height=430, menubar=yes, scrollbars=yes, resizable=yes, status=yes";
	if (!callWinInfo.closed) {
		callWinInfo.name="searchWindow"+(new Date().getTime());
		callWinInfo.close();
	}
	callWinInfo = window.open("", "searchWindow", prop);
	callWinInfo.location.replace(url);
	callWinInfo.focus();
}

function gomanage(frm, prm) {
	url = "LIFEV002Link?parm="+prm;
	prop = "width=740, height=430, menubar=yes, scrollbars=yes, resizable=yes, status=yes";
	if (!callWinInfo.closed) {
		callWinInfo.name="manageWindow"+(new Date().getTime());
		callWinInfo.close();
	}
	callWinInfo = window.open("", "manageWindow", prop);
	callWinInfo.location.replace(url);
	callWinInfo.focus();
}
function onBack(frm) {
	if (!callWinInfo.closed) {
		callWinInfo.close();
	}
	frm.method = "post";
	frm.target = "_top";
	frm.action = "LIFEV002Link";
	frm.submit();
}