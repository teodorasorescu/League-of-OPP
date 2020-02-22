package hero;

public final class HeroFactory {
    private static HeroFactory instance = null;

    private HeroFactory() {
    }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    public Hero createHero(final String type) {
        switch (type) {
            case "K":
                return new Knight();
            case "P":
                return new Pyromancer();
            case "W":
                return new Wizard();
            case "R":
                return new Rogue();
            default:
                return null;
        }
    }
}
