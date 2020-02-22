package thegreatmagician;

import angels.Angel;
import constants.Constants;
import hero.Hero;
import hero.HeroActions;


public class LevelUp extends Observer {
    @Override
    public final void update(final Hero hero, final Angel angel, final Hero striker) {
        //it notices the great magician if an hero levels up
        HeroActions actions = new HeroActions();
        int nr;
        if (hero != null && hero.getDead() == Constants.NULL
                && hero.getReachedLevel() == Constants.Sem.TRUE
                && hero.getLevel() != hero.getLevelBefore()) {
            nr = hero.getLevel() - hero.getLevelBefore();
            for (int i = hero.getLevelBefore() + 1; i < nr; i++) {
                System.out.println(actions.intoWords(hero) + " " + hero.getNumber()
                        + " reached level " + i);
            }
            System.out.println(actions.intoWords(hero) + " " + hero.getNumber()
                    + " reached level " + hero.getLevel());
            //it sets the flags
            hero.setLevelBefore(hero.getLevel());
            hero.setReachedLevel(Constants.NULL);
        }
    }
}
