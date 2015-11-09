function sendChat(e)
{
	var key;
	if(window.event && e != null) 
	{
		key = e.keyCode;//IE
	}
	else if(e != null)
	{
		key = e.which;//firefox
	}
	if(key == 13 || e == null)
	{
		var xmlHttp = getXmlHttpObject();
		var url = 'chatWindow.go?method=chatPage';
		var formdata = '&check='+document.getElementById('chatTextArea').value;
		if (xmlHttp == null)
	  	{
	  		alert("Your browser does not support AJAX!");
		  	return false;
	  	}
	  	xmlHttp.open("POST", url, false);
	  	xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	  	//xmlHttp.send('v='+encodeURIComponent(data)) 
	  	xmlHttp.send(formdata);
	  	if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
		{
		  	var message = xmlHttp.responseText.split('^');
		  	document.getElementById('divElement').innerHTML=message[1];
		  	document.getElementById('activeUsers').innerHTML='<strong>'+message[0]+'</strong>';
		}
		document.getElementById('chatTextArea').value = '';
		document.getElementById('chatTextArea').focus();
  	}
}


function getXmlHttpObject()
{
	var xmlHttp=null;
	try
	{
  		// Firefox, Opera 8.0+, Safari
  		xmlHttp=new XMLHttpRequest();
  	}
	catch (e)
  	{
  		// Internet Explorer
  		try
    	{
    		xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    	}
  		catch (e)
    	{
    		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    	}
  	}
	return xmlHttp;
}
function setFocus()
{
	stateChanged();
	checkForMessage();
	document.getElementById('chatTextArea').focus();	
}
function handleOnClose()
{
	//if (window.event.clientY < 0 || window.event.clientX < 0) 
	//{
	document.forms[0].action = "Change.go?method=refreshSession";
	document.forms[0].submit();
	alert("You will be moved out of the chat now");
    	//event.returnValue = '';
   	//}
}


function stateChanged()
{
	var xmlHttp = getXmlHttpObject();
	var url = 'chatWindow.go?method=chatPage';
	var formdata = '';
	if (xmlHttp == null)
  	{
  		alert("Your browser does not support AJAX!");
	  	return false;
  	}
  	xmlHttp.open("POST", url, false);
  	xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  	//xmlHttp.send('v='+encodeURIComponent(data)) 
  	xmlHttp.send(formdata);
  	if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
	{
	  	var message = xmlHttp.responseText.split('^');
	  	document.getElementById('divElement').innerHTML=message[1];
		document.getElementById('activeUsers').innerHTML='<strong>'+message[0]+'</strong>';
	}
}

//for relaoding automatically

var isIE = false;
var req;
var messageHash = -1;
var targetId = "1";
function initRequest(url) {
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function checkForMessage() {
    var url = "chatWindow.go?method=chatPage";
    initRequest(url);
    req.onreadystatechange = processReqChange;
    req.open("GET", url, true);
    req.send(null);
}

// callback for the request
function processReqChange() {
    if (req.readyState == 4) {
        if (req.status == 200) {
            var message = req.responseText.split('^');
	  		document.getElementById('divElement').innerHTML=message[1];
	  		document.getElementById('activeUsers').innerHTML='<strong>'+message[0]+'</strong>';
	  		window.status = "";
        }
        setTimeout("checkForMessage()", 1000);
    }
}

