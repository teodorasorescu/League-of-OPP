package strategy;

import constants.Constants;
import hero.Hero;
import modifiers.ModifiersFactory;


public class DamageStrategy implements Strategy {
    @Override
    public final void angelAction(final Hero hero) {
        //it changes the modifiers if the hero is alive
        if (hero.getDead() == Constants.NULL) {
            if (hero.getRace().equals("K")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.DmgStr.K, hero);
            } else if (hero.getRace().equals("P")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.DmgStr.P, hero);
            } else if (hero.getRace().equals("R")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.DmgStr.R, hero);
            } else if (hero.getRace().equals("W")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.DmgStr.W, hero);
            }
        }
    }
}
