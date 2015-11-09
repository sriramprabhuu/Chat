package ch.com.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import ch.com.utils.DateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class Sample.
 */
public class Sample extends DispatchAction {

	private String lineAfterBreak =
			"------------------------------------------------------" +
			"------------------------------------------------------<br>";
	/**
	 * Submit and refresh.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws IOException the IO exception
	 */
	public ActionForward SubmitAndRefresh(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		FormBean formm = (FormBean) form;
		PrintWriter printWriter = response.getWriter();
		if(request.getParameter("chat") != null 
					&& request.getParameter("chat").equals("1"))
		{
			formm.setSriram(request.getRemoteUser());
			return mapping.findForward("chatWindow");
		}
		if(formm.getSriram().equals("sriram"))
		{
			printWriter.print("U hav sucessfully logged in");
		}
		else if(formm.getSriram().equals("venki"))
		{
			response.sendRedirect("Dummy.jsp");
		}
		else
		{
			return mapping.findForward("tileWindow");
		}
		if(request.getParameter("sriram")!=null)
		{
			System.out.println("request.getParameter() "+
						request.getParameter("sriram"));
		}
		return null;
	}
	
	/**
	 * Back to page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws IOException the IO exception
	 */
	public ActionForward backToPage(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		DynaActionForm dynaActionForm = (DynaActionForm)form;
		ActionMessages actionMessages = new ActionMessages();
		System.out.println("dynaActionForm> "+dynaActionForm.get("keyyy"));
		System.out.println("dynaActionForm> "+dynaActionForm.get("valueee"));
		if(dynaActionForm.get("keyyy").equals(""))
		{
			actionMessages.add("new",new ActionMessage(
						"please fill the field"));
		}
		if(actionMessages.isEmpty()){
		return mapping.findForward("go");
		}else{
			return mapping.findForward("error");
		}
	}
	
	/**
	 * Prints the doc.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws IOException the IO exception
	 */
	public ActionForward printDoc(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
//		response.addHeader("Content-Disposition", "attachment;"
//				+ "filename=Sriram.doc");
//		response.setContentType("report/msword");
//		try {
//			response.getWriter().print("Sriram's application");
//			response.getWriter().flush();
//		} catch (IOException e) {
//			response.getWriter().print("Error while writing the file");
//		}
		response.addHeader("Content-Disposition",
				"attachment;filename=\"File name.csv\"");
		response.setContentType("application/ms-excel");

		try {
			response.getWriter().
				print("Whatever u want to print in the file,sriram");
			response.getWriter().flush();
		} catch (IOException e) {
		}
		return null;
	}
	
	/**
	 * Open pop up.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws IOException the IO exception
	 */
	public ActionForward openPopUp(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return mapping.findForward("popup");
	}
	
	/**
	 * Chat page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws IOException the IO exception
	 */
	public ActionForward chatPage(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) 
	{
		try
		{
			if(request.getParameter("destroyFile") != null)
			{
				checkForSession(request);
			}
			boolean flagForRefresh = false;
			String str = "";
			String chatName = "";
			String tempString = "";
			if(request.getParameter("check") != null)
			{
				str = request.getParameter("check");
				flagForRefresh = false;
			}
			else
			{
				flagForRefresh = true;
			}
			if(request.getSession(false).getAttribute("chatName") != null)
			{
				chatName = (String) request.getSession(false).
					getAttribute("chatName");
			}
			else
			{
				return mapping.findForward("chatLogin");
			}
			String message = "";
			long fileStartVal = 0;
			Long long1 = new Long(0);
			File file = new File("C:/log/Chat.txt");
			RandomAccessFile  fileToReadStream = 
					new RandomAccessFile(file,"rw");
			fileToReadStream.seek(file.length());
			if(request.getSession(false).getAttribute("fileStartValue") == null)
			{
				request.getSession().setAttribute(
							"fileStartValue",new Long(file.length()));
				fileStartVal = file.length();
			}
			else
			{
				long1 = (Long)request.getSession(false)
					.getAttribute("fileStartValue");
				fileStartVal = long1.longValue();			
			}
			if(!flagForRefresh)
			{
				tempString = "<strong>"+chatName+"</strong>"+
					"  posted at "+getSysDate()+" from "
					+request.getRemoteAddr()+":<br>"+str+"<br>"+lineAfterBreak;
				fileToReadStream.writeBytes(tempString);
			}
			fileToReadStream.seek(fileStartVal);
			byte[] buffer = new byte[(int) file.length()];
			fileToReadStream.read(buffer);
			message = new String(buffer);
			fileToReadStream.close();
			message = message+tempString;
			String activeUsers = getActiveMmebers(request); 
			response.getWriter().write(
						activeUsers+"^"+message.toString());
		}
		catch(IOException e)
		{
			try
			{
				response.getWriter().write("Problem accessing sriram's server");
			}
			catch (IOException e1)
			{
			}
		}
		return null;
	}

	private String getSysDate()
	{
		Date date = new Date();
		return DateUtils.formatDate(date,DateUtils.EVENT_LOG_FORMAT);
	}

	private void checkForSession(HttpServletRequest request) 
		throws FileNotFoundException
	{
		if(request.getSession().getAttribute("isSessionAlive") == null)
		{
			request.getSession().getAttributeNames();
			FileOutputStream stream = new FileOutputStream(
						new File("C:/log/Chat.txt"));
		}
	}
	
	/**
	 * Refresh session.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 */
	public ActionForward refreshSession(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) 
	{
		final Properties handlerProps = new Properties();
		FileInputStream fin;
		String loggedInUser = request.getRemoteUser();
		FileOutputStream fileOutputStream = null;
		try
		{
			fin = new FileInputStream("C:/log/ActiveUsers.properties");
			handlerProps.load(fin);
			fileOutputStream = new FileOutputStream(
			"C:/log/ActiveUsers.properties");
			handlerProps.remove(loggedInUser);
			handlerProps.store(fileOutputStream,"ActiveUsers");
		}
		catch (FileNotFoundException e)
		{
		}
		catch (IOException e)
		{
		}
		return null;
	}
	
	/**
	 * Gets the active mmebers.
	 * 
	 * @param request the request
	 * 
	 * @return the active mmebers
	 * 
	 * @throws IOException the IO exception
	 */
	private String getActiveMmebers(HttpServletRequest request) 
		throws IOException
	{
		final Properties handlerProps = new Properties();
		String tempString = "";
		FileInputStream fin = new 
			FileInputStream("C:/log/ActiveUsers.properties");
		handlerProps.load(fin);
		final Enumeration enumeration = handlerProps.propertyNames();
		String activeUsers = " StartedTime    Name<br>";
		while (enumeration.hasMoreElements())
		{
			tempString = (String) enumeration.nextElement();
			activeUsers = activeUsers+ handlerProps.getProperty(tempString)+
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
					"   &nbsp;&nbsp;       &nbsp;&nbsp;"+tempString+"<br>";
		}
		return activeUsers;
	}
}
