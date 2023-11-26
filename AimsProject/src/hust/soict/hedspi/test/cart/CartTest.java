package hust.soict.hedspi.test.cart;

import java.util.ArrayList;
import java.util.List;

//import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

public class CartTest {
	public static void main(String[] args) {
		List <Media> mediae = new ArrayList<Media>();
		
		Book book = new Book(123, "Silence of the lambs", "Horror, Psychology", 20.50f);
		book.addAuthor("Thomas Harris");
		DigitalVideoDisc dvd = new DigitalVideoDisc(123, "Star War", "Sci-fi", 19.95f, "George Lucas", 121);
		CompactDisc cd = new CompactDisc(123, "Thriller", "Micheal Jackson", "Pop", 25.65f, "Micheal Jackson");
		Track track1 = new Track("Wanna Be Startin' Somethin", 363);
		Track track2 = new Track("Baby Be Mine", 260);
		Track track3 = new Track("The Girl Is Mine", 222);
		cd.addTrack(track1);
		cd.addTrack(track2);
		cd.addTrack(track3);
		
		mediae.add(book);
		mediae.add(dvd);
		mediae.add(cd);
		
		for (Media m: mediae) {
			System.out.println(m.toString());
		}
	}
}
