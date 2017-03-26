package com.jasonblackhurst.gameoflife;

/**
 * Game of Life Application
 *
 * Responsible for taking command line input
 * building a Game of Life board
 * and providing the next generation of the board
 *
 */
public class App 
{
    Board board = new Board();
    int currentRow = 1;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public Board getBoard() {
        return board;
    }

    public void addRow(String row) {
        if (row.length() > board.getColumnCount() || currentRow > board.getRowCount()) {
            System.out.println("ignoring invalid input there is no cell at " + currentRow + "," + row.length());
            return;
        }

        for (int column = 0; column < row.length(); column++) {
            if ('O' == row.charAt(column)) {
                board.setAliveAt(currentRow, column+1);
            }
        }
        currentRow++;
    }

    public void printBoard() {
        for (int x = 1; x <= board.getRowCount(); x++){
            for (int y = 1; y <= board.getColumnCount(); y++){
                System.out.print(board.at(x,y) ? 'O' : '.');
            }
            System.out.println();
        }
    }
}
