package angels;

import hero.Hero;

public class XPAngel extends Angel {
    @Override
    public final void accept(final Visitor v, final Hero hero) {
        v.visit(this, hero);
    }
}
