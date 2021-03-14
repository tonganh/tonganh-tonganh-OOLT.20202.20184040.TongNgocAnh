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
            dateOrder = new MyDate();
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
        for (int i = 0; i < nOrders; i++) {
            System.out.println(itemsOrdered[i].getTitle());
        }
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

    public static void main(String[] args) {
        Order anOrder = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setCost(19.95f);
        dvd1.setDirector("Roger Allers");
        dvd1.setLength((87));
//    add the dvd to the order
        anOrder.addDigitalVideoDisc(dvd1);

//    new dvd2
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Start wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setCost(24.95f);
        dvd2.setDirector("George Lucas");
        dvd2.setLength(124);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin");
        dvd3.setCategory("Animation");
        dvd3.setCost(18.99f);
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);

//      add the dvd to the order
        anOrder.addDigitalVideoDisc(dvd3);
        anOrder.addDigitalVideoDisc(dvd3);
        anOrder.addDigitalVideoDisc(dvd3);
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());
        System.out.println("-------------------Now delete element-------------------");
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("-------------------Check delete-------------------");
        anOrder.test();

        System.out.println("-------------------Show list now-------------------");
        anOrder.showAllListVideoDisc();
    }
}
