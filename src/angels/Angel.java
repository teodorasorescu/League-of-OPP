package angels;

import hero.Hero;

public class Angel implements Angels {
    private int rawAngel;
    private int columnAngel;
    private String type;

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    public final int getRawAngel() {
        return rawAngel;
    }

    public final void setRawAngel(final int rawAngel) {
        this.rawAngel = rawAngel;
    }

    public final int getColumnAngel() {
        return columnAngel;
    }

    public final void setColumnAngel(final int columnAngel) {
        this.columnAngel = columnAngel;
    }

    @Override
    public void accept(final Visitor v, final Hero hero) {
    }
}
