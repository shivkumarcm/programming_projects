package main.dp.structural.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Ancestor {

    protected String _name;

    protected Ancestor _father;

    protected Ancestor _mother;

    protected List<Ancestor> _spouses;

    protected List<Ancestor> _children;

    protected Person(String name) {
        setName(name);
        _spouses = new ArrayList<Ancestor>();
        _children = new ArrayList<Ancestor>();
    }

    protected Person(String name, Ancestor father) {
        this(name);
        setFather(father);
    }

    protected Person(String name, Ancestor father, Ancestor mother) {
        this(name, father);
        setMother(mother);
    }

    @Override
    public String getName() {
        return _name;
    }

    protected void setName(String _name) {
        this._name = _name;
    }

    @Override
    public Ancestor getFather() {
        return _father;
    }

    @Override
    public Ancestor setFather(Ancestor father) {
        this._father = father;
        return this;
    }

    @Override
    public Ancestor getMother() {
        return _mother;
    }

    @Override
    public Ancestor setMother(Ancestor mother) {
        this._mother = mother;
        return this;
    }

    @Override
    public List<Ancestor> getSpouses() {
        return _spouses;
    }

    @Override
    public Ancestor addSpouse(Ancestor spouse) {
        _spouses.add(spouse);
        return this;
    }

    @Override
    public boolean hasSpouses() {
        return !getSpouses().isEmpty();
    }

    public List<Ancestor> getChildren() {
        return _children;
    }

    public Ancestor addChild(Ancestor child) {
        _children.add(child);
        return this;
    }

    @Override
    public boolean hasChildren() {
        return !getChildren().isEmpty();
    }

    protected String printSpouses() {
        if(!hasSpouses()) {
            return "";
        }
        StringBuilder retval = new StringBuilder();
        for(Ancestor spouse: getSpouses()) {
            retval.append(spouse).append(",");
        }
        return retval.deleteCharAt(retval.lastIndexOf(",")).toString();
    }

    protected String printChildren(boolean withSpouses, boolean withChildren,
                                   boolean withMother, int generations, int level) {
        if(!hasChildren() || generations < 1) {
            return "";
        }
        StringBuilder retval = new StringBuilder();
        for(Ancestor child: getChildren()) {
            retval.append("    ".repeat(level-1)).append(" |__");
            retval.append(child.printNode(withSpouses, withChildren, withMother,
                    generations, level+1)).append("\n");
        }
        return retval.deleteCharAt(retval.lastIndexOf("\n")).toString();
    }

    @Override
    public String printNode(boolean withSpouses, boolean withChildren, boolean withMother) {
        return printNode(withSpouses, withChildren, withMother, MAX_GENERATIONS);
    }

    @Override
    public String printNode(boolean withSpouses, boolean withChildren,
                            boolean withMother, int generations) {
        return printNode(withSpouses, withChildren, withMother, generations, 0);
    }

    public String printNode(boolean withSpouses, boolean withChildren,
                            boolean withMother, int generations, int level) {

        StringBuilder retval = new StringBuilder();
        retval.append(this);
        if(withSpouses && hasSpouses()) {
            retval.append("+").append(printSpouses());
        }
        if(withMother && getMother() != null) {
            retval.append(" m=>"+getMother());
        }
        if(withChildren && hasChildren() && generations > 1) {
            retval.append("\n")
                    .append(printChildren(withSpouses, withChildren, withMother,
                    generations-1, level+1));
        }
        return retval.toString();
    }
}
