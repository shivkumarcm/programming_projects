package main.dp.structural.composite;

public class Man extends Person {

    public Man(String name) {
        super(name);
    }

    public Man(String name, Ancestor father) {
        super(name, father);
    }

    public Man(String name, Ancestor father, Ancestor mother) {
        super(name, father, mother);
    }

    @Override
    public Gender getGender() {
        return Gender.MALE;
    }

    @Override
    public String toString() {
        return "[" + getName() + "]";
    }
}
