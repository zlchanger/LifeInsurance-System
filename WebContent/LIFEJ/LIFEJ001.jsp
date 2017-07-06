<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Pragma:no-cache">
<meta http-equiv="Cache-Control:no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="LIFEUTIL/DChk.js" type="text/javascript"></script>
<script src="LIFEJ/LIFEJ001.js" type="text/javascript"></script>
<title>新增事务所(LIFEJ001)</title>
</head>
<body>
	<form name="form1">
		<input type="hidden" name="sid" value="LIFEJ001">
		<table width="100%" border="1" align="center" bgcolor="blue"
			bordercolor="blue">
			<tr></tr>
			<tr>
				<td>新建事务所信息</td>
			</tr>
			<tr></tr>
		</table>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<table width="100%" border="1" bordercolor="blue" cellpadding="1" cellspacing="2">
		<tr><td>
		<table width="100%" border="0">
		<tr><td>&nbsp;</td></tr>
		<tr><td width="5%">&nbsp;</td>
		<td width="20%">事务所CD：</td>
		<td width="15%"><input type="text" name="jgycd" id="jjycd" maxlength="3" style="ime-mode: disabled"></td>
		<td width="62%">&nbsp;</td></tr>
		<tr><td>&nbsp;</td>
		<td>事务所名：</td>
		<td><input type="text" name="jgyname" id="jgyname" maxlength="30" size="30"></td></tr>
		<tr><td>&nbsp;</td>
		<td></td></tr>
		</table>
		</td></tr>
		</table>
	</form>
</body>
</html>