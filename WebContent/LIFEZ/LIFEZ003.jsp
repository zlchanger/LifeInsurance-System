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
<script src="LIFEZ/LIFEZ003.js" type="text/javascript"></script>
<title>账号信息修改(LIFEZ003)</title>
</head>
<%
	LIFEZ000Form user = (LIFEZ000Form)request.getAttribute("userdata");
	Vector<Hashtable<String, String>> alterUser = user.getuser();
	String power = (String)alterUser.get(0).get("POWER");
%>
<body>
	<form name="form1">
	<input type="hidden" name="jcd" id="jcd" value=<%=(String)request.getAttribute("jcd") %>>
	<input type="hidden" name="uid" id="uid" value=<%=(String)request.getAttribute("uid") %>>
	<input type="hidden" name="oldjcd" id="oldjcd" value=<%=(String)alterUser.get(0).get("JGYCD") %>>
	<input type="hidden" name="olduid" id="olduid" value=<%=(String)alterUser.get(0).get("USERID") %>>
	<input type="hidden" name="actionexcute" id="actionexcute">
	<table width="100%" border="1" align="center" bgcolor="blue"
			bordercolor="blue">
			<tr></tr>
			<tr>
				<td>账号信息</td>
			</tr>
			<tr></tr>
		</table>
		<div>&nbsp;</div>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<table width="100%" border="1" cellpadding="1" cellspacing="2" align="center">
		<tr><td>
		<table width="100%" border="0" align="center">
		<tr><td>&nbsp;</td></tr>
		<tr><td width="20%">*事务所CD:</td>
		<td width="30%"><input type="text" name="jjscd" id="jjscd" maxlength="3" style="ime-mode:disabled" value=<%=(String)alterUser.get(0).get("JGYCD") %>></td></tr>
		<tr><td width="20%">*用户ID:</td>
		<td width="30%"><input type="text" name="userid" id="userid" maxlength="30" style="ime-mode:disabled" value=<%=(String)alterUser.get(0).get("USERID") %>></td></tr>
		<%if ("1".equals(power)) {
			%>
		<tr><td width="20%">*权限：</td>
		<td width="30%"><input type="radio" name="pow"
					id="pow" value="0">普通账号</td>
		<td width="30%"><input type="radio" name="pow" id="pow" value="1" checked="checked">管理员账号</td></tr>
		<%}else { %>
		<tr><td width="20%">*权限：</td>
		<td width="30%"><input type="radio" name="pow"
					id="pow" value="0" checked="checked">普通账号</td>
		<td width="30%"><input type="radio" name="pow" id="pow" value="1">管理员账号</td></tr>
		<%} %>
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
					name="implement" id="implement" value="确 认"
					onclick="onImplement(form1);" class="btn"></td>
				<td width=“25%” align="center"><input type="button"
					name="close" id="close" value="关 闭" onclick="onClose();"
					class="btn"></td>
			</tr>
		</table>
	</form>
</body>
</html>