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
<script src="LIFEZ/LIFEZ005.js" type="text/javascript"></script>
<title>创建账户(LIFEZ005)</title>
</head>
<body>
	<form name="form1">
		<table width="100%" border="1" align="center" bgcolor="blue"
			bordercolor="blue">
			<tr></tr>
			<tr>
				<td>账号创建</td>
			</tr>
			<tr></tr>
		</table>
		<div>&nbsp;</div>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<table width="100%" align="center" border="1" cellpadding="1" cellspacing="2" bordercolor="blue">
		<tr><td>
		<table width="100%" align="center" border="0">
		<tr><td>&nbsp;</td></tr>
		<tr><td width="5%">&nbsp;</td>
		<td width="20%">*事务所CD:</td>
		<td width="30%"><input type="text" maxlength="3" name="jjscd" id="jjscd" style="ime-mode:disabled"
						value=<%=(String)request.getAttribute("jjscd") == null ? "" : (String)request.getAttribute("jjscd")%>></td>
		<td><font color="blue">(请输入三位事务所CD,例：001)</font></td></tr>
		<tr><td width="5%">&nbsp;</td>
		<td width="20%">*用户名ID:</td>
		<td><input type="text" maxlength="30" name="userid" id="userid" style="ime-mode:disabled"
						value=<%=(String)request.getAttribute("userid") == null ? "" : (String)request.getAttribute("userid")%>></td>
		</tr>
		<% String power = (String)request.getAttribute("pow");
		if ("1".equals(power)) {
		%>
		<tr><td width="5%">&nbsp;</td>
		<td width="20%">*账号权限:</td>
		<td><input type="radio" name="pow"
					id="pow" value="0">普通账号</td>
		<td><input type="radio" name="pow" id="pow" value="1" checked="checked">管理员账号</td></tr>
		<%} else { %>
		<tr><td width="5%">&nbsp;</td>
		<td width="20%">*账号权限:</td>
		<td><input type="radio" name="pow"
					id="pow" value="0" checked="checked">普通账号</td>
		<td><input type="radio" name="pow" id="pow" value="1">管理员账号</td></tr>
		<%} %>
		<tr><td width="5%">&nbsp;</td>
		<td width="20%">*密&nbsp;码:</td>
		<td><font color="blue">初始密码默认为：passwd</font></td></tr>
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
				<td width="25%" align="center">&nbsp;</td>
				<td width="25%" align="center"><input type="button"
					name="implement" id="implement" value="创 建"
					onclick="onImplement(form1);" class="btn"></td>
				<td width=“25%” align="center"><input type="button"
					name="close" id="close" value="关 闭" onclick="onClose();"
					class="btn"></td>
			</tr>
		</table>
	</form>
</body>
</html>