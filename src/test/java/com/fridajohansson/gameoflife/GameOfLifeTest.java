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
        GridBoard gridBoard = new GridBoard(2, 2);
        String answer = gridBoard.printBoard();
        assertEquals("....", answer);
    }

    @Test
    void seeIfCellIsAlive(){
        GridBoard gridBoard = new GridBoard(2,2);
        gridBoard.setAlive(0,0);
        String answer = gridBoard.printBoard();

        assertEquals("*...",answer);
    }
    @Test
    void seeIfCellHasNeighbour(){
        GridBoard gridBoard = new GridBoard(3,3);
        gridBoard.setAlive(1,1);
        int answer = gridBoard.countNeighbours(1,1);
        gridBoard.printBoard();
        assertEquals(0,answer);
    }
    @Test
    void seeIfCellHasTwoNeighbour(){
        GridBoard gridBoard = new GridBoard(4,3);
        gridBoard.setAlive(0,0);
        gridBoard.setAlive(1,0);
        gridBoard.setAlive(3,0);

        int answer = gridBoard.countNeighbours(2,0);
        gridBoard.printBoard();
        assertEquals(2,answer);
    }
    @Test
    void seeIfCellHasFourNeighbour(){
        GridBoard gridBoard = new GridBoard(3,3);
        gridBoard.setAlive(0,0);
        gridBoard.setAlive(1,0);
        gridBoard.setAlive(2,0);
        gridBoard.setAlive(2,2);

        int answer = gridBoard.countNeighbours(1,1);
        gridBoard.printBoard();
        assertEquals(4,answer);
    }
    @Test
    void seeIfCellHasEightNeighbour(){
        GridBoard gridBoard = new GridBoard(3,3);
        gridBoard.setAlive(0,0);
        gridBoard.setAlive(1,0);
        gridBoard.setAlive(2,0);
        gridBoard.setAlive(2,2);
        gridBoard.setAlive(0,1);
        gridBoard.setAlive(0,2);
        gridBoard.setAlive(1,2);
        gridBoard.setAlive(2,1);

        int answer = gridBoard.countNeighbours(1,1);
        gridBoard.printBoard();
        assertEquals(8,answer);
    }
    @Test
    void shouldReturnTwoNeighboursEvenThouTreeAliveButOneIsOutOfBoard(){
        GridBoard gridBoard = new GridBoard(3,3);
        gridBoard.setAlive(0,0);
        gridBoard.setAlive(-1,1);
        gridBoard.setAlive(0,2);

        int answer = gridBoard.countNeighbours(0,1);
        gridBoard.printBoard();
        assertEquals(2,answer);
    }
    @Test
    void shouldReturnEmptyEvenIfOneIsAliveOutsideTheBoard(){
        GridBoard gridBoard = new GridBoard(2,3);
        gridBoard.setAlive(2,1);
        String answer = gridBoard.printBoard();
        assertEquals("......", answer);
    }

    @Test
    void whenCellHasFewerThanTwoNeighboursItDies(){
        GridBoard gridBoard = new GridBoard(3,2);
        gridBoard.setAlive(1,1);
        gridBoard.countNeighbours(1,1);
        gridBoard.printBoard();
        gridBoard.nextGen();
        String answer = gridBoard.printBoard();
        assertEquals("......",answer);
    }

    @Test
    void whenCellHasOneNeighboursItDies(){
        GridBoard gridBoard = new GridBoard(3,2);
        gridBoard.setAlive(1,1);
        gridBoard.setAlive(2,1);
        gridBoard.countNeighbours(1,1);
        gridBoard.printBoard();
        gridBoard.nextGen();
        String answer = gridBoard.printBoard();
        assertEquals("......",answer);
    }
    @Test
    void whenCellHasThreeNeighboursItStartsToLive(){
        GridBoard gridBoard = new GridBoard(3,2);
        gridBoard.setAlive(1,1);
        gridBoard.setAlive(2,1);
        gridBoard.setAlive(0,1);
        gridBoard.countNeighbours(0,1);
        gridBoard.printBoard();
        gridBoard.nextGen();
        String answer = gridBoard.printBoard();
        assertEquals(".*..*.",answer);
    }
    @Test
    void whenCellHasMoreThanThreeNeighboursItDies(){
        GridBoard gridBoard = new GridBoard(3,2);
        gridBoard.setAlive(1,1);
        gridBoard.setAlive(2,1);
        gridBoard.setAlive(0,1);
        gridBoard.setAlive(1,0);
        gridBoard.setAlive(0,0);

        gridBoard.printBoard();
        gridBoard.nextGen();
        String answer = gridBoard.printBoard();
        assertEquals("*.**.*",answer);
    }
    @Test
    void whenCellHasTwoOrThreeNeighboursItLivesOn(){
        GridBoard gridBoard = new GridBoard(8,4);
        gridBoard.setAlive(4,1);
        gridBoard.setAlive(3,2);
        gridBoard.setAlive(4,2);
        gridBoard.setAlive(5,0);
        gridBoard.printBoard();
        gridBoard.nextGen();
        String answer = gridBoard.printBoard();
        assertEquals("...........***.....**...........",answer);
    }


}


//F??rst testa och se ifall alla celler ??r d??da osv. sen kontrollera hur m??nga grannar en cell har.
//Sen g??ra metod som kollar hur m??nga grannar cell har som man ska kunna anv??nda.
//Sen skriva test om en cell skulle hamna utanf??r boarden. Sen en metod som sorterar bort celler som
//hamnar utanf??r.
//Sen ska man testa ifall en cell d??r ifall den inte har grannar, sen g??r den metoden.
//Sen ifall den ??verlever om den har grannar. Sen g??ra den metoden.
//Sen se ifall den har tre grannar om det ska f??das en ny. Sen g??ra det... osv..