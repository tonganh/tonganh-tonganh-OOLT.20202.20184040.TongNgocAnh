package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;

    DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category) {
        super(title, category);
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


    @Override
    public void play() {
        System.out.printf("The title is %s and the category is %s\n", this.getTitle(), this.getCategory());
    }

    @Override
    public int compareTo(Media o) {
        int valueReturn = this.getTitle().compareTo(o.getTitle()) + this.getCategory().compareTo(o.getCategory());
        return valueReturn;
    }
}
