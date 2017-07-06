<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Vector"%>
<%@page import="LIFE.C.LIFEC001Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="LIFE.UTIL.*"%>
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
	src="LIFEC/LIFEC001.js" charset="utf-8"></script>
<title>契约者情报变更(LIFEC001)</title>
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
		<input type="hidden" name="sid" value="LIFEC001">
		<div>&nbsp;</div>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<div class="px13">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该页面可进行契约者情报的修改变更。</div>
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
			<td width="12%">契约者姓：</td>
			<td width="30%"><input type="text" name="kamanax" value=<%=(String)data.getKamanax() %>></td>
			<td width="5%">&nbsp;</td>
			<td width="12%">契约者名：</td>
			<td width="36%"><input type="text" name="kamanam" value=<%=(String)data.getKamanam() %>></td></tr>
			<tr><td>&nbsp;</td>
			<td>生年月日：</td>
			<td><input type="text" name="birthday" value=<%=(String)data.getBirthday() %>></td>
			<td>&nbsp;</td>
			<td>契约者性别：</td>
			<td><input type="text" name="sex" value=<%=(String)data.getSex() %>></td></tr>
			<tr><td width="5%">&nbsp;</td>
			<td width="12%">契约者电话：</td>
			<td width="30%"><input type="text" name="tele" maxlength="13" value=<%=(String)data.getTele() %>></td>
			<td width="5%">&nbsp;</td>
			<td width="12%">&nbsp;</td>
			<td width="36%">&nbsp;</td></tr>
			<tr><td>&nbsp;</td>
			<td>契约者邮编：</td>
			<td><input type="text" name="zipcode" maxlength="6" value=<%=(String)data.getZipcode() %>></td>
			<td>&nbsp;</td>
			<td>契约者住址：</td>
			<td><input type="text" name="addre" value=<%=(String)data.getAddre() %>></td>
			</tr>
			<tr><td>&nbsp;</td>
			<td>契约者身体状况：</td>
			<td><input type="text" name="physicalcase" value=<%=(String)data.getPhysicalcase() %>></td>
			<td colspan="3">&nbsp;</td></tr>
			<tr><td>&nbsp;</td>
			<td>契约者职业：</td>
			<td><input type="text" name="occupation" value=<%=(String)data.getOccupation() %>></td>
			<td colspan="3">&nbsp;</td></tr>
			<tr><td>&nbsp;</td></tr>
		</table></td></tr>
		</table>
		<table width="90%" align="center" border="1" cellpadding="2" cellspacing="1" >
		<tr><td>
		<table width="100%" align="center" border="0" class="px13">
		<tr><td width="5%">&nbsp;</td>
		<td width="30%"><input type="checkbox" name="nam" id="nam" value="姓名变更" <%=data.checkName() %>>姓名变更</td>
		<td width="30%"><input type="checkbox" name="bir" id="bir" value="生年月日变更" <%=data.checkBir() %>>生年月日变更</td>
		<td width="30%"><input type="checkbox" name="telep" id="telep" value="电话变更" <%=data.checkTele() %>>电话变更</td>
		<td width="5%">&nbsp;</td></tr>
		<tr>
		<td width="5%">&nbsp;</td>
		<td width="30%"><input type="checkbox" name="se" id="se" value="性别变更" <%=data.checkSex() %>>性别变更</td>
		<td width="30%"><input type="checkbox" name="whe" id="whe" value="住址变更" <%=data.checkWhe() %>>住址变更</td>
		<td width="30%"><input type="checkbox" name="oth" id="oth" value="其他变更" <%=data.checkOth() %>>其他变更</td>
		<td width="5%">&nbsp;</td>
		</table>
		</td></tr>
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
		<td width="20%"><input type="button" name="onclose" value="关 闭" onclick="onClose(form1)" class="btn"></td>
		<td width="10%">&nbsp;</td></tr>
		</table>
		<input type="hidden" name="reUktkno" value=<%=uktkno %>>
	</form>
</body>
</html>