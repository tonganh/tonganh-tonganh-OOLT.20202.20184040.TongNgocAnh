import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {
//   Sai so
    private static final double DELTA = 0.02;

    @Test
    public void totalCost() {
        Order anOrder = new Order();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCost(19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Start wars");
        dvd2.setCost(24.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        float cost = anOrder.totalCost();
        System.out.println("cost" + cost);
        assertEquals(44.9, cost, DELTA);
    }
}