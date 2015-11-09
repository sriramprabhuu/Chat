package ch.com.sample;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ch.com.utils.DateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Login extends Action {
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.
	 * struts.action.ActionMapping, org.apache.struts.action.ActionForm, 
	 * javax.servlet.http.HttpServletRequest, 
	 * javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) {
		String nameOfLoggenPerson = servletRequest.getRemoteUser();
		if(checkForDuplicate(servletRequest))
		{
			return actionMapping.findForward("duplicateUser");
		}
		servletRequest.getSession(true).
		setAttribute("chatName",nameOfLoggenPerson);
		FormBean formBean = (FormBean)actionForm;
		double rand = Math.random();
		int intRand = (int)(rand*10)%10;
		formBean.setRandomNumber(intRand);
		formBean.setSriram(nameOfLoggenPerson);
		servletRequest.setAttribute("FormBean",formBean);
		File file = new File("C:/log/ActiveUsers.properties");
		try
		{
			RandomAccessFile fileToReadStream = new RandomAccessFile(file,"rw");
			fileToReadStream.seek(file.length());
			fileToReadStream.writeBytes(
					nameOfLoggenPerson+"="+getSysDate()+"\n");
			fileToReadStream.close();
		}
		catch (FileNotFoundException e)
		{
			
		}catch (IOException e)
		{
			
		}
		return actionMapping.findForward("go");
	}
	
	/**
	 * Gets the sys date.
	 * 
	 * @return the sys date
	 */
	private String getSysDate()
	{
		Date date = new Date();
		return DateUtils.formatDate(date,"HH:mm");
	}
	
	/**
	 * Check for duplicate.
	 * 
	 * @param request the request
	 * 
	 * @return true, if check for duplicate
	 * 
	 * @throws IOException the IO exception
	 */
	private boolean checkForDuplicate(HttpServletRequest request)
	{
		final Properties handlerProps = new Properties();
		String tempString = "";
		String loggedInName = request.getRemoteUser();
		FileInputStream fin;
		try
		{
			fin = new FileInputStream(
					"C:/log/ActiveUsers.properties");
			handlerProps.load(fin);
		}
		catch (FileNotFoundException e)
		{
		}
		catch (IOException e)
		{
		}
		final Enumeration enumeration = handlerProps.propertyNames();
		while (enumeration.hasMoreElements())
		{
			tempString = (String) enumeration.nextElement();
			if(tempString.equals(loggedInName))
			{
				return true;
			}
		}
		return false;
	}

}