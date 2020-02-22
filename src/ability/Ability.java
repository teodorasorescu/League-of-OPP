package ability;

import hero.Hero;

public abstract class Ability {
    public abstract void firstAbility(Hero opponent, Hero striker);
    public abstract void secondAbility(Hero opponent, Hero striker);
}
