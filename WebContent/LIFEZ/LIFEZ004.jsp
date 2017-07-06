<%@page import="LIFE.Z.LIFEZ000Form"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Pragma:no-cache">
<meta http-equiv="Cache-Control:no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="LIFECSS/DCmnStyle.css" type="text/css">
<script src="LIFEUTIL/DChk.js" type="text/javascript"></script>
<script src="LIFEZ/LIFEZ004.js" type="text/javascript"></script>
<title>账号删除确认(LIFEZ004)</title>
</head>
<%
	LIFEZ000Form form = (LIFEZ000Form)request.getAttribute("userdata");
	Vector<Hashtable<String, String>> user = (Vector<Hashtable<String, String>>)form.getuser();
	String jcd = (String)form.getjjscd();
	String uid = (String)form.getuserid();
%>
<body>
	<form name="form1">
	<input type="hidden" name="actionexcute" id="actionexcute">
	<input type="hidden" name="jcd" id="jcd" value=<%=(String)request.getAttribute("jcd") %>>
	<input type="hidden" name="uid" id="uid" value=<%=(String)request.getAttribute("uid") %>>
	<table width="100%" border="1" align="center" bgcolor="blue"
			bordercolor="blue">
			<tr></tr>
			<tr>
				<td>账号删除确认</td>
			</tr>
			<tr></tr>
		</table>
		<div>&nbsp;</div>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<table width="100%" align="center" border="1" cellpadding="1"
			cellspacing="2" bordercolor="blue">
		<tr><td>
		<table width="100%" align="center" border="0">
		<tr><td><font color="red">&nbsp;&nbsp;确定删除此账号！</font><td></tr>
		<%
				for (int i = 0; i < user.size(); i++) {
					request.setAttribute("user", user.get(i));
			%>
			<tr>
				<td><jsp:include page="/LIFEZ/USER.jsp"
						flush="true" />
					<input type="hidden" name="user"
					id="user" value=<%=(String)user.get(i).get("JGYCD")+(String)user.get(i).get("USERID")%>></td>
			</tr>
			<%
				}
			%>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		</table>
		</td></tr>
		</table>
		<table width="90%" border="0" align="center" class="px13">
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td width="25%" align="center">&nbsp;</td>
				<td width="25%" align="center"><input type="button"
					name="back" id="back" value="返 回"
					onclick="onBack(form1);" class="btn"></td>
				<td width="25%" align="center"><input type="button"
					name="implement" id="implement" value="删 除"
					onclick="onImplement(form1);" class="btn"></td>
				<td width=“25%” align="center"><input type="button"
					name="close" id="close" value="关 闭" onclick="onClose();"
					class="btn"></td>
			</tr>
		</table>
	</form>
</body>
</html>