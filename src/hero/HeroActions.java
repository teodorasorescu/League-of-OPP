package hero;

import constants.Constants;
import constants.InitialHP;
import modifiers.ModifiersFactory;
import thegreatmagician.AngelLife;
import thegreatmagician.LevelUp;
import thegreatmagician.TheGreatMagician;

import java.util.LinkedList;
import java.util.List;


import static java.lang.Integer.max;

public final class HeroActions {

    public void finalLevel(final Hero hero, final int level) {
        LevelUp levelUp = new LevelUp();
        if (level != hero.getLevel()) {
            TheGreatMagician.getInstance().add(levelUp);
            hero.setReachedLevel(Constants.Sem.TRUE);
            TheGreatMagician.getInstance().execute(hero, null, null);
            hero.setReachedLevel(Constants.NULL);
            TheGreatMagician.getInstance().getObserverList().clear();
        }
    }

    public void showsTheLevels(final Hero hero, final int level) {
        int inter, nr;
        LevelUp levelUp = new LevelUp();
        if (hero.getLevel() - level > Constants.Sem.TRUE) {
            nr = hero.getLevel() - level;
            inter = hero.getLevel();
            for (int k = level + Constants.Sem.TRUE; k <= nr; k++) {
                hero.setLevel(k);
                TheGreatMagician.getInstance().add(levelUp);
                hero.setReachedLevel(Constants.Sem.TRUE);
                TheGreatMagician.getInstance().execute(hero, null, null);
                hero.setReachedLevel(Constants.Sem.FALSE);
                TheGreatMagician.getInstance().getObserverList().clear();
            }
            hero.setLevel(inter);
        }
    }

