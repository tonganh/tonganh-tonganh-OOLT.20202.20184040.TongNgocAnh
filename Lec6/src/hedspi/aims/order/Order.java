package hedspi.aims.order;

import hedspi.aims.media.Media;
import hedspi.aims.utils.MyDate;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final int MAX_LIMITTED_ORDERS = 5;
    private int nOrders = 0;
    MyDate dateOrder;
    private List<Media> itemsOrdered = new ArrayList<Media>();
    public void addMedia(Media mediaAdd){
        itemsOrdered.add(mediaAdd);
        System.out.println("Added this media to list");
    }
    public void removeMedia(String title){
        itemsOrdered.forEach(media -> {
            if (media.getTitle().equals(title)){
                System.out.println("Deleted this media have title:"+title);
                removeMedia(title);
            }
        });
    }
    public float totalCost() {
        float valueReturn = 0;
        for (Media media : itemsOrdered) {
            valueReturn += media.getCost();
        }
        return valueReturn;
    }
}
