package com.util.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



//import com.bull.framework.dmd.DMDException;
//import com.bull.framework.dmd.EntityManager;
//import com.bull.iris.cfg.dao.TG21_PUBLIC_HOLIDAYSDAO;

//import com.bull.iris.util.ErisException;

/**
 * This class is used for all computations related to whether a day is a working
 * day or not.
 * 
 * It can also give you the next working day of a given date.
 * 
 * java.sql.Timestamp extends java.util.Date, so feel free to pass some
 * Timestamp objects as parameters.
 * 
 * @author EC
 * 
 */
public class WorkingDaysUtil {

	private static final long msInDay = 1000 * 60 * 60 * 24L;

	// No need for instances since this is a utility class with static methods.
	private WorkingDaysUtil() {}
	
	public static Timestamp getNextWorkingDay(Date date) throws Exception
	{
		Date newDate = new Date(date.getTime()+msInDay);
		return getEnforcedWorkingDay(newDate);
	}

	/**
	 * Returns a Timestamp object containing the next working day if the date is
	 * not a working day, or a Timestamp set to the same date in case it is a
	 * working day.
	 * @throws DMDException 
	 */
	public static Timestamp getEnforcedWorkingDay(Date date){
//		try{
			Date dateStripped = (Date)date.clone();
			stripTimeInfo(dateStripped);
	
			List<TG21_PUBLIC_HOLIDAYS> holidays = getImpactingHolidaysSingleDay(dateStripped);
	
			boolean isWorkingDay = isWorkingDay(dateStripped, holidays);
			// We keep going to the next potential working day until we reach one
			while (!isWorkingDay) {
				// We check for forced day in the holidays
				dateStripped.setTime(dateStripped.getTime() + msInDay);
				isWorkingDay = isWorkingDay(dateStripped, holidays);
			}
			return new Timestamp(dateStripped.getTime());
//		}catch (Exception e) {
//			throw new Exception("getEnforcedWorkingDay Exception",e);
//		}
		// If we are here it means we have a working day.
		
	}

	/**
	 * @param date
	 * @return true if date is a working day (forced or not), false if it is a
	 *         week end or an holiday (but not a forced working day).
	 * @throws DMDException 
	 */
	public static boolean isWorkingDay(Date date) throws Exception {
		Date dateStripped = (Date) date.clone();
		stripTimeInfo(dateStripped);
		return isWorkingDay(dateStripped, getImpactingHolidaysSingleDay(date));
	}
	/**
	 * 
	 * @param startdate
	 * @param enddate
	 * @return get a hash map between start date to end date that specified which date is work date or work off.
	 * 		   if Boolean in map is true that means it's work date.
	 * @throws DMDException 
	 */
	public static java.util.Map<String,Boolean> getAllDays(java.util.Date startdate,java.util.Date enddate) throws Exception{
		java.util.Map<String, Boolean> datemap=new java.util.HashMap<String, Boolean>();		
		java.util.Calendar start_calendar =java.util.Calendar.getInstance();
		start_calendar.setLenient(true);
		start_calendar.setTime(startdate);
		java.util.Calendar end_calendar =java.util.Calendar.getInstance();
		end_calendar.setLenient(true);
		end_calendar.setTime(enddate);
		
		while(!start_calendar.after(end_calendar)){
			datemap.put(start_calendar.get(java.util.Calendar.MONTH)+" "+start_calendar.get(java.util.Calendar.DATE)+" "+start_calendar.get(java.util.Calendar.YEAR), isWorkingDay(new Timestamp(start_calendar.getTime().getTime())));
			start_calendar.add(java.util.Calendar.DATE, 1);
		}
		
		return datemap;
	}

