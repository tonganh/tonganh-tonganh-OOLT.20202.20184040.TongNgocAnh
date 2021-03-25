package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

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
            try {
                dateOrder = new MyDate();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            nOrders++;
        } else {
//            max of nOrders is MAX_LIMITTED_ORDERS. If full => message to client
            System.out.println("The order is almost full");
        }
    }

    //1.1 exercise in lab4
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (dvdList != null) {
            if (nOrders + dvdList.length > MAX_LIMITTED_ORDERS) {
                throw new ArithmeticException("Full");
            }
            for (int i = 0; i < dvdList.length; i++) {
                addDigitalVideoDisc(dvdList[i]);
            }
        }
    }

    //    exercise 1.2 in lab4
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (nOrders == MAX_LIMITTED_ORDERS - 1) {
            addDigitalVideoDisc(dvd1);
            System.out.printf("The dvd %s could not be added \n", dvd1.getTitle());
        } else if (nOrders == MAX_LIMITTED_ORDERS - 2) {
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        } else System.out.println("The item quantity has reached its limit.");
    }

    public void showAllListVideoDisc() {
        int day = dateOrder.getDay();
        int month = dateOrder.getMonth();
        int year = dateOrder.getYear();
        System.out.println("***********************hust.soict.hedspi.aims.order.Order***********************");
        System.out.printf("Date: %d/%d/%d\n", day, month, year);
        for (int i = 0; i < nOrders; i++) {
            String title = itemsOrdered[i].getTitle();
            String category = itemsOrdered[i].getCategory();
            String director = itemsOrdered[i].getDirector();
            int length = itemsOrdered[i].getLength();
            float cost = itemsOrdered[i].getCost();
            System.out.printf("%d. DVD-%s-%s-%s-%d-%f\n", i + 1, title, category, director, length, cost);
        }
        float cost = totalCost();
        System.out.println("Total cost: " + cost);
        System.out.println("***************************************************");
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

    public boolean search(String title) {
        String titleLowerCase = title.toLowerCase();
        String[] arraySplit = titleLowerCase.split(" ");
        ArrayList<String> subStringInput = new ArrayList<>(Arrays.asList(arraySplit));
        for (int i = 0; i < nOrders; i++) {
            String titleVideoDiscLowerCase = itemsOrdered[i].getTitle().toLowerCase();
            String[] arrayTitleVideoSplit = titleVideoDiscLowerCase.split(" ");
            int lengthArrayTitleVideoSplit = arrayTitleVideoSplit.length;
            int checkForDisk = 0;
            for (int indexInArraySplit = 0; indexInArraySplit < lengthArrayTitleVideoSplit; indexInArraySplit++) {
                int existInInputTitle = subStringInput.indexOf(arrayTitleVideoSplit[indexInArraySplit]);
                if (existInInputTitle != -1) {
                    checkForDisk += 1;
                }
            }
            if (checkForDisk == lengthArrayTitleVideoSplit) {
                return true;
            }
        }
        return false;
    }

    public DigitalVideoDisc getALuckyItem() {
        int max = 4;
        int min = 0;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;
        return itemsOrdered[rand];
    }

    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }
}
