package ability;

import constants.Constants;
import hero.Hero;


import static java.lang.Math.round;

public final class PyromancerAbilities extends Ability {
    public PyromancerAbilities() {
    }

    @Override
    //FIREBLAST
    public void firstAbility(final Hero opponent, final Hero striker) {
        int damage1, withoutModifiers;
        //verifies on which land is on
        if (striker.getLocation() == 'V') {
            striker.setBonusLand(Constants.Land.VOLCANIC);
        } else {
            striker.setBonusLand(Constants.Land.NEUTRAL);
        }
        //calculates the damage
        damage1 = round((Constants.Damages.FIREBLASTDMG + Constants.Damages.FIREBLASTLVL
                * striker.getLevel()) * striker.getBonusLand()
                * striker.getModifiers1().get(opponent.getRace()));

        /*calculates the damage without modifiers in case the opponent
                will be attacked by a wizard
                 */
        if (opponent.getRace().equals("W")) {
            withoutModifiers = round((Constants.Damages.FIREBLASTDMG
                    + Constants.Damages.FIREBLASTLVL
                    * striker.getLevel()) * striker.getBonusLand());
            opponent.setWithoutModifiers(opponent.getWithoutModifiers() + withoutModifiers);
        }
        //sets the damage
        opponent.setDamage(opponent.getDamage() + damage1);
    }

    @Override
    //IGNITE
    public void secondAbility(final Hero opponent, final Hero striker) {
        int damage1, withoutModifiers;
        //calculates the damage
        damage1 = round((Constants.Damages.IGNITEDMG
                + Constants.Damages.IGNITELVL * striker.getLevel()) * striker.getBonusLand()
                * striker.getModifiers2().get(opponent.getRace()));

        /*calculates the damage without modifiers in case the opponent
                will be attacked by a wizard
                 */
        if (opponent.getRace().equals("W")) {
            withoutModifiers = round((Constants.Damages.IGNITEDMG
                    + Constants.Damages.IGNITELVL * striker.getLevel()) * striker.getBonusLand());
            opponent.setWithoutModifiers(opponent.getWithoutModifiers() + withoutModifiers);
        }
        //sets the flags for overtime
        opponent.setIgnite(Constants.Sem.TRUE);
        opponent.setNoLessDamage(Constants.Damages.NOLESSDMG);
        opponent.setPyrStriker(striker);
        opponent.setNumberStriker(striker.getNumber());

        opponent.setDamage(opponent.getDamage() + damage1);

    }


}
