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
        app.addRow("...OO...");
        app.printBoard();
        assertTrue("Cell at 1,7 should be alive", app.getBoard().at(1,7));
        assertTrue("Cell at 5,4 should be alive", app.getBoard().at(5,4));
    }
}