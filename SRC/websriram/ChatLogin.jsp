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
<script type="text/javascript" src="ChatLogin.js"></script>
</head>
<body onload="javascript:setFocus();" onbeforeunload="handleOnClose()">
<logic:empty name="FormBean">
	<logic:forward name="Login" />
</logic:empty>
<html:form action="/Login">
	<input type="hidden" name="chat">
	<table width="100%">
		<tr align="right">
			<td align="center"><font color="Black" size="7">Welcome to DON's
			forum,<Strong><bean:write name="FormBean" property="sriram" /></Strong></font></td>
		</tr>
		<tr align="right">
			<td align="center"><logic:equal name="FormBean" property="sriram" value="sriram">
			Administrator's Login
			</logic:equal></td>
		</tr>		
		<tr align="center">
			<td align="center">
			<logic:notEqual name="FormBean" property="sriram" value="sriram">
			<font color="green">click the picture to enter
			into your chat window</font>
			</logic:notEqual>
			</td>
		</tr>
		<tr align="center">
			<td><a onclick="javascript:submitPage();">0 
			<logic:equal
				name="FormBean" property="randomNumber" value="0">
				<img src="1024_3.jpg" alt="Click me to enter into your chat window"
					width="60%">
			</logic:equal>
			<logic:equal
				name="FormBean" property="randomNumber" value="1">1
				<img src="1024_3.jpg" alt="Click me to enter into your chat window"
					width="60%">
			</logic:equal>
			<logic:equal
				name="FormBean" property="randomNumber" value="2">
				<img src="don26s.jpg" alt="Click me to enter into your chat window"
					width="60%">
			</logic:equal>
			<logic:equal
				name="FormBean" property="randomNumber" value="3">
				<img src="don7s.jpg" alt="Click me to enter into your chat window"
					width="60%">
			</logic:equal>
			<logic:equal
				name="FormBean" property="randomNumber" value="4">
				<img src="khnh14_8x6.jpg" alt="Click me to enter into your chat window"
					width="60%">
			</logic:equal>
			<logic:equal
				name="FormBean" property="randomNumber" value="5">
				<img src="khnh7_8x6.jpg" alt="Click me to enter into your chat window"
					width="60%">
			</logic:equal>
			<logic:equal
				name="FormBean" property="randomNumber" value="6">
				<img src="pic00491.jpg" alt="Click me to enter into your chat window"
					width="60%">
			</logic:equal>
			<logic:equal
				name="FormBean" property="randomNumber" value="7">
				<img src="pic11478.jpg" alt="Click me to enter into your chat window"
					width="60%">
			</logic:equal>
			<logic:greaterThan name="FormBean" property="randomNumber" value="7">
				<img src="pic11478.jpg" alt="Click me to enter into your chat window"
					width="60%">
			</logic:greaterThan>
			 </a></td>
		</tr>
	</table>
</html:form>
</body>
</html>
