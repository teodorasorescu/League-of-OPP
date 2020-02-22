package strategy;

import constants.Constants;
import hero.Hero;
import modifiers.ModifiersFactory;

public class DraculaStrategy implements Strategy {
    @Override
    public final void angelAction(final Hero hero) {
        //it changes the HP and the modifiers if the hero is alive
        if (hero.getDead() == Constants.NULL) {
            if (hero.getRace().equals("K")) {
                ModifiersFactory.getInstance().changeModifiers(-Constants.Dracula.K, hero);
                hero.setHP(hero.getHP() - Constants.Dracula.KHP);

            } else if (hero.getRace().equals("P")) {
                ModifiersFactory.getInstance().changeModifiers(-Constants.Dracula.P, hero);
                hero.setHP(hero.getHP() - Constants.Dracula.PHP);

            } else if (hero.getRace().equals("R")) {
                ModifiersFactory.getInstance().changeModifiers(-Constants.Dracula.R, hero);
                hero.setHP(hero.getHP() - Constants.Dracula.RHP);

            } else if (hero.getRace().equals("W")) {
                ModifiersFactory.getInstance().changeModifiers(-Constants.Dracula.W, hero);
                hero.setHP(hero.getHP() - Constants.Dracula.WHP);
            }
        }
    }
}
