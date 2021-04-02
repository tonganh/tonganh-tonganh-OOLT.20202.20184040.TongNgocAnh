package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category) {
        super(title, category);
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    private int length;
    private String director;
}
