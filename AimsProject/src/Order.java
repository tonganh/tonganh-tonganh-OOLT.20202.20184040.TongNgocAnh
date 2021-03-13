public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    int checkValueExistInArray = 0;

    //    add digital video disc method
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < 10) {
            itemsOrdered[qtyOrdered] = disc;
            System.out.println("The disc has been added");
            qtyOrdered++;
        } else {
//            max of qtyOrdered is 10. If full => message to client
            System.out.println("The order is almost full");
        }
    }

    public void showAllListVideoDisc() {
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i].getTitle());
        }
    }

    public float totalCost() {
        float valueReturn = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            valueReturn += itemsOrdered[i].getCost();
        }
        return valueReturn;
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
//        checkValueExistInArray = 0 => disc.title not exist in array. =1 => exist and we can delete.
        for (int i = 0; i < qtyOrdered; i++) {
            String titleDisc = disc.getTitle();
            String titleItem = itemsOrdered[i].getTitle();
            if (titleDisc.equals(titleItem)) {
                if (i < (qtyOrdered - 1)) {
                    for (int k = i; k < qtyOrdered; k++) {
                        itemsOrdered[k] = itemsOrdered[k + 1];
                    }
                }
                qtyOrdered--;
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
