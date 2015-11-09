var iden = '-1';
function submitPage(){
			iden = 1;
			document.forms[0].chat.value=1;
			document.forms[0].action = "Change.go?method=SubmitAndRefresh";
			document.forms[0].submit();
}

function setFocus()
{
}

function handleOnClose()
{
	if (iden == -1) 
	{
	document.forms[0].action = "Change.go?method=refreshSession";
	document.forms[0].submit();
	alert("You will be moved out of the chat now.");
    	//event.returnValue = '';
   	}
}