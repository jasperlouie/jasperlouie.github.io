
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  This class consists of utility methods to simplify Date processing using the DateFormat class
 *
 *  @author	Jasper Louie
 *  @version	0.1
 * 
 */
public class DateUtil
{
	
   /**
    * Given a string of the format 7/31/11 (month/day/year) returns a 
    * Date object
    *
    * @param	dateStr	 the string of the date to be parsed
    * @return the Date object for the date string
    */
   public static Date parseDate( String dateStr ) {
     if ( dateStr == null )
       return null;
     Date date = null;
     try {
       DateFormat dateFormat = new SimpleDateFormat( "M/d/yy" );
       date = dateFormat.parse( dateStr );
     } catch ( ParseException e ) {
       return null;
     }
     return date;
   }
   
   /**
    *Checks the validity of the Month field of the given Date String
    *
    * @param	dateStr	Date in String Form
    * @return a boolean declaring whether the month is a valid month or not
    */
   public static boolean isValidMonth(String dateStr){
	   int end = dateStr.indexOf("/");
	   String month =dateStr.substring(0, end);
	   if(Integer.parseInt(month)>12||month.length()!=2){
		   return false;
	   }else{
		   return true;
	   }
   }
   
   /**
    *Checks the validity of the Year field of the given Date String
    *
    * @param	dateStr	Date in String Form
    * @return a boolean declaring whether the Year is a valid month or not
    */
   public static boolean isValidYear(String dateStr){
	   int end = dateStr.indexOf("/");
	   String year =dateStr.substring(end+1);
	   if(Integer.parseInt(year)<0||Integer.parseInt(year)>3000||year.length()!=4){
		   return false;
	   }else{
		   return true;
	   }
   }
   
   /**
    * Given a string of the format 7/11 (month/year) returns a 
    * Date object
    *
    * @param	dateStr	the string of the date to be parsed
    * @return the Date object for the date string
    */
   public static Date parseShortDate( String dateStr ) {
	     if ( dateStr == null )
	       return null;
	     Date date = null;
	     try {
	       DateFormat dateFormat = new SimpleDateFormat( "M/yy" );
	       date = dateFormat.parse( dateStr );
	     } catch ( ParseException e ) {
	       return null;
	     }
	     return date;
	   }

   /**
    * Returns today as a date object.
    *
    * @return the Date object for today.
    */
   public static Date today() {
     return new Date();
   }

   /**
    * Returns a Date object given month, day, and year as integers.
    *
    * @return the Date object for the created date.
    */
   public static Date getDate( int month, int day, int year ) {
     Calendar theCalendar = Calendar.getInstance();
     theCalendar.set( year, month, day );
     return theCalendar.getTime();
   }

   /**
    * Returns a Date object two weeks into the future.
    *
    * @return the Date object for 14 days from the current date.
    */
   public static Date getDateTwoWeeksLater() {
     Calendar theCalendar = Calendar.getInstance();
     theCalendar.setLenient( true );
     theCalendar.add( Calendar.DAY_OF_YEAR, 14 );
     return theCalendar.getTime();
   }
   
   /**
    * Returns a date formatted String for a Date object
    *
    * @param	d	a Date
    * @return the String for that date in MM/dd/yy format
    */
   public static String printDate(Date d){
	   DateFormat dateFormat = new SimpleDateFormat( "MM/dd/yyyy" );
	   return dateFormat.format(d);
   }
   
   /**
    * Returns a date formatted String for a Date object
    *
    * @param	d	a Date
    * @return the String for that date in MM/yyyy format
    */
   public static String printShortDate(Date d){
	   DateFormat dateFormat = new SimpleDateFormat( "MM/yyyy" );
	   return dateFormat.format(d);
   }
   
   /**
    * Returns a boolean detailing whether the String contains a digit
    *
    * @param	str	A String
    * @return 	result	a boolean detailing whether the given String contains a number
    */
   public static boolean containsNumber(String str){
	  boolean result = false;
	   for(int i = 0; i < str.length(); i++){
		  if(Character.isDigit(str.charAt(i))){
			  result = true;
		  }
	  }
	   return result;
   }
}
