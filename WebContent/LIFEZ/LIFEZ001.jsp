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
<script src="LIFEZ/LIFEZ001.js" type="text/javascript"></script>
<title>账号管理(LIFEZ001)</title>
</head>
<body>
	<form name="form1">
		<input type="hidden" name="sid" value="LIFEZ001">
		<table width="100%" border="1" align="center" bgcolor="blue"
			bordercolor="blue">
			<tr></tr>
			<tr>
				<td>各事务所账号管理</td>
			</tr>
			<tr></tr>
		</table>
		<div>&nbsp;</div>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<table width="100%" border="1" cellpadding="1" cellspacing="2" bordercolor="blue" align="center">
		<tr><td>
		<table width="100%" border="0" align="center">
		<tr><td>&nbsp;</td></tr>
		<tr><td colspan="3">&nbsp;&nbsp;&nbsp;检索条件</td></tr>
		<tr><td  width="5%">&nbsp;</td>
		<td width="14%">*事务所CD:</td>
		<td width="15%"><input type="text" name="jjscd" id="jjscd" maxlength="3" style="ime-mode:disabled" 
						value=<%=(String) request.getAttribute("Jjscd") == null ? "" : (String) request.getAttribute("Jjscd")%>></td>
		<td><font color="blue">(请输入3位数字，例：001)</font></td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td width="5%">&nbsp;</td>
		<td>*用户ID:</td>
		<td><input type="text" name="userid" id="userid" maxlength="30" style="ime-mode:disabled"
						value=<%=(String) request.getAttribute("Userid") == null ? "" : (String) request.getAttribute("Userid")%>></td>
		<td><font color="blue">(请输入所要查找的用户ID，例：001testusr)</font></td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		</table>
		</td></tr>
		</table>
		<table width="100%" align="center" border="0">
		<tr><td>&nbsp;</td></tr>
		<tr><td width="30%">&nbsp;</td>
		<td width="30%" align="center"><input type="button" name="implement" id="implement" class="btn" value="实 行" onclick="onImplement(form1)"></td>
		<td width="30%" align="center"><input type="button" name="close" id="close" class="btn" value="关 闭" onclick="onClose()"></td>
		<td width="10%">&nbsp;</td></tr>
		</table>
	</form>
</body>
</html>