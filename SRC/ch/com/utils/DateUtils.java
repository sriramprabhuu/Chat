package ch.com.utils;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateUtils
{
	private static Calendar calendarInstance = Calendar.getInstance();
	private static SimpleDateFormat dateFormat = null;
	public final static String DEFAULT_DATE_FORMAT = "dd.MM.yyyy";
	public final static String EVENT_LOG_FORMAT = "dd.MM.yyyy HH:mm";
	public final static String YY = "yy";
	public final static String YYYY = "yyyy";
	public final static String DD = "dd";
	public final static String MM = "MM";
	public final static String SECONDS = "ss";
	public final static String DISPLAY_FORMAT = "dd.MM.yyyy h:mm a";	
	
	/** The Constant DEFAULT_DECIMAL_FORMAT. */
	public final static String DEFAULT_DECIMAL_FORMAT = "####.00";

	/**
	*	Utility Method to get DATE field from <code>java.util.Date</code> Object.
	*	@param date Date Object for which DATE field has to be retrieved.
	*	@return DATE field for the <code>date</code>.
	*/
	public static int getDate(Date date)
	{
        calendarInstance.setTime(date);
		return calendarInstance.get(Calendar.DATE);
  	}
	
	/**
	*	Utility Method to get DATE field as Integer from 
	*	<code>java.util.Date</code> Object.
	*	@param date Date Object for which DATE field has to be retrieved.
	*	@return DATE field for the <code>date</code>.
	*/
	public static int getDateInt(Date date)
	{
        return Integer.parseInt(formatDate(date, DD));		
  	}
	
	/**
	*	Utility Method to get YEAR field as Integer from 
	*	<code>java.util.Date</code> Object.
	*	@param date Date Object for which YEAR field has to be retrieved.
	*	@return DATE field for the <code>date</code>.
	*/
	public static int getYearInt(Date date)
	{
        return Integer.parseInt(formatDate(date, YY));		
  	}
	
	/**
	*	Utility Method to get MONTH field as Integer from 
	*	<code>java.util.Date</code> Object.
	*	@param date Date Object for which MONTH field has to be retrieved.
	*	@return DATE field for the <code>date</code>.
	*/
	public static int getMonthInt(Date date)
	{
        return Integer.parseInt(formatDate(date, MM));		
  	}
	
	/**
	*	Utility Method to get SECONDS field as Integer from 
	*	<code>java.util.Date</code> Object.
	*	@param date Date Object for which SECONDS field has to be retrieved.
	*	@return DATE field for the <code>date</code>.
	*/
	public static int getSecondsInt(Date date)
	{
        return Integer.parseInt(formatDate(date, SECONDS));		
  	}
	

	/**
	*	Utility Method to get MONTH field from <code>java.util.Date</code> Object.
	*	@param date Date Object for which MONTH field has to be retrieved.
	*	@return MONTH field for the <code>date</code>.
	*/
  	public static int getMonth(Date date)
	{
        calendarInstance.setTime(date);
		return calendarInstance.get(Calendar.MONTH);
  	}

	/**
	*	Utility Method to get YEAR field from <code>java.util.Date</code> Object.
	*	@param date Date Object for which YEAR field has to be retrieved.
	*	@return YEAR field for the <code>date</code>.
	*/
  	public static int getYear(Date date)
  	{
        calendarInstance.setTime(date);
  		return calendarInstance.get(Calendar.YEAR);
  	}

	/**
	*	Utility Method to parse a dateString to <code>java.util.Date</code>
	*	using the required </code>datePattern</code>. This method returns null
	*	if the <code>dateStr</code> can not be parsed.
	*	@param dateStr Date in String Format.
	*	@param datePattern Date Pattern to be used to Parse the <code>dateStr</code>.
	*	@return Parsed <code>java.util.Date</code> Object.
	*/
  	public static Date parseDate(String dateStr, String datePattern)
	{
		try
		{
			dateFormat = new SimpleDateFormat(datePattern);
			dateFormat.setLenient(false);
			if(dateStr != null)
			{
				Date parsedDate = dateFormat.parse(dateStr); 
				return parsedDate;
			}
			else
			{
				return null;
			}
		}
		catch(ParseException pe)
		{
			return null;
		}
  	}

  	/**
	*	Utility Method to format <code>java.util.Date</code> to String
	*	using the required </code>datePattern</code>.
	*	@param date Date to be formated.
	*	@param datePattern Date Pattern to be used to Formate the date.
	*	@return Formated Date String.
	*/
  	public static String formatDate(Date date, String datePattern)
	{
  		if(date != null)
  		{
			dateFormat = new SimpleDateFormat(datePattern);
			return dateFormat.format(date);
  		}
  		else
  		{
  			return null;
  		}
  	}

  	/**
	*	Utility Method to parse a dateString to <code>java.util.Date</code>
	*	using the required </code>datePattern</code>. This method returns null
	*	if the <code>dateStr</code> can not be parsed.
	*	@param dateStr Date in String Format.
	*	@param datePattern Date Pattern to be used to Parse the <code>dateStr</code>.
	*	@return Parsed <code>java.util.Date</code> Object.
	*/
	public static Date addToDate(Date date, int day, int month, int year)
	{
		calendarInstance.setTime(date);

		calendarInstance.add(Calendar.DATE, day);
		calendarInstance.add(Calendar.MONTH, month);
		calendarInstance.add(Calendar.YEAR, year);

		return calendarInstance.getTime();
  	}
	
  	/**
	   * Utility Method to parse a dateString to <code>java.util.Date</code>
	   * using the required </code>datePattern</code>. This method returns null
	   * if the <code>dateStr</code> can not be parsed.
	   * 
	   * @param month the month
	   * @param hour the hour
	   * @param day the day
	   * @param year the year
	   * @param date the date
	   * 
	   * @return Parsed <code>java.util.Date</code> Object.
	   */
	public static Date addToDate(Date date, int day, int month, int year, 
			int hour)
	{
		calendarInstance.setTime(date);

		calendarInstance.add(Calendar.DATE, day);
		calendarInstance.add(Calendar.MONTH, month);
		calendarInstance.add(Calendar.YEAR, year);
		calendarInstance.add(Calendar.HOUR, hour);

		return calendarInstance.getTime();
  	}	
        
}