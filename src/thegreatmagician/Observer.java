package thegreatmagician;

import angels.Angel;
import hero.Hero;

public abstract class Observer {
    public abstract void update(Hero hero, Angel angel, Hero striker);
}
