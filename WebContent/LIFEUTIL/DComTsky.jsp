<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="Dchange" scope="page" class="LIFE.UTIL.DChange"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="LIFECSS/DCmnStyle.css" type="text/css">
<title></title>
</head>
<%Hashtable<String,String> tdata = (Hashtable<String,String>)request.getAttribute("tdata"); %>
<body>
	<table width="100%" border="1" cellpadding="1" cellspacing="2">
		<tr>
			<td width="50%" align="center">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="px13">
					<tr>
						<td width="20%">契约者姓：</td>
						<td width="80%" colspan="2"><%=Dchange.nullCheck((String)tdata.get("KAMANAX")) %></td>
					</tr>
					<tr>
						<td width="20%">契约者名：</td>
						<td width="80%" colspan="2"><%=Dchange.nullCheck((String)tdata.get("KAMANAM")) %></td>
					</tr>
					<tr><td width="20%">生年月日：</td>
					<td width="60%" align="left"><%=Dchange.toYYMMDD((String)tdata.get("BIRTHDAY")) %></td>
					<td width="20%" align="left"><%=Dchange.sexShow((String)tdata.get("SEX")) %></td></tr>
				</table>
			</td>
			<td width="50%" align="center">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="px13">
					<tr>
						<td width="25%">被共济者姓：</td>
						<td width="75%" colspan="2"><%=Dchange.nullCheck((String)tdata.get("KAMANNX")) %></td>
					</tr>
					<tr>
						<td width="25%">被共济者名：</td>
						<td width="75%" colspan="2"><%=Dchange.nullCheck((String)tdata.get("KAMANNM")) %></td>
					</tr>
					<tr><td width="25%">生年月日：</td>
					<td width="55%" align="left"><%=Dchange.toYYMMDD((String)tdata.get("KBIRTHDAY")) %></td>
					<td width="20%" align="left"><%=Dchange.sexShow((String)tdata.get("KSEX")) %></td></tr>
				</table>
			</td>
		</tr>
		<tr>
		<td width="100%" colspan="2">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="px13">
		<tr><td width="12%">合作社CD：</td>
		<td width="12%" align="left"><%=Dchange.nullCheck((String)tdata.get("COPCD")) %></td>
		<td width="10%"><%=Dchange.changeShow((String)tdata.get("ISCHANGE")) %></td>
		<td width="14%">合作社会员号：</td>
		<td width="12%"><%=Dchange.nullCheck((String)tdata.get("COPMEMBER")) %></td>
		<td width="16%">合作社电话号码：</td>
		<td width="14%"><%=Dchange.teleChange((String)tdata.get("TELEPHONE")) %></td>
		<td width="10%">&nbsp;</td></tr>
		<tr><td width="10%">契约申请日：</td>
		<td width="10%"><%=Dchange.toYYMMDD((String)tdata.get("APPLYYMD")) %></td>
		<td width="12%">加入型表示：</td>
		<td width="8%"><%=(String)tdata.get("GOODSDIS") %><%=(String)tdata.get("GOODSFORE") %></td>
		<td width="10%">契约生效日：</td>
		<td width="10%"><%=Dchange.toYYMMDD((String)tdata.get("EFFECTYMD")) %></td>
		<td width="10%">事故发生日：</td>
		<td width="10%"><%=Dchange.toYYMMDD((String)tdata.get("HAPPENYMD")) %></td></tr>
		</table>
		</td>
		</tr>
		<tr>
		<td width="100%" colspan="2">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="px13">
		<tr><td width="12%">解约指定日：</td>
		<td width="12%" align="left"><%=Dchange.toYYMMDD((String)tdata.get("ESCAPEDATE")) %></td>
		<td width="10%">&nbsp;</td>
		<td width="12%">付金方式：</td>
		<td width="2%"><%=Dchange.modeChange((String)tdata.get("MODECASE")) %></td>
		<td width="2%">付</td>
		<td width="7%">&nbsp;</td>
		<td width="14%">予定需付金额：</td>
		<td width="8%"><%=(String)tdata.get("MENEY") %></td>
		<td width="21">&nbsp;</td>
		<td>&nbsp;</td></tr>
		<tr><td width="16%">予约解约指定日：</td>
		<td width="10%"><%=Dchange.toYYMMDD((String)tdata.get("ESCAPEYMD")) %></td>
		<td width="74%" colspan="8">&nbsp;</td>

		</table>
		</td>
		</tr>
	</table>
</body>
</html>