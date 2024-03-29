package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {

	private String title;
	private int length;
	
	public Track(String title) {
		this.title = title;
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Track) {			
			Track that = (Track) obj;
			if (this.title.equals(that.title)) return false;
			if (this.length != that.length) return false;
			return true;
		} else return false;
	}
	
	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		} else {			
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
    }
	
	public String toString() {
		return "Track - " + this.getTitle() + " - " + this.getLength();
	}
}
