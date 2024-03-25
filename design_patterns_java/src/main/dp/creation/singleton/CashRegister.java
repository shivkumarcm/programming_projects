package main.dp.creation.singleton;

/**
 * A simple implementation of a singleton design pattern.
 * Imagine a store with only one cash register instance.
 */
public class CashRegister {

    private final Cash _totalCash;

    private CashRegister() {
        _totalCash = new Cash();
    }

    private static CashRegister _SINGLETON_INSTANCE;

    public static synchronized CashRegister getInstance() {
        if(_SINGLETON_INSTANCE == null) {
            _SINGLETON_INSTANCE = new CashRegister();
        }
        return _SINGLETON_INSTANCE;
    }

    /**
     * @return Returns a clone representing total cash
     */
    public Cash getTotalCash() {
        return new Cash(_totalCash);
    }

    public void addCash(Cash cash) {
        this._totalCash.add(cash);
    }

    public void removeCash(Cash cash) throws Cash.NegativeValueException {
        this._totalCash.subtract(cash);
    }

    /**
     * Open the cash register and adds the given cash
     * @param cash Cash to be added to the register
     */
    public void open(Cash cash) {
        addCash(cash);
    }

    /**
     * Empties the cash register and returns a cloned value of the Cash in it
     * @return the cloned value of the Cash in it
     */
    public Cash closeOut() {
        Cash todaysCash = new Cash(getTotalCash());
        _totalCash.clear();
        return todaysCash;
    }

    @Override
    public String toString() {
        return getTotalCash().toString();
    }
}
