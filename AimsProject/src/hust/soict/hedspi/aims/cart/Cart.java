package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < 20) {
        	itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("The disc has been added!");
        } else {
            System.out.println("The cart is full!");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if ((qtyOrdered + dvdList.length) > 20) {
            int j = 0;
            for(int i = qtyOrdered; i < 20; i++) {
                itemsOrdered[qtyOrdered] = dvdList[j];
                qtyOrdered++;
                j++;
                System.out.println("The disc has been added!");
            }
            System.out.println("Can't add all " + dvdList.length + " dvds into the cart since the cart is now full!");
        } else {
            for(int i = 0; i < dvdList.length; i++) {
                itemsOrdered[qtyOrdered] = dvdList[i];
                qtyOrdered++;
                System.out.println("The disc has been added!");
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered == 20) {
            System.out.println("The cart is full!");
        } else {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("The disc has been added!");
        }
        if (qtyOrdered == 20) {
            System.out.println("The cart is full!");
        } else {
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The disc has been added!");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty. No item can be removed!");
        } else {
        	int deletedPosition = 0;
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] != null) {
                    if (itemsOrdered[i].getTitle().toLowerCase().equals(disc.getTitle().toLowerCase())) {
                        deletedPosition = i;
                    	System.out.println("Removed disc " + itemsOrdered[i].getTitle() + " out of the cart");
                        qtyOrdered -= 1;
                        itemsOrdered[i] = null;
                        break;
                    }
                }
            }
            for(int j = deletedPosition; j < qtyOrdered; j++) {
            	itemsOrdered[j] = itemsOrdered[j+1];
            }
        }
    }

    public float totalCost() {
    	 float total = 0;
         for (int i = 0; i < qtyOrdered; i++) {
             if (itemsOrdered[i] != null) {
                 total += itemsOrdered[i].getCost();
             }
         }
         return total;
    }
    
    public void searchDVD(String title) {
    	int found = 0;
    	for(int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrdered[i].isMatch(title)) {
    			System.out.println("Found: " + itemsOrdered[i].toString());
    			found = 1;
    		}
    	}
    	if (found == 0) {
    		System.out.println("The DVD with title " + title + " does not exist!");
    	}
    	
    }
    
    public void searchDVD(int id) {
    	int found = 0;
    	for(int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrdered[i].isMatch(id)) {
    			System.out.println("Found: " + itemsOrdered[i].toString());
    			found = 1;
    		}
    	}
    	if (found == 0) {
    		System.out.println("The DVD with id " + id + " does not exist!");
    	}
    	
    }
    
    public void printCartTableFormat() {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty!");
        } else {
        	int index = 1;
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemsOrdered[i] != null) {
                    System.out.printf("%-5d %-50s %.2f\n", index, itemsOrdered[i].getTitle(),
                            itemsOrdered[i].getCost());
                    index++;
                }
            }
            System.out.printf("%-5s %-50s %.2f\n", "", "Total Cost", totalCost());
        }
    }
    
    public void printCartListFormat() {
    	if (qtyOrdered == 0) {
    		System.out.println("The cart is empty!");
    	} else {    		
    		System.out.println("***********************CART***********************");
    		System.out.println("Ordered Items:");
    		for (int i = 0; i < qtyOrdered; i++) {
    			System.out.println(i+1 + ". " + itemsOrdered[i].toString());
    		}
    		System.out.println("Total cost: " + totalCost());
    		System.out.println("***************************************************");
    	}
    }
}
