<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Hashtable"%>
<jsp:useBean id="Dchange" scope="page" class="LIFE.UTIL.DChange"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="LIFECSS/DCmnStyle.css" type="text/css">
<title></title>
</head>
<% 	Vector alldata = (Vector)request.getAttribute("history");
	String uktk = (String)request.getAttribute("uktk");
	Hashtable<String,String> data = new Hashtable<String,String>(); 
	int num = 0;
%>
<body>
<table width="100%" border="1" cellpadding="1" cellspacing="2">
<tr><td>
<table width="100%" border="0" class="px13">
<tr><td width="15%" bgcolor="#CCCCCC">受付编号：</td>
<td width="35%"><%=uktk %></td>
<td width="15%">&nbsp;</td>
<td width="35%">&nbsp;</td></tr>
<%
	if (alldata != null && alldata.size() > 0) {
		for (int i = 0; i < alldata.size(); i++) {
			data = (Hashtable<String,String>)alldata.get(i);
			if (uktk.equals(data.get("UKTKNO"))) {
				num = i;
%>
<tr><td bgcolor="#CCCCCC">契约编号：</td>
<td><%=(String)data.get("KEKNO") %></td>
<td bgcolor="#CCCCCC">&nbsp;契&nbsp;&nbsp;约&nbsp;&nbsp;者：</td>
<td><%=(String)data.get("KANAMA") %></td></tr>
<tr><td bgcolor="#CCCCCC">保险种别：</td>
<td><%=Dchange.deedChange((String)data.get("SIDO")) %></td></tr>
<%				
			}
		}
		data = (Hashtable<String,String>)alldata.get(num);
	}
%>
<tr><td bgcolor="#CCCCCC">受付内容：</td>
<td><%=(String)data.get("UKCONTENT") %></td></tr>
</table>
</td></tr>
</table>
</body>
</html>