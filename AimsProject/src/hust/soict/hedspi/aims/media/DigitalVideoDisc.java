package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(int id, String title) {
    	super(id, title);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    
    public DigitalVideoDisc(int id, String title, String category, float cost, String director) {
    	super(id, title, category, cost, director);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
    	super(id, title, category, cost, director, length);
    }

	public String toString() {
    	return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getCost();
    }

    public void play() {
    	if (this.getLength() <= 0) {
    		System.out.println("DVD " + this.getTitle() + " can't be played!");
    	} else {
    		System.out.println("Playing DVD: " + this.getTitle());
        	System.out.println("DVD length: " + this.getLength());
    	}
    }
}
