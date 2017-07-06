/**
 * 
 */
winInfo = new Object();
winInfo.closed = true;
function onClose() {
	if (winInfo != null && winInfo != 'undefined') {
		if (!winInfo.closed) {
			winInfo.close();
		}
	}
	window.close();
}