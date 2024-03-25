package main.dp.behavioral.command.operations;

import main.dp.behavioral.command.Item;

public interface InventoryOperation {
    
    boolean execute();

    boolean isSuccessful();

    void setItem(Item item);

    Item getItem();
}
