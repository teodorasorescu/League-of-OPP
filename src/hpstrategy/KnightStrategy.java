package hpstrategy;

import constants.Constants;
import hero.Hero;
import hero.Initialisation;
import modifiers.ModifiersFactory;

public final class KnightStrategy implements Strategy {
    @Override
    public void hpStrategy(final Hero striker) {
        if (striker.getStandStill() == Constants.NULL) {
            if ((int) (Constants.Knight.LMT1 * (Initialisation.Heroes.KHP + striker.getLevel()
                    * Initialisation.Heroes.KLEVEL)) < striker.getHP()
                    && striker.getHP() < Constants.Knight.LMT2 * (Initialisation.Heroes.KHP
                    + striker.getLevel()
                    * Initialisation.Heroes.KLEVEL)) {
                striker.setHP((int) (striker.getHP() - striker.getHP() * Constants.Knight.KHP1));
                ModifiersFactory.getInstance().changeModifiers(Constants.Knight.K1, striker);
            }
            if (striker.getHP() < (int) (Constants.Knight.LMT1 * (Initialisation.Heroes.KHP
                    + striker.getLevel()
                    * Initialisation.Heroes.KLEVEL))) {
                striker.setHP((int) (striker.getHP() + striker.getHP() * Constants.Knight.KHP2));
                ModifiersFactory.getInstance().changeModifiers(-Constants.Knight.K2, striker);
            }
        }
    }
}
