package strategy;

import constants.Constants;
import hero.Hero;

public class XpStrategy implements Strategy {
    @Override
    public final void angelAction(final Hero hero) {
        //it sets the new XP
        if (hero.getDead() == Constants.NULL) {
            if (hero.getRace().equals("K")) {
                hero.setXP(hero.getXP() + Constants.Xp.KXP);
            } else if (hero.getRace().equals("P")) {
                hero.setXP(hero.getXP() + Constants.Xp.PXP);
            } else if (hero.getRace().equals("R")) {
                hero.setXP(hero.getXP() + Constants.Xp.RXP);
            } else if (hero.getRace().equals("W")) {
                hero.setXP(hero.getXP() + Constants.Xp.WXP);
            }
        }
    }
}
