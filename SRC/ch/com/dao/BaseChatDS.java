package ch.com.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseChatDS
{
	
	/** The con. */
	Connection con;
	
	/** The result set. */
	ResultSet resultSet;
	
	/** The prepared statement. */
	PreparedStatement preparedStatement;
	
	/** The statement. */
	Statement statement;
	
	/**
	 * Gets the connection.
	 * 
	 * @throws DAOException the DAO exception
	 */
	protected void getConnection() throws DAOException
	{
		try
		{
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:/MSAccessDS");
			con = dataSource.getConnection();
		}
		catch (SQLException e)
		{
			throw new DAOException(); 
		}
		catch (NamingException e)
		{
			throw new DAOException(); 
		}
	}
	
	/**
	 * Close connection.
	 * 
	 * @throws DAOException the DAO exception
	 */
	protected void closeConnection() throws DAOException
	{
		try
		{
			if (resultSet != null) 
			{
				resultSet.close();
			}
			if(con != null)
			{
				con.close();
			}

			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}
			
			if (statement != null) 
			{
				//statement.close();
			}

		}
		catch (SQLException e)
		{
			throw new DAOException(); 
		}
	}
}
