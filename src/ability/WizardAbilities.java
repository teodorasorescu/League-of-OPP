package ability;

import constants.Constants;
import constants.InitialHP;
import hero.Hero;


import static java.lang.Float.min;
import static java.lang.Math.round;


public final class WizardAbilities extends Ability {

    @Override
    //DRAIN
    public void firstAbility(final Hero opponent, final Hero striker) {
        float x, baseHp, damage1;
        //verifies on which land is on
        if (striker.getLocation() == 'D') {
            striker.setBonusLand(Constants.Land.DESERT);
        } else {
            striker.setBonusLand(Constants.Land.NEUTRAL);
        }
        //calculates the procent and the damage
        InitialHP initialHP = new InitialHP();

        x = Constants.Damages.PROCENTDMG + Constants.Damages.PROCENTLVL * striker.getLevel();

        baseHp = min((Constants.Damages.BASEHP * (initialHP.getMaxHp(opponent)
                        + initialHP.getMaxPerLevel(opponent) * opponent.getLevel())),
                opponent.getHP());
        damage1 = round((x / Constants.TOPROCENT * striker.getBonusLand())
                * striker.getModifiers1().get(opponent.getRace()) * baseHp);

        //sets the damage
        opponent.setDamage(opponent.getDamage() + (damage1));

    }

    @Override
    //DEFLECT
    public void secondAbility(final Hero opponent, final Hero striker) {
        float damage2;
        //calculates the damage for the heroes which are not wizards
        if (opponent.getRace() != "W") {
            damage2 = (float) round(((Constants.Damages.DEFLECTDMG
                    + Constants.Damages.DEFLECTLVL * striker.getLevel())
                    * striker.getWithoutModifiers()
                    * striker.getBonusLand())
                    * striker.getModifiers2().get(opponent.getRace()));
            //sets the damage
            opponent.setDamage(opponent.getDamage() + damage2);


        }
    }
}

