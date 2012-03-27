/* Copyright(c) ISoftstone,2006 - 2008
 * 
 * 版权声明 v1.0
 *
 * 本程序(包括源代码和二进制码)的知识产权(包括但不限于著作权、专利申请权、商标权、专有技术)的所有权、使用权、
 * 转让权以及收益等一切权利均属于ISoftstone所有。
 * ==============================================================================================================*/
package com.common.tools.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class DateUtil {
	public static long oneDay = 24 * 60 * 60 * 1000;

	public static String format(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		return formater.format(date);
	}

	public static String Dateformat(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		return formater.format(date);
	}

	/**
	 * d1 是否小于或等于d2
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean isAgoOrEquals(Date d1, Date d2) {
		d1 = textToDate(format(d1), "yyyy/MM/dd");
		d2 = textToDate(format(d2), "yyyy/MM/dd");
		return d1.getTime() <= d2.getTime();

	}

	/**
	 * d1 是否小于d2
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean isAgoNoEqual(Date d1, Date d2) {
		d1 = textToDate(format(d1), "yyyy/MM/dd");
		d2 = textToDate(format(d2), "yyyy/MM/dd");
		return d1.getTime() < d2.getTime();

	}

	public static String format(Date date, String patern) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat formater = new SimpleDateFormat(patern);
		return formater.format(date);
	}

	/**
	 * java.util.Date类型转换成xx年xx月xx日
	 * 
	 */
	public static String getStringDate(Date date) {
		String resultString = "";
		String tempString = format(date, "yyyy-MM-dd");
		String[] sub = tempString.split("-");

		if (sub.length >= 0) {
			resultString = sub[0] + "年" + sub[1] + "月" + sub[2] + "日";
		}
		return resultString;

	}

	/**
	 * 字符串转成Date型
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date textToDate(String dateStr, String pattern) {
		try {
			Date date = new SimpleDateFormat(pattern).parse(dateStr);
			return date;
		} catch (ParseException e) {
			// TODO 自动生成 catch 块

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 判断date是否在flag之前
	 */
	public static boolean isBefore(Date flag, Date date) {
		return date.getTime() < flag.getTime();
	}

	/**
	 * 判断date是否在flag之前或相等
	 */
	public static boolean isBeforeOrEquals(Date flag, Date date) {
		return date.getTime() <= flag.getTime();
	}

	/**
	 * 判断date是否在flag之后
	 */
	public static boolean isAfter(Date flag, Date date) {
		return date.getTime() > flag.getTime();
	}

	/**
	 * 判断date是否在flag之后或相等
	 */
	public static boolean isAfterOrEquals(Date flag, Date date) {
		return date.getTime() >= flag.getTime();
	}

	public static boolean isStartWrap(Date flagStart, Date flagEnd, Date dateStart) {
		return dateStart.before(flagEnd) && dateStart.after(flagStart)
				|| dateStart.equals(flagStart) || dateStart.equals(flagEnd);
	}

	public static boolean isEndWrap(Date flagStart, Date flagEnd, Date dateEnd) {
		return dateEnd.before(flagEnd) && dateEnd.after(flagStart)
				|| dateEnd.equals(flagStart) || dateEnd.equals(flagEnd);
	}

	/**
	 * example: DateUtil.getYear(new Date(182,4,7)) <p/> result: 1982
	 */
	public static int getYear(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return year;
	}

	/**
	 * example: DateUtil.getMonth(new Date(182,4,7)) <p/> result: 5
	 */
	public static int getMonth(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH) + 1;
		return month;
	}

	/**
	 * @
	 */
	/**
	 * example: DateUtil.getDate(new Date(182,4,7)) <p/> result: 7
	 */
	public static int getDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int date2 = calendar.get(Calendar.DATE);
		return date2;
	}
	
	public static int getHour(Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	
	public static int getMinute(Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int minute = calendar.get(Calendar.MINUTE);
		return minute;
	}

	/**
	 * example: DateUtil.addYears(new Date(182,4,7), 22) <p/> result: 2004年5月7日
	 * 
	 */
	public static Date addYears(Date date, int yearNum) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, yearNum);
		return calendar.getTime();
	}

	/**
	 * example: DateUtil.addMonths(new Date(182,4,7), 13) <p/> result: 1983年6月7日
	 * 
	 */
	public static Date addMonths(Date date, int monthNum) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, monthNum);
		return calendar.getTime();
	}
	
	public static Date addHours(Date date, int hourNum) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, hourNum);
		return calendar.getTime();
	}


	/**
	 * 日期比较函数，相等返回0,大于大于零的值,小于返回小于零的值
	 */ 
	public static int dateCompare(Date dateA, Date dateB) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datea = format.format(dateA);
		String dateb = format.format(dateB);
		return datea.compareTo(dateb);
	}

	/**
	 * 
	 * 为date加上dateNum天数之后的日期
	 * 
	 */
	public static Date addDates(Date date, int dateNum) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, dateNum);
		return calendar.getTime();
	}

	/**
	 * example: DateUtil.createDate(1982,5,7) <p/> result: 1982年5月7日
	 * 
	 */
	public static Date createDate(int year, int month, int date) {
		Calendar calendar = new GregorianCalendar(year, month - 1, date);
		return calendar.getTime();
	}

	/**
	 * 将指定格式的日期/时间字符串转换成Date格式
	 * 
	 * @param strDate
	 *            String类型，日期字符
	 * @param strFormat
	 *            String类型，格式
	 * @return Date类型
	 * @throws java.lang.Exception
	 */
	public static java.util.Date toUtilDate(String strDate, String strFormat) {
		try {
			if (strDate == null || strDate.equals("")) {
				return null;
			} else {
				SimpleDateFormat _formatdate = new SimpleDateFormat(strFormat, Locale
						.getDefault());
				java.util.Date _date = new java.util.Date((_formatdate.parse(strDate))
						.getTime());
				return _date;
			}
		} catch (Exception ex) {
			// ex.printStackTrace();
			// return null;
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 将指定格式的日期/时间字符串转换成Date格式
	 * 
	 * @param strDate
	 *            String类型，日期字符
	 * @param strFormat
	 *            String类型，格式
	 * @return Date类型
	 * @throws java.lang.Exception
	 */
	public static java.sql.Date toSQLDate(String strDate, String strFormat) {
		try {
			if (strDate == null || strDate.equals("")) {
				return null;
			} else {
				SimpleDateFormat _formatdate = new SimpleDateFormat(strFormat, Locale
						.getDefault());
				java.sql.Date _date = new java.sql.Date((_formatdate.parse(strDate))
						.getTime());
				return _date;
			}
		} catch (Exception ex) {
			// ex.printStackTrace();
			// return null;
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 取得系统当前时间
	 */
	public static String getCurrentSysTime(int iType) {

		Date dtNow = new Date(System.currentTimeMillis());

		String dateString = "";

		try {
			SimpleDateFormat formatter = null;
			switch (iType) {
			case 1:
				formatter = new SimpleDateFormat("yyyy.MM.dd");
				break;
			case 2:
				formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
				break;
			case 3:
				formatter = new SimpleDateFormat("yyyy.MM.dd hh:mm a");
				break;
			case 4:
				formatter = new SimpleDateFormat("yyyy-MM-dd");
				break;
			case 5:
				formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				break;
			case 6:
				formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm a");
				break;
			default:
				formatter = new SimpleDateFormat("yyyy.MM.dd");
				break;
			}
			dateString = formatter.format(dtNow);
		} catch (Exception e) {
			dateString = "";
		}
		return dateString;
	}

	/**
	 * 获得两个日期相隔天数
	 * 
	 * @param dtBeginDate
	 * @param dtEndDate
	 * @return
	 */
	public static long intervalDays(Date dtBeginDate, Date dtEndDate) {
		GregorianCalendar gc1, gc2;
		gc1 = new GregorianCalendar();
		gc1.setTime(dtBeginDate);
		gc2 = new GregorianCalendar();
		gc2.setTime(dtEndDate);
		gc1.clear(Calendar.MILLISECOND);
		gc1.clear(Calendar.SECOND);
		gc1.clear(Calendar.MINUTE);
		gc1.clear(Calendar.HOUR_OF_DAY);
		gc2.clear(Calendar.MILLISECOND);
		gc2.clear(Calendar.SECOND);
		gc2.clear(Calendar.MINUTE);
		gc2.clear(Calendar.HOUR_OF_DAY);
		long lInterval = 0;
		lInterval = gc2.getTime().getTime() - gc1.getTime().getTime();
		lInterval = lInterval / (24 * 60 * 60 * 1000);
		return lInterval;
	}

	/**
	 * 取当月第一天，输出格式：YYYY-MM-DD
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Date getFirstDayOfMonth(Date date) {
		StringBuffer newDate = new StringBuffer();
		newDate.append(getYear(date)).append("-");
		newDate.append(getMonth(date)).append("-");
		newDate.append("1");
		return toSQLDate(newDate.toString(), "yyyy-MM-dd");
	}

	/**
	 * 取当月最后一天，输出格式：YYYY-MM-DD
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Date getLastDayOfMonth(Date date) {
		Integer year = getYear(date);
		Integer[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 闰年判断
		if (year / 4 == 0 || (year / 100 == 0 && year / 400 == 0)) {
			monthArray[1] = 29;
		}
		Integer month = getMonth(date);
		StringBuffer newDate = new StringBuffer();
		newDate.append(year).append("-");
		newDate.append(month).append("-");
		newDate.append(monthArray[month - 1]);
		return toSQLDate(newDate.toString(), "yyyy-MM-dd");
	}

	/**
	 * 取当年第一天，输出格式：YYYY-MM-DD
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Date getFirstDayOfYear(Date date) {
		StringBuffer newDate = new StringBuffer();
		newDate.append(getYear(date)).append("-");
		newDate.append("1-1");
		return toSQLDate(newDate.toString(), "yyyy-MM-dd");
	}

	/**
	 * 将JAVA DATE型转成sql Date 输出格式：YYYY-MM-DD
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Date utilDate_2_sqlDate(Date date) {
		StringBuffer newDate = new StringBuffer();
		newDate.append(getYear(date)).append("-");
		newDate.append(getMonth(date)).append("-");
		newDate.append(getDate(date));
		return toSQLDate(newDate.toString(), "yyyy-MM-dd");
	}

	/**
	 * 只精确到日期，舍去时分秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date correctToDate(Date date) {
		GregorianCalendar gc1 = new GregorianCalendar();
		gc1.setTime(date);
		gc1.clear(Calendar.MILLISECOND);
		gc1.clear(Calendar.SECOND);
		gc1.clear(Calendar.MINUTE);
		gc1.clear(Calendar.HOUR_OF_DAY);
		return gc1.getTime();
	}

	public static Date getLastMonthDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, month - 1);
		return calendar.getTime();
	}

	// 将日期加一天
	public static Date addOneDay(Date date) {

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.DATE, 1);
		Date newdate = calendar.getTime();
		return newdate;
	}

	public static void main(String[] args) {
		// Calendar calendar = Calendar.getInstance();
		// calendar.set(2010, 12, 31);
		// System.out.println("date = " + new
		// DateUtil().Dateformat(calendar.getTime()));
		// String result = new
		// DateUtil().Dateformat(getLastMonthDate(calendar.getTime()));
		// System.out.println("lastMonthDate="+result);

		System.out.println(DateUtil.addOneDay(new Date()));

	}
}