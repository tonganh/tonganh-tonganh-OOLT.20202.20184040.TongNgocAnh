package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class TestMediaCompareTo {

    public static void main(String[] args) {
        List<Media> collection = new ArrayList<Media>();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Le bao hieu", "lla");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Tong Ngoc Anh", "a123");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Lele", "1");
        collection.add(dvd2);
        collection.add(dvd1);
        collection.add(dvd3);
        Iterator iterator = collection.iterator();
        System.out.println("--------------------------");
        System.out.println("The currently in the order are: ");
        while (iterator.hasNext()){
            System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
        }
        System.out.println("================");
//        Sort the collection of DVDs - based on the compareTo()
        Collections.sort(collection);
         iterator = collection.iterator();
        System.out.println("After using sort");
        while (iterator.hasNext()){
            System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
        }
    }
}
