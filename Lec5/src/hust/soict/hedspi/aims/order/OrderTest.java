package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void testTotalCost() {
        Order anOrder = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCost(19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Start wars");
        dvd2.setCost(24.95f);
        float DELTA = (float) 0.0012312301;
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        float cost = anOrder.totalCost();
        System.out.println("cost" + cost);
        assertEquals(44.9, cost, DELTA);
        assertEquals(true, anOrder.search("The Lion King"));
        assertEquals(false, anOrder.search("123123"));
    }
}