package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<Media>();
    
    public void addMedia(Media media) {
    	if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
    		itemsOrdered.add(media);
    		System.out.println("Successfully added an media to cart!");
    	} else {
    		System.out.println("Cart is now full. Can't add more media to cart!");
    	}
    }
    
    public void addMedia(List<Media> listMedia) {
    	for(int i = 0; i < listMedia.size(); i++) {
    		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
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
    
    public void filterById(int id) {
    	int filtered = 0;
    	for(Media item: itemsOrdered) {
    		if (item.isMatch(id)) {
    			System.out.println("Filter result: \n");
    			System.out.println(item.toString());
    			filtered = 1;
    		}
    	}
    	if (filtered == 0) {
    		System.out.println("No such media in cart!");
    	}
    }
    
    public void filterByTitle(String title) {
    	int filtered = 0;
    	for(Media item: itemsOrdered) {
    		if (item.isMatch(title)) {
    			System.out.println("Filter result: \n");
    			System.out.println(item.toString());
    			filtered = 1;
    		}
    	}
    	if (filtered == 0) {
    		System.out.println("No such media in cart!");
    	}
    }
    
    public void sortMediaByTitle() {
    	Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    
    public void sortMediaByCost() {
    	Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    
    public void emptyCart() {
    	itemsOrdered.clear();
    }
    
    public Media searchMediaByTitle(String title) {
    	for (Media item: itemsOrdered) {
    		if (item.isMatch(title)) return item;
    	}
    	return null;
    }
    
    public float totalCost() {
    	 float cost = 0;
    	 for(Media item: itemsOrdered) {
    		 cost += item.getCost();
    	 }
    	 return cost;
    }
    
    public void printCartListFormat() {
    	if (itemsOrdered.size() == 0) {
    		System.out.println("No items in cart to display!");
    	} else {
    		System.out.println("The current cart: ");
    		for (int i = 0; i < itemsOrdered.size(); i++) {
    			System.out.println(i+1 + ". " + itemsOrdered.get(i).toString());
    		}
    		System.out.printf("Total cost: %.2f\n\n", totalCost());
    	}
    }
}
