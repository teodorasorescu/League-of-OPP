package strategy;

import hero.Hero;

public class Messenger {
    //it calls the specified strategy of an angel
    public final void appearance(final Strategy strategy, final Hero hero) {
        strategy.angelAction(hero);
    }
}
