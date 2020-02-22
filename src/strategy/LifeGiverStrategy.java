package strategy;

import constants.Constants;
import hero.Hero;

public class LifeGiverStrategy implements Strategy {
    @Override
    public final void angelAction(final Hero hero) {
        //it set the HP if the hero is alive
        if (hero.getDead() == Constants.NULL) {
            if (hero.getRace().equals("K")) {
                hero.setHP(hero.getHP() + Constants.LifeGiver.KHP);
            } else if (hero.getRace().equals("P")) {
                hero.setHP(hero.getHP() + Constants.LifeGiver.PHP);
            } else if (hero.getRace().equals("R")) {
                hero.setHP(hero.getHP() + Constants.LifeGiver.RHP);
            } else if (hero.getRace().equals("W")) {
                hero.setHP(hero.getHP() + Constants.LifeGiver.WHP);
            }
        }
    }
}
