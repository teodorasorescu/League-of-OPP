package movement;


import constants.Constants;
import hero.Hero;


import java.util.LinkedList;


public final class Direction {
    public void up(final Hero hero) {
        int result;
        result = hero.getRaw() - Constants.SUM;
        hero.setRaw(result);
    }

    public void down(final Hero hero) {
        int result;
        result = hero.getRaw() + Constants.SUM;
        hero.setRaw(result);
    }

    public void left(final Hero hero) {
        int result;
        result = hero.getColumn() - Constants.SUM;
        hero.setColumn(result);
    }


    public void right(final Hero hero) {
        int result;
        result = hero.getColumn() + Constants.SUM;
        hero.setColumn(result);
    }

    //execute the move for each hero
    public void executeMove(final LinkedList<Hero> heroes) {
        int i;
        for (i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getStandStill() == Constants.NULL
                    && heroes.get(i).getDead() == Constants.NULL) {
                if (heroes.get(i).getDirection() == 'U') {
                    up(heroes.get(i));
                } else if (heroes.get(i).getDirection() == 'D') {
                    down(heroes.get(i));
                } else if (heroes.get(i).getDirection() == 'L') {
                    left(heroes.get(i));
                } else if (heroes.get(i).getDirection() == 'R') {
                    right(heroes.get(i));
                }
            }
            //verifies if the hero is paralysied
            if (heroes.get(i).getStandStill() == Constants.Sem.TRUE) {
                heroes.get(i).setNoMoves(heroes.get(i).getNoMoves() - Constants.SUM);
                if (heroes.get(i).getNoMoves() == 0) {
                    heroes.get(i).setStandStill(0);
                }
            }
        }
    }

}


