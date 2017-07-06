<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Hashtable"%>
<jsp:useBean id="Dchange" scope="page" class="LIFE.UTIL.DChange"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="LIFECSS/DCmnStyle.css" type="text/css">
<title>Insert title here</title>
</head>
<%Hashtable<String,String> user = (Hashtable<String,String>)request.getAttribute("user"); %>
<body>
	<table width="100%" align="left" border="1" cellpadding="1" cellspacing="2" bordercolor="blue">
	<tr><td>
	<table width="100%" align="center" border="0" class="px13">
	<tr><td width="20%" bgcolor="#CCCCCC">事务所CD:</td>
	<td width="30"><%=(String)user.get("JGYCD") %></td>
	<td width="20%" bgcolor="#CCCCCC">用户ID:</td>
	<td width="30%"><%=(String)user.get("USERID") %></td></tr>
	<tr><td width="20%" bgcolor="#CCCCCC">是否登陆状态：</td>
	<td><%=Dchange.login((String)user.get("ISLOGIN")) %></td></tr>
	<tr><td bgcolor="#CCCCCC">账号权限：</td>
	<td><%=Dchange.power((String)user.get("POWER")) %></td></tr>
	<tr><td bgcolor="#CCCCCC">注册时间：</td>
	<td><%=(String)user.get("DATETIME") %></td>
	<td bgcolor="#CCCCCC">最近登陆时间：</td>
	<td><%=(String)user.get("LOGINDATE") %></td></tr>
	</table>
	</td></tr>
	</table>
</body>
</html>