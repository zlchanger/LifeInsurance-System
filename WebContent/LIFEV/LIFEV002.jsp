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
<script src="LIFEV/LIFEV002.js" type="text/javascript"></script>
<title>业务`一览(LIFEV002)</title>
</head>
<%
	String jjscd = (String)session.getAttribute("jjscd");
	String userid = (String)session.getAttribute("userid");
	String power = (String)request.getAttribute("power");
%>
<body>
	<form name="form1">
		<input type="hidden" name="sid" value="LIFEV002">
		<table width="100%" border="1" align="center" bgcolor="blue"
			bordercolor="blue">
			<tr></tr>
			<tr>
				<td>业务概况一览</td>
			</tr>
			<tr></tr>
		</table>
		<div>&nbsp;</div>
		<span>欢迎事务所CD为<font color="blue"><%=jjscd %></font>,账号ID为<font color="blue"><%=userid %></font>进入生命保险系统！</span>
		<table width="100%" border="1" align="center" bordercolor="blue">
			<tr>
				<td width=33%>
					<table width="100%" border="0" align="center">
						<tr><td align="center" class="span">业务处理</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><A href="#"
								onclick="gonext(form1,'LIFEA001');return false;">咨询~受理</A></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><A href="#"
								onclick="goalter(form1,'LIFEA004','1');return false;">契约~修正</A></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><A href="#"
								onclick="goalter(form1,'LIFEA004','2');return false;">返送~受付</A></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><A href="#"
								onclick="goalter(form1,'LIFEA004','3');return false;">受付~取消</A></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
					</table>
				</td>
				<td width="33%">
					<table width="100%" border="0" align="center">
						<tr><td align="center" class="span">个人账号管理</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><A href="#"
								onclick="gomodify(form1,'LIFEA006');return false;">账号信息修改</A></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><A href="#"
								onclick="gosearch(form1,'LIFEA009');return false;">事务所信息查看</A></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
					</table>
				</td>
				<td width="34%">
					<table width="100%" border="0" align="center">
						<tr><td align="center" class="span">管理员一栏</td></tr>
						<%if ("1".equals(power)) { %>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><A href="#"
								onclick="gomanage(form1,'LIFEZ001');return false;">账号管理</A></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><A href="#"
								onclick="gomanage(form1,'LIFEZ005');return false;">新建账号</A></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><A href="#"
								onclick="gomanage(form1,'LIFEJ001');return false;">新增事务所信息</A></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><A href="#"
								onclick="gomanage(form1,'LIFEJ002');return false;">事务所管理</A></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<%} else {%>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td align="center"><strong><font color="red" style="font-size: 20px">权限不足！</font></strong></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>&nbsp;</td></tr>
						<%} %>
					</table>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="2" cellspacing="2">
		<tr><td>&nbsp;<input type="button" name="back" id="back" class="btn" value="注 销" onclick="onBack(form1)"></td></tr>
		</table>
	</form>
</body>
</html>