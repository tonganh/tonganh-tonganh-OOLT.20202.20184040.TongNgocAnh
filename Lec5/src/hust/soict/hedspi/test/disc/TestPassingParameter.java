package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        System.out.println("*********BEFORE SWAP*********");
        System.out.printf("Jungle DVD: %s -  cinderella DVD: %s\n", jungleDVD.getTitle(), cinderellaDVD.getTitle());

        System.out.println("*********AFTER SWAP*********");
        swap(jungleDVD, cinderellaDVD);
        System.out.printf("Jungle DVD: %s -  cinderella DVD: %s\n", jungleDVD.getTitle(), cinderellaDVD.getTitle());

        System.out.println("Jungle dvd title  " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title  " + cinderellaDVD.getTitle());
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Jungle dvd title is: " + jungleDVD.getTitle());
    }

    public static void swap(Object object1, Object object2) {
        DigitalVideoDisc o1 = (DigitalVideoDisc) object1;
        DigitalVideoDisc o2 = (DigitalVideoDisc) object2;
        String titleTmp = o1.getTitle();
        String categoryTmp = o1.getCategory();
        String directorTmp = o1.getDirector();
        int lengthTmp = o1.getLength();
        float costTmp = o1.getCost();
//        Set value o2 to o1
        o1.setTitle(o2.getTitle());
        o1.setCategory(o2.getCategory());
        o1.setDirector(o2.getDirector());
        o1.setLength(o2.getLength());
        o1.setCost(o2.getCost());
//        set value o2 from o1
        o2.setTitle(titleTmp);
        o2.setCategory(categoryTmp);
        o2.setDirector(directorTmp);
        o2.setLength(lengthTmp);
        o2.setCost(costTmp);
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
