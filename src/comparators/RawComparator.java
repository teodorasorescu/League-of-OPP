package comparators;

import hero.Hero;

import java.util.Comparator;

public final class RawComparator implements Comparator<Hero> {
    @Override
    public int compare(final Hero hero, final Hero t1) {
        return hero.getColumn() - t1.getColumn();
    }
}
