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
<script src="LIFEA/LIFEA006.js" type="text/javascript"></script>
<title>个人账号管理(LIFEA006)</title>
</head>
<%
	String jjscd = (String) session.getAttribute("jjscd");
	String userid = (String) session.getAttribute("userid");
	String passwd = (String) session.getAttribute("passwd");
%>
<body>
	<form name="form1">
		<input type="hidden" name="sid" value="LIFEA006"> 
		<input type="hidden" name="password" value=<%=passwd%>>
		<table width="100%" border="1" align="center" bgcolor="blue"
			bordercolor="blue">
			<tr></tr>
			<tr>
				<td>个人信息管理一栏</td>
			</tr>
			<tr></tr>
		</table>
		<jsp:include page="/LIFEV/DHeadError.jsp"></jsp:include>
		<table width="100%" border="1" align="center" bordercolor="blue">
			<tr>
				<td>
					<table width="100%" border="0" align="center">
						<tr>
							<td width="8%">&nbsp;</td>
							<td width="18%">&nbsp;</td>
							<td width="30%">&nbsp;</td>
							<td width="44%">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td align="right">*</td>
							<td align="left">事务所CD：</td>
							<td><input type="text" name="jyscd" id="jyscd"
								readonly="readonly" maxlength="3" size="6" value=<%=jjscd%>></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td align="right">*</td>
							<td align="left">用户个人ID：</td>
							<td><input type="text" name="userid" id="userid"
								readonly="readonly" maxlength="32" size="35" value=<%=userid%>></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">
								<table width="100%" align="center" border="1" cellpadding="1"
									cellspacing="2" bordercolor="blue">
									<tbody>
										<tr>
											<td>
												<table width="100%" align="center" border="0">
													<tr>
														<td width="12%">&nbsp;</td>
														<td width="22%">&nbsp;</td>
														<td width="30%">&nbsp;</td>
														<td width="36%">&nbsp;</td>
													</tr>
													<tr>
														<td align="right">*</td>
														<td align="left">现在的账号密码：</td>
														<td><input type="text" name="passwd" id="passwd"
															maxlength="16" size="35" style="ime-mode: disabled"></td>
														<td>&nbsp;</td>
													</tr>
													<tr>
														<td align="right">*</td>
														<td align="left">新的账号密码：</td>
														<td><input type="text" name="newpasswd"
															id="newpasswd" maxlength="16" size="35"
															style="ime-mode: disabled"></td>
														<td>&nbsp;</td>
													</tr>
													<tr>
														<td align="right">*</td>
														<td align="left">确认账号密码：</td>
														<td><input type="text" name="confirmpasswd"
															id="confirmpasswd" maxlength="16" size="35"
															style="ime-mode: disabled"></td>
														<td>&nbsp;</td>
													</tr>
													<tr>
														<td colspan="4">&nbsp;</td>
													</tr>
												</table>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4"><table width="100%" align="center"
									border="0">
									<tbody>
										<tr>
											<td width="10%">&nbsp;</td>
											<td width="20%" align="center"><input type="button"
												name="chang" id="chang" onclick="onChang(form1)" value="确认"
												class="btn"></td>
											<td width="20%" align="center"><input type="button"
												name="close" id="close" onclick="onClose()" value="关闭"
												class="btn"></td>
											<td>&nbsp;</td>
										</tr>
									</tbody>
								</table></td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>