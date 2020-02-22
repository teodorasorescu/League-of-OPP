package hpstrategy;

import hero.Hero;

public class HpStrategy {
    //it calls the specified strategy of an hero
    public final void execute(final Strategy strategy, final Hero hero) {
        strategy.hpStrategy(hero);
    }
}
