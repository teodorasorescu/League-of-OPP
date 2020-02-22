package strategy;

import constants.Constants;
import hero.Hero;
import hero.HeroActions;
import modifiers.ModifiersFactory;

public class LevelUpStrategy implements Strategy {
    private HeroActions actions = new HeroActions();

    @Override
    public final void angelAction(final Hero hero) {
        //it sets the new XP and it makes level up if it will be needed
        if (hero.getDead() == Constants.NULL) {
            if (hero.getLevel() == Constants.LevelUP.NULL) {
                hero.setXP(Constants.LevelUP.LIMIT1);
                actions.XP_level_up(hero);
            } else if (hero.getLevel() == Constants.LevelUP.LVL1) {
                hero.setXP(Constants.LevelUP.LIMIT2);
                actions.XP_level_up(hero);
            } else if (hero.getLevel() == Constants.LevelUP.LVL2) {
                hero.setXP(Constants.LevelUP.LIMIT3);
                actions.XP_level_up(hero);
            } else if (hero.getLevel() == Constants.LevelUP.LVL3) {
                hero.setXP(Constants.LevelUP.LIMIT4);
                actions.XP_level_up(hero);
            } else if (hero.getLevel() >= Constants.LevelUP.LVL4) {
                hero.setXP(hero.getXP() + (Constants.LvlUp.LVL
                        - hero.getXP() % Constants.LvlUp.LVL));
                actions.XP_level_up(hero);
            }
            //it sets the new modifiers
            if (hero.getRace().equals("K")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.LvlUp.K, hero);

            } else if (hero.getRace().equals("P")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.LvlUp.P, hero);

            } else if (hero.getRace().equals("R")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.LvlUp.R, hero);

            } else if (hero.getRace().equals("W")) {
                ModifiersFactory.getInstance().changeModifiers(Constants.LvlUp.W, hero);
            }
        }
    }

    public final HeroActions getActions() {
        return actions;
    }

    public final void setActions(final HeroActions actions) {
        this.actions = actions;
    }
}
