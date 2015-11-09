<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Chat</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="Style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="ChatPage.js"></script>
</head>
<body  onload="javascript:setFocus();" onbeforeunload="handleOnClose()">
<table cellpadding="0" cellspacing="0" border="0" width="100%"
	summary="Main Layout Table">
	<tr>
		<td width="50%">
		<tiles:insert attribute="left" />
		</div>
		</td>
		<td width="50%">
		<tiles:insert attribute="right" />
		</div>
		</td>
	</tr>
</table>
</body>
</html>

