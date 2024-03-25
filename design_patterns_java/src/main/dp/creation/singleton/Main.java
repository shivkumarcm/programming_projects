package main.dp.creation.singleton;

public class Main {
    public static void main(String args[]) {
        CashRegister register = CashRegister.getInstance();

        Cash openingCashValue = new Cash()
                .setBills(3, 2, 6, 2, 10, 1)
                .setCoins(20, 10, 5, 8);

        register.open(openingCashValue);

        System.out.println(register);
    }
}
