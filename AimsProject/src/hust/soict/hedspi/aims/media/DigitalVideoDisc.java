package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media{
    private static int nbDigitalVideoDiscs = 0;

    private String director;
    private int length;

    public DigitalVideoDisc(String title) {
    	this.setTitle(title);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        nbDigitalVideoDiscs++;
    }
    
    public DigitalVideoDisc(String title, String category, String director, float cost) {
    	this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.director = director;
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    	this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.length = length;
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    
    public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
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
