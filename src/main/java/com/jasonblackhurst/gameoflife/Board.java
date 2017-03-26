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
        //if it's out of bounds return false
        if (row < 1 || row > rowCount || column < 1 || column > columnCount){
            return false;
        }
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

    /**
     * Moving from one generation to the next is sometimes called the tick (wikipedia)
     */
    public void tick() {
        boolean newCells[][] = new boolean[rowCount][columnCount];

        for (int x = 1; x <= rowCount; x++){
            for (int y = 1; y <= columnCount; y++){
                int neighborCount = getNeighborCount(x,y);

                //live cell with 2 or 3 neighbors stays a live cell
                if (at(x,y) && (neighborCount == 2 || neighborCount == 3)) {
                    newCells[x-1][y-1] = true;
                }

                //dead cell with 3 neighbors becomes a live cell
                if (!at(x,y) && (neighborCount == 3)) {
                    newCells[x-1][y-1] = true;
                }

            }
        }

        cells = newCells;
    }

    private int getNeighborCount(int row, int column) {
        int neighborCount = 0;
        for (int x = row - 1; x <= row + 1; x++) {
            for (int y = column - 1; y <= column + 1; y++) {
                //skip the middle
                if (!(x == row && y == column)){
                    neighborCount += ( at(x,y) ? 1 : 0);
                }
            }
        }
        return neighborCount;
    }
}
