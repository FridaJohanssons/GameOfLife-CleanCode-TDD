package com.fridajohansson.gameoflife;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTest {

    @Test
    void callingGridBoardShouldNotReturnNull(){
        GridBoard gridBoard = new GridBoard(4,8);
        assertNotNull(gridBoard.gridBoardarray);
    }

    @Test
    void seeIfALLCellIsDead() {
        GridBoard gridBoard = new GridBoard(8, 4);
        String answer = gridBoard.printBoard();
        assertEquals(".", answer);

    }

}
