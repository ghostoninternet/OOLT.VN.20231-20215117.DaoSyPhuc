package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;

public class Store {
	
	private List<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		itemsInStore.add(media);
	}
	
	public void addMedia(List<Media> listMedia) {
		for(Media item: listMedia) {
			itemsInStore.add(item);
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.remove(media)) {
			System.out.println("Successfully removed a media out of store");
		} else {
			System.out.println("Media isn't existed in store");
		}
	}
	
	public Media findMediaByTitle(String title) {
		for (Media m: itemsInStore) {
			if (m.isMatch(title)) {
				System.out.println("Media founded!\n" + m.toString());
				return m;
			}
		}
		System.out.println("No such media in store!");
		return null;
	}
	
	public void showStore() {
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(i+1 + ". " + itemsInStore.get(i).toString() );
		}
	}
}
