package hpstrategy;

import constants.Constants;
import hero.Hero;
import hero.Initialisation;
import modifiers.ModifiersFactory;

public final class RogueStrategy implements Strategy {
    @Override
    public void hpStrategy(final Hero striker) {
        if (striker.getStandStill() == Constants.NULL) {
            if ((int) (Constants.Rogue.LMT1 * (Initialisation.Heroes.RHP
                    + striker.getLevel()
                    * Initialisation.Heroes.RLEVEL)) < striker.getHP()
                    && striker.getHP() < (int) (Constants.Rogue.LMT2 * (Initialisation.Heroes.RHP
                    + striker.getLevel()
                    * Initialisation.Heroes.RLEVEL))) {
                striker.setHP((int) (striker.getHP() - striker.getHP() * (Constants.Rogue.RHP1)));
                ModifiersFactory.getInstance().changeModifiers(Constants.Rogue.R1, striker);
            }
            if (striker.getHP() < (int) (Constants.Rogue.LMT1
                    * (Initialisation.Heroes.RHP + striker.getLevel()
                    * Initialisation.Heroes.RLEVEL))) {
                striker.setHP((int) (striker.getHP() + striker.getHP() * Constants.Rogue.RHP2));
                ModifiersFactory.getInstance().changeModifiers(-Constants.Rogue.R2, striker);
            }
        }
    }
}
