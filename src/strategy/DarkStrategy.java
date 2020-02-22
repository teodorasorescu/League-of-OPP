package strategy;

import constants.Constants;
import hero.Hero;


public class DarkStrategy implements Strategy {

    @Override
    public final void angelAction(final Hero hero) {
        //it changes the HP if the hero is alive
        if (hero.getDead() == Constants.NULL) {
            if (hero.getRace().equals("K")) {
                hero.setHP(hero.getHP() - Constants.Dark.K);
            } else if (hero.getRace().equals("P")) {
                hero.setHP(hero.getHP() - Constants.Dark.P);
            } else if (hero.getRace().equals("R")) {
                hero.setHP(hero.getHP() - Constants.Dark.R);
            } else if (hero.getRace().equals("W")) {
                hero.setHP(hero.getHP() - Constants.Dark.W);
            }
        }
    }
}
