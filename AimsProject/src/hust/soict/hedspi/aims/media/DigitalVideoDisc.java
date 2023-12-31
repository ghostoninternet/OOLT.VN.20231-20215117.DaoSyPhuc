package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

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

    public void play() throws PlayerException {
    	if (this.getLength() <= 0) {
    		throw new PlayerException("ERROR: DVD length is non-positive!");
    	} else {
    		System.out.println("Playing DVD: " + this.getTitle());
        	System.out.println("DVD length: " + this.getLength());
    	}
    }
}
