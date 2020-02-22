package strategy;

import constants.Constants;
import hero.Hero;
import modifiers.ModifiersFactory;

public class SmallStrategy implements Strategy {
    @Override
    public final void angelAction(final Hero hero) {
        //it sets the HP and the modifiers
        if (hero.getDead() == Constants.NULL) {
            if (hero.getRace().equals("K")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.Small.K, hero);
                hero.setHP(hero.getHP() + Constants.Small.KHP);
            } else if (hero.getRace().equals("P")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.Small.P, hero);
                hero.setHP(hero.getHP() +  Constants.Small.PHP);
            } else if (hero.getRace().equals("R")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.Small.R, hero);
                hero.setHP(hero.getHP() +  Constants.Small.RHP);
            } else if (hero.getRace().equals("W")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.Small.W, hero);
                hero.setHP(hero.getHP() +  Constants.Small.WHP);
            }
        }
    }
}
