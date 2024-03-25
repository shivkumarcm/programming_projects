package main.dp.structural.composite;

public class Woman extends Person {

    public Woman(String name) {
        super(name);
    }

    public Woman(String name, Ancestor father) {
        super(name, father);
    }

    public Woman(String name, Ancestor father, Ancestor mother) {
        super(name, father, mother);
    }

    @Override
    public Gender getGender() {
        return Gender.FEMALE;
    }

    @Override
    public String toString() {
        return "(" + getName() + ")";
    }
}
