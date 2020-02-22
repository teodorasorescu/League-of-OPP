package hero;

import constants.Constants;

import java.util.LinkedList;
import java.util.List;

public final class Initialisation {
    public static class Heroes {
        public static final int PHP = 500;
        public static final int PLEVEL = 50;
        public static final int KHP = 900;
        public static final int KLEVEL = 80;
        public static final int WHP = 400;
        public static final int WLEVEL = 30;
        public static final int RHP = 600;
        public static final int RLEVEL = 40;
    }

    public void initHeroes(final LinkedList<Hero> heroes, final List<String> type) {
        int i;
        //gets and sets the initial HP and the values for levelUP
        for (i = 0; i < type.size(); i++) {
            if (type.get(i).equals("P")) {
                heroes.get(i).setHP(Heroes.PHP);
                heroes.get(i).setPerLevel(Heroes.PLEVEL);
            } else if (type.get(i).equals("K")) {
                heroes.get(i).setHP(Heroes.KHP);
                heroes.get(i).setPerLevel(Heroes.KLEVEL);
            } else if (type.get(i).equals("W")) {
                heroes.get(i).setHP(Heroes.WHP);
                heroes.get(i).setPerLevel(Heroes.WLEVEL);
            } else if (type.get(i).equals("R")) {
                heroes.get(i).setHP(Heroes.RHP);
                heroes.get(i).setPerLevel(Heroes.RLEVEL);
            }
            heroes.get(i).setXP(Constants.Sem.FALSE);
            heroes.get(i).setLevel(Constants.Sem.FALSE);
        }
    }
}
