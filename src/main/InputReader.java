package main;

import constants.Constants;
import fileio.implementations.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class InputReader {
    private int r = Constants.NEGATIVE;
    private int n = Constants.NEGATIVE;
    private int m = Constants.NEGATIVE;
    private int p = Constants.NEGATIVE;
    private List<String> landType = new ArrayList<>();
    private List<String> playerType = new ArrayList<>();
    private List<String> playerRoute = new ArrayList<>();
    private int[] posInit1;
    private int[] posInit2;
    private int[] rawAngels;
    private int[] columnAngels;
    private int[] noAngelsperRound;
    private List<String> angelType = new ArrayList<>();
    private String[] types = new String[Constants.MAXANGELS];


    public String removeCharacter(final String str, final int noChar) {
        String res = null;
        if ((str != null) && (str.length() > Constants.NULL)) {
            res = str.substring(Constants.NULL, str.length() - noChar);
        }
        return res;
    }

    public void reader(final String inputFile) throws IOException {
        FileReader fileReader = new FileReader(inputFile);
        n = fileReader.nextInt();
        m = fileReader.nextInt();
        for (int i = 0; i < n; i++) {
            landType.add(fileReader.nextWord());
        }

        p = fileReader.nextInt();
        posInit1 = new int[p];
        posInit2 = new int[p];

        for (int i = 0; i < p; i++) {
            playerType.add(fileReader.nextWord());
            posInit1[i] = fileReader.nextInt();
            posInit2[i] = fileReader.nextInt();
        }

        r = fileReader.nextInt();
        for (int i = 0; i < r; i++) {
            playerRoute.add(fileReader.nextWord());
        }
        //number of angels
        noAngelsperRound = new int[Constants.MAXANGELS];
        rawAngels = new int[Constants.MAXANGELS];
        columnAngels = new int[Constants.MAXANGELS];
        int k = Constants.NULL;
        //reading the angel's information
        for (int i = 0; i < r; i++) {
            noAngelsperRound[i] = fileReader.nextInt();
            for (int j = 0; j < noAngelsperRound[i]; j++) {
                types[k] = fileReader.nextWord();
                angelType.add(removeCharacter(types[k], Constants.NOCHAR));
                columnAngels[k] = Integer.parseInt(
                        String.valueOf(types[k].charAt(types[k].length() - Constants.Sem.TRUE)));
                rawAngels[k] = Integer.parseInt(String.valueOf(types[k].charAt(types[k].length()
                        - Constants.DIVIDE)));
                k++;
            }
        }
        fileReader.close();
    }

    public int getR() {
        return r;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getP() {
        return p;
    }

    public List<String> getPlayerType() {
        return playerType;
    }

    public List<String> getLandType() {
        return landType;
    }

    public List<String> getPlayerRoute() {
        return playerRoute;
    }

    public int[] getPosInit1() {
        return posInit1;
    }

    public int[] getPosInit2() {
        return posInit2;
    }

    public int[] getRawAngels() {
        return rawAngels;
    }

    public int[] getColumnAngels() {
        return columnAngels;
    }

    public int[] getNoAngelsperRound() {
        return noAngelsperRound;
    }

    public List<String> getAngelType() {
        return angelType;
    }


}
