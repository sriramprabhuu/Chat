<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sriram's Chat</title>
<script type="text/javascript" src="ChatPage.js"></script>
</head>
<body onload="javascript:setFocus();" onbeforeunload="handleOnClose()">
<logic:empty name="FormBean">
	<logic:forward name="Login" />
</logic:empty>
<html:form action="/chatWindow">
	<table width="90%">
		<tr>
			<td align="center"><font color="Black" size="5"><Strong><bean:write
				name="FormBean" property="sriram" /></Strong>'s chat window</font>
			</td>
		<tr>
			<!-- <td><img src="don7s.jpg" alt="Sriram's" width="15%"></td> -->
		</tr>
	</table>
	<div style="overflow:scroll;height:400px;" valign="bottom" align="left">
	<table width="90%">
		<tr>
			<td width="70%">
			<div id="divElement"></div>
			</td>
		</tr>
		<tr>
			<td><font color="green"> Enter your text <bean:write name="FormBean"
				property="sriram" />:</font></td>
		</tr>
		<tr valign="top">
			<td><html:textarea property="chatTextArea"
				onkeypress="javascript:sendChat(event);" rows="4" cols="80%"></html:textarea></td>
			<td valign="top" align="left"><html:button property="Submit"
				value="<<----Post this" onclick="javascript:sendChat(null);"></html:button></td>
		</tr>
	</table>
	</div>
</html:form>
</body>
</html>
