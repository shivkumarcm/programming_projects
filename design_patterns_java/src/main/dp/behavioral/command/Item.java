package main.dp.behavioral.command;

import org.json.simple.JSONAware;

public class Item implements JSONAware {
    private String asin;

    private String name;

    private String description;

    private double price;

    private int quantity;

    public Item(String asin, String name, String description, double price, int quantity) {
        setAsin(asin);
        setName(name);
        setDescription(description);
        setPrice(price);
        setQuantity(quantity);
    }

    public Item(String asin, String name, String description, double price) {
        this(asin, name, description, price, 1);
    }

    public Item(String asin, int quantity) {
        this(asin, "", "", 0.00, quantity);
    }

    public Item(String asin) {
        this(asin, 1);
    }

    @Override
    public String toJSONString() {
        return "{" +
                "asin: '" + getAsin() + "', " +
                "name: '" + getName() + "', " +
                "desc: '" + getDescription() + "', " +
                "price: $" + getPrice() + ", " +
                "qty: " + getQuantity() +
                "}";
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Item setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
