package main.dp.behavioral.command;

import main.dp.behavioral.command.operations.AddOp;
import main.dp.behavioral.command.operations.RemoveOp;

public class Vendor {

    private String name;

    public Vendor(String name) {
        this.name = name;
    }

    public boolean buyFrom(Item item) {
        System.out.printf("Buying from Vendor:'%s' %d units of '%s'\n", getName(), item.getQuantity(), item.getAsin());
        return new AddOp(item).execute();
    }

    public boolean hasRecalled(Item item) {
        System.out.printf("Recalled to Vendor:'%s' %d units of '%s'\n", getName(), item.getQuantity(), item.getAsin());
        return new RemoveOp(item).execute();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
