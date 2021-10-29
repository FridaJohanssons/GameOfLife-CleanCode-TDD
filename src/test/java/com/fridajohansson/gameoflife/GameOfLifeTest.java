package com.fridajohansson.gameoflife;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTest {

    @Test
    void callingGridBoardShuldNotReturnNull(){
        GridBoard gridBoard = new GridBoard();
        assertNotNull(gridBoard.gridBoardarray);
    }

}
