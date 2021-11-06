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


//Först testa och se ifall alla celler är döda osv. sen kontrollera hur många grannar en cell har.
//Sen göra metod som kollar hur många grannar cell har som man ska kunna använda.
//Sen skriva test om en cell skulle hamna utanför boarden. Sen en metod som sorterar bort celler som
//hamnar utanför.
//Sen ska man testa ifall en cell dör ifall den inte har grannar, sen gör den metoden.
//Sen ifall den överlever om den har grannar. Sen göra den metoden.
//Sen se ifall den har tre grannar om det ska födas en ny. Sen göra det... osv..