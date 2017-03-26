package com.jasonblackhurst.gameoflife;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jason_blackhurst on 3/25/17.
 */
public class AppTest {

    @Test
    public void testBoard() {
        Board board = new Board();
        assertFalse("Cell should be dead", board.at(1,1));
        board.setAliveAt(1,1);
        assertTrue("Cell should be alive", board.at(1,1));
    }

    @Test
    public void testApp() {
        App app = new App();
        assertFalse(app.getBoard().at(1,1));
        app.addRow("......O.");
        app.addRow("OOO...O.");
        app.addRow("......O.");
        app.addRow("........");
        app.addRow("...OO...");
        app.addRow("...OO...");
        assertTrue("Cell at 1,7 should be alive", app.getBoard().at(1,7));
        assertTrue("Cell at 5,4 should be alive", app.getBoard().at(5,4));
    }

    @Test
    public void testDyingFromUnderPopulation() {
        Board board = new Board();
        board.setAliveAt(1,1);
        board.tick();
        assertFalse(board.at(1,1));
    }

    @Test
    public void testStayinAliveWith2Neighbors() {
        Board board = new Board();
        board.setAliveAt(1,1); //has two neighbors
        board.setAliveAt(1,2);
        board.setAliveAt(2,1);
        board.tick();
        assertTrue("Cell with 2 neighbors should live", board.at(1,1));
    }

    @Test
    public void testStayinAliveWith3Neighbors() {
        Board board = new Board();
        board.setAliveAt(1,1); //has three neighbors
        board.setAliveAt(1,2);
        board.setAliveAt(2,1);
        board.setAliveAt(2,2);
        board.tick();
        assertTrue("Cell with 3 neighbors should live", board.at(1,1));
    }

    @Test
    public void testDyingFromOverCrowding() {
        int xToTest = 4;
        int yToTest = 4;

        //test neighbor count 4 - 8
        for (int livingCountUnderTest = 4; livingCountUnderTest <= 8; livingCountUnderTest++) {
            Board board = new Board();
            //set the middle alive
            board.setAliveAt(xToTest, yToTest);

            //set neighbors until we get to the count under test
            int livingCount = 0;
            for (int x = xToTest - 1; x <= xToTest + 1; x++) {
                for (int y = yToTest - 1; y <= yToTest + 1; y++) {
                    //skip the middle
                    if (!(x == xToTest && y == yToTest) && livingCount < livingCountUnderTest) {
                        board.setAliveAt(x, y);
                        livingCount++;
                    }
                }
            }
            board.tick();
            assertFalse("Cell with " +livingCountUnderTest + " neighbors should die", board.at(xToTest, yToTest));
        }
    }

    @Test
    public void testCellReproduction() {
        Board board = new Board();
        //dead cell 1,1 has three neighbors
        board.setAliveAt(1,2);
        board.setAliveAt(2,1);
        board.setAliveAt(2,2);
        board.tick();
        assertTrue("Dead cell with 3 neighbors should become a live cell", board.at(1,1));
    }
}