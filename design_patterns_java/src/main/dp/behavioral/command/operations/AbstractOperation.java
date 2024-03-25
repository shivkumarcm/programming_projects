package main.dp.behavioral.command.operations;

import main.dp.behavioral.command.Inventory;
import main.dp.behavioral.command.Item;

import java.util.logging.Level;

public abstract class AbstractOperation implements InventoryOperation {
    private Item item;

    private boolean success = false;

    public AbstractOperation(Item item) {
        this.item = item;
    }
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isSuccessful() {
        return success;
    }

    protected void setSuccessful(boolean success) {
        this.success = success;
    }

    protected void preExecute() {
        Inventory.LOGGER.log(Level.FINE,
                "#### Attempting " + this.getClass().getSimpleName() + " Inventory Operation ####");
    }

    protected void postExecute() {
        String message = (isSuccessful() ? "#### Success! " : "!!!! FAILED ");
            Inventory.LOGGER.log(Level.FINE,
            message + this.getClass().getSimpleName() + " Inventory Operation %s ####");
    }
}
