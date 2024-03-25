package main.dp.behavioral.command;

import org.json.simple.JSONObject;

import java.util.logging.Logger;

public class Inventory {
    private JSONObject _database;

    private static final Inventory _INSTANCE = new Inventory();

    public static final Logger LOGGER = Logger.getLogger(Inventory.class.getName());

    public static Inventory getInstance() {
        return _INSTANCE;
    }

    private Inventory() {
        _database = new JSONObject();
    }

    public boolean hasItem(String asin) {
       return hasItem(asin, 1);
    }

    /**
     * Adds the item to the inventory. If the item already exists
     * it updates the quantity
     * @param item item to be added
     */
    public void addItem(Item item) {
        Item existing;
        if(_database.containsKey(item.getAsin())) {
            existing = (Item)_database.get(item.getAsin());
            existing.setQuantity(existing.getQuantity() + item.getQuantity());
        } else {
            _database.put(item.getAsin(), item);
        }
    }

    /**
     * Checks if the given quantity of the given ASIN is in the inventory
     * @param asin
     * @param quantity
     * @return
     */
    public boolean hasItem(String asin, int quantity) {
        if(_database.containsKey(asin)) {
            Item item = (Item)_database.get(asin);
            if(item.getQuantity() >= quantity) {
                return true;
            }
        }
        return false;
    }

    public int getItemQty(String asin) {
        if(_database.containsKey(asin)) {
            Item item = (Item)_database.get(asin);
            if(item != null) {
                return item.getQuantity();
            }
        }
        return 0;
    }
    /**
     * Removes the given quantity of the given asin from the inventory
     * @param asin
     * @param quantity
     * @return
     */
    public Item removeItem(String asin, int quantity) {
        if(hasItem(asin, quantity)) {
            Item item = (Item)_database.get(asin);
            item.setQuantity(item.getQuantity() - quantity);
            return item;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        for(Object key: _database.keySet()) {
            Item item = (Item)_database.get(key);
            builder.append(key).append(": ").append(item.toJSONString()).append("\n");
        }
        builder.append("}\n");
        return builder.toString();
    }
}
