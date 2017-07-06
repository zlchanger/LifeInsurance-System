<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="LIFE.A.*"%>
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
	src="LIFEA/LIFEA002.js" charset="utf-8"></script>
<title>基本情报一览(LIFEA002)</title>
</head>
<%
	LIFEA002Form nextform = (LIFEA002Form) request.getAttribute("formdata");
	session.setAttribute("tdata", nextform.getWheret());
	session.setAttribute("idata", nextform.getWherei());
	session.setAttribute("ldata", nextform.getWherel());
	Vector<Hashtable<String,String>> his = (Vector<Hashtable<String,String>>)nextform.getHistory();
%>
<body>
	<form name="form1" target="_top">
		<input type="hidden" name="sid" value="LIFEA002">
		<table width="100%" border="1" align="center" bgcolor="blue"
			bordercolor="blue">
			<tr></tr>
			<tr>
				<td>基本情报一览</td>
			</tr>
			<tr></tr>
		</table>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<div>&nbsp;</div>
		<table width="95%" border="0" cellpadding="0" cellspacing="0" align="center" class="px13" style="border:1px solid #000000;">
			<tr>
				<td colspan="10">契约情报栏</td>
			</tr>
			<tr>
				<td width="1%"></td>
				<td width="40%" colspan="4">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						bgcolor="#36C0DA" align="center" style="border: 1px solid #000000;">
						<tr>
							<td width="20%" colspan="2" align="center">合同编号：</td>
							<td width="20%" colspan="2" align="left"><%=(String) nextform.getKekno()%></td>
						</tr>
						<tr>
							<td width="20%" colspan="2" align="center">合作社会员号：</td>
							<td width="20%" colspan="2" align="left"><%=(String) nextform.getMember()%></td>
						</tr>
						<tr>
							<td width="20%" colspan="2" align="center">合作社CD：</td>
							<td width="20%" colspan="2" align="left"><%=(String) nextform.getCopcd()%></td>
						</tr>
						<tr>
							<td width="20%" colspan="2" align="center">电话号码：</td>
							<td width="20%" colspan="2" align="left"><%=(String) nextform.getTelephone()%></td>
						</tr>
					</table>
				</td>
				<td width="1%">&nbsp;</td>
				<td width="57%">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#36C0DA" align="center" style="border: 1px solid #000000;">
				<tr><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td></tr></table>
				</td>
				<td width="1%">&nbsp;</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
		</table>
		<table width="95%" border="0" cellpadding="0" cellspacing="0"
			align="center" class="px13">
			<tr><td width="60%">契约件数栏</td></tr>
			<tr>
				<td width="60%" rowspan="2">
					<table width="100%" border="1" cellpadding="0" cellspacing="0"
						align="center" bordercolor="blue">
						<tr>
							<td width="25%">&nbsp;</td>
							<td width="25%" align="center">终生生命</td>
							<td width="25%" align="center">终生医疗</td>
							<td width="25%" align="center">火灾</td>
						</tr>
						<tr>
							<td align="center">契约数目</td>
							<td align="center"><%=Dchange.nullCheck((String) nextform.getTskyNum()) == "" ? "-" : (String) nextform.getTskyNum()%></td>
							<td align="center"><%=Dchange.nullCheck((String) nextform.getIkyNum()) == "" ? "-" : (String) nextform.getIkyNum()%></td>
							<td align="center"><%=Dchange.nullCheck((String) nextform.getLkyNum()) == "" ? "-" : (String) nextform.getLkyNum()%></td>
						</tr>
					</table>
				</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
			<td width="5%">&nbsp;</td>
				<td class="btn"><input type="button" value="契约一览"
					onclick="onAgree(form1);"></td>
			</tr>
		</table>
		<table width="95%" border="0" align="center">
		<tr><td width="7%">&nbsp;</td>
		<td width="20%" class="btn"><input type="button" value="检索" onclick="onSearch(form1);"></td>
		<td width="20%" class="btn"><input type="button" value="修正履历" onclick="onAdtler(form1);"></td>
		<td width="23%" class="btn"><input type="button" value="关闭" onclick="onClo(form1);"></td>
		<td width="30%">&nbsp;</td></tr>
		<tr><td colspan="2"><div class="px13">契约履历表</div></td></tr>
		</table>
		<table width="95%" border="1" cellpadding="0" cellspacing="0" align="center" class="px13">
		<tr><td width="5%" align="center">修改</td>
		<td width="15%" align="center">年月日</td>
		<td width="10%" align="center">时刻</td>
		<td width="15%" align="center">受付No.</td>
		<td width="5%" align="center">商品</td>
		<td width="10%" align="center">契约号码</td>
		<td width="15%" align="center">受付内容</td>
		<td width="8%" align="center">申入者</td>
		<td width="9%" align="center">受付事务所</td>
		<td width="8%" align="center">受付担当者</td></tr>
        <% for (int i = 0; i < his.size(); i++) {
        	Hashtable<String,String> dhis = (Hashtable<String,String>)his.get(i);
        %>
        <tr><td width="5%" align="center"><input type="checkbox" name="alter" id="alter" value=<%=(String)dhis.get("UKTK") %>></td>
		<td width="15%" align="center"><%=(String)dhis.get("UKYMD") %></td>
		<td width="10%" align="center"><%=(String)dhis.get("UKTIME") %></td>
		<td width="15%" align="center"><%=(String)dhis.get("UKTKNO") %></td>
		<td width="5%" align="center"><%=Dchange.deedChange((String)dhis.get("SIDO")) %></td>
		<td width="10%" align="center"><%=(String)dhis.get("KEKNO") %></td>
		<td width="15%" align="center"><%=(String)dhis.get("UKCONTENT") %></td>
		<td width="8%" align="center"><%=(String)dhis.get("KANAMA") %></td>
		<td width="9%" align="center"><%=(String)dhis.get("JJSCD") %></td>
		<td width="8%" align="center"><%=(String)dhis.get("USERID") %></td></tr>
        <%} %>
		</table>
		<input type="hidden" name="kekno" id="kekno" value=<%=(String) nextform.getKekno()%>>
		<input type="hidden" name="member" id="member" value=<%=(String) nextform.getKekno()%>>
		<input type="hidden" name="copcd" id="copcd" value=<%=(String) nextform.getCopcd()%>>
		<input type="hidden" name="telephone" id="telephone" value=<%=(String) nextform.getTelephone()%>>
		<input type="hidden" name="tskyNum" id="tskyNum" value=<%=Dchange.nullCheck((String) nextform.getTskyNum()) == "" ? "-" : (String) nextform.getTskyNum()%>>
		<input type="hidden" name="ikyNum" id="ikyNum" value=<%=Dchange.nullCheck((String) nextform.getIkyNum()) == "" ? "-" : (String) nextform.getIkyNum()%>>
		<input type="hidden" name="lkyNum" id="lkyNum" value=<%=Dchange.nullCheck((String) nextform.getLkyNum()) == "" ? "-" : (String) nextform.getLkyNum()%>>
	</form>
</body>
</html>