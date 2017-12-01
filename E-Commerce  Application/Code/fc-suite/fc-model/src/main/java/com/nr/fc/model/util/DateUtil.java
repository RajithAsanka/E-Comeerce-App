

package com.nr.fc.model.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Weeks;

public class DateUtil {

    public static int checkWeekdifferent(Date date1, Date date2) {
        DateTime dateTime1 = new DateTime(date1);
        DateTime dateTime2 = new DateTime(date2);

        int weeks = Weeks.weeksBetween(dateTime1, dateTime2).getWeeks();
        return weeks;

    }
  
  public static class DateFormats {
    public static String MMddYYYY = "MM/dd/yyyy";
    
    public static String HHmma = "HH:mm a";
    
    public static String HHmmss = "HH:mm:ss";
  }
  
  public enum Formats {
    DEFAULTDATE, TWELEVEHOURS, TWENTYFOURHOURS, DEFAULTDATEANDTIME,DATEFORMATSEPARATEDASH
  };
  
  /**
   * Author: Sayyaff String to long Conversion
   * 
   * @return
   * @throws ParseException
   */
  public long convertToLong(String date, String format) throws ParseException {
  
    SimpleDateFormat f = new SimpleDateFormat(format);// dd-MMM-yyyy
    Date d = f.parse(date);
    return d.getTime();
  }
  
  /**
   * String to Date Conversion
   * 
   * @param sDate
   * @param format
   * @return
   * @throws ParseException
   */
  public static final Date stringToDate(String sDate, String format) throws ParseException {
  
    DateFormat simpleDateFormat = new SimpleDateFormat(format);
    Date date = simpleDateFormat.parse(sDate);
    System.out.println(simpleDateFormat.format(date));
    return date;
  }
  
  /**
   * 
   * @param sDate
   * @param format <pre>
	 * {@code
	 * 		Formats.DEFAULTDATE = "MM/dd/yyyy";
	 *		Formats.TWELEVEHOURS = "HH:mm a";
	 *		Formats.TWENTYFOURHOURS = "HH:mm:ss";
	 *		Formats.DEFAULTDATEANDTIME = "MM/dd/yyyy HH:mm a";
	 *}
	 * }
	 * </pre>
   * @return
   * @throws ParseException
   * 
   * 
   * 
   */
  public static final Date stringToDate(String sDate, Formats format) throws ParseException {
  
    DateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
    Date date = null;
    
    if (format == Formats.DEFAULTDATE) {
      simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    } else if (format == Formats.TWELEVEHOURS) {
      simpleDateFormat = new SimpleDateFormat("hh:mm a");
    } else if (format == Formats.TWENTYFOURHOURS) {
      simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    } else if (format == Formats.DEFAULTDATEANDTIME) {
      simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
    }else if (format == Formats.DATEFORMATSEPARATEDASH) {
      simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    try {
      date = simpleDateFormat.parse(sDate);
      System.out.println(simpleDateFormat.format(date));
    } catch (ParseException e) {
      date = null;
    }
    return date;
  }
  
  /**
   * Date to String Conversion
   * 
   * @param date
   * @param format
   * @return
   */
  public static final String dateToString(Date date, String format) {
  
    Format formatter = new SimpleDateFormat(format);
    String sDate = formatter.format(date);
    return sDate;
  }
  
  public static final String dateToString(Date date, Formats format) {
  
    DateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
    if (format == Formats.DEFAULTDATE) {
      simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    } else if (format == Formats.TWELEVEHOURS) {
      simpleDateFormat = new SimpleDateFormat("hh:mm a");
    } else if (format == Formats.TWENTYFOURHOURS) {
      simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    } else if (format == Formats.DEFAULTDATEANDTIME) {
      simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
    }else if (format == Formats.DATEFORMATSEPARATEDASH) {
      simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    
    String sDate = simpleDateFormat.format(date);
    return sDate;
  }
  
  /**
   * Adding days to the current date
   * 
   * @param date
   * @param days
   * @return
   */
  public static Date addDays(Date date, int days) {
  
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, days); // minus number would decrement the days
    return cal.getTime();
  }
  
  /**
   * check which day is it by entering date
   * 
   * @return String whether it is monday or tuesday
   */
  public static String checkDate(Date theDate) {
  
    Calendar cal = Calendar.getInstance();
    cal.setTime(theDate);
    if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
      return "Monday";
    else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY)
      return "Tuesday";
    else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY)
      return "WednesDay";
    else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY)
      return "Thursday";
    else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
      return "Friday";
    else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
      return "Saturday";
    else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
      return "Sunday";
    else
      return "Aiyoo";
  }
  
  
  public static int dayChecker(String day) {
  
    switch (day) {
      case "Sunday":
        return 7;
      case "Monday":
        return 1;
      case "Tuesday":
        return 2;
      case "Wednesday":
        return 3;
      case "Thursday":
        return 4;
      case "Friday":
        return 5;
      case "Saturday":
        return 6;
      default:
        return 0;
    }
  }
  
}
