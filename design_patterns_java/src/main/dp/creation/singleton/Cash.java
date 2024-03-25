package main.dp.creation.singleton;

/**
 * A simple implementation of a singleton design pattern.
 * Imagine a store with only one cash register instance.
 */
public class Cash {

    public enum Coins {
        CENTS,
        NICKELS,
        DIMES,
        QUARTERS
    }

    public enum Bills {
        ONES,
        FIVES,
        TENS,
        TWENTIES,
        FIFTIES,
        HUNDREDS
    }

    public static class NegativeValueException extends Exception {
        public NegativeValueException(Coins type, int value) {
            super("Encountered negative value for Coin " + type.toString() + ": " + value);
        }

        public NegativeValueException(Bills type, int value) {
            super("Encountered negative value for Bill " + type.toString() + ": " + value);
        }
    }

    /* Coins */
    private int cents = 0;
    private int nickels = 0;
    private int dimes = 0;
    private int quarters = 0;

    /* Bills */
    private int ones = 0;
    private int fives = 0;
    private int tens = 0;
    private int twenties = 0;
    private int fifties = 0;
    private int hundreds = 0;

    /**
     * Creates a new Cash object with all empty values
     */
    public Cash() {
    }

    /**
     * Copy constructor
     * @param cash value to be duplicated
     */
    public Cash(Cash cash) {
        cloneFrom(cash);
    }

    /**
     * Copies values from the given cash to this one
     * @param cash Cash amount to be copied
     * @return returns this
     */
    public Cash cloneFrom(Cash cash)  {
        try {
            for (Cash.Bills type : Cash.Bills.values()) {
                setBill(type, cash.getBill(type));
            }
            for (Cash.Coins type : Cash.Coins.values()) {
                setCoin(type, cash.getCoin(type));
            }
        } catch (NegativeValueException e) {
            // this should never happen!
            throw new RuntimeException("Unexpected exception: " + e.getMessage());
        }
        return this;
    }

    /**
     * Sets all coin and bill values to zero
     */
    public void clear() {
        this.cloneFrom(new Cash());
    }

    /**
     * Adds the given cash amount to this cash object
     * @param amount Cash amount to be added
     * @return this Cash object
     */
    public Cash add(Cash amount) {
        try {
            for (Coins type : Coins.values()) {
                addCoin(type, amount.getCoin(type));
            }
            for (Bills type : Bills.values()) {
                addBill(type, amount.getBill(type));
            }
        } catch (NegativeValueException e) {
            // this should never happen!
            throw new RuntimeException("Unexpected exception: " + e.getMessage());
        }
        return this;
    }

    /**
     * Checks if the given Cash amount is present in this Cash object
     * @param amount the cash amount to be checked
     * @return true if the amount is present, false otherwise
     */
    public boolean hasCash(Cash amount) {
        try {
            Cash newCash = new Cash();
            for (Coins type : Coins.values()) {
                newCash.setCoin(type, getCoin(type) - amount.getCoin(type));
            }
            for (Bills type : Bills.values()) {
                newCash.setBill(type, getBill(type) - amount.getBill(type));
            }
        } catch (NegativeValueException e) {
            /* this means there was a negative value, return false */
            return false;
        }
        return true;
    }

    /**
     * Safely subtracts the given amount
     * @param amount amount to be subtracted
     * @return returns itself
     * @throws NegativeValueException if subtraction is not possible
     */
    public Cash subtract(Cash amount) throws NegativeValueException {
        /* Create a duplicate first instead of modifying current values */
        Cash duplicated = new Cash(this);
        for (Coins type : Coins.values()) {
            duplicated.setCoin(type, duplicated.getCoin(type) - amount.getCoin(type));
        }
        for (Bills type : Bills.values()) {
            duplicated.setBill(type, duplicated.getBill(type) - amount.getBill(type));
        }
        /* This means no exception occurred. Safe to actually subtract. */
        return this.cloneFrom(duplicated);
    }

    /**
     * Returns the double value of this Cash
     */
    public double getAmount() {
        return 100 * getHundreds() +
                50 * getFifties() +
                20 * getTwenties() +
                10 * getTens() +
                5 * getFives() +
                getOnes() +
                0.25 * getQuarters() +
                0.10 * getDimes() +
                0.05 * getNickels() +
                0.01 * getCents();
    }

    public boolean amountEquals(Cash cash) {
        return getAmount() == cash.getAmount();
    }

    public boolean amountGreater(Cash cash) {
        return getAmount() > cash.getAmount();
    }

    public boolean amountLesser(Cash cash) {
        return getAmount() < cash.getAmount();
    }

    /**
     * Generic getter for coins
     * @param type type of coins
     * @return number of coins of the given type
     */
    public int getCoin(Cash.Coins type) {
        switch(type) {
            case CENTS -> {
                return getCents();
            }
            case NICKELS -> {
                return getNickels();
            }
            case DIMES -> {
                return getDimes();
            }
            case QUARTERS -> {
                return getQuarters();
            }
        }
        //technically, this should be impossible
        throw new RuntimeException("Unknown coin type: " + type);
    }

    /**
     * Generic getter for bills
     * @param type type of bill
     * @return number of bills of the given type
     */
    public int getBill(Cash.Bills type) {
        switch(type) {
            case ONES -> {
                return getOnes();
            }
            case FIVES -> {
                return getFives();
            }
            case TENS -> {
                return getTens();
            }
            case TWENTIES -> {
                return getTwenties();
            }
            case FIFTIES -> {
                return getFifties();
            }
            case HUNDREDS -> {
                return getHundreds();
            }
        }
        //technically, this should be impossible
        throw new RuntimeException("Unknown bill type: " + type);
    }

