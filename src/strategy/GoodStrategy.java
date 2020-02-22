package strategy;

import constants.Constants;
import hero.Hero;
import modifiers.ModifiersFactory;

public class GoodStrategy implements Strategy {
    @Override
    public final void angelAction(final Hero hero) {
        //it changes the modifiers and the HP if the hero is alive
        if (hero.getDead() == Constants.NULL) {
            if (hero.getRace().equals("K")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.Good.K, hero);
                hero.setHP(hero.getHP() + Constants.Good.KHP);

            } else if (hero.getRace().equals("P")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.Good.P, hero);
                hero.setHP(hero.getHP() + Constants.Good.PHP);

            } else if (hero.getRace().equals("R")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.Good.R, hero);
                hero.setHP(hero.getHP() + Constants.Good.RHP);

            } else if (hero.getRace().equals("W")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.Good.W, hero);
                hero.setHP(hero.getHP() + Constants.Good.WHP);
            }
        }
    }
}
