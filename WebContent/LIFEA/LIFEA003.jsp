<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="LIFE.A.LIFEA003Form"%>
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
	src="LIFEA/LIFEA003.js" charset="utf-8"></script>
<title>契约一览</title>
</head>
<%
	LIFEA003Form allData = (LIFEA003Form) request.getAttribute("LIFEA003form");
	Vector<Hashtable<String, String>> tsky = allData.getTsky();
	Vector<Hashtable<String, String>> iky = allData.getIky();
	Vector<Hashtable<String, String>> lky = allData.getLky();
	int count = allData.getCount();
	String copmember = "";
	String copcd = "";
	if (tsky != null && tsky.size() > 0) {
		copmember = tsky.get(0).get("COPMEMBER");
		copcd = tsky.get(0).get("COPCD");
	} else if (iky != null && iky.size() > 0) {
		copmember = iky.get(0).get("COPMEMBER");
		copcd = iky.get(0).get("COPCD");
	} else if (lky != null && lky.size() > 0) {
		copmember = lky.get(0).get("COPMEMBER");
		copcd = lky.get(0).get("COPCD");
	}
%>
<body>
	<form name="form1">
		<div>&nbsp;</div>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<div class="px13">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该当页面的契约的检索的合作社会员号是<%=copmember%>，合作社CD是<%=copcd%>。
		</div>
		<div class="px13">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检索到的契约一共<%=count%>件。
		</div>
		<table width="90%" align="center" border="0" cellpadding="0"
			cellspacing="0" class="px13">
			<%
				if (tsky != null && tsky.size() > 0) {
			%>
			<tr>
				<td bgcolor="#8968CD" align="left" colspan="2">终生生命</td>
			</tr>
			<%
				for (int i = 0; i < tsky.size(); i++) {
						Hashtable<String, String> tskydata = tsky.get(i);
						request.setAttribute("tdata", tskydata);
			%>
			<tr>
				<td width="5%" valign="top"><input type="checkbox" name="tsky" id="tsky" value=<%=(String)tskydata.get("KEKNO") %>></td>
				<td><jsp:include page="/LIFEUTIL/DComTsky.jsp" flush="true" /></td>
			</tr>
			<%
				}
				}
			%>
			<%
				if (iky != null && iky.size() > 0) {
			%>
			<tr>
				<td bgcolor="#BBFFFF" align="left" colspan="2">终生医疗</td>
			</tr>
			<%
				for (int i = 0; i < iky.size(); i++) {
						Hashtable<String, String> ikydata = iky.get(i);
						request.setAttribute("idata", ikydata);
			%>
			<tr>
				<td width="5%" valign="top"><input type="checkbox" name="iky" id="iky" value=<%=(String)ikydata.get("KEKNO") %>></td>
				<td><jsp:include page="/LIFEUTIL/DComIky.jsp" flush="true" /></td>
			</tr>
			<%
				}
				}
			%>
			<%
				if (lky != null && lky.size() > 0) {
			%>
			<tr>
				<td bgcolor="#CDCD00" align="left" colspan="2">火灾</td>
			</tr>
			<%
				for (int i = 0; i < lky.size(); i++) {
						Hashtable<String, String> lkydata = lky.get(i);
						request.setAttribute("ldata", lkydata);
			%>
			<tr>
				<td width="5%" valign="top"><input type="checkbox" name="lky" id="lky" value=<%=(String)lkydata.get("KEKNO") %>></td>
				<td><jsp:include page="/LIFEUTIL/DComLky.jsp" flush="true" /></td>
			</tr>
			<%
				}
				}
			%>
		</table>
		<table width="90%" align="center" border="0" class="px13">
			<tr><td colspan="5">&nbsp;</td></tr>
			<tr>
				<td width="10%">&nbsp;</td>
				<td width="20%">契约选择处理：</td>
				<td width="25%"><select onchange="" style="width:160px;" name="oneselect">
				<option selected="selected">受理</option>
				<option>咨询</option></select></td>
				<td width="30%"><select onchange="" style="width:200px;" name="twoselect">
				<option selected="selected">契约者变更</option>
				<option>被共济者变更</option>
				<option>解约</option></select></td>
				<td width="15%">&nbsp;</td>
			</tr>
		</table>
		<table width="90%" border="0" align="center" class="px13">
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td width="25%" align="center">&nbsp;</td>
				<td width="25%" align="center">&nbsp;</td>
				<td width="25%" align="center"><input type="button"
					name="implement" id="implement" value="实 行"
					onclick="onImplement(form1);" class="btn"></td>
				<td width=“25%” align="center"><input type="button"
					name="close" id="close" value="关 闭" onclick="onClose();"
					class="btn"></td>
			</tr>
		</table>
	</form>
</body>
</html>