    public Cash addCoin(Cash.Coins type, int value) throws NegativeValueException {
        return this.setCoin(type, getCoin(type) + value);
    }

    public Cash addBill(Cash.Bills type, int value) throws NegativeValueException {
        return this.setBill(type, getBill(type) + value);
    }

    /**
     * Generic setter for coins
     * @param type type of coin
     * @param value value of coin to be added
     * @return returns itself
     */
    public Cash setCoin(Cash.Coins type, int value)  throws NegativeValueException {
        switch(type) {
            case CENTS -> {
                return setCents(value);
            }
            case NICKELS -> {
                return setNickels(value);
            }
            case DIMES -> {
                return setDimes(value);
            }
            case QUARTERS -> {
                return setQuarters(value);
            }
        }
        throw new RuntimeException("Unknown coin type: " + type);
    }

    /**
     * Genetic setter for bills
     * @param type type of bill to be set
     * @param value number of bills of the given type
     * @return returns itself
     */
    public Cash setBill(Cash.Bills type, int value) throws NegativeValueException{
        switch(type) {
            case ONES -> {
                return setOnes(value);
            }
            case FIVES -> {
                return setFives(value);
            }
            case TENS -> {
                return setTens(value);
            }
            case TWENTIES -> {
                return setTwenties(value);
            }
            case FIFTIES -> {
                return setFifties(value);
            }
            case HUNDREDS -> {
                return setHundreds(value);
            }
        }
        throw new RuntimeException("Unknown bill type: " + type);
    }

    public Cash setBills(int hundreds, int fifties, int twenties, int tens, int fives, int ones) {
        try {
            this.setHundreds(hundreds)
                    .setFifties(fifties)
                    .setTwenties(twenties)
                    .setTens(tens)
                    .setFives(fives)
                    .setOnes(ones);
            return this;
        } catch (NegativeValueException e) {
            throw new RuntimeException(e);
        }
    }

    public Cash setCoins(int quarters, int dimes, int nickels, int cents) {
        try {
            this.setQuarters(quarters)
                    .setDimes(dimes)
                    .setNickels(nickels)
                    .setCents(cents);
            return this;
        } catch (NegativeValueException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) {
            return false;
        }
        Cash amount = (Cash)obj;
        for (Coins type : Coins.values()) {
            if (getCoin(type) == amount.getCoin(type)) {
                return false;
            }
        }
        for (Bills type : Bills.values()) {
            if (getBill(type) == amount.getBill(type)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return  String.format("Amount: $%.2f ", getAmount()) +
                String.format("[Bills: {100s: %d, 50s: %d, 20s: %d, 10s: %d, 5s: %d, 1s: %d} ",
                getHundreds(), getFifties(), getTwenties(), getTens(), getFives(), getOnes()
                ) +
                String.format("Coins: {Quarters: %d, Dimes: %d, Nickels: %d, Cents: %d}]",
                getQuarters(), getDimes(), getNickels(), getCents()
                );
    }

    /* Getters that return the count */
    public int getCents() {
        return cents;
    }

    public int getNickels() {
        return nickels;
    }

    public int getDimes() {
        return dimes;
    }

    public int getQuarters() {
        return quarters;
    }

    public int getOnes() {
        return ones;
    }

    public int getFives() {
        return fives;
    }

    public int getTens() {
        return tens;
    }

    public int getTwenties() {
        return twenties;
    }

    public int getFifties() {
        return fifties;
    }

    public int getHundreds() {
        return hundreds;
    }

    /* Setters that return self */
    public Cash setCents(int cents) throws NegativeValueException {
        checkNegative(Coins.CENTS, cents);
        this.cents = cents;
        return this;
    }

    public Cash setNickels(int nickels) throws NegativeValueException{
        checkNegative(Coins.NICKELS, nickels);
        this.nickels = nickels;
        return this;
    }

    public Cash setDimes(int dimes) throws NegativeValueException {
        checkNegative(Coins.DIMES, dimes);
        this.dimes = dimes;
        return this;
    }

    public Cash setQuarters(int quarters) throws NegativeValueException {
        checkNegative(Coins.QUARTERS, quarters);
        this.quarters = quarters;
        return this;
    }

    public Cash setOnes(int ones) throws NegativeValueException {
        checkNegative(Bills.ONES, ones);
        this.ones = ones;
        return this;
    }

    public Cash setFives(int fives) throws NegativeValueException {
        checkNegative(Bills.FIVES, fives);
        this.fives = fives;
        return this;
    }

    public Cash setTens(int tens) throws NegativeValueException {
        checkNegative(Bills.TENS, tens);
        this.tens = tens;
        return this;
    }

    public Cash setTwenties(int twenties) throws NegativeValueException {
        checkNegative(Bills.TWENTIES, twenties);
        this.twenties = twenties;
        return this;
    }

    public Cash setFifties(int fifties) throws NegativeValueException {
        checkNegative(Bills.FIFTIES, fifties);
        this.fifties = fifties;
        return this;
    }

    public Cash setHundreds(int hundreds) throws NegativeValueException {
        checkNegative(Bills.HUNDREDS, hundreds);
        this.hundreds = hundreds;
        return this;
    }

    private void checkNegative(Bills type, int value) throws NegativeValueException {
        if(value < 0) {
            throw new NegativeValueException(type, value);
        }
    }

    private void checkNegative(Coins type, int value) throws NegativeValueException {
        if(value < 0) {
            throw new NegativeValueException(type, value);
        }
    }
}