    public void initialiseModifiers(final LinkedList<Hero> heroes) {
        int i;
        for (i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getRace().equals("W")) {
                ModifiersFactory.getInstance().setModifiersWizard(
                        heroes.get(i).getModifiers1(),
                        heroes.get(i).getModifiers2());
            } else if (heroes.get(i).getRace().equals("R")) {
                ModifiersFactory.getInstance().setModifiersRogue(
                        heroes.get(i).getModifiers1(),
                        heroes.get(i).getModifiers2());
            } else if (heroes.get(i).getRace().equals("K")) {
                ModifiersFactory.getInstance().setModifiersKnight(
                        heroes.get(i).getModifiers1(),
                        heroes.get(i).getModifiers2());
            } else {
                ModifiersFactory.getInstance().setModifiersPyromancer(
                        heroes.get(i).getModifiers1(),
                        heroes.get(i).getModifiers2());
            }
        }
    }

    public void initialiseFlags(final LinkedList<Hero> heroes) {
        int i;
        for (i = 0; i < heroes.size(); i++) {
            heroes.get(i).setNumber(i);
        }
        for (i = 0; i < heroes.size(); i++) {
            heroes.get(i).setStandStill(Constants.NULL);
            heroes.get(i).setDead(Constants.NULL);
            heroes.get(i).setIgnite(Constants.NULL);
            heroes.get(i).setNoMoves(Constants.NULL);
            heroes.get(i).setCritical(Constants.NULL);
            heroes.get(i).setNoLessDamage(Constants.NULL);
            heroes.get(i).setBroughtToLife(Constants.NULL);
            heroes.get(i).setKilledbyAngel(Constants.NULL);
            heroes.get(i).setKilledbyHero(Constants.NULL);
            heroes.get(i).setReachedLevel(Constants.NULL);
            heroes.get(i).setBeenThere(Constants.NULL);
        }
    }


    public int verifyLevel(final Hero hero) {
        //it verifies if a player will upgrade
        int sem = Constants.NULL;
        if (hero.getXP() >= Constants.LevelUP.LIMIT1
                && hero.getXP() < Constants.LevelUP.LIMIT2) {
            sem = Constants.LevelUP.LVL1;
        } else if (hero.getXP() >= Constants.LevelUP.LIMIT2
                && hero.getXP() < Constants.LevelUP.LIMIT3) {
            sem = Constants.LevelUP.LVL2;

        } else if (hero.getXP() >= Constants.LevelUP.LIMIT3
                && hero.getXP() < Constants.LevelUP.LIMIT4) {
            sem = Constants.LevelUP.LVL3;
        } else if (hero.getXP() >= Constants.LevelUP.LIMIT4) {
            sem = Constants.LevelUP.LVL4;
        }
        int dif;
        if (sem == Constants.LevelUP.LVL4) {
            dif = (int) (hero.getXP() / Constants.LvlUp.LVL - Constants.LevelUP.LMT);
            sem = sem + dif;
        }
        return sem;
    }

    public void XP_level_up(final Hero hero) {
        InitialHP init = new InitialHP();
        //calculates the HP after level up
        //sets the new level
        int nrlvl = Constants.NULL, dif;
        if (hero.getXP() >= Constants.LevelUP.LIMIT1
                && hero.getXP() < Constants.LevelUP.LIMIT2) {
            hero.setLevel(Constants.LevelUP.LVL1);
            init.loadHP(hero);
            hero.setReachedLevel(Constants.Sem.TRUE);
        } else if (hero.getXP() >= Constants.LevelUP.LIMIT2
                && hero.getXP() < Constants.LevelUP.LIMIT3) {
            hero.setLevel(Constants.LevelUP.LVL2);
            init.loadHP(hero);
            hero.setReachedLevel(Constants.Sem.TRUE);
        } else if (hero.getXP() >= Constants.LevelUP.LIMIT3
                && hero.getXP() < Constants.LevelUP.LIMIT4) {
            hero.setLevel(Constants.LevelUP.LVL3);
            init.loadHP(hero);
            hero.setReachedLevel(Constants.Sem.TRUE);
        } else if (hero.getXP() >= Constants.LevelUP.LIMIT4) {
            hero.setLevel(Constants.LevelUP.LVL4);
            init.loadHP(hero);
            hero.setReachedLevel(Constants.Sem.TRUE);
            nrlvl = Constants.LevelUP.LVL4;
        }
        //for the levels bigger than four
        if (nrlvl == Constants.LevelUP.LVL4) {
            dif = (int) (hero.getXP() / Constants.LvlUp.LVL - Constants.LevelUP.LMT);
            hero.setLevel(nrlvl + dif);
            init.loadHP(hero);
            hero.setReachedLevel(Constants.Sem.TRUE);
        }
    }

    public void XP_winner(final Hero winner, final Hero loser) {
        int xpWinner = Constants.NULL;
        //calculates and sets the XP
        xpWinner += max(Constants.LevelUP.NULL,
                Constants.LevelUP.LIMIT1XP - (winner.getLevel()
                        - loser.getLevel() * Constants.LevelUP.XPLVL));
        winner.setXP(winner.getXP() + xpWinner);
    }

    public void setUpPosition(final LinkedList<Hero> heroes, final int[] pos1, final int[] pos2) {
        int i;
        //sets the positions for each hero
        for (i = 0; i < pos1.length; i++) {
            heroes.get(i).setRaw(pos1[i]);
            heroes.get(i).setColumn(pos2[i]);
        }

    }

    public void setUpDirection(final LinkedList<Hero> heroes, final List<String> direction,
                               final int r) {
        //sets the directions for each hero
        int i;
        for (i = 0; i < heroes.size(); i++) {
            heroes.get(i).setDirection(direction.get(r).charAt(i));
        }
    }

    public String intoWords(final Hero hero) {
        String race;
        if (hero.getRace().equals("K")) {
            race = "Knight";
        } else if (hero.getRace().equals("P")) {
            race = "Pyromancer";
        } else if (hero.getRace().equals("R")) {
            race = "Rogue";
        } else {
            race = "Wizard";
        }
        return race;
    }

    public void setUpRace(final LinkedList<Hero> heroes, final List<String> race) {
        int i;
        //sets the race for each hero
        for (i = 0; i < race.size(); i++) {
            heroes.get(i).setRace(race.get(i));
        }
    }

    public void verifyIfItsDead(final Hero opponent, final Hero striker, final String filename) {
        //verifies if the opponent is dead
        //sets the XP and the Dead flag
        AngelLife angelLife = new AngelLife();
        LevelUp levelUp = new LevelUp();
        TheGreatMagician theGreatMagician = TheGreatMagician.getInstance();
        theGreatMagician.add(angelLife);

        if (striker.getHP() < Constants.LevelUP.NULL
                && opponent.getHP() < Constants.LevelUP.NULL
                && opponent.getDead() != Constants.Sem.TRUE
                && striker.getDead() != Constants.Sem.TRUE) {
            opponent.setDead(Constants.Sem.TRUE);
            striker.setDead(Constants.Sem.TRUE);
            opponent.setKilledbyHero(Constants.Sem.TRUE);
            striker.setKilledbyHero(Constants.Sem.TRUE);
            opponent.setBroughtToLife(0);
            striker.setBroughtToLife(0);
            theGreatMagician.execute(opponent, null, striker);
            theGreatMagician.execute(striker, null, opponent);

        } else if (striker.getHP() > Constants.LevelUP.NULL
                && opponent.getHP() < Constants.LevelUP.NULL
                && opponent.getDead() != Constants.Sem.TRUE) {
            theGreatMagician.add(levelUp);
            XP_winner(striker, opponent);
            opponent.setDead(Constants.Sem.TRUE);
            opponent.setBroughtToLife(Constants.NULL);
            opponent.setKilledbyHero(Constants.Sem.TRUE);
            opponent.setReachedLevel(Constants.Sem.TRUE);
            XP_level_up(striker);
            theGreatMagician.execute(opponent, null, striker);
        }
        theGreatMagician.getObserverList().clear();
    }

    public void initialise(final List<Hero> heroes) {
        /*initialises the damage with and without modifiers
        for each round */
        int i;
        for (i = 0; i < heroes.size(); i++) {
            heroes.get(i).setDamage(Constants.LevelUP.NULL);
            heroes.get(i).setWithoutModifiers(Constants.LevelUP.NULL);
        }
    }


}
