package main.dp.creation.singleton;

/**
 * A simple implemntation of a singleton design pattern.
 * Imagine a store with only one cash register instance.
 */
public class CashRegister {

    private Cash _totalCash;

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
     * Returns a clone representing total cash
     * @return
     */
    public Cash getTotalCash() {
        return new Cash(_totalCash);
    }

    public void setTotalCash(Cash cash) {
        this._totalCash = new Cash(cash);
    }

    /**
     * Open the cash register with the given cash
     * @param cash
     */
    public void open(Cash cash) {
        setTotalCash(cash);
    }

    /**
     * Empties the cash register and returns a cloned value of the Cash in it
     * @return
     */
    public Cash close() {
        Cash todaysCash = new Cash(getTotalCash());
        _totalCash.clear();
        return todaysCash;
    }

    @Override
    public String toString() {
        return "Cash Register Total Value = " + getTotalCash().toString();
    }
}
