<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Vector"%>
<%@page import="LIFE.C.LIFEC001Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="Dchange" scope="page" class="LIFE.UTIL.DChange"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Pragma:no-cache">
<meta http-equiv="Cache-Control:no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="LIFECSS/DCmnStyle.css" type="text/css">
<script type="text/javascript" language="javascript"
	src="LIFEUTIL/DChk.js" charset="utf-8"></script>
<script type="text/javascript" language="javascript"
	src="LIFEC/LIFEC002.js" charset="utf-8"></script>
<title>契约者情报变更初回确认(LIFEC002)</title>
</head>
<%
	LIFEC001Form data = (LIFEC001Form)request.getAttribute("nextform");
	Vector<Hashtable<String, String>> tsky = (Vector<Hashtable<String, String>>) data.gettsky();
	Vector<Hashtable<String, String>> iky = (Vector<Hashtable<String, String>>) data.getiky();
	Vector<Hashtable<String, String>> lky = (Vector<Hashtable<String, String>>) data.getlky();
	String uktkno = (String)request.getAttribute("reUktkno");
%>
<body>
	<form name="form1">
	<input type="hidden" name="sid" value="LIFEC002">
	<input type="hidden" name="actionexcute" id="actionexcute" value="">
		<div>&nbsp;</div>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<div class="px13">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该页面进行契约者情报的修改确认。</div>
		<table width="90%" border="0" class="px13" align="center">
			<%
				if (tsky != null && tsky.size() > 0) {
			%>
			<tr>
				<td bgcolor="#8968CD" align="left">终生生命</td>
			</tr>
			<%
				for (int i = 0; i < tsky.size(); i++) {
						Hashtable<String, String> tskydata = tsky.get(i);
						request.setAttribute("tdata", tskydata);
			%>
			<tr>
				<td><jsp:include page="/LIFEUTIL/DComTsky.jsp" flush="true" /></td>
			</tr>
			<tr><td><input type="hidden" name="tsky" id="tsky" value=<%=(String) tskydata.get("KEKNO")%>></td></tr>
			<%
				}
				}
			%>
			<%
				if (iky != null && iky.size() > 0) {
			%>
			<tr>
				<td bgcolor="#BBFFFF" align="left">终生医疗</td>
			</tr>
			<%
				for (int i = 0; i < iky.size(); i++) {
						Hashtable<String, String> ikydata = iky.get(i);
						request.setAttribute("idata", ikydata);
			%>
			<tr>
				<td><jsp:include page="/LIFEUTIL/DComIky.jsp" flush="true" /></td>
			</tr>
			<tr><td><input type="hidden" name="iky" id="iky" value=<%=(String)ikydata.get("KEKNO") %>></td></tr>
			<%
				}
				}
			%>
			<%
				if (lky != null && lky.size() > 0) {
			%>
			<tr>
				<td bgcolor="#CDCD00" align="left">火灾</td>
			</tr>
			<%
				for (int i = 0; i < lky.size(); i++) {
						Hashtable<String, String> lkydata = lky.get(i);
						request.setAttribute("ldata", lkydata);
			%>
			<tr>
				<td><jsp:include page="/LIFEUTIL/DComLky.jsp" flush="true" /></td>
			</tr>
			<tr><td><input type="hidden" name="lky" id="lky" value=<%=(String)lkydata.get("KEKNO") %>></td></tr>
			<%
				}
				}
			%>
		</table>
		<table width="90%" align="center" border="1" cellpadding="2" cellspacing="1" class="px13">
		<tr><td>
		<table width="100%" align="center" border="0" class="px13">
		<tr><td>&nbsp;</td></tr>
			<tr><td width="5%">&nbsp;</td>
			<td width="12%">契约者姓：</td>
			<td width="30%"><input type="text" name="kamanax" value=<%=(String)data.getKamanax() %> class="inputsty" readonly></td>
			<td width="5%">&nbsp;</td>
			<td width="12%">契约者名：</td>
			<td width="36%"><input type="text" name="kamanam" value=<%=(String)data.getKamanam() %> class="inputsty"readonly></td></tr>
			<tr><td>&nbsp;</td>
			<td>生年月日：</td>
			<td><input type="text" name="birthday" value=<%=(String)data.getBirthday() %> class="inputsty" readonly></td>
			<td>&nbsp;</td>
			<td>契约者性别：</td>
			<td><input type="text" name="sex" value=<%=(String)data.getSex() %> class="inputsty" readonly></td></tr>
			<tr><td width="5%">&nbsp;</td>
			<td width="12%">契约者电话：</td>
			<td width="30%"><input type="text" name="tele" maxlength="13" value=<%=(String)data.getTele() %> class="inputsty" readonly></td>
			<td width="5%">&nbsp;</td>
			<td width="12%">&nbsp;</td>
			<td width="36%">&nbsp;</td></tr>
			<tr><td>&nbsp;</td>
			<td>契约者邮编：</td>
			<td><input type="text" name="zipcode" maxlength="6" value=<%=(String)data.getZipcode() %> class="inputsty" readonly></td>
			<td>&nbsp;</td>
			<td>契约者住址：</td>
			<td><input type="text" name="addre" value=<%=(String)data.getAddre() %> class="inputsty" readonly></td>
			</tr>
			<tr><td>&nbsp;</td>
			<td>契约者身体状况：</td>
			<td><input type="text" name="physicalcase" value=<%=(String)data.getPhysicalcase() %> class="inputsty" readonly></td>
			<td colspan="3">&nbsp;</td></tr>
			<tr><td>&nbsp;</td>
			<td>契约者职业：</td>
			<td><input type="text" name="occupation" value=<%=(String)data.getOccupation() %> class="inputsty" readonly></td>
			<td colspan="3">&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
		</table></td></tr>
		</table>
		<table width="90%" align="center" border="1" cellpadding="2" cellspacing="1" >
		<tr><td>
		<table width="100%" align="center" border="0" class="px13">
		<tr><td colspan="5">变更种类</td></tr>
		<tr><td width="5%">&nbsp;</td>
		<td width="30%"><%="1".equals((String)data.getnameflg())? "姓名变更" : ""%></td>
		<td width="30%"><%="1".equals((String)data.getbirthflg())? "生年月日变更" : ""%></td>
		<td width="30%"><%="1".equals((String)data.getteleflg())? "电话变更" : ""%></td>
		<td width="5%">&nbsp;</td></tr>
		<tr>
		<td width="5%">&nbsp;</td>
		<td width="30%"><%="1".equals((String)data.getsexflg())? "性别变更" : ""%></td>
		<td width="30%"><%="1".equals((String)data.getwheflg())? "住址变更" : ""%></td>
		<td width="30%"><%="1".equals((String)data.getothflg())? "其他变更" : ""%></td>
		<td width="5%">&nbsp;</td>
		</table>
		</td></tr>
		</table>
		<table width="90%" align="center" border="1" cellpadding="2" cellspacing="1" >
		<tr><td>
		<table width="100%" align="center" border="0" class="px13">
		<tr><td width="5%">&nbsp;</td>
		<td width="12%">担当者：</td>
		<td width="20%"><input type="text" name="assign" class="inputsty" readonly value=<%=(String)data.getAssign() %>></td>
		<td width="60%"><input type="text" name="note1" size="65" class="inputsty" readonly value=<%=(String)data.getNote1() %>></td></tr>
		<tr><td colspan="3">&nbsp;</td>
		<td><input type="text" name="note2" size="65" class="inputsty" readonly value=<%=(String)data.getNote2() %>></td></tr>
		<tr><td colspan="3">&nbsp;</td>
		<td><input type="text" name="note3" size="65" class="inputsty" readonly value=<%=(String)data.getNote3() %>></td></tr>
		</table>
		</td></tr>
		</table>
		<table width="90%" align="center" border="0" class="px13">
		<tr><td colspan="7">&nbsp;</td></tr>
		<tr><td width="10%">&nbsp;</td>
		<td width="20%"><input type="button" name="onalter" value="修 改" onclick="onAlter(form1)" class="btn"></td>
		<td width="10%">&nbsp;</td>
		<td width="20%"><input type="button" name="onimplement" value="实 行" onclick="onImplement(form1)" class="btn"></td>
		<td width="10%">&nbsp;</td>
		<td width="20%"><input type="button" name="onclose" value="关 闭" onclick="onClose(form1)" class="btn"></td>
		<td width="10%">&nbsp;</td></tr>
		</table>
		<input type="hidden" name="reUktkno" value=<%=uktkno %>>
		<input type="hidden" name="namflg" value=<%=(String)data.getnameflg() %>>
		<input type="hidden" name="birflg" value=<%=(String)data.getbirthflg() %>>
		<input type="hidden" name="telflg" value=<%=(String)data.getteleflg() %>>
		<input type="hidden" name="sexflg" value=<%=(String)data.getsexflg() %>>
		<input type="hidden" name="wheflg" value=<%=(String)data.getwheflg() %>>
		<input type="hidden" name="othflg" value=<%=(String)data.getothflg() %>>
	</form>
</body>
</html>