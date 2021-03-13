import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    MyDate inputInteger = new MyDate(10, 10, 2020);
    MyDate inputString;

    {
        try {
            inputString = new MyDate("December 10 2020");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    MyDate currentDay;

    {
        try {
            currentDay = new MyDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getDay() {
//        Test with integer input
        assertEquals(10, inputInteger.getDay());
//        test with string input
        assertEquals(10, inputString.getDay());
//    Test with current day. To day i 13
        assertEquals(13, currentDay.getDay());
    }

    @Test
    void getMonth() {
        //        Test with integer input
        assertEquals(10, inputInteger.getMonth());
//        test with string input
        assertEquals(12, inputString.getMonth());
//    Test with current day. To day i 13
        assertEquals(3, currentDay.getMonth());
    }

    @Test
    void getYear() {
        //        Test with integer input
        assertEquals(2020, inputInteger.getYear());
//        test with string input
        assertEquals(2020, inputString.getYear());
//    Test with current day. To day i 13
        assertEquals(2021, currentDay.getYear());
    }
}