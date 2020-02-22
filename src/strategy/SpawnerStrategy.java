package strategy;

import constants.Constants;
import hero.Hero;

public class SpawnerStrategy implements Strategy {
    @Override
    public final void angelAction(final Hero hero) {
        //if the hero is dead, this angel will brought him to life
        if (hero.getDead() == Constants.Sem.TRUE) {
            if (hero.getRace().equals("K")) {
                hero.setHP(Constants.Spawner.KHP);
            } else if (hero.getRace().equals("P")) {
                hero.setHP(Constants.Spawner.PHP);
            } else if (hero.getRace().equals("R")) {
                hero.setHP(Constants.Spawner.RHP);
            } else if (hero.getRace().equals("W")) {
                hero.setHP(Constants.Spawner.WHP);
            }
            hero.setDead(Constants.NULL);
            hero.setBroughtToLife(Constants.Sem.TRUE);
        }
    }
}
