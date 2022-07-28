package util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Earlier tried methods
 *   //LocalDateTime localDateTime = LocalDateTime.now();
 *       //  DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
 *        // String formattedDateTime = localDateTime.format(dateTimeFormatter);
 *
 *         //Date date = new Date();
 *        // return date.toString().replaceAll(":","_").replaceAll("","_");
 *         //return formattedDateTime;
 */

public class DateUtil {

    public static String getTimeStamp() {
        String timeStamp = new SimpleDateFormat("dd-MM-yyy HH-mm-ss").format(new Date());
        return timeStamp;


    }
}
