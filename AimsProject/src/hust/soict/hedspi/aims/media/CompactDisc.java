package hust.soict.hedspi.aims.media;

import java.util.List;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private static int nbCompactDiscs = 0;
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(int id, String title, String artist) {
		super(id, title);
		this.artist = artist;
		nbCompactDiscs++;
	}

	public CompactDisc(int id, String title, String artist, String category, float cost) {
	    super(id, title, category, cost);
	    this.artist = artist;
	    nbCompactDiscs++;
	}
	    
	public CompactDisc(int id, String title, String artist, String category, float cost, String director) {
		super(id, title, category, cost, director);
		this.artist = artist;
		nbCompactDiscs++;
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
			System.out.printf("Successfully added a track with title %s and length %d to tracks list!\n", track.getTitle(), track.getLength());
		} else {
			System.out.printf("Track with title %s and length %d is already existed!\n", track.getTitle(), track.getLength());
		}
	}
	
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.printf("Successfully removed a track with title %s and length %d out of tracks list!\n", track.getTitle(), track.getLength());
		} else {
			System.out.printf("Track with title %s and length %d is not existed!\n", track.getTitle(), track.getLength());
		}
	}
	
	public int getLength() {
		int sumLength = 0;
		for (Track track: tracks) {
			sumLength += track.getLength();
		}
		return sumLength;
	}
	
	public void play() {
		System.out.printf("Now is playing CD $s - $s\n", this.getTitle(), this.getArtist());
		for(Track track: tracks) {
			track.play();
		}
	}
	
	public String toString() {
		return "CD - " + this.getId() + " - " + this.getTitle() + " - " + this.getArtist() + " - " + this.getDirector() + " - " + this.getCategory() + " - "  + this.getLength() + " - " + this.getCost();
	}
}
