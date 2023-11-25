package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<Media>();
    
    public void addMedia(Media media) {
    	if (itemsOrdered.size() < 20) {
    		itemsOrdered.add(media);
    		System.out.println("Successfully added an media to cart!");
    	} else {
    		System.out.println("Cart is now full. Can't add more media to cart!");
    	}
    }
    
    public void addMedia(List<Media> listMedia) {
    	for(int i = 0; i < listMedia.size(); i++) {
    		if (itemsOrdered.size() < 20) {
    			itemsOrdered.add(listMedia.get(i));
    			System.out.println("Successfully added an media to cart!");
    		} else {
    			System.out.printf("Cart is now full. Can only add %d out of %d items.", i+1, listMedia.size());
    		}
    	}
    }
    
    public void removeMedia(Media media) {
    	if (itemsOrdered.remove(media)) {
    		System.out.println("Successfully removed an media out of cart!");
    	} else {
    		System.out.println("The media is not existed!");
    	}
    }
    
    public float totalCost() {
    	 float cost = 0;
    	 for(Media item: itemsOrdered) {
    		 cost += item.getCost();
    	 }
    	 return cost;
    } 
}
