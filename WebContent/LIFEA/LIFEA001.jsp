<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="LIFE.UTIL.*"%>
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
	src="LIFEA/LIFEA001.js" charset="utf-8"></script>
<title>基本情报检索(LIFEA001)</title>
</head>
<body>
	<form name="form1">
		<input type="hidden" name="sid" value="LIFEA001">
		<table width="100%" border="1" align="center" bgcolor="blue"
			bordercolor="blue">
			<tr></tr>
			<tr>
				<td>基本情报检索</td>
			</tr>
			<tr></tr>
		</table>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<div>&nbsp;</div>
		<table width="95%" border="1" bordercolor="bule" cellpadding=“0”
			cellspacing=“0” align="center">
			<tr>
				<td>
					<table width="90%" border="0" cellpadding="0" cellspacing="0"
						align="center" bordercolor="blue" class="px13">
						<TR>
							<td>&nbsp;</td>
						</TR>
						<tr>
							<td width="25%">合作社会员号码：</td>
							<td width="25%"><input type="text" name="member" id="member"
								maxlength="8"></td>
							<td width="25%">合作社CD：</td>
							<td width="25%"><input type="text" name="copcd" id="copcd"
								maxlength="7"></td>
						</tr>
						<tr>
							<td width="20%">电话号码：</td>
							<td width="30%"><input type="text" name="telephone" id="telephone"
								maxlength="13"></td>
						</tr>
						<tr>
							<td width="20%">保险种别：</td>
							<td width="10%"><input type="radio" name="insurance1"
								id="insur1" value="全部" onclick="onChanged(form1);" checked="checked"><%=DConstants.allInsurance %></td>
							<td width="10%"><input type="radio" name="insurance1"
								id="insur1" value="终生生命" onclick="onChanged(form1);"><%=DConstants.taskei %></td>
							<td width="10%"><input type="radio" name="insurance1"
								id="insur1" value="终生医疗" onclick="onChanged(form1);"><%=DConstants.aipic %></td>
						</tr>
						<tr><td>&nbsp;</td>
						<td width="10%"><input type="radio" name="insurance1"
								id="insur1" value="火灾" onclick="onChanged(form1);"><%=DConstants.aiai %></td></tr>
						<tr>
							<td width="20%">契约编号：</td>
							<td width="30%"><input type="text" name="kekno" id="kekno"
								maxlength="8"></td>
						</tr>
						<TR>
							<td>&nbsp;</td>
						</TR>
						<tr>
							<td colspan="4">
								<table width="100%" border="1" cellpadding="0" cellspacing="0"
									bordercolor="blue">
									<tr>
										<td>
											<table width="90%" border="0" cellpadding="0" cellspacing="0"
												align="center">
												<TR>
													<td>&nbsp;</td>
												</TR>
												<tr>
													<td width="25%"><input type="radio" id="rolek"
														name="agreement" value="契约者" checked="checked"
														onclick="onSelected();">契约者</td>
													<td width="25%">&nbsp;</td>
													<td width="25%"><input type="radio" id="roleK"
														name="agreement" value="被救济者" onclick="onSelected();">被救济者</td>
													<td width="25%">&nbsp;</td>
												</tr>
												<tr>
													<td width="25%">姓名：</td>
													<td width="25%"><input type="text" id="kekname"
														name="kekname" maxlength="8"></td>
													<td width="25%">身份ID：</td>
													<td width="25%"><input type="text" id="identity"
														name="identity" maxlength="10"></td>
												</tr>
												<tr>
													<td width="25%">生年月日：</td>
													<td width="50%" colspan="2"><input type="text"
														id="birth" name="birthday"></td>
												</tr>
												<TR>
													<td>&nbsp;</td>
												</TR>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<TR>
							<td>&nbsp;</td>
						</TR>

					</table>
				</td>
			</tr>
		</table>
		<table width="95%" border="0" align="center">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td width="33%" align="center"><input type="button"
					name="back" id="back" value="返 回" align="middle"
					onclick="onBack();" class="btn"></td>
				<td width="33%" align="center"><input type="button"
					name="implement" id="implement" value="实 行"
					onclick="onImplement(form1);" class="btn"></td>
				<td width=“34%” align="center"><input type="button"
					name="close" id="close" value="关 闭" onclick="onClose();"
					class="btn"></td>
			</tr>
		</table>
	</form>
</body>
</html>