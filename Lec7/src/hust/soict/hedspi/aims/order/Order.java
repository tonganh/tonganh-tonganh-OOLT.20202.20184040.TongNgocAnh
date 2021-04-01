package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final int MAX_LIMITTED_ORDERS = 5;
    private int nOrders = 0;
    MyDate dateOrder;
    int totalAdded = 0;
    private List<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media mediaAdd) {
        itemsOrdered.add(mediaAdd);
        System.out.println("Added this media to list");
        totalAdded++;
    }


    public void removeMedia(String title) {
        itemsOrdered.forEach(media -> {
            if (media.getTitle().equals(title)) {
                System.out.println("Deleted this media have title:" + title);
                itemsOrdered.remove(itemsOrdered.indexOf(title));
            }
        });
    }

    public void removeMedia(int id) {
        if (id > totalAdded) {
            System.out.println("Invalid number");
            return;
        }
        totalAdded--;
        itemsOrdered.remove(id - 1);
    }

    public void showListMedia() {
        int idCheck = 0;
        System.out.println("Show list media:");
        System.out.printf("ID %-20s %-20s\n", "Title", "Category");
        for (int i = 0; i < totalAdded; i++) {
            System.out.printf("%d. %-20s %-20s\n", i + 1, itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCategory());
        }
    }
    public float totalCost() {
        float valueReturn = 0;
        for (Media media : itemsOrdered) {
            valueReturn += media.getCost();
        }
        return valueReturn;
    }
}
