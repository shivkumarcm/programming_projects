package main.dp.structural.composite;

public class Main {
    public static void main(String[] args) throws Exception {

        // Set up the people in first and second generation
        Ancestor abe = new ChosenMan("Abraham");
        Ancestor sarah = new Woman("Sarah");
        Ancestor hagar = new Woman("Hagar");
        Ancestor ishmael = new Man("Ishmael", abe, hagar);
        Ancestor isaac = new ChosenMan("Isaac", abe, sarah);

        // Storyline of adding spouses and children
        abe.addSpouse(sarah).addSpouse(hagar).addChild(ishmael).addChild(isaac);

        // Set up the people in second and third generation
        Ancestor rebekah = new Woman("Rebekah");
        Ancestor jacob = new ChosenMan("Jacob", isaac, rebekah);
        Ancestor esau = new Man("Esau", isaac, rebekah);

        // Storyline of adding spouses and children
        isaac.addSpouse(rebekah).addChild(esau).addChild(jacob);

        // Set up the people in third and fourth generation
        Ancestor leah = new Woman("Leah");
        Ancestor rachel = new Woman("Rachel");
        Ancestor reuben = new Man("Reuben", jacob, leah);
        Ancestor simeon = new Man("Simeon", jacob, leah);
        Ancestor levi = new Man("Levi", jacob, leah);
        Ancestor judah = new ChosenMan("Judah", jacob, leah);
        Ancestor dinah = new Woman("Dinah", jacob, leah);
        Ancestor joseph = new Man("Joseph", jacob, rachel);
        Ancestor benjamin = new Man("Benjamin", jacob, rachel);

        // Storyline of adding spouses and children
        jacob.addSpouse(leah).addSpouse(rachel)
                .addSpouse(new Woman("Bilhah")).addSpouse(new Woman("Zilpah"));
        jacob.addChild(reuben).addChild(simeon).addChild(levi).addChild(judah).addChild(dinah)
                .addChild(joseph).addChild(benjamin);

        // Adding the fifth generation
        Ancestor tamar = new Woman("Tamar");
        judah.addChild(new ChosenMan("Perez", judah, tamar))
                .addChild(new Man("Zerah", judah, tamar));

        Ancestor asenath = new Woman("Asenath");
        joseph.addSpouse(asenath)
                .addChild(new Man("Ephraim", joseph, asenath))
                .addChild(new Man("Manasseh", joseph, asenath));

        // Print Abe's family tree
        System.out.println("###################### This is Abraham's family ######################");
        System.out.println(abe.printNode(true, true, true));

        System.out.println("###################### This is Jacob's family ######################");
        System.out.println(jacob.printNode(true, true, false));

        // Now let's back up and add a 0th Generation
        Ancestor terah = new ChosenMan("Terah");
        terah.addChild(new Man("Nahor", terah));
        Ancestor haran = new Man("Haran", terah);
        terah.addChild(haran.addChild(new Man("Lot", haran)));
        terah.addChild(abe);

        System.out.println("###################### This is Jacob's family ######################");
        System.out.println(jacob.printNode(true, true, true));

        int gens = 4;
        System.out.printf("###################### This is Terah's family (%d generations) ######################\n", gens);
        System.out.println(terah.printNode(false, true, false, gens));

    }
}
