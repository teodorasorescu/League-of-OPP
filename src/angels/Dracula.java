package angels;

import hero.Hero;

public class Dracula extends Angel {
    @Override
    public final void accept(final Visitor v, final Hero hero) {
        v.visit(this, hero);
    }
}
