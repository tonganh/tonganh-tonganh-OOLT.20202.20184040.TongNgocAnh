package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;
public class Aims {
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

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry potter");
        dvd3.setCategory("Animation");
        dvd3.setCost(18.99f);
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);

//      add the dvd to the order
        anOrder.addDigitalVideoDisc(dvd3);
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());
        System.out.println("-------------------Show list now-------------------");
        anOrder.showAllListVideoDisc();

        System.out.println("-------------------Show list now 1.1-------------------");
        DigitalVideoDisc[] listDiscTest = {dvd1, dvd2};
        anOrder.addDigitalVideoDisc(listDiscTest);
        anOrder.showAllListVideoDisc();
        System.out.println("-------------------Show list now 1.2-------------------");
        anOrder.addDigitalVideoDisc(dvd3, dvd2);

        anOrder.showAllListVideoDisc();
        System.out.println(anOrder.search("potter harry"));
        DigitalVideoDisc itemLuck = anOrder.getALuckyItem();
        System.out.println(itemLuck.getTitle());
    }
}
