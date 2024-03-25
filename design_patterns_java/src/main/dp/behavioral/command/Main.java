package main.dp.behavioral.command;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {

        Inventory.LOGGER.setLevel(Level.FINE);
        Handler console = new ConsoleHandler();
        console.setLevel(Level.FINE);
        Inventory.LOGGER.addHandler(console);
        Inventory.LOGGER.setUseParentHandlers(false);

        // Setup some sample items
        Item harryPotter1 = new Item("BOOK001",
                "Harry Potter I", "First Harry Potter book", 24.99);
        Item harryPotter2 = new Item("BOOK002",
                "Harry Potter II", "Second Harry Potter book", 29.99);
        Item magazine1 = new Item("MAG001",
                "Best Kids Magazine", "Vol. 1 of Best Kids Magazine", 12.24);
        Item pens = new Item("PEN001",
                "Ball point pen", "Standard ball point pen", 1.99);

        // Set up Vendors
        Vendor hpBookSeller = new Vendor("HP Books");
        Vendor magazinePublisher = new Vendor("Kids Publishing");
        Vendor officeGoods = new Vendor("Office Goods");

        // Set up some customers
        Customer sam = new Customer("Sam");
        Customer kate = new Customer("Kate");
        Customer kidHarry = new Customer("Harry");

        // Let's do some purchasing!
        hpBookSeller.buyFrom(harryPotter1.setQuantity(20));
        hpBookSeller.buyFrom(harryPotter2.setQuantity(10));
        magazinePublisher.buyFrom(magazine1.setQuantity(15));

        // Now we are online selling goods and making profit!!!
        sam.sellTo(new Item(harryPotter1.getAsin(), 3));
        kate.sellTo(new Item(harryPotter2.getAsin(), 1));
        sam.hasReturned(new Item(harryPotter1.getAsin(), 1));
        kidHarry.sellTo(new Item(magazine1.getAsin(), 2));
        kidHarry.sellTo(new Item(magazine1.getAsin(), 1));
        sam.sellTo(new Item(harryPotter2.getAsin(), 2));
        kidHarry.hasReturned(new Item(magazine1.getAsin(), 1));

        // Let's make sure our inventory is in good shape
        assertItems(harryPotter1, 18);
        assertItems(harryPotter2, 7);
        assertItems(magazine1, 13);
        assertEmpty(pens);
        System.out.println("Inventory is in good shape!");

        // Let's buy some pens
        officeGoods.buyFrom(pens.setQuantity(100));

        // And they are getting sold already!
        new Customer("Bulk Buyer").sellTo(new Item(pens.getAsin(), 30));
        kidHarry.sellTo(new Item(pens.getAsin(), 3));

        assertItems(pens, 67);

        System.out.println("Inventory is still in good shape! This is where we are: ");
        System.out.println(Inventory.getInstance());

    }

    static void assertItems(Item item, int quantity) {
        assert Inventory.getInstance().hasItem(item.getAsin(), quantity) :
                "Item quantity mismatch for " + item.getAsin() +
                " Expected: " + quantity +
                " Found: " + Inventory.getInstance().getItemQty(item.getAsin());
    }

    static void assertEmpty(Item item) {
        assert Inventory.getInstance().getItemQty(item.getAsin()) == 0:
                "Item quantity mismatch for " + item.getAsin() +
                        " Expected: 0" +
                        " Found: " + Inventory.getInstance().getItemQty(item.getAsin());
    }
}