	/**
	 * 
	 * @param startdate
	 * @param enddate
	 * @return get a hash map between start date to end date that specified which date is work date or work off.
	 * 		   if Boolean in map is true that means it's work date.
	 * @throws DMDException 
	 */
	public static java.util.List<Date> getAllWorkingDays(java.util.Date startdate,java.util.Date enddate) {
		java.util.List<Date> listDates = new java.util.ArrayList<Date>();		
		java.util.Calendar start_calendar =java.util.Calendar.getInstance();
		start_calendar.setLenient(true);
		start_calendar.setTime(startdate);
		java.util.Calendar end_calendar =java.util.Calendar.getInstance();
		end_calendar.setLenient(true);
		end_calendar.setTime(enddate);
		try{
		while(!start_calendar.after(end_calendar)){
			if (isWorkingDay(new Timestamp(start_calendar.getTime().getTime())))
			{
				listDates.add(new Date(start_calendar.getTimeInMillis()));
			}
			start_calendar.add(java.util.Calendar.DATE, 1);
		}
		}catch (Exception e) {
			//throw new Exception("getAllWorkingDays Exception",e);
		}
		
		return listDates;
	}
	
	
	/**
	 * Count the number of Non Working days passed between a given startDate and EndDate
	 * @param startDate provides the starting date we are checking either it is a working date of not.
	 * @param endDate provides the date (included) when the count will be completed
	 * @return integer, the number of days which can be considered as Non Working Days
	 * @throws DMDException 
	 **/
	public static int countNonWorkingDays(Date startDate, Date endDate) throws Exception
	{
		int count = 0;
		Calendar cursorDate = Calendar.getInstance(); 
		cursorDate.setTime(startDate);
		
		List<TG21_PUBLIC_HOLIDAYS> holidays = getImpactingHolidays(startDate, endDate);
		
		while (endDate.before (cursorDate.getTime()) == false)
		{
			Date d = (Date)cursorDate.getTime().clone();
			stripTimeInfo(d);
			if (isWorkingDay(new Timestamp(d.getTime()), holidays) == false)
			{
				count ++;
			}
			cursorDate.add(Calendar.DATE, 1);
		}
		
		return count;
	}
	
	/**
	 * Removes all the time info, keeping only date data.
	 * 
	 * @param d
	 */
	private static void stripTimeInfo(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		// resetting time, we only want the year, month and days.
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		d.setTime(cal.getTimeInMillis());
	}

	static int compareIgnoreYear(Date d1, Date d2) {
		Date d1noYear = new Date(d1.getTime());
		d1noYear.setYear(2000);
		Date d2noYear = new Date(d2.getTime());
		d2noYear.setYear(2000);

		return (d1noYear.compareTo(d2noYear));
	}

	/**
	 * Returns true if the day is a working day (according to the list of
	 * holidays and the week end days), false else.
	 * 
	 * @param date
	 * @param holidays
	 *            List of holidays that might impact this date.
	 * @return
	 */
	private static boolean isWorkingDay(Date date,
			List<TG21_PUBLIC_HOLIDAYS> holidays) {
		boolean isHoliday = false;
		// First, check whether the date is a forced working day or a holiday
		for (TG21_PUBLIC_HOLIDAYS holiday : holidays) {
			// Check whether each holiday impacts this date or not
			if ("Y".equals(holiday.getCg21_reoccurring())) { // Ignore year
				if (holiday.getCg21_end_reoccur_date() == null) { // Only one
					// day
					if (0 == compareIgnoreYear(holiday.getCg21_holiday_date(),
							date)) {
						if ("Y".equals(holiday.getCg21_is_working_day())) {
							return true;
						} else {
							isHoliday = true;
						}
					}
				} else { // period
					// if date is in the period
					if (compareIgnoreYear(date, holiday.getCg21_holiday_date()) >= 0
							&& compareIgnoreYear(date, holiday
									.getCg21_end_reoccur_date()) <= 0) {

						if ("Y".equals(holiday.getCg21_is_working_day())) {
							return true;
						} else {
							isHoliday = true;
						}
					}
				}
			} else { // Check full date
				if (holiday.getCg21_end_reoccur_date() == null) { // Only one
					// day
					if (0 == (holiday.getCg21_holiday_date()).compareTo(date)) {
						if ("Y".equals(holiday.getCg21_is_working_day())) {
							return true;
						} else {
							isHoliday = true;
						}
					}
				} else { // period
					// if date is in the period
					if (date.compareTo(holiday.getCg21_holiday_date()) >= 0
							&& date.compareTo(holiday
									.getCg21_end_reoccur_date()) <= 0) {

						if ("Y".equals(holiday.getCg21_is_working_day())) {
							return true;
						} else {
							isHoliday = true;
						}
					}
				}
			}
		}

		// If at the end, it's only a holiday, return false.
		if (isHoliday) {
			return false;
		}

		// Then if it is a week end, return false, else return true.
		if (isWeekEndDay(date)) {
			return false;
		}
		return true;
	}

