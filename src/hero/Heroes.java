package hero;

public interface Heroes {

    //double dispatch
    void fightsWith(Hero hero);

    void interactWith(Knight knight);

    void interactWith(Pyromancer pyromancer);

    void interactWith(Rogue rogue);

    void interactWith(Wizard wizard);

    void addLandModifier(Hero hero);

    //strategy
    void newFeatures(Hero hero);
}
