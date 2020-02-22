package hpstrategy;

import constants.Constants;
import hero.Hero;
import hero.Initialisation;
import modifiers.ModifiersFactory;

public final class WizardStrategy implements Strategy {
    @Override
    public void hpStrategy(final Hero striker) {
        if (striker.getStandStill() == Constants.NULL) {
            if ((int) (Constants.Wizard.LMT1 * (Initialisation.Heroes.WHP
                    + Initialisation.Heroes.KLEVEL
                    * striker.getLevel())) < striker.getHP() && striker.getHP()
                    < (int) (Constants.Wizard.LMT2 * (Initialisation.Heroes.WHP
                    + Initialisation.Heroes.KLEVEL
                    * striker.getLevel()))) {
                ModifiersFactory.getInstance().changeModifiers(Constants.Wizard.W1, striker);
                striker.setHP((int) (striker.getHP() - striker.getHP() * Constants.Wizard.WHP1));
            }
            if (striker.getHP() < (int) (Constants.Wizard.LMT1
                    * (Initialisation.Heroes.WHP + Initialisation.Heroes.KLEVEL
                    * striker.getLevel()))) {
                ModifiersFactory.getInstance().changeModifiers(-Constants.Wizard.W2, striker);
                striker.setHP((int) (striker.getHP() + striker.getHP() * Constants.Wizard.WHP2));
            }
        }
    }
}
