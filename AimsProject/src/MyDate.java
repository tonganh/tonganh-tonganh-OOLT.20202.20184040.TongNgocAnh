import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class MyDate {
    public int day;
    public int month;
    public int year;

    public void setDay(int day) {

        String month = "" + getMonth();
        String year = "" + getYear();
        String date = month + "/" + "1/" + year;
        LocalDate convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yyyy"));
        convertedDate = convertedDate.withDayOfMonth(
                convertedDate.getMonth().length(convertedDate.isLeapYear()));
        int lastDayInMonth = convertedDate.getDayOfMonth();
        if (day < 1 || day > lastDayInMonth) {
            throw new ArithmeticException("Day in valid.");
        }
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new ArithmeticException("Month invalid. Month must in range 1 to 12");
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        if (year < 0) {
            throw new ArithmeticException("Year invalid. Year must great then 0");
        }
        this.year = year;
    }

    MyDate(int day, int month, int year) {
        setMonth(month);
        setYear(year);
        setDay(day);
    }
    public void print(){
        printf();
    }
    //Input like a string
    MyDate(String date) throws ParseException {
        SimpleDateFormat formatter2 = new SimpleDateFormat("MMM dd yyyy");
//      format date2 from string
        Date date2 = formatter2.parse(date);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
//        using Calendar to convert
        calendar.setTime(date2);
//        printf year - month- and day
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String monthFromInput = new SimpleDateFormat("M").format(calendar.getTime());
        int month = Integer.parseInt(monthFromInput);
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    //    Get current time
    MyDate() throws ParseException {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        setYear(year);
        setMonth(month+1);
        setDay(day);

    }

    static String accept() {
        Scanner sc = new Scanner(System.in);
//       Get input is a string
        System.out.print("Enter string date you want to convert:");
        return sc.nextLine();
    }

    void printf() {
        int day = getDay();
        int month = getMonth();
        int year = getYear();
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
    }

    public static void main(String[] args) throws ParseException {


        String test = "December  18 2019";
//        Input is a string. Format of this is: month day year.
        String dateInputString = accept();
        MyDate inputString = new MyDate(dateInputString);
//        printf value
        System.out.println("Input is a string");
        inputString.printf();
//        Input date is int value
        System.out.println("-------------------------------------");
        System.out.println("Input integer");
        MyDate dateInteger = new MyDate(10, 10, 2020);
//        printf value when input is integer
        dateInteger.printf();
//        Current date
        MyDate currentDate = new MyDate();
        System.out.println("-------------------------------------");
        System.out.println("Current time");
        currentDate.print();
    }
}
