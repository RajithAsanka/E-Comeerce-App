
package com.nr.fc.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil {

    public static long dateDifferentInTwoDates(Date fromDate, Date toDate) {

        long startTime = fromDate.getTime();
        long endTime = toDate.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        return diffDays;
    }

    public static class DateFormats {

        public static String MMddYYYY = "MM/dd/yyyy";

        public static String HHmma = "HH:mm a";

        public static String HHmmss = "HH:mm:ss";
    }

    public enum Formats {

        DEFAULTDATE, TWELEVEHOURS, TWENTYFOURHOURS, DEFAULTDATEANDTIME, NEWDEFAULTDATE, NEWDEFALTDATE2
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
     *
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
        } else if (format == Formats.NEWDEFAULTDATE) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else if (format == Formats.NEWDEFALTDATE2) {
            simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
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
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            return "Monday";
        } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            return "Tuesday";
        } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            return "WednesDay";
        } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            return "Thursday";
        } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            return "Friday";
        } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            return "Saturday";
        } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return "Sunday";
        } else {
            return "";
        }
    }

    public static int dayChecker(String day) {

        switch (day) {
            case "Sunday":
                return 1;
            case "Monday":
                return 2;
            case "Tuesday":
                return 3;
            case "WendsDay":
                return 4;
            case "Thursday":
                return 5;
            case "Friday":
                return 6;
            case "Saturday":
                return 7;
            default:
                return 0;
        }
    }

    public static String returnEndDate(String month, String yearEnd) {

        String dateString = "";

        DateTimeFormatter format = DateTimeFormat.forPattern("MMM");
        DateTime instance = format.withLocale(Locale.ENGLISH).parseDateTime(month);

        int month_number = instance.getMonthOfYear();
        int yearInt = Integer.parseInt(yearEnd);

        Calendar c = Calendar.getInstance();
        c.set(yearInt, month_number - 1, 1); //------>
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        dateString = sdf.format(c.getTime());

        return dateString;

    }

}
