package tomaszkopacz.meetbam.service;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

/**
 * Created by tomas on 09.03.2018.
 */

public class PostTimeProviderTest {

    @Test
    /**
     * Test countTimeAgoInMin(). Should return value greater than 0.
     */
    public void testCountTimeAgo(){
        String date = "2018-03-08 23:28:07.001234";
        assertTrue(PostTimeProvider.INSTANCE.countTimeAgo(date) > 0);
    }

    @Test
    /**
     * Test countTimeAgoInMin(). When incorrect argument should return -1.
     */
    public void testCountTimeAgoWhenIncorrectArgument(){

        String argument = "xxx 123 meetbam";

        assertTrue(PostTimeProvider.INSTANCE.countTimeAgo(argument) == -1);
    }

    @Test
    /**
     * Test countTimeAgoInMin(). When incorrect argument should return -1.
     */
    public void testCountTimeAgoWhenIncorrectArgumentPattern(){
        String pattern1 = "2018.03.08 23:30:58";
        String pattern2 = "2010/01/30 12:00:00";
        String pattern3 = "30 Jun 2010 12/00/00";

        assertTrue(PostTimeProvider.INSTANCE.countTimeAgo(pattern1) == -1);
        assertTrue(PostTimeProvider.INSTANCE.countTimeAgo(pattern2) == -1);
        assertTrue(PostTimeProvider.INSTANCE.countTimeAgo(pattern3) == -1);
    }

    @Test
    /**
     * Test countTimeAgoInMin(). When incorrect date should return -1.
     */
    public void testCountTimeAgoWhenIncorrectDate(){
        String date = "2010-15-90 12:00:00";
        assertTrue(PostTimeProvider.INSTANCE.countTimeAgo(date) == -1);
    }

    @Test
    /**
     * Test countTimeAgoInMin(). When incorrect date should return -1.
     */
    public void testCountTimeAgoWhenDateTooBig(){
        String date = "5000-01-30 12:00:00";
        assertTrue(PostTimeProvider.INSTANCE.countTimeAgo(date) == -1);
    }

    @Test
    /**
     * Test getTimeAgo() method. When time is less than zero should return "TIME ERROR".
     */
    public void testGetTimeAgoTextWhenArgumentIsLessThanZero(){
        float time = -100;
        assertTrue(PostTimeProvider.INSTANCE.getCustomTimeAgoText(time).equals("TIME ERROR"));
    }

    @Test
    /**
     * Test getTimeAgo() method. When time is less than 60 should return minutes
     * considering grammar for singular.
     */
    public void testGetTimeAgoTextForMinutes(){
        float time1 = 1;
        float time2 = 45;
        assertTrue(PostTimeProvider.INSTANCE.getCustomTimeAgoText(time1).equals("1 minute ago"));
        assertTrue(PostTimeProvider.INSTANCE.getCustomTimeAgoText(time2).equals("45 minutes ago"));
    }

    @Test
    /**
     * Test getTimeAgo() method. When time is less than 60*24 = 1440 should return hours
     * considering grammar for singular.
     */
    public void testGetTimeAgoTextForHours(){

        // example: 1h and 10 minutes = 60 + 10 = 70 min -> approximately 1h
        float time1 = 70;

        // example: 15h and 15 minutes = 15*60 + 15 = 915 min -> approximately 15h
        float time2 = 915;
        assertTrue(PostTimeProvider.INSTANCE.getCustomTimeAgoText(time1).equals("1 hour ago"));
        assertTrue(PostTimeProvider.INSTANCE.getCustomTimeAgoText(time2).equals("15 hours ago"));
    }

    @Test
    /**
     * Test getTimeAgo() method. When time is bigger than 60*24 = 1440 should return days
     * considering grammar for singular.
     */
    public void testGetTimeAgoTextForDays(){

        // example: a day and 2 hours = 24*60 + 2*60 = 1560 -> approximately 1 day
        float time1 = 1560;

        // example: 20 days and 4h = 20*24*60 + 4*60 = 29040 minutes -> approximately 20 days
        float time2 = 29040;

        assertTrue(PostTimeProvider.INSTANCE.getCustomTimeAgoText(time1).equals("1 day ago"));
        assertTrue(PostTimeProvider.INSTANCE.getCustomTimeAgoText(time2).equals("20 days ago"));
    }
}
