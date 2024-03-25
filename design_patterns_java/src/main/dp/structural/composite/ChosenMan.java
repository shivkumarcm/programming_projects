package main.dp.structural.composite;

public class ChosenMan extends Man {

    public ChosenMan(String name) {
        super(name);
    }

    public ChosenMan(String name, Ancestor father) {
        super(name, father);
    }

    public ChosenMan(String name, Ancestor father, Ancestor mother) {
        super(name, father, mother);
    }

    @Override
    public String toString() {
        return "[" + getName().toUpperCase() + "]";
    }
}
