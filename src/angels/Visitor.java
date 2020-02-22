package angels;

import hero.Hero;

public interface Visitor {
    void visit(DamageAngel damageAngel, Hero hero);

    void visit(DarkAngel darkAngel, Hero hero);

    void visit(Dracula dracula, Hero hero);

    void visit(GoodBoy goodBoy, Hero hero);

    void visit(LevelUpAngel levelUpAngel, Hero hero);

    void visit(LifeGiver lifeGiver, Hero hero);

    void visit(SmallAngel smallAngel, Hero hero);

    void visit(Spawner spawner, Hero hero);

    void visit(TheDoomer theDoomer, Hero hero);

    void visit(XPAngel xpAngel, Hero hero);
}
