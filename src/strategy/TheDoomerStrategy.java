package strategy;

import constants.Constants;
import hero.Hero;

public class TheDoomerStrategy implements Strategy {
    @Override
    public final void angelAction(final Hero hero) {
        //if the hero is dead, this angel will brought him to life
        if (hero.getDead() == Constants.Sem.FALSE) {
            hero.setDead(Constants.Sem.TRUE);
        }
    }
}
