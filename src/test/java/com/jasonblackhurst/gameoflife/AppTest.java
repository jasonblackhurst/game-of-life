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
        assertFalse("Cell should be dead", board.at(0,0));
        board.setAliveAt(0,0);
        assertTrue("Cell should be alive", board.at(0,0));
        System.out.println(board);
    }
}