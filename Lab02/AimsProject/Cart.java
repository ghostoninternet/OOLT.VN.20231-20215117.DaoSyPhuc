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

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty. No item can be removed!");
        } else {
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] != null) {
                    if (itemsOrdered[i].getTitle().toLowerCase().equals(disc.getTitle().toLowerCase())) {
                        System.out.println("Removed disc " + itemsOrdered[i].getTitle() + " out of the cart");
                        qtyOrdered -= 1;
                        itemsOrdered[i] = null;
                    }
                }

            }
        }
    }

    public float totalCost() {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty!");
            return 0;
        } else {
            float total = 0;
            int index = 1;
            for (int i = 0; i < itemsOrdered.length; i++) {
                if (itemsOrdered[i] != null) {
                    System.out.printf("%-5d %-50s %.2f\n", index, itemsOrdered[i].getTitle(),
                            itemsOrdered[i].getCost());
                    index++;
                    total += itemsOrdered[i].getCost();
                }
            }
            System.out.printf("%-5s %-50s ", "", "Total Cost");
            return total;
        }
    }
}
