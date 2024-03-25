package main.dp.behavioral.command.operations;

import main.dp.behavioral.command.Inventory;
import main.dp.behavioral.command.Item;

public class CheckOp extends AbstractOperation {

    public CheckOp(Item item) {
        super(item);
    }

    @Override
    public boolean execute() {
        preExecute();
        Item item = getItem();
        if(item != null && !item.getAsin().isBlank() && item.getQuantity() > 0) {
            setSuccessful(Inventory.getInstance().hasItem(item.getAsin(), item.getQuantity()));
        }
        postExecute();
        return isSuccessful();
    }
}
