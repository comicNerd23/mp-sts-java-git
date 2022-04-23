package com.moulik.java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;


/**
 * Issues with Legacy Date Time Classes:
 * 1. Java Date Time classes are not defined consistently, we have Date Class in both java.util as well as java.sql 
 * packages. Again formatting and parsing classes are defined in java.text package.
 * 2. java.util.Date contains both date and time values whereas java.sql.Date contains only date value. Having this in 
 * java.sql package doesn’t make any sense. Also, both the classes have the same name, which is a very bad design itself.
 * 3. There are no clearly defined classes for time, timestamp, formatting, and parsing. We have java.text.DateFormat 
 * abstract class for parsing and formatting need. Usually, the SimpleDateFormat class is used for parsing and formatting
 * 4. All the Date classes are mutable, so they are not thread-safe. It’s one of the biggest problems with Java Date and 
 * Calendar classes
 * 5. Date class doesn’t provide internationalization, there is no timezone support. So java.util.Calendar and 
 * java.util.TimeZone classes were introduced, but they also have all the problems listed above.
 * 
 * 	Advantages of new Data-Time API
 * 	1. With Java 8, All classes in new Date-time API are immutable. 
 * 	2. The new Data-time clearly separates between Human-readable time and machine time.
 *	3. The methods are clearly defined and perform the same action in all the classes. For example, to get the current 
 *	instance we have now() method.
 *	4. All the new Date-Time API classes come with methods to perform common tasks, such as plus, minus, format, parsing,
 *	getting the separate part in date/time.
 *	5. The new Date Time API works on the ISO-8601 calendar system but we can use it with other non-ISO calendars as 
 *	well. So it is extendable.
 *
 *	It has following 5 packages:
 *	java.time: base package of the new Java Date Time API. All the major base classes are part of this package, such as 
 *	LocalDate, LocalTime, LocalDateTime, Instant, Period, Duration, etc. All of these classes are immutable and 
 *	thread-safe.
 *	java.time.chrono: defines generic APIs for non-ISO calendar systems. We can extend AbstractChronology class to create
 *	our own calendar system.
 *	java.time.format: for formatting and parsing date-time objects. We wont be directly using them.
 *	java.time.temporal: contains temporal objects and used to find specific dates/times related to data/time objects.
 *	java.time.zone: for supporting different time-zones.
 */
public class DateTimeDemo5 {

