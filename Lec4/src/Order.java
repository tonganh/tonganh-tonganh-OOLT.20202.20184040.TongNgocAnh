import java.text.ParseException;

public class Order {
    public static final int MAX_LIMITTED_ORDERS = 5;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_LIMITTED_ORDERS];
    private int nOrders = 0;
    int checkValueExistInArray = 0;
    MyDate dateOrder;

    //    add digital video disc method
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (nOrders < MAX_LIMITTED_ORDERS) {
            itemsOrdered[nOrders] = disc;
            System.out.println("The disc has been added");
            try {
                dateOrder = new MyDate();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            nOrders++;
        } else {
//            max of nOrders is MAX_LIMITTED_ORDERS. If full => message to client
            System.out.println("The order is almost full");
        }
    }
//    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//        if (nOrders + dvdList.length > 9) {
//            throw new ArithmeticException("Full");
//        }
//
//    }

    public void showAllListVideoDisc() {
        int day = dateOrder.getDay();
        int month = dateOrder.getMonth();
        int year = dateOrder.getYear();
        System.out.println("***********************Order***********************");
        System.out.printf("Date: %d/%d/%d\n", day, month, year);
        for (int i = 0; i < nOrders; i++) {
            String title = itemsOrdered[i].getTitle();
            String category = itemsOrdered[i].getCategory();
            String director = itemsOrdered[i].getDirector();
            int length = itemsOrdered[i].getLength();
            float cost = itemsOrdered[i].getCost();
            System.out.printf("%d. DVD-%s-%s-%s-%d-%f\n", i + 1, title, category, director, length, cost);
        }
        float cost = totalCost();
        System.out.println("Total cost: " + cost);
        System.out.println("***************************************************");
    }

    public float totalCost() {
        float valueReturn = 0;
        for (int i = 0; i < nOrders; i++) {
            valueReturn += itemsOrdered[i].getCost();
        }
        return valueReturn;
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
//        checkValueExistInArray = 0 => disc.title not exist in array. =1 => exist and we can delete.
        for (int i = 0; i < nOrders; i++) {
            String titleDisc = disc.getTitle();
            String titleItem = itemsOrdered[i].getTitle();
            if (titleDisc.equals(titleItem)) {
                if (i < (nOrders - 1)) {
                    for (int k = i; k < nOrders; k++) {
                        itemsOrdered[k] = itemsOrdered[k + 1];
                    }
                }
                nOrders--;
                checkValueExistInArray = 1;
                break;
            }
        }
    }

    public void test() {
        if (checkValueExistInArray == 0) {
            System.out.println("Disc not exist in array");
            return;
        }
        System.out.println("Deleted");
    }
}
