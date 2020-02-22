package modifiers;

import hero.Hero;
import movement.Map;

public final class LandModifiers {
    public void setLocation(final Hero hero, final Map map) {
        hero.setLocation(map.getLandType(hero.getRaw(), hero.getColumn()));
    }
}
