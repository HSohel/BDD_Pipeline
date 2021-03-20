package utilities;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    public static String returnNextMonth(){
        //Create Date object
        Date dNow=new Date();

        //Create Calender object for Gregorian Calender
        Calendar calender= new GregorianCalendar();
        calender.setTime(dNow);

        //Create object for sample date format
        //Defining date format to - example : (Jan-2020)
        SimpleDateFormat sdf=new SimpleDateFormat("MMM-yyyy");

        //Incrementing the current month
        calender.add(calender.MONTH,1);
        //Getting date based on specified format
        String date=sdf.format(calender.getTime());
        return date;
    }
}
