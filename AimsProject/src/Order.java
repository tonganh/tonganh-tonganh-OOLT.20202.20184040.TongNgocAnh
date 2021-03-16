public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    //    add digital video disc method
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
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

    public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int checkValueExistInArray = 0;
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
        return checkValueExistInArray;
    }

    public void test(int checkValueExistInArray) {
        if (checkValueExistInArray == 0) {
            System.out.println("Disc not exist in array");
            return;
        }
        System.out.println("Deleted");
    }
}
