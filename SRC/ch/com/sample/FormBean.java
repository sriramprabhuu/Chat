package ch.com.sample;

import org.apache.struts.action.ActionForm;

public class FormBean extends ActionForm{

	
	private static final long serialVersionUID = 1L;
	String sriram = "";
	String pwd = "";
	String selectBox = "";
	String chatTextArea = "";
	int randomNumber = 0;
	public String getSriram() {
		return sriram;
	}

	public void setSriram(String sriram) {
		this.sriram = sriram;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSelectBox() {
		return selectBox;
	}

	public void setSelectBox(String selectBox) {
		this.selectBox = selectBox;
	}

	public String getChatTextArea()
	{
		return chatTextArea;
	}

	public void setChatTextArea(String chatTextArea)
	{
		this.chatTextArea = chatTextArea;
	}

	public int getRandomNumber()
	{
		return randomNumber;
	}

	public void setRandomNumber(int randomNumber)
	{
		this.randomNumber = randomNumber;
	}
	

}
