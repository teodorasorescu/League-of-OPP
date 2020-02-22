package thegreatmagician;

import angels.Angel;
import constants.Constants;
import hero.Hero;
import hero.HeroActions;

public class Powers extends Observer {

    @Override
    public final void update(final Hero hero, final Angel angel, final Hero striker) {
        //it notices the great magician if an hero was helped by an angel
        HeroActions actions = new HeroActions();
        if (angel != null && hero != null
                && hero.getKilledbyHero() == Constants.NULL
                && hero.getKilledbyAngel() == Constants.NULL) {
            //if the angels are bad
            if ((angel.getType().equals("TheDoomer") || angel.getType().equals("Dracula")
                    || angel.getType().equals("DarkAngel"))) {
                System.out.println(angel.getType() + " hit "
                        + actions.intoWords(hero) + " " + hero.getNumber());
            } else if (hero.getDead() == Constants.NULL
                    && !angel.getType().equals("Spawner")) {
                //for the good angels
                System.out.println(angel.getType() + " helped "
                        + actions.intoWords(hero) + " " + hero.getNumber());
            }

        } else if (angel != null && hero != null && hero.getBeenThere() == Constants.Sem.TRUE
                && (angel.getType().equals("TheDoomer") || angel.getType().equals("Dracula")
                        || angel.getType().equals("DarkAngel"))) {
            System.out.println(angel.getType() + " hit " + actions.intoWords(hero)
                    + " " + hero.getNumber());
        } else if (angel != null && hero != null
                && hero.getBroughtToLife() == Constants.Sem.TRUE) {
            //for the brought to life angels
            System.out.println(angel.getType() + " helped " + actions.intoWords(hero)
                    + " " + hero.getNumber());
        } else if (angel != null && hero != null && hero.getDead() == Constants.NULL
                && !angel.getType().equals("Spawner")) {
            System.out.println(angel.getType() + " helped " + actions.intoWords(hero)
                    + " " + hero.getNumber());
        }
    }
}
