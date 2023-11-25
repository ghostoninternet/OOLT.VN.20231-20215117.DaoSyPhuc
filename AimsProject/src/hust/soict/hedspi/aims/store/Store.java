package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Store {
	public static final int MAXIMUM_STORE_ITEM = 10000;
	private int currentQuantityInStore = 0;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAXIMUM_STORE_ITEM];
	
	public void addDVD(DigitalVideoDisc dvd) {
		itemsInStore[currentQuantityInStore] = dvd;
		currentQuantityInStore++;
		System.out.println("Successfully added a DVD to store");
	}
	
	public void addDVD(DigitalVideoDisc[] dvdList) {
		int j = 0;
		while(currentQuantityInStore <= MAXIMUM_STORE_ITEM) {
			itemsInStore[currentQuantityInStore] = dvdList[j];
			j++;
			currentQuantityInStore++;
		}
		if (j+1 == dvdList.length) System.out.println("Successfully added a list of DVDs to store");
		else System.out.printf("Can only added %d DVD(s) out of %d DVD(s) because the store is now full!", j+1, dvdList.length);
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		if (currentQuantityInStore == 0) {
			System.out.println("Store is empty! No items can be removed");
		} else {
			int deletedPosition = 0;
			for(int i = 0; i < MAXIMUM_STORE_ITEM; i++) {
				if(itemsInStore[i] != null) {
					if (itemsInStore[i].getTitle().equals(dvd.getTitle())) {
						itemsInStore[i] = null;
						currentQuantityInStore--;
						deletedPosition = i;
						System.out.println("Removed disc " + dvd.getTitle() + " out of the store");
						break;
					}
				}
			}
			for(int j = deletedPosition; j <= currentQuantityInStore; j++) {
				itemsInStore[j] = itemsInStore[j+1];
			}
		}
	}
}
