package main.dp.structural.composite;

import java.util.List;

public interface Ancestor {

    enum Gender { MALE, FEMALE };

    int MAX_GENERATIONS = 100;

    String getName();

    Ancestor getFather();

    Ancestor setFather(Ancestor father);

    Ancestor getMother();

    Ancestor setMother(Ancestor mother);

    List<Ancestor> getSpouses();

    Ancestor addSpouse(Ancestor spouse);

    boolean hasSpouses();

    List<Ancestor> getChildren();

    Ancestor addChild(Ancestor child);

    boolean hasChildren();

    Gender getGender();

    String printNode(boolean withSpouses, boolean withChildren, boolean withMother);

    String printNode(boolean withSpouses, boolean withChildren, boolean withMother, int generations);

    String printNode(boolean withSpouses, boolean withChildren, boolean withMother, int generations, int level);
}
