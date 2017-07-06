<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Vector"%>
<%@page import="LIFE.D.LIFED001Form"%>
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
	src="LIFED/LIFED003.js" charset="utf-8"></script>
<title>被共济者情报返送录入(LIFEC003)</title>
</head>
<%
	LIFED001Form data = (LIFED001Form)request.getAttribute("nextform");
	Vector<Hashtable<String, String>> tsky = (Vector<Hashtable<String, String>>) data.gettsky();
	Vector<Hashtable<String, String>> iky = (Vector<Hashtable<String, String>>) data.getiky();
	Vector<Hashtable<String, String>> lky = (Vector<Hashtable<String, String>>) data.getlky();
	String uktkno = (String)request.getAttribute("reUktkno");
%>
<body>
	<form name="form1">
		<input type="hidden" name="sid" value="LIFED003">
		<div>&nbsp;</div>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<div class="px13">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该页面可进行被共济者情报的修改变更。</div>
		<table width="90%" border="0" class="px13" align="center">
			<%
				if (tsky != null && tsky.size() > 0) {
			%>
			<tr>
				<td bgcolor="#8968CD" align="left" colspan="2">终生生命</td>
			</tr>
			<%
				for (int i = 0; i < tsky.size(); i++) {
						Hashtable<String, String> tskydata = tsky.get(i);
						request.setAttribute("tdata", tskydata);
			%>
			<tr>
				<td width="5%" valign="top"><input type="checkbox" name="tsky"
					id="tsky" value=<%=(String) tskydata.get("KEKNO")%> checked="checked"></td>
				<td><jsp:include page="/LIFEUTIL/DComTsky.jsp" flush="true" /></td>
			</tr>
			<%
				}
				}
			%>
			<%
				if (iky != null && iky.size() > 0) {
			%>
			<tr>
				<td bgcolor="#BBFFFF" align="left" colspan="2">终生医疗</td>
			</tr>
			<%
				for (int i = 0; i < iky.size(); i++) {
						Hashtable<String, String> ikydata = iky.get(i);
						request.setAttribute("idata", ikydata);
			%>
			<tr>
				<td width="5%" valign="top"><input type="checkbox" name="iky" id="iky" value=<%=(String)ikydata.get("KEKNO") %> checked="checked"></td>
				<td><jsp:include page="/LIFEUTIL/DComIky.jsp" flush="true" /></td>
			</tr>
			<%
				}
				}
			%>
			<%
				if (lky != null && lky.size() > 0) {
			%>
			<tr>
				<td bgcolor="#CDCD00" align="left" colspan="2">火灾</td>
			</tr>
			<%
				for (int i = 0; i < lky.size(); i++) {
						Hashtable<String, String> lkydata = lky.get(i);
						request.setAttribute("ldata", lkydata);
			%>
			<tr>
				<td width="5%" valign="top"><input type="checkbox" name="lky" id="lky" value=<%=(String)lkydata.get("KEKNO") %> checked="checked"></td>
				<td><jsp:include page="/LIFEUTIL/DComLky.jsp" flush="true" /></td>
			</tr>
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
			<td width="14%">被共济者姓：</td>
			<td width="30%"><input type="text" name="kamannx" <%=data.disableName() %> value=<%=(String)data.getKamannx() %>></td>
			<td width="5%">&nbsp;</td>
			<td width="14%">被共济者名：</td>
			<td width="32%"><input type="text" name="kamannm" <%=data.disableName() %> value=<%=(String)data.getKamannm() %>></td></tr>
			<tr><td>&nbsp;</td>
			<td>生年月日：</td>
			<td><input type="text" name="kbirthday" <%=data.disableBir() %> value=<%=(String)data.getKbirthday() %>></td>
			<td>&nbsp;</td>
			<td>被共济者性别：</td>
			<td><input type="text" name="ksex" <%=data.disableSex() %> value=<%=(String)data.getKsex() %>></td></tr>
			<tr><td width="5%">&nbsp;</td>
			<td width="12%">被共济者电话：</td>
			<td width="30%"><input type="text" name="ktele" maxlength="13" <%=data.disableTele() %> value=<%=(String)data.getKtele() %>></td>
			<td width="5%">&nbsp;</td>
			<td width="12%">&nbsp;</td>
			<td width="36%">&nbsp;</td></tr>
			<tr><td>&nbsp;</td>
			<td>被共济者邮编：</td>
			<td><input type="text" name="kzipcode" maxlength="6" <%=data.disableWhe() %> value=<%=(String)data.getKzipcode() %>></td>
			<td>&nbsp;</td>
			<td>被共济者住址：</td>
			<td><input type="text" name="kaddre" <%=data.disableWhe() %> value=<%=(String)data.getKaddre() %>></td>
			</tr>
			<tr><td>&nbsp;</td>
			<td>被共济者身体状况：</td>
			<td><input type="text" name="kphysical" <%=data.disableOth() %> value=<%=(String)data.getKphysical() %>></td>
			<td colspan="3">&nbsp;</td></tr>
			<tr><td>&nbsp;</td>
			<td>被共济者职业：</td>
			<td><input type="text" name="koccupation" <%=data.disableOth() %> value=<%=(String)data.getKoccupation() %>></td>
			<td colspan="3">&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
		</table></td></tr>
		</table>
		<table width="90%" align="center" border="1" cellpadding="2" cellspacing="1" >
		<tr><td>
		<table width="100%" align="center" border="0" class="px13">
		<tr><td width="5%">&nbsp;</td>
		<td width="12%">担当者：</td>
		<td width="20%"><input type="text" name="assign" value=<%=(String)data.getAssign() %>></td>
		<td width="60%"><input type="text" name="note1" size="65" value=<%=(String)data.getNote1() %>></td></tr>
		<tr><td colspan="3">&nbsp;</td>
		<td><input type="text" name="note2" size="65" value=<%=(String)data.getNote2() %>></td></tr>
		<tr><td colspan="3">&nbsp;</td>
		<td><input type="text" name="note3" size="65" value=<%=(String)data.getNote3() %>></td></tr>
		</table>
		</td></tr>
		</table>
		<table width="90%" align="center" border="0" class="px13">
		<tr><td colspan="7">&nbsp;</td></tr>
		<tr><td width="10%">&nbsp;</td>
		<td width="20%"><input type="button" name="onsearch" value="检 索" onclick="onSearch(form1)" class="btn"></td>
		<td width="10%">&nbsp;</td>
		<td width="20%"><input type="button" name="onimplement" value="实 行" onclick="onImplement(form1)" class="btn"></td>
		<td width="10%">&nbsp;</td>
		<td width="20%"><input type="button" name="onclose" value="关 闭" onclick="onClose()" class="btn"></td>
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