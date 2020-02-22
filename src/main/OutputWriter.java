package main;

import constants.Constants;
import hero.Hero;

import java.util.LinkedList;

import static java.lang.StrictMath.round;

public final class OutputWriter {
    //writes the output
    public void outputWriter(final LinkedList<Hero> heroes, final InputReader inputReader) {
        int i;
        System.out.println("~~ Results ~~");
        for (i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getDead() == Constants.Sem.TRUE) {
                System.out.println(inputReader.getPlayerType().get(i) + " dead");
            } else {
                System.out.print(inputReader.getPlayerType().get(i) + " ");
                System.out.print(heroes.get(i).getLevel() + " ");
                System.out.print(round(heroes.get(i).getXP()) + " ");
                System.out.println(heroes.get(i).getHP() + " " + heroes.get(i).getRaw()
                        + " " + heroes.get(i).getColumn());
            }
        }
    }
}
