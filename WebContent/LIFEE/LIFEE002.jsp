<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="LIFE.E.LIFEE001Form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Pragma:no-cache">
<meta http-equiv="Cache-Control:no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="LIFECSS/DCmnStyle.css" type="text/css">
<script src="LIFEUTIL/DChk.js" type="text/javascript"></script>
<script src="LIFEE/LIFEE002.js" type="text/javascript"></script>
<title>履历确认(LIFEE002)</title>
</head>
<%
	LIFEE001Form form = (LIFEE001Form) request.getAttribute("nextform");
%>
<body>
<form name="form1">
		<input type="hidden" name="sid" value="LIFEE002">
		<input type="hidden" name="actionexcute" id="actionexcute" value="">
		<table width="100%" border="1" align="center" bgcolor="blue"
			bordercolor="blue">
			<tr></tr>
			<tr>
				<td>履-历-确-认</td>
			</tr>
			<tr></tr>
		</table>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<table border="1" cellpadding="1" cellspacing="2" bordercolor="blue" align="center" width="95%">
		<tr><td>
		<table border="0" width="100%" align="center" class="px13">
		<tr><td>&nbsp;</td></tr>
		<tr><td width="5%">&nbsp;</td>
		<td width="12%">*合同编号：</td>
		<td width="12%"><input type="text" name="kekno" id="kekno" readonly class="inputsty" value=<%=form.getKekno() %>></td>
		<td width="5%">&nbsp;</td>
		<td width="14%">*合作社编号：</td>
		<td width="12%"><input type="text" name="member" id="member" readonly class="inputsty" value=<%=form.getMember() %>></td>
		<td>&nbsp;</td>
		</tr>
		<tr>
		<td width="5%">&nbsp;</td>
		<td>*合作社CD:</td>
		<td><input type="text" name="copcd" id="copcd" readonly="readonly" class="inputsty" value=<%=form.getCopcd() %>></td>
		<td>&nbsp;</td>
		<td>*电话号码：</td>
		<td><input type="text" name="telephone" id="telephone" readonly="readonly" class="inputsty" value=<%=form.getTelephone() %>></td>
		<td>&nbsp;</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td>
		<td>*受付号码：</td>
		<td><input type="text" name="uktkno" id="uktkno" readonly="readonly" class="inputsty" value=<%=form.getUktkno() %>></td>
		<td>&nbsp;</td>
		</tr>
		<tr><td>&nbsp;</td>
		<td>*契约者：</td>
		<td><input type="text" name="kanama" id="kanama" readonly class="inputsty" value=<%=form.getKanama() %>></td>
		<td>&nbsp;</td>
		<td>*受付内容：</td>
		<td><input type="text" name="ukContent" id="ukContent" size="30" readonly class="inputsty" value=<%=form.getUkContent() %>></td>
		<td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td colspan="7">------担当者-----------------------------------------------------</td></tr>
		<tr><td>&nbsp;</td>
		<td>事务所CD:</td>
		<td><input type="text" name="jjscd" id="jjscd" readonly class="inputsty" value=<%=form.getJjscd() %>></td>
		<td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td>
		<td>用户名：</td>
		<td><input type="text" name="userid" id="userid" readonly class="inputsty" value=<%=form.getUserid()%>></td></tr>
		<tr><td>&nbsp;</td></tr>
		</table>
		</td></tr>
		</table>
		<table width="100%" border="0" align="center">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
			<td width="10%">&nbsp;</td>
				<td width="20%"><input
					type="button" name="alter" id="alter" onclick="onAlter(form1)"
					value="修 改" class="btn"></td>
					<td width="10%">&nbsp;</td>
					<td width="20%"><input
					type="button" name="implement" id="implement" onclick="onImplement(form1)"
					value="实 行" class="btn"></td>
					<td width="10%">&nbsp;</td>
					<td width="20%">
					<input
					type="button" name="close" id="close" onclick="onClose()"
					value="关 闭" class="btn"></td>
					<td width="10%">&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		<input type="hidden" name="tskyNum" id="tskyNum" value=<%=form.getTskyNum() %>>
		<input type="hidden" name="ikyNum" id="ikyNum" value=<%=form.getIkyNum() %>>
		<input type="hidden" name="lkyNum" id="lkyNum" value=<%=form.getLkyNum() %>>
		<input type="hidden" name="uktk" id="uktk" value=<%=form.getUktk() %>>
	</form>
</body>
</html>