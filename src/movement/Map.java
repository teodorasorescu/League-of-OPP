package movement;

import java.util.List;

public final class Map {
    private int n;
    private int m;
    private List<String> type;
    private char[][] landType;

    public Map(final List<String> type, final int n, final int m) {
        this.n = n;
        this.m = m;
        land(type);
    }

    //sets the type of land for each position on the map
    public void land(final List<String> type) {
        this.landType = new char[this.n][this.m];
        int i, j, k;
        for (i = 0; i < this.n; i++) {
            k = 0;
            for (j = 0; j < this.m; j++) {
                landType[i][j] = type.get(i).charAt(k);
                k++;
            }
        }
    }

    public List<String> getType() {
        return type;
    }

    public void setType(final List<String> type) {
        this.type = type;
    }

    public char getLandType(final int raw, final int column) {
        return landType[raw][column];
    }

    public void setLandType(final char[][] landType) {
        this.landType = landType;
    }

    public int getN() {
        return n;
    }

    public void setN(final int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(final int m) {
        this.m = m;
    }


}

