package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc{
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(int id, String title) {
    	super(id, title);
    	nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        nbDigitalVideoDiscs++;
    }
    
    public DigitalVideoDisc(int id, String title, String category, float cost, String director) {
    	super(id, title, category, cost, director);
    	nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
    	super(id, title, category, cost, director, length);
        nbDigitalVideoDiscs++;
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
