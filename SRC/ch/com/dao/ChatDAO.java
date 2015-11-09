package ch.com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import ch.com.utils.DateUtils;
import ch.com.valueobject.ChatUserVO;

public class ChatDAO extends BaseChatDS
{

	public ArrayList getAllUsers(ChatUserVO userVO) throws DAOException
	{
		ArrayList arrayList = new ArrayList();
		String seatchQuery = null;
		try
		{
			getConnection();
			seatchQuery = getSearchQuery(userVO);
			preparedStatement = con.prepareStatement(seatchQuery);
			ChatUserVO user = null;
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null)
				while (resultSet.next())
				{
					user = new ChatUserVO();
					user.setId(resultSet.getInt(1));
					user.setUserName(resultSet.getString(2));
					user.setUserId(resultSet.getString(3));
					user.setPassword(resultSet.getString(4));
					user.setPhoneNumber(resultSet.getString(5));
					user.setCreatedDate(resultSet.getString(6));
					arrayList.add(user);
				}
		}
		catch (SQLException e)
		{
			throw new DAOException();
		}
		finally
		{
			closeConnection();
		}

		return arrayList;
	}

	private String getSearchQuery(ChatUserVO userVO)
	{
		StringBuffer buffer = new StringBuffer();
		int tokenNo = 0;
		StringTokenizer tokenizer = null;
		String [] array = new String[10];
		if(userVO != null && userVO.getSearchString() != null && 
				!userVO.getSearchString().equals(""))
		{
			tokenizer = new StringTokenizer(userVO.getSearchString(), "+");
			while(tokenizer.hasMoreTokens())
			{
				array[tokenNo] = tokenizer.nextToken();
				tokenNo++;
			}
			for(int i=0;i<tokenNo;i++)
			{
				if(i != 0 && !array[i].equals(""))
				{
					buffer.append(" union ");
				}
				buffer.append("select * from User where userName like '%");
				buffer.append(array[i]);
				buffer.append("%' or userId like '%");
				buffer.append(array[i]);
				buffer.append("%' or createdDate like '%");
				buffer.append(array[i]);
				buffer.append("%' or phoneNumber like '%");
				buffer.append(array[i]);
				buffer.append("%'");
			}
		}
		else
		{
			buffer.append("select * from User");
		}
		return buffer.toString();
	}

	public void createUser(ChatUserVO userVO) throws DAOException
	{
		String query = null;
		try
		{
			getConnection();
			query = getqueryForInsert(userVO);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.execute();
		}
		catch (SQLException e)
		{
			throw new DAOException();
		}
		finally
		{
			closeConnection();
		}
	}

	private String getqueryForInsert(ChatUserVO userVO)
	{
		StringBuffer newString = new StringBuffer();
		newString.append("insert into User (userName, userId, " +
			"password, phoneNumber,createdDate) values ('");
		newString.append(userVO.getUserName());
		newString.append("','");
		newString.append(userVO.getUserId());
		newString.append("','");
		newString.append(userVO.getPassword());
		newString.append("','");
		newString.append(DateUtils.formatDate(
				new Date(),DateUtils.DEFAULT_DATE_FORMAT));
		newString.append("')");
		return newString.toString();
	}

	public void deleteUser(ChatUserVO userVO) throws DAOException
	{
		String query = "";
		try
		{
			getConnection();
			query = "delete from User where id = "+userVO.getId();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.execute();
		}
		catch (SQLException e)
		{
			throw new DAOException();
		}
		finally
		{
			closeConnection();
		}
	}
}