	/**
	 * Returns all the records from table TG21_PUBLIC_HOLIDAYS that might impact
	 * every single dates between a start date and an end date.
	 * 
	 * This includes all recurring dates, plus non-recurring dates starting
	 * after or finishing after the date d.
	 * 
	 * Both holidays and forced working days are returned (with working days
	 * first in theory).
	 * 
	 * @param startDate
	 * @param endDate
	 * @throws DMDException 
	 */
	@SuppressWarnings("unchecked")
	private static List<TG21_PUBLIC_HOLIDAYS> getImpactingHolidays(Date startDate, Date endDate) {

		if (startDate == null || endDate == null) {
			return new ArrayList<TG21_PUBLIC_HOLIDAYS>();
		}
		if (startDate.after(endDate)){
			return new ArrayList<TG21_PUBLIC_HOLIDAYS>();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStrStart = sdf.format(startDate);
		String dateStrEnd = sdf.format(endDate);
		List<TG21_PUBLIC_HOLIDAYS> holidays = null;
		
/** find the hholidays from DB		
		EntityManager entityManager = EntityManager.getInstance();
		ArrayList paraList = new ArrayList();
		paraList.add(dateStrStart);
		paraList.add(dateStrEnd);
		List<TG21_PUBLIC_HOLIDAYS> holidays = entityManager.customFind("TG21_PUBLIC_HOLIDAYS", "findHolidays", paraList);;
*/		
		// Stripping time info
		for (TG21_PUBLIC_HOLIDAYS holiday : holidays) {
			stripTimeInfo(holiday.getCg21_holiday_date());
			if (holiday.getCg21_end_reoccur_date() != null) {
				stripTimeInfo(holiday.getCg21_end_reoccur_date());
			}
		}

		return holidays;
	}
	
	/**
	 * Returns all the records from table TG21_PUBLIC_HOLIDAYS that might impact
	 * the date d.
	 * 
	 * This includes all recurring dates, plus non-recurring dates starting
	 * after or finishing after the date d.
	 * 
	 * Both holidays and forced working days are returned (with working days
	 * first in theory).
	 * 
	 * @param d
	 * @return
	 * @throws DMDException 
	 */
	@SuppressWarnings("unchecked")
	private static List<TG21_PUBLIC_HOLIDAYS> getImpactingHolidaysSingleDay(Date d){
		return getImpactingHolidays(d, d);
	}

	/**
	 * Returns whether the day is a week end day, without checking whether it is
	 * a special working day.
	 * 
	 * Be careful, because of exceptions (forced working day), week-end day is
	 * not equal to non-working day.
	 * 
	 * 
	 * @param date
	 *            date to check.
	 * @return true if date is a day of the week end, false if it is not.
	 */
	public static boolean isWeekEndDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		try {
//			switch (cal.get(Calendar.DAY_OF_WEEK)) {
//				case Calendar.THURSDAY:
//					if (ErisCustomParameters.getBooleanValue("IS_THURSDAY_WEEK_END").booleanValue()) {
//						return true;
//					}
//					break;
//				case Calendar.FRIDAY:
//					if (ErisCustomParameters.getBooleanValue("IS_FRIDAY_WEEK_END").booleanValue()) {
//						return true;
//					}
//					break;
//				case Calendar.SATURDAY:
//					if (ErisCustomParameters.getBooleanValue("IS_SATURDAY_WEEK_END").booleanValue()) {
//						return true;
//					}
//					break;
//				case Calendar.SUNDAY:
//					if (ErisCustomParameters.getBooleanValue("IS_SUNDAY_WEEK_END").booleanValue()) {
//						return true;
//					}
//					break;
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
class TG21_PUBLIC_HOLIDAYS{
    private static final long serialVersionUID = 1L;
    private Long   cg21_holiday_id;
    private String cg21_reoccurring;
    private String cg21_audit_trail_action;
    private Timestamp cg21_audit_trail_date;
    private String cg21_audit_trail_user;
    private Timestamp cg21_end_reoccur_date;
    private Timestamp cg21_holiday_date;
    private String cg21_holiday_desc;
    private String cg21_is_working_day;
    private String cg21_religious;
	public Long getCg21_holiday_id() {
		return cg21_holiday_id;
	}
	public void setCg21_holiday_id(Long cg21HolidayId) {
		cg21_holiday_id = cg21HolidayId;
	}
	public String getCg21_reoccurring() {
		return cg21_reoccurring;
	}
	public void setCg21_reoccurring(String cg21Reoccurring) {
		cg21_reoccurring = cg21Reoccurring;
	}
	public String getCg21_audit_trail_action() {
		return cg21_audit_trail_action;
	}
	public void setCg21_audit_trail_action(String cg21AuditTrailAction) {
		cg21_audit_trail_action = cg21AuditTrailAction;
	}
	public Timestamp getCg21_audit_trail_date() {
		return cg21_audit_trail_date;
	}
	public void setCg21_audit_trail_date(Timestamp cg21AuditTrailDate) {
		cg21_audit_trail_date = cg21AuditTrailDate;
	}
	public String getCg21_audit_trail_user() {
		return cg21_audit_trail_user;
	}
	public void setCg21_audit_trail_user(String cg21AuditTrailUser) {
		cg21_audit_trail_user = cg21AuditTrailUser;
	}
	public Timestamp getCg21_end_reoccur_date() {
		return cg21_end_reoccur_date;
	}
	public void setCg21_end_reoccur_date(Timestamp cg21EndReoccurDate) {
		cg21_end_reoccur_date = cg21EndReoccurDate;
	}
	public Timestamp getCg21_holiday_date() {
		return cg21_holiday_date;
	}
	public void setCg21_holiday_date(Timestamp cg21HolidayDate) {
		cg21_holiday_date = cg21HolidayDate;
	}
	public String getCg21_holiday_desc() {
		return cg21_holiday_desc;
	}
	public void setCg21_holiday_desc(String cg21HolidayDesc) {
		cg21_holiday_desc = cg21HolidayDesc;
	}
	public String getCg21_is_working_day() {
		return cg21_is_working_day;
	}
	public void setCg21_is_working_day(String cg21IsWorkingDay) {
		cg21_is_working_day = cg21IsWorkingDay;
	}
	public String getCg21_religious() {
		return cg21_religious;
	}
	public void setCg21_religious(String cg21Religious) {
		cg21_religious = cg21Religious;
	}
}

/*DB SCRIPT
CREATE TABLE [CFG_INTG].[TG21_PUBLIC_HOLIDAYS](
	[CG21_HOLIDAY_ID] [numeric](6, 0) NOT NULL,
	[CG21_HOLIDAY_DATE] [datetime] NOT NULL,
	[CG21_HOLIDAY_DESC] [nvarchar](200) COLLATE Arabic_CI_AS NOT NULL,
	[CG21_REOCCURRING] [nchar](1) COLLATE Arabic_CI_AS NOT NULL DEFAULT ('N'),
	[CG21_RELIGIOUS] [nchar](1) COLLATE Arabic_CI_AS NOT NULL DEFAULT ('N'),
	[CG21_END_REOCCUR_DATE] [datetime] NULL,
	[CG21_AUDIT_TRAIL_ACTION] [nvarchar](30) COLLATE Arabic_CI_AS NOT NULL,
	[CG21_AUDIT_TRAIL_DATE] [datetime] NOT NULL,
	[CG21_AUDIT_TRAIL_USER] [nvarchar](50) COLLATE Arabic_CI_AS NOT NULL,
	[AR_CG21_HOLIDAY_DESC] [nvarchar](200) COLLATE Arabic_CI_AS NULL,
	[CG21_IS_WORKING_DAY] [nchar](1) COLLATE Arabic_CI_AS NULL DEFAULT ('N'),
 CONSTRAINT [TG21_PK] PRIMARY KEY CLUSTERED 
(
	[CG21_HOLIDAY_ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [INDEX]
) ON [INDEX] 

 SQl:
 
select * 
from TG21_PUBLIC_HOLIDAYS 
where
(CG21_REOCCURRING='N' and 
	(cg21_holiday_date &gt;= ERIS_INTG.eris_char_to_date(#dateStrStart#) OR 
		CG21_END_REOCCUR_DATE &gt;= ERIS_INTG.eris_char_to_date( #dateStrEnd# ))) 
OR (CG21_REOCCURRING='Y') 
ORDER BY CG21_IS_WORKING_DAY DESC
 

 */