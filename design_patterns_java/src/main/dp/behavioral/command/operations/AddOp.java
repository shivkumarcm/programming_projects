package main.dp.behavioral.command.operations;

import main.dp.behavioral.command.Inventory;
import main.dp.behavioral.command.Item;

public class AddOp extends AbstractOperation {

    public AddOp(Item item) {
        super(item);
    }

    @Override
    public boolean execute() {
        preExecute();
        Item item = getItem();
        if(item != null && !item.getAsin().isBlank() && item.getQuantity() > 0) {
            Inventory.getInstance().addItem(item);
            setSuccessful(true);
        }
        postExecute();
        return isSuccessful();
    }
}
