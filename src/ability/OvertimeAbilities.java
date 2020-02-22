
package ability;

import constants.Constants;
import hero.Hero;
import hero.HeroActions;
import modifiers.ModifiersFactory;
import thegreatmagician.AngelLife;
import thegreatmagician.TheGreatMagician;


import java.io.IOException;

import static java.lang.Math.round;

public final class OvertimeAbilities {
    public void identifyBonus(final Hero opponent) {
        if (opponent.getLocation() == 'W') {
            opponent.setBonusLand(Constants.Land.WOODS);
        } else {
            opponent.setBonusLand(Constants.Land.NEUTRAL);
        }
    }

    public void ignite(final Hero opponent, final String filename) throws IOException {
        float damage1;
        HeroActions actions = new HeroActions();
        AngelLife angelLife = new AngelLife();
        TheGreatMagician theGreatMagician = TheGreatMagician.getInstance();
        theGreatMagician.add(angelLife);
        //calculates the damage for the overtime rounds
        if (opponent.getPyrStriker() != null) {
            damage1 = round(((Constants.Damages.LESSDMG))
                    * ModifiersFactory.getInstance().getPyromancerModifiers2(opponent.getRace()));
            opponent.setDamage(opponent.getDamage() + damage1);

            //verifies if the hero dies from overtime damage
            if (opponent.getDead() == Constants.NULL
                    && (opponent.getHP() - opponent.getDamage()) < Constants.NULL) {
                opponent.setDead(Constants.Sem.TRUE);
                opponent.setBroughtToLife(Constants.NULL);
                opponent.setKilledbyHero(Constants.Sem.TRUE);
                theGreatMagician.execute(opponent, null, opponent.getPyrStriker());
            }
            //sets the flag
            opponent.setHP((int) (opponent.getHP() - opponent.getDamage()));
            opponent.setNoLessDamage(opponent.getNoLessDamage() - Constants.SUM);
            actions.verifyIfItsDead(opponent, opponent.getPyrStriker(), filename);
        }
    }

    public void paralysis(final Hero opponent) {
        if (opponent.getParalysis() != null) {
            identifyBonus(opponent);
            //calculates the damage
            float damage2 = round(round(opponent.getBonusLand() * (Constants.Damages.PARALYSISDMG))
                    * ModifiersFactory.getInstance().getRogueModifiers2(opponent.getRace()));
            opponent.setDamage(opponent.getDamage() + damage2);
            //verifies if the hero dies from overtime damage
            if ((opponent.getHP() - opponent.getDamage()) < Constants.NULL) {
                opponent.setDead(Constants.Sem.TRUE);
                opponent.setBroughtToLife(Constants.NULL);
                opponent.setKilledbyHero(Constants.Sem.TRUE);
            }
        }
    }
}

