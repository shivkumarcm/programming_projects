package main.dp.behavioral.command.operations;

import main.dp.behavioral.command.Inventory;
import main.dp.behavioral.command.Item;

public class RemoveOp extends AbstractOperation {

    public RemoveOp(Item item) {
        super(item);
    }

    @Override
    public boolean execute() {
        preExecute();
        Item item = getItem();
        if(item != null && !item.getAsin().isBlank() && item.getQuantity() > 0) {
            Item retval = Inventory.getInstance().removeItem(item.getAsin(), item.getQuantity());
            setSuccessful(retval != null);
        }
        postExecute();
        return isSuccessful();
    }
}
