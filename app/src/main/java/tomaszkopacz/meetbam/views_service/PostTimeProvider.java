package tomaszkopacz.meetbam.views_service;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tomas on 09.03.2018.
 */

public class PostTimeProvider {

    /**
     * Counts time interval between now and given timestamp in past. The timestamp
     * should be given in "yyyy-MM-dd HH:mm:ss.SSSSSS" pattern. The result is time in minutes.
     * @param timestamp
     * @return time interval started from timestamp and ending now. If error occurs, returns -1.
     */
    public static float countTimeAgo(String timestamp){

        // date pattern
        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        simpleDateFormat.setLenient(false);

        // time interval
        float diff;

        try {
            // convert timestamp to given pattern
            Date timestampDate = simpleDateFormat.parse(timestamp);

            // get actual date and convert to pattern
            Date date = new Date();
            simpleDateFormat.format(date);

            // count difference in millis
            diff = date.getTime() - timestampDate.getTime();

            // convert millis to minutes
            diff = diff/(1000*60);

        } catch (ParseException e) {
            return -1;
        }

        if (diff < 0)
            return -1;

        else
            return diff;
    }

    /**
     * Returns text according to a given time. If time is less than 1h, returns
     * result in minutes. If time is less than a day, returns result in hours. Otherwise,
     * returns result in days.
     * For example:<br/>
     * If parameter is 1 minute returns "1 minute ago".<br/>
     * If parameter is 45 minutes returns "45 minutes ago".<br/>
     * If parameter is 130 minutes returns "2 hours ago".<br/>
     * If parameter is 1450 minutes returns "1 day ago". <br/>
     * If given time is less than zero, returns "TIME ERROR" message.
     * @param timeAgo time given in minutes
     * @return text about how many time went off approximately
     */
    public static String getTimeAgoText(float timeAgo){

        if (timeAgo < 0)
            return "TIME ERROR";
        else if (timeAgo == 1)
            return "1" + " minute ago";
        else if (timeAgo < 60)
            return String.valueOf(Math.round(timeAgo)) + " minutes ago";
        else if (timeAgo < 120)
            return "1" + " hour ago";
        else if (timeAgo < 1440)
            return String.valueOf(Math.round(timeAgo/60)) + " hours ago";
        else if (timeAgo < 2880)
            return "1" + " day ago";
        else
            return String.valueOf(Math.round(timeAgo/(60*24))) + " days ago";
    }
}
