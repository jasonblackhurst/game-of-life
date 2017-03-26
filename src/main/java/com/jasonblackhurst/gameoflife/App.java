package com.jasonblackhurst.gameoflife;

import java.util.Scanner;

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
        App gameOfLifeApp = new App();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the starting state one line at a time using O for live cells and . for dead cells");
        System.out.println();

        for (int x = 0; x < 6; x++){
            gameOfLifeApp.addRow(scanner.next());
        }

        System.out.println("One tick later looks like this: ");
        System.out.println();

        gameOfLifeApp.tick();
        gameOfLifeApp.printBoard();
    }

    public Board getBoard() {
        return board;
    }

    public void tick() {
        board.tick();
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
