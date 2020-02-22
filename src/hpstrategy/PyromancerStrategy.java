package hpstrategy;

import constants.Constants;
import hero.Hero;
import hero.Initialisation;
import modifiers.ModifiersFactory;

public final class PyromancerStrategy implements Strategy {
    @Override
    public void hpStrategy(final Hero striker) {
        if (striker.getStandStill() == Constants.NULL) {
            if ((int) (Constants.Pyr.LMT1 * (Initialisation.Heroes.PHP + striker.getLevel()
                    * Initialisation.Heroes.PLEVEL)) < striker.getHP()
                    && striker.getHP() < (int) (Constants.Pyr.LMT2 * (Initialisation.Heroes.PHP
                    + striker.getLevel()
                    * Initialisation.Heroes.PLEVEL))) {
                striker.setHP((int) (striker.getHP() - striker.getHP() * Constants.Pyr.PHP1));
                ModifiersFactory.getInstance().changeModifiers(Constants.Pyr.P1, striker);
            }
            if (striker.getHP() < (int) (Constants.Pyr.LMT1 * Initialisation.Heroes.PHP
                    + striker.getLevel()
                    * Initialisation.Heroes.PLEVEL)) {
                striker.setHP((int) (striker.getHP() + striker.getHP() * (Constants.Pyr.PHP2)));
                ModifiersFactory.getInstance().changeModifiers(-Constants.Pyr.P2, striker);
            }
        }
    }
}