	public static void main(String[] args) {
		
		/*
		 * 1. LocalDate API (5): now(), now(String zoneId), of(date args), ofEpochDay(long x), 
		 * ofYearDay(int year, int day)
		 */
		
		//Current Date
        LocalDate today = LocalDate.now();
        System.out.println("Current Date="+today);
        
        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata")); 
        //LocalDate todayKolkata = LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS.get("IST"))); Same as above line
        
        System.out.println("Current Date in IST="+todayKolkata);
        
        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));
         
        //Creating LocalDate by providing input arguments: Year, Month, Day
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("Specific Date="+firstDay_2014);
         
         
        //Try creating date by providing invalid inputs
        //LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
        //Exception in thread "main" java.time.DateTimeException: 
        //Invalid date 'February 29' as '2014' is not a leap year
         
         
        //Getting date from the base date i.e 01/01/1970
        System.out.println("365th day from base date= "+LocalDate.ofEpochDay(365));
        System.out.println("LocalDate.ofEpochDay="+LocalDate.ofEpochDay(18902));	//18902 Days since 01-01-1970
         
        System.out.println("100th day of 2014="+LocalDate.ofYearDay(2014, 100));
        System.out.println("LocalDate.ofYearDay="+LocalDate.ofYearDay(1992, 297));	//297th day of the year is Oct 23
        
        System.out.println("----------------------------------------------------");
        
        /*
         * 2. LocalTime API (4): now(), now(String zoneId), of(time args), ofSecondOfDay(long seconds)
         */
        
        //Current Time
        LocalTime time = LocalTime.now();
        System.out.println("Current Time="+time);
         
        //Creating LocalTime by providing input arguments: HH:mm:ss:nss
        LocalTime specificTime = LocalTime.of(12,20,25,40);
        System.out.println("Specific Time of Day="+specificTime);
         
         
        //Try creating time by providing invalid inputs
        //LocalTime invalidTime = LocalTime.of(25,20);
        //Exception in thread "main" java.time.DateTimeException: 
        //Invalid value for HourOfDay (valid values 0 - 23): 25
         
        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Time in IST="+timeKolkata);
 
        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalTime todayIST = LocalTime.now(ZoneId.of("IST"));
         
        //Getting date from the base date i.e 01/01/1970
        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
        System.out.println("10000th second time= "+specificSecondTime);
        System.out.println("43200th second time= "+LocalTime.ofSecondOfDay(43200));
        System.out.println("46800th second time= "+LocalTime.ofSecondOfDay(46800));//13 hours
        
        System.out.println("----------------------------------------------------");
        
        /* 
         * 3. LocalDateTime API (5): now(), now(String zoneId), of(localDate, localTime), of(date and time args), 
         * ofEpochSecond(long epochSecond, int nanoOfSecond, ZoneOffset offset)
         * 
         */
        
        //Current Date
        LocalDateTime today1 = LocalDateTime.now();
        System.out.println("Current DateTime="+today1);
         
        //Current Date using LocalDate and LocalTime
        today1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("Current DateTime="+today1);
         
        //Creating LocalDateTime by providing input arguments: Year,Month,Day,HH,mm,ss
        LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
        System.out.println("Specific Date="+specificDate);
         
         
        //Try creating date by providing invalid inputs
        //LocalDateTime feb29_2014 = LocalDateTime.of(2014, Month.FEBRUARY, 28, 25,1,1);
        //Exception in thread "main" java.time.DateTimeException: 
        //Invalid value for HourOfDay (valid values 0 - 23): 25
 
        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDateTime todayKolkata1 = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST="+todayKolkata1);
 
        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //System.out.println( LocalDateTime.now(ZoneId.of("IST")));
         
        //Getting date from the base date i.e 01/01/1970
        LocalDateTime dateFromBase1 = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
        System.out.println("10000th second time from 01/01/1970= "+dateFromBase1);
        
        System.out.println("----------------------------------------------------");
        
        /*
         * 4. Instant API (3): now(), ofEpochMilli(long noOfMilliSecondsSinceEpochOf1970-01-01T00:00:00Z), 
         * Duration.ofDays(long days)
         * 
         * Instant class is used to work with machine readable time format. Instant stores date time in unix timestamp.
         */
        
        //Current timestamp
        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = "+timestamp);
         
        //Instant from timestamp
        Instant specificTime4 = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time = "+specificTime4);
         
        //Duration example
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay);
        
        System.out.println("----------------------------------------------------");

        /* 
         * 5. Java 8 DateApiUtilities (3 + 2 + 2): isLeapYear(), isBefore(LocalDate), atTime(LocalTime), plusDays(long), 
         * plusWeeks(long), plusMonths(long), minusDays(long), minusWeeks(long), minusMonths(), with(TemporalAdjusters),
         * until(LocalDate)
         * 
         * Most of the Date Time principle classes provide various utility methods such as plus/minus days, weeks, months
         * etc. There are some other utility methods for adjusting the date using TemporalAdjuster and to calculate the 
         * period between two dates.
         * 
         */
        LocalDate today5 = LocalDate.now();
        
        //Get the Year, check if it's leap year
        System.out.println("Year "+today5.getYear()+" is Leap Year? "+today5.isLeapYear());
         
        //Compare two LocalDate for before and after
        System.out.println("Today is before 01/01/2015? "+today5.isBefore(LocalDate.of(2015,1,1)));
         
        //Create LocalDateTime from LocalDate
        System.out.println("Current Time="+today5.atTime(LocalTime.now()));
        today5.getDayOfWeek().toString();
         
        //plus and minus operations
        System.out.println("10 days after today will be "+today5.plusDays(10));
        System.out.println("3 weeks after today will be "+today5.plusWeeks(3));
        System.out.println("20 months after today will be "+today5.plusMonths(20));
 
        System.out.println("10 days before today will be "+today5.minusDays(10));
        System.out.println("3 weeks before today will be "+today5.minusWeeks(3));
        System.out.println("20 months before today will be "+today5.minusMonths(20));
         
        //Temporal adjusters for adjusting the dates
        System.out.println("First date of this month= "+today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year= "+lastDayOfYear);
         
        Period period = today.until(lastDayOfYear); // eg P6Y3M1D
        System.out.println("Period Format= "+period); //P+ NoOfYears+Y + NoOfMonths+M + NoOfDays+D
        System.out.println("Months remaining in the year= "+period.getMonths());
        
        System.out.println("----------------------------------------------------");
        
        /*
         * 6. Java 8 Data Parsing and Formatting (3 + 3): 
         * 	date.format(DateTimeFormatter.ofPattern(CharSequence like "d::MMM::uuuu")),
         *  	date.format(DateTimeFormatter.ofPattern(DateTimeFormatter formatter)
         * 	time.format(DateTimeFormatter.ofPattern(CharSequence like "d::MMM::uuuu")), 
         * 		time.format(DateTimeFormatter.ofPattern(DateTimeFormatter formatter)
         * 	dateTime.format(DateTimeFormatter.ofPattern(CharSequence like "d::MMM::uuuu")), 
         * 		dateTime.format(DateTimeFormatter.ofPattern(DateTimeFormatter formatter)
         * 
         * 	date.parse(CharSequence text, DateTimeFormatter formatter)
         * 	time.parse(CharSequence text, DateTimeFormatter formatter)
         * 	dateTime.parse(CharSequence text, DateTimeFormatter formatter)
         * 
         */
        
        //Format examples
        LocalDate date = LocalDate.now();
        //default format
        System.out.println("Default format of LocalDate="+date);
        //specific format
        System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));
         
         
        LocalDateTime dateTime = LocalDateTime.now();
        //default format
        System.out.println("Default format of LocalDateTime="+dateTime);
        //specific format
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
         
        Instant timestamp6 = Instant.now();
        //default format of Instant: 2021-10-02T05:52:15.738729300Z
        System.out.println("Default format of Instant="+timestamp6);
        System.out.println("LocalDateTime from Instant="+LocalDateTime.ofInstant(timestamp6, ZoneId.of("Asia/Kolkata")));
        //Parse examples
        LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48", DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
        System.out.println("Default format after parsing = "+dt);
        
        System.out.println("----------------------------------------------------");
        
        /*
         * 7. Java Date API Legacy Date Time Support 
         * 
         */
        
        //Date to Instant
        Instant timestamp7 = new java.util.Date().toInstant();
        //Now we can convert Instant to LocalDateTime or other similar classes
        LocalDateTime date7 = LocalDateTime.ofInstant(timestamp7, 
                        ZoneId.of(ZoneId.SHORT_IDS.get("IST")));
        System.out.println("7. Date = "+date7);
         
        //Calendar to Instant
        Instant time7 = java.util.Calendar.getInstance().toInstant();
        System.out.println(time7);
        //TimeZone to ZoneId
        ZoneId defaultZone = java.util.TimeZone.getDefault().toZoneId();
        System.out.println(defaultZone);
         
        //ZonedDateTime from specific Calendar
        ZonedDateTime gregorianCalendarDateTime = new java.util.GregorianCalendar().toZonedDateTime();
        System.out.println(gregorianCalendarDateTime);
        
         
        //Date API to Legacy classes
        java.util.Date dt7 = java.util.Date.from(Instant.now());
        System.out.println(dt7);
         
        java.util.TimeZone tz = java.util.TimeZone.getTimeZone(defaultZone);
        System.out.println(tz);
         
        java.util.GregorianCalendar gc = java.util.GregorianCalendar.from(gregorianCalendarDateTime);
        System.out.println(gc);
        
        //Instant to ZonedDateTime
        java.util.Date date4 = new java.util.Date();
        final ZoneId id = ZoneId.of("Z");
        ZonedDateTime x = ZonedDateTime.ofInstant(date4.toInstant(), id);
        System.out.println("Z:"+x);
        
        
	}

}
