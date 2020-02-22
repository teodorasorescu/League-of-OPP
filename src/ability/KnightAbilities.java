package ability;

import constants.Constants;
import constants.InitialHP;
import hero.Hero;
import hero.HeroActions;


import static java.lang.Math.round;

public final class KnightAbilities extends Ability {

    public KnightAbilities() {

    }

    @Override
    //EXECUTE
    public void firstAbility(final Hero opponent, final Hero striker) {
        float damage1, hpLimit, withoutModifiers;
        HeroActions actions = new HeroActions();
        InitialHP max = new InitialHP();
        //verifies on each land is on and adds the land modifier
        if (striker.getLocation() != 'L') {
            striker.setBonusLand(Constants.Land.NEUTRAL);
        } else {
            striker.setBonusLand(Constants.Land.LAND);
        }
        //calculates the damage
        damage1 = round(round((Constants.Damages.EXECUTEDMG
                + Constants.Damages.EXECUTELEVEL * striker.getLevel())
                * striker.getBonusLand())
                * striker.getModifiers1().get(opponent.getRace()));
        //calculates the hp limit
        hpLimit = round(round(Constants.Damages.EXECUTEPROCENT * (max.getMaxHp(opponent)
                + max.getMaxPerLevel(opponent) * opponent.getLevel()))
                + Constants.Damages.EXECUTEPERLEVEL * striker.getLevel());
        //verifies the HP of the opponent
        if (opponent.getHP() < hpLimit && hpLimit <= Constants.Damages.HPLIMIT) {
            damage1 = opponent.getHP();
            actions.XP_winner(striker, opponent);
            opponent.setDead(Constants.Sem.TRUE);
            actions.XP_level_up(striker);
        }

        //calculates the damage without modifiers in case the opponent will be attacked by a wizard
        if (opponent.getRace().equals("W")) {
            withoutModifiers = round((Constants.Damages.EXECUTEDMG
                    + Constants.Damages.EXECUTELEVEL
                    * striker.getLevel()) * striker.getBonusLand());
            opponent.setWithoutModifiers(opponent.getWithoutModifiers() + withoutModifiers);
        }
        //sets the damage
        opponent.setDamage(opponent.getDamage() + damage1);
    }

    //SLAM
    @Override
    public void secondAbility(final Hero opponent, final Hero striker) {
        int damage2, withoutModifiers;
        //calculates the damage
        if (opponent.getDead() != Constants.Sem.TRUE) {
            damage2 = round(round((Constants.Damages.SLAMDMG + Constants.Damages.SLAMLEVEL
                    * striker.getLevel()) * striker.getBonusLand())
                    * striker.getModifiers2().get(opponent.getRace()));
            if (opponent.getRace().equals("W")) {
                /*calculates the damage without modifiers in case the opponent
                will be attacked by a wizard
                 */
                withoutModifiers = round((Constants.Damages.SLAMDMG + Constants.Damages.SLAMLEVEL
                        * striker.getLevel()) * striker.getBonusLand());
                opponent.setWithoutModifiers(opponent.getWithoutModifiers() + withoutModifiers);
            }
            //sets the damage
            opponent.setDamage(opponent.getDamage() + damage2);

            //sets the flags for OVERTIME
            opponent.setNoMoves(Constants.Sem.TRUE);
            opponent.setStandStill(Constants.Sem.TRUE);
        }
    }

}
