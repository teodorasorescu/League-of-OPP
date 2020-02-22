package constants;

import hero.Hero;

public final class InitialHP {
    private static class HP {
        private static final int PHP = 500;
        private static final int KHP = 900;
        private static final int WHP = 400;
        private static final int RHP = 600;
        private static final int KLEVEL = 80;
        private static final int PLEVEL = 50;
        private static final int WLEVEL = 30;
        private static final int RLEVEL = 40;
    }

    public int getMaxHp(final Hero hero) {
        if (hero.getRace().equals("K")) {
            return HP.KHP;
        } else if (hero.getRace().equals("P")) {
            return HP.PHP;
        } else if (hero.getRace().equals("W")) {
            return HP.WHP;
        } else if (hero.getRace().equals("R")) {
            return HP.RHP;
        }
        return 0;
    }

    public int getMaxPerLevel(final Hero hero) {
        if (hero.getRace().equals("K")) {
            return HP.KLEVEL;
        } else if (hero.getRace().equals("P")) {
            return HP.PLEVEL;
        } else if (hero.getRace().equals("W")) {
            return HP.WLEVEL;
        } else if (hero.getRace().equals("R")) {
            return HP.RLEVEL;
        }
        return 0;
    }

    public void loadHP(final Hero hero) {
        if (hero.getRace().equals("K")) {
            hero.setHP(HP.KHP + HP.KLEVEL * hero.getLevel());
        } else if (hero.getRace().equals("P")) {
            hero.setHP(HP.PHP + HP.PLEVEL * hero.getLevel());
        } else if (hero.getRace().equals("W")) {
            hero.setHP(HP.WHP + HP.WLEVEL * hero.getLevel());
        } else if (hero.getRace().equals("R")) {
            hero.setHP(HP.RHP + HP.RLEVEL * hero.getLevel());
        }
    }
}
