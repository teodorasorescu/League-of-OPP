package thegreatmagician;

import angels.Angel;
import constants.Constants;
import hero.Hero;
import hero.HeroActions;


public class AngelLife extends Observer {
    @Override
    public final void update(final Hero hero, final Angel angel, final Hero striker) {
        HeroActions actions = new HeroActions();
        //it notices the great magician if an hero was killed or brought to life
        if (hero != null) {
            if (hero.getDead() == Constants.Sem.TRUE) {
                //if the hero was killed by another hero
                if (angel == null) {
                    System.out.println("Player " + actions.intoWords(hero) + " "
                            + hero.getNumber()
                            + " was killed by " + actions.intoWords(striker) + " "
                            + striker.getNumber());
                    //it sets the flag
                    hero.setKilledbyHero(Constants.Sem.TRUE);

                } else if (hero.getKilledbyAngel() == Constants.NULL
                        && hero.getKilledbyHero() == Constants.NULL) {
                    //if the hero was killed by an angel
                    System.out.println("Player " + actions.intoWords(hero) + " "
                            + hero.getNumber()
                            + " was killed by an angel");
                    //it sets the flag
                    hero.setKilledbyAngel(Constants.Sem.TRUE);

                }
            }
            //if the hero was killed by the Doomer angel
            if (angel != null && hero.getBeenThere() == Constants.Sem.TRUE
                    && angel.getType().equals("TheDoomer")) {
                System.out.println("Player " + actions.intoWords(hero) + " "
                        + hero.getNumber()
                        + " was killed by an angel");
            } else if (hero.getBroughtToLife() == Constants.Sem.TRUE
                    && angel.getType().equals("Spawner")) {
                //if the hero was brought to life by the Spawner
                System.out.println("Player " + actions.intoWords(hero) + " " + hero.getNumber()
                        + " was brought to life by an angel ");
                //it sets the flags
                hero.setBroughtToLife(Constants.NULL);
                hero.setBeenThere(Constants.Sem.TRUE);
            }
        }
    }
}
