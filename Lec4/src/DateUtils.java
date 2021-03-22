

public class DateUtils {
    public int compare(MyDate d1, MyDate d2) {
        int dayD1 = d1.getDay();
        int dayD2 = d2.getDay();
        int monthD1 = d1.getMonth();
        int monthD2 = d2.getMonth();
        int yearD1 = d1.getYear();
        int yearD2 = d2.getYear();
        if (yearD1 > yearD2) {
            return 1;
        } else if (yearD1 < yearD2) {
            return -1;
        } else {
            if (monthD1 > monthD1) {
                return 1;
            } else if (monthD1 < monthD1) {
                return -1;
            } else {
                if (dayD1 > dayD2) {
                    return 1;
                } else if (dayD1 < dayD2) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        DateUtils test1 = new DateUtils();
        MyDate dateTest = new MyDate("one", "January", "thirteen one");
        MyDate currentDate = new MyDate();
        int x1 = test1.compare(dateTest, currentDate);
        if (x1 == 1) {
            System.out.println("D1 = D2");
        }
        if (x1 == -1) {
            System.out.println("D1<d2");
        } else {
            System.out.println("D1>D2");
        }
    }
}
