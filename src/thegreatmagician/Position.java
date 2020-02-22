package thegreatmagician;

import angels.Angel;
import hero.Hero;

public class Position extends Observer {
    @Override
    public final void update(final Hero hero, final Angel angel, final Hero striker) {
        //it notices the great magician of the angel's position
        if (angel != null) {
            System.out.println("Angel " + angel.getType()
                    + " was spawned at " + angel.getRawAngel() + " " + angel.getColumnAngel());
        }
    }
}

