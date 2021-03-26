import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test
    void removeDigitalVideoDisc() {
        Order order1 = new Order();
        Order order2 = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Start wars");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin");
//        Create order 1
        order1.addDigitalVideoDisc(dvd1);
        order1.addDigitalVideoDisc(dvd2);
        order1.addDigitalVideoDisc(dvd3);
//        Create order2
        order2.addDigitalVideoDisc(dvd1);
        order2.addDigitalVideoDisc(dvd2);
//        remove in order 1
        order1.removeDigitalVideoDisc(dvd3);
        int checkValueDeleted = 0;
        DigitalVideoDisc[] itemInOrder1 = order1.getItemsOrdered();
        DigitalVideoDisc[] itemInOrder2 = order2.getItemsOrdered();
        int qtyOrderedOrder1 = order1.getQtyOrdered();
        int qtyOrderedOrder2 = order2.getQtyOrdered();
        if (qtyOrderedOrder1 == qtyOrderedOrder2) {
            checkValueDeleted = 1;
            for (int i = 0; i < qtyOrderedOrder2; i++) {
                if (itemInOrder1[i].getTitle() != itemInOrder2[i].getTitle()) {
                    checkValueDeleted = 0;
                    break;
                }
            }
        }
        assertEquals(1, checkValueDeleted);
//        using assert to compare

    }

}