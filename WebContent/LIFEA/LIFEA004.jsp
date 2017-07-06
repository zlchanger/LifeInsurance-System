<%@page import="LIFE.UTIL.DConstants"%>
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
	src="LIFEA/LIFEA004.js" charset="utf-8"></script>
<title>受付检索(LIFEA004)</title>
</head>
<body>
	<form name="form1">
		<table width="90%" border="1" align="center" bgcolor="blue"
			bordercolor="blue" >
			<tr></tr>
			<tr>
				<td>受付检索</td>
			</tr>
			<tr></tr>
		</table>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<table width="90%" border="1" align="center" cellpadding="1" cellspacing="2">
		<tr><td><table width="100%" border="0" align="left" class="px13">
		<tr><td>&nbsp;</td></tr>
			<tr>
				<td width="10%">&nbsp;</td>
				<%String flg = Dchange.nullCheck((String)request.getAttribute("chooseflg"));
				  if("修改".equals(flg)) {%>
				<td width="20%"><input type="radio" name="keknoAlter"
					id="keknoAlter" value="契约修改" checked="checked"><%=DConstants.keknoAlter%></td>
				<td width="10%">&nbsp;</td>
				<td width="20%"><input type="radio" name="keknoAlter"
					id="keknoAlter" value="返送受付"><%=DConstants.keknoAgian%></td>
				<td width="10%">&nbsp;</td>
				<td width="20%"><input type="radio" name="keknoAlter"
					id="keknoAlter" value="受付取消"><%=DConstants.keknoDele%></td>
				<%} else if ("返送".equals(flg)) {%>
				<td width="20%"><input type="radio" name="keknoAlter"
					id="keknoAlter" value="契约修改"><%=DConstants.keknoAlter%></td>
				<td width="10%">&nbsp;</td>
				<td width="20%"><input type="radio" name="keknoAlter"
					id="keknoAlter" value="返送受付" checked="checked"><%=DConstants.keknoAgian%></td>
				<td width="10%">&nbsp;</td>
				<td width="20%"><input type="radio" name="keknoAlter"
					id="keknoAlter" value="受付取消"><%=DConstants.keknoDele%></td>
				<%} else if ("取消".equals(flg)) {%>
				<td width="20%"><input type="radio" name="keknoAlter"
					id="keknoAlter" value="契约修改"><%=DConstants.keknoAlter%></td>
				<td width="10%">&nbsp;</td>
				<td width="20%"><input type="radio" name="keknoAlter"
					id="keknoAlter" value="返送受付"><%=DConstants.keknoAgian%></td>
				<td width="10%">&nbsp;</td>
				<td width="20%"><input type="radio" name="keknoAlter"
					id="keknoAlter" value="受付取消" checked="checked"><%=DConstants.keknoDele%></td>
				<%} %>
				<td width="10%">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="7">&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>受付No.:</td>
				<td colspan="5"><input type="text" name="uktkno" id="uktkno" maxlength="12"
					value=<%=(String) request.getAttribute("uktkno") == null ? "" : (String) request.getAttribute("uktkno")%>></td>
			</tr>
			<tr>
				<td colspan="7">&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>契约编号：</td>
				<td colspan="5"><input type="text" name="kekno" id="kekno" maxlength="8"
					value=<%=(String) request.getAttribute("kekno") == null ? "" : (String) request.getAttribute("kekno")%>></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table></td></tr>
		</table>
		<table width="90%" border="0" align="center" class="px13">
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td width="10%">&nbsp;</td>
				<td width="20%" align="center"><input type="button" name="implememt"
					id="implememt" class="btn" onclick="onImplememt(form1);"
					value="实 行"></td>
				<td width="10%">&nbsp;</td>
				<td width="20%" align="center"><input type="button" name="close" id="close"
					class="btn" onclick="onclose();" value="关 闭"></td>
				<td width="10%">&nbsp;</td>
				<td width="20%">&nbsp;</td>
				<td width="10%"></td>
			</tr>
		</table>
	</form>
</body>
</html>