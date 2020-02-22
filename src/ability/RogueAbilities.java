package ability;

import constants.Constants;
import hero.Hero;

import static java.lang.Math.round;

public final class RogueAbilities extends Ability {
    public RogueAbilities() {
    }

    @Override
    //BACKSTAB
    public void firstAbility(final Hero opponent, final Hero striker) {
        float damage1, withoutModifiers, critical;
        //verifies on which land is on
        if (striker.getLocation() == 'W') {
            striker.setBonusLand(Constants.Land.WOODS);
        } else {
            striker.setBonusLand(Constants.Land.NEUTRAL);
        }
        //verifies if the hero will give a critical hit and it will set it
        if (striker.getCritical() % Constants.DIVIDE == Constants.NULL
                && striker.getLocation() == 'W') {
            critical = Constants.Damages.CRITICAL;
        } else if (striker.getCritical() % Constants.DIVIDE == Constants.NULL
                && striker.getLocation() != 'W') {
            striker.setCritical(Constants.Sem.FALSE);
            critical = Constants.Sem.TRUE;
        } else {
            critical = Constants.Sem.TRUE;
        }

        striker.setCritical(striker.getCritical() + Constants.SUM);

        //calculates the damage
        damage1 = round(round(striker.getBonusLand() * critical * (Constants.Damages.BACKSTABDMG
                + Constants.Damages.BACKSTABLVL * striker.getLevel()))
                * striker.getModifiers1().get(opponent.getRace()));


        /*calculates the damage without modifiers in case the opponent
                will be attacked by a wizard
                 */

        if (opponent.getRace().equals("W")) {
            withoutModifiers = round(striker.getBonusLand() * critical
                    * (Constants.Damages.BACKSTABDMG
                    + Constants.Damages.BACKSTABLVL * striker.getLevel()));
            opponent.setWithoutModifiers(opponent.getWithoutModifiers() + withoutModifiers);
        }
        //sets the damage
        opponent.setDamage(opponent.getDamage() + damage1);
    }

    @Override
    //PARALYSIS
    public void secondAbility(final Hero opponent, final Hero striker) {
        float damage2, withoutModifiers;
        //calculates the damage

        damage2 = round(round(striker.getBonusLand() * (Constants.Damages.PARALYSISDMG
                + Constants.Damages.PARALYSISLVL * striker.getLevel()))
                * striker.getModifiers2().get(opponent.getRace()));
        /*calculates the damage without modifiers in case the opponent
                will be attacked by a wizard
                 */
        if (opponent.getRace().equals("W")) {
            withoutModifiers = round(striker.getBonusLand() * (Constants.Damages.PARALYSISDMG
                    + Constants.Damages.PARALYSISLVL * striker.getLevel()));
            opponent.setWithoutModifiers(opponent.getWithoutModifiers() + withoutModifiers);
        }

        //sets the damage
        opponent.setDamage(opponent.getDamage() + damage2);

        //set the flags for overtime and verifies if is on the land woods
        opponent.setStandStill(Constants.Sem.TRUE);
        if (opponent.getBonusLand() != Constants.Sem.TRUE) {
            opponent.setNoMoves(Constants.NOMOVESW);
            opponent.setParalysis(striker);
        } else {
            opponent.setNoMoves(Constants.NOMOVES);
            opponent.setParalysis(striker);
        }


    }
}
