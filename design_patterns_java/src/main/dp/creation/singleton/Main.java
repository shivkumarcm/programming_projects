package main.dp.creation.singleton;

public class Main {
    public static void main(String[] args) throws Exception {
        CashRegister register = CashRegister.getInstance();

        Cash openingCashValue = new Cash()
                .setBills(3, 2, 6, 2, 10, 4)
                .setCoins(20, 10, 5, 8);

        System.out.println("################## Opening Cash Register ##################");
        register.open(openingCashValue);
        System.out.println("Cash Register Value         : " + register);
        assert register.getTotalCash().getAmount() == 600.33 : "Opening cash value error";

        Cash tenDollarsThirtySixCents = new Cash().setTens(1).setQuarters(1).setDimes(1).setCents(1);
        System.out.println("Adding Cash to register     : " + tenDollarsThirtySixCents);
        register.addCash(tenDollarsThirtySixCents);
        System.out.println("Cash Register Value         : " + register);
        assert register.getTotalCash().getAmount() == 600.33 + 10.36 : "Error in adding cash";
        assert register.getTotalCash().amountGreater(openingCashValue);

        Cash fourDollarsTwelveCents = new Cash().setOnes(4).setNickels(2).setCents(2);
        System.out.println("Removing Cash from register : " + fourDollarsTwelveCents);
        assert register.getTotalCash().hasCash(fourDollarsTwelveCents);
        assert fourDollarsTwelveCents.amountLesser(register.getTotalCash());
        register.removeCash(fourDollarsTwelveCents);
        System.out.println("Cash Register Value         : " + register);
        assert register.getTotalCash().getAmount() == 600.33 + 10.36 - 4.12 : "Error in removing cash";

        assert register.getTotalCash().hasCash(new Cash().setHundreds(2));
        assert register.getTotalCash().hasCash(new Cash().setQuarters(21));

        System.out.println("################## Closing Cash Register ##################");
        Cash closingCash = register.closeOut();
        System.out.println("Closing Cash                : " + closingCash.toString());
        // 600.33 + 10.36 - 4.12 = 606.57
        assert closingCash.amountEquals(new Cash()
                .setHundreds(6).setFives(1).setQuarters(6).setNickels(1).setCents(2)) :
                "Error in closing amount!!!";
    }
}
