<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Pragma:no-cache">
<meta http-equiv="Cache-Control:no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="LIFECSS/DCmnStyle.css" type="text/css">
<script type="text/javascript" language="javascript" src="LIFEUTIL/DChk.js" charset="utf-8"></script>
<script type="text/javascript" language="javascript" src="LIFEV/LIFEV001.js" charset="utf-8"></script>
<title>生命 保险系统</title>
</head>
<body bgcolor="#ffffff" text="#000000"
	onload="document.form1.jgyCd.focus();">
	<form name="form1">
		<input type="hidden" name="sid" value="LIFEV001">
		<table width="100%" border="1" align="center" bgcolor="blue"
			bordercolor="blue">
			<tr></tr>
			<tr>
				<td>生命保险系统登录</td>
			</tr>
			<tr></tr>
		</table>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<table width="95%" border="0" align="center">
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td width="20%">事务所CD</td>
				<td><input type="text" id="jgyCd" name="Jgycd" maxlength="3" size="6"
					autocomplete="off" style="ime-mode: disabled"
					value=<%=(String) request.getAttribute("Jgycd") == null ? "" : (String) request.getAttribute("Jgycd")%>></td>
			</tr>
			<tr>
				<td width="20%">用户ID</td>
				<td><input type="text" id="userId" name="Userid" maxlength="32" size="35"
					autocomplete="off" style="ime-mode: disabled"
					value=<%=(String) request.getAttribute("Userid") == null ? "" : (String) request.getAttribute("Userid")%>></td>
			</tr>
			<tr>
				<td width="20%">密码</td>
				<td><input type="password" id="password" name="Password" maxlength="16" size="36"
					autocomplete="off" style="ime-mode: disabled"
					value=<%=(String) request.getAttribute("Password") == null ? "" : (String) request.getAttribute("Password")%>></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><input type="button" name="confirm" value="确   认" onclick="goNext(form1)"></td>
			</tr>
		</table>
	</form>
</body>
</html>