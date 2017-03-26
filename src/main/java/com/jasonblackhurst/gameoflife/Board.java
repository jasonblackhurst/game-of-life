package com.jasonblackhurst.gameoflife;

/**
 * Created by jason_blackhurst on 3/25/17.
 */
public class Board {

    boolean cells[][] = new boolean[8][6];

    public boolean at(int x, int y) {
        return cells[x][y];
    }

    public void setAliveAt(int x, int y) {
        cells[x][y] = true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (boolean row[] : cells){
            for (boolean value : row){
                stringBuilder.append(value ? 'O' : '.');
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
