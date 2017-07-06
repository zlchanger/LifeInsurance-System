<%@page import="java.util.ArrayList"%>
<%@page import="LIFE.A.LIFEA004Form"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Hashtable"%>
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
	src="LIFEA/LIFEA005.js" charset="utf-8"></script>
<title>受付一览(LIFEA005)</title>
</head>
<%
	LIFEA004Form allData = (LIFEA004Form) request.getAttribute("nextform");
	Vector<Hashtable<String, String>> ukTil = allData.getUkdata();
	ArrayList<String> uktknos = new ArrayList<String>();
	for (int i = 0; i < ukTil.size(); i++) {
		Hashtable<String, String> tildata = ukTil.get(i);
		if (!uktknos.contains((String)tildata.get("UKTKNO"))) {
			uktknos.add((String)tildata.get("UKTKNO"));
		}
	}
	String domessage = (String)request.getAttribute("domessage");
%>
<body>
	<form name="form1">
		<div>&nbsp;</div>
		<input type="hidden" name="domessage" value=<%=domessage %>>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;受付情报结果选择</div>
		<table width="90%" align="center" border="0" cellpadding="0"
			cellspacing="0" class="px13">
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<%
				for (int i = 0; i < uktknos.size(); i++) {
					request.setAttribute("history", ukTil);
					request.setAttribute("uktk", uktknos.get(i));
			%>
			<tr>
				<td width="5%" valign="top"><input type="checkbox" name="uktil"
					id="uktil" value=<%=(String) uktknos.get(i)%>></td>
				<td><jsp:include page="/LIFEUTIL/DComUkTilInfo.jsp"
						flush="true" /></td>
			</tr>
			<%
				}
			%>
		</table>
		<table width="90%" border="0" align="center" class="px13">
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td width="25%" align="center">&nbsp;</td>
				<td width="25%" align="center">&nbsp;</td>
				<td width="25%" align="center"><input type="button"
					name="implement" id="implement" value="实 行"
					onclick="onImplement(form1);" class="btn"></td>
				<td width=“25%” align="center"><input type="button"
					name="close" id="close" value="关 闭" onclick="onClose();"
					class="btn"></td>
			</tr>
		</table>
	</form>
</body>
</html>