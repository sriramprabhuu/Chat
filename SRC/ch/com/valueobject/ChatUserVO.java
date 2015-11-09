package ch.com.valueobject;

public class ChatUserVO
{
	private int id = 0;
	
	private String userName = "";
	
	private String userId = "";
	
	private String password = "";
	
	private String address = "";
	
	private String phoneNumber = "";
	
	private String createdDate = "";
	
	private String searchString = "";

	/**
	 * @return Returns the address.
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * @param address The address to set.
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * @return Returns the id.
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return Returns the password.
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return Returns the phoneNumber.
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * @param phoneNumber The phoneNumber to set.
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return Returns the userId.
	 */
	public String getUserId()
	{
		return userId;
	}

	/**
	 * @param userId The userId to set.
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	/**
	 * @return Returns the userName.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * @param userName The userName to set.
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	/**
	 * @return Returns the searchString.
	 */
	public String getSearchString()
	{
		return searchString;
	}

	/**
	 * @param searchString The searchString to set.
	 */
	public void setSearchString(String searchString)
	{
		this.searchString = searchString;
	}

	/**
	 * @return Returns the createdDate.
	 */
	public String getCreatedDate()
	{
		return createdDate;
	}

	/**
	 * @param createdDate The createdDate to set.
	 */
	public void setCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
	}
	
	
}
