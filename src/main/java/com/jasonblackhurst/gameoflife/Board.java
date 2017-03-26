package com.jasonblackhurst.gameoflife;

/**
 * Game of Life Board
 * Addressed via a 1-based grid (x,y)
 * With X being the row number and y being the column
 *
 * Created by jason_blackhurst on 3/25/17.
 */
public class Board {

    int rowCount = 6;
    int columnCount = 8;
    boolean cells[][] = new boolean[rowCount][columnCount];

    public boolean at(int row, int column) {
        return cells[row-1][column-1];
    }

    public void setAliveAt(int row, int column) {
        cells[row-1][column-1] = true;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }
}
