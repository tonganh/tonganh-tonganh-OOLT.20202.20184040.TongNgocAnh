package hedspi.aims.media;

public class DigitalVideoDisc extends Media  {
    private String director;
    private int length;

    public DigitalVideoDisc(String title) {
        super();
        this.setTitle(title);
    }

    public DigitalVideoDisc(String title, String category) {
        super();
        this.setTitle(title);
        this.setCategory(category);
    }

    public DigitalVideoDisc(String title, String category, String director) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.length = length;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category); ;
        this.setDirector(director);
        this.setLength(length);
        this.setCost(cost);
    }





    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }



    public static void main(String[] args) {

    }
}
