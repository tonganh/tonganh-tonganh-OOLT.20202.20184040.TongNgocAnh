package hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {


    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    private List<String> authors = new ArrayList<String>();

    public void addAuthor(String authorName) {
        int checkAuthorInList = authors.indexOf(authorName);
        if (checkAuthorInList ==-1){
            System.out.println("Adding to list...");
            authors.add(authorName);
        } else System.out.println("This author existed in author list.");
    }
    public void removeAuthor(String authorName){
        int indexOfAuthor = authors.indexOf(authorName);
        if (indexOfAuthor ==-1){
            System.out.println(authorName+" not existed in list");
            return;
        }
        authors.remove(indexOfAuthor);
        System.out.println("Deleted");
    }
    public static void main(String[] args) {
        Book testBook1 = new Book();
        testBook1.addAuthor("Tong Ngoc Anh");
        testBook1.addAuthor("Tong Ngoc Anh");
        testBook1.removeAuthor("Tong Ngoc Anh");
    }
}
