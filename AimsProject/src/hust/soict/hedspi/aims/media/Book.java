package hust.soict.hedspi.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public List<String> getAuthors() {
		return authors;
	}
	
	public void addAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.printf("Successfully added a new author name: %s\n", authorName);
		} else {
			System.out.printf("Author name %s is already existed!\n", authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.printf("Successfully removed author %s!\n", authorName);
		} else {
			System.out.printf("Author %s is not existed in the list!\n", authorName);
		}
	}
	
	public String toString() {
		return "Book - " + this.getId() + " - " + " - " + this.getTitle() + " - " + this.getAuthors() + " - " + this.getCategory() + " - " + this.getCost();
	}

}
