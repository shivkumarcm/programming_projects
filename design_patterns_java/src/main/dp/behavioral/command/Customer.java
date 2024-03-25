package main.dp.behavioral.command;

import main.dp.behavioral.command.operations.AddOp;
import main.dp.behavioral.command.operations.RemoveOp;

public class Customer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public boolean sellTo(Item item) {
        System.out.printf("Selling to Customer:'%s' %d units of '%s'\n", getName(), item.getQuantity(), item.getAsin());
        return new RemoveOp(item).execute();
    }

    public boolean hasReturned(Item item) {
        System.out.printf("Returned by Customer:'%s' %d units of '%s'\n", getName(), item.getQuantity(), item.getAsin());
        return new AddOp(item).execute();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
