package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;

    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
    }
    
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
    }

    public int getId() {
    	return id;
    }
    
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String toString() {
    	return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost();
    }
    
    public boolean isMatch(String title) {
    	return this.getTitle().equals(title);
    }
    
    public boolean isMatch(int id) {
    	return this.getId() == id;
    }
}
