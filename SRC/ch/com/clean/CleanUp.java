package ch.com.clean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import ch.com.dao.DAOException;
import ch.com.dao.ChatDAO;
import ch.com.valueobject.ChatUserVO;

public class CleanUp extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	/**
	 * The appllog.
	 */

	public void init(ServletConfig config) throws ServletException
	{
		FileOutputStream outputStream = null;
		try
		{
			outputStream = new FileOutputStream(
					"C:/log/ActiveUsers.properties");
			updateList();
		}
		catch (FileNotFoundException e)
		{

		}
	}
	
	private void updateList()
	{
		ChatDAO userDAO = new ChatDAO();
		ArrayList arrayList = null;
		int size = 0;
		ChatUserVO userVO = null;
		FileOutputStream roles = null;
		File file = null;
		RandomAccessFile fileToReadStream = null;

		File users = null;
		RandomAccessFile usersToReadStream = null;
		try
		{
			roles = new FileOutputStream("C:/log/ActiveUsers.properties");
			roles = new FileOutputStream("C:/Projects/Chat/SRC/roles.properties");
			roles = new FileOutputStream("C:/Projects/Chat/SRC/users.properties");
			arrayList = userDAO.getAllUsers(new ChatUserVO());
			file = new File("C:/Projects/Chat/SRC/roles.properties");
			users = new File("C:/Projects/Chat/SRC/users.properties");
			fileToReadStream = new RandomAccessFile(file, "rw");
			usersToReadStream = new RandomAccessFile(users, "rw");
			if (arrayList != null && arrayList.size() != 0)
			{
				fileToReadStream.seek(file.length());
				usersToReadStream.seek(users.length());
				size = arrayList.size();
				for (int i = 0; i < size; i++)
				{
					userVO = (ChatUserVO) arrayList.get(i);
					if (userVO.getUserId() != null
							&& !userVO.getUserId().equals("")
							&& userVO.getPassword() != null
							&& !userVO.getPassword().equals(""))
					{
						fileToReadStream.writeBytes(userVO.getUserId() + "="
								+ "AuthorizedUser" + "\n");
						usersToReadStream.writeBytes(userVO.getUserId() + "="
								+ userVO.getPassword() + "\n");
					}
				}
				fileToReadStream.close();
				usersToReadStream.close();
			}
		}
		catch (FileNotFoundException e)
		{

		}
		catch (DAOException e)
		{
		}
		catch (IOException e)
		{

		}
	}
